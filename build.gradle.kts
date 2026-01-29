plugins {
    kotlin("jvm") version "2.0.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "me.template"
version = "1.0.0"

/* =====================================================
 * Java / Kotlin toolchain
 * ===================================================== */
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

kotlin {
    jvmToolchain(21)
}

/* =====================================================
 * Repositories
 * ===================================================== */
repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

/* =====================================================
 * Dependencies
 * ===================================================== */
dependencies {

    /* Paper / Purpur API */
    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")

    /* Kotlin standard library */
    implementation(kotlin("stdlib"))

    /* KSpigot framework */
    implementation("net.axay:kspigot:1.21.0")

    /* Adventure API */
    implementation("net.kyori:adventure-api:4.17.0")
    implementation("net.kyori:adventure-text-minimessage:4.17.0")
    implementation("net.kyori:adventure-platform-bukkit:4.3.2")

    /* Database */
    implementation("com.zaxxer:HikariCP:5.1.0")
    implementation("mysql:mysql-connector-java:8.0.33")

    /* Cache */
    implementation("com.github.ben-manes.caffeine:caffeine:3.1.8")
}

/* =====================================================
 * Compiler configuration
 * ===================================================== */
tasks {

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)

            // Strict nullability for Java interop
            freeCompilerArgs.addAll(
                "-Xjsr305=strict"
            )
        }
    }

    withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
    }

    /* =================================================
     * ShadowJar configuration
     * ================================================= */
    shadowJar {
        archiveClassifier.set("")

        // Make builds reproducible
        isPreserveFileTimestamps = false
        isReproducibleFileOrder = true

        // Relocate only third-party libraries
        // (DO NOT relocate kotlin / kotlinx)
        relocate("com.zaxxer.hikari", "${project.group}.shadow.hikari")
        relocate("com.github.benmanes.caffeine", "${project.group}.shadow.caffeine")
    }

    /* =================================================
     * Build lifecycle
     * ================================================= */
    build {
        dependsOn(shadowJar)
    }
}
