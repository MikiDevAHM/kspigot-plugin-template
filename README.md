# KSpigot Plugin Template (Paper / Purpur 1.21+)

A modern **Kotlin-first** template for developing **Paper / Purpur** plugins using:

- Kotlin **2.0.0**
- KSpigot
- Adventure (MiniMessage)
- MySQL with HikariCP
- Caffeine cache
- ShadowJar (fully shaded & relocated)

This template is designed for **production-ready plugins** and long-term maintenance.

---

## ✨ Features

- Kotlin 2.2.0 (JVM 21)
- Paper / Purpur 1.21.x compatible
- KSpigot DSL
- Adventure API + MiniMessage
- MySQL connection pooling (HikariCP)
- In-memory caching (Caffeine)
- Shadowed & relocated dependencies
- Ready-to-use GitHub Actions CI (disabled for the template repo itself)

---

## 🚀 Getting Started

1. Click **Use this template** on GitHub.
2. Rename packages (`me.template.myplugin`).
3. Update `plugin.yml` and `build.gradle.kts`.
4. Configure `config.yml`.

---

## 🛠 Build

```bash
./gradlew build
```

The final JAR will be generated in `build/libs`.

---

## 📄 Requirements

- Java 21
- Paper / Purpur 1.21+

---

## 📜 License

Free to use and modify.
