# 🧪 QA Automation — Sauce Demo

![Java](https://img.shields.io/badge/Java-17-orange?logo=java)
![Selenium](https://img.shields.io/badge/Selenium-4.39.0-green?logo=selenium)
![Cucumber](https://img.shields.io/badge/Cucumber-7.33.0-brightgreen?logo=cucumber)
![Maven](https://img.shields.io/badge/Maven-3.x-red?logo=apachemaven)
![BDD](https://img.shields.io/badge/Pattern-BDD-blue)
![POM](https://img.shields.io/badge/Pattern-Page%20Object%20Model-blue)

Proyek **QA Automation** berbasis **Selenium + Cucumber (BDD)** untuk menguji fungsionalitas website [Sauce Demo](https://www.saucedemo.com/). Dibangun menggunakan pola **Page Object Model (POM)** dan **Behavior Driven Development (BDD)**.

---

## 📋 Daftar Isi

- [Demo](#-demo)
- [Fitur yang Diuji](#-fitur-yang-diuji)
- [Teknologi](#-teknologi)
- [Prasyarat](#-prasyarat)
- [Instalasi & Menjalankan](#-instalasi--menjalankan)
- [Struktur Project](#-struktur-project)
- [Laporan Test](#-laporan-test)
- [Kontribusi](#-kontribusi)

---

## 🎥 Demo

> Website yang diuji: **https://www.saucedemo.com/**

---

## ✅ Fitur yang Diuji

### 🔐 Login
| Skenario | Status |
|----------|--------|
| Login berhasil dengan kredensial valid | ✅ |
| Login gagal dengan username salah | ✅ |
| Login gagal dengan password salah | ✅ |
| Login gagal dengan kredensial kosong | ✅ |
| Login dengan akun yang dikunci (locked_out_user) | ✅ |
| Validasi berbagai kondisi login (Scenario Outline) | ✅ |

### 🛍️ Halaman Produk
| Skenario | Status |
|----------|--------|
| Verifikasi judul halaman produk | ✅ |
| Verifikasi produk ditampilkan | ✅ |
| Verifikasi jumlah produk (6 produk) | ✅ |
| Sorting produk A-Z / Z-A | ✅ |
| Sorting produk harga rendah-tinggi / tinggi-rendah | ✅ |
| Menambahkan produk ke keranjang | ✅ |
| Verifikasi badge keranjang | ✅ |
| Logout dari halaman produk | ✅ |

### 🛒 Keranjang Belanja
| Skenario | Status |
|----------|--------|
| Melihat keranjang setelah menambah produk | ✅ |
| Menghapus produk dari keranjang | ✅ |
| Lanjut belanja dari halaman keranjang | ✅ |
| Keranjang menyimpan beberapa produk | ✅ |

---

## 🛠️ Teknologi

- **Java 17** — Bahasa pemrograman utama
- **Selenium 4.39.0** — Browser automation (ChromeDriver otomatis dikelola)
- **Cucumber 7.33.0** — BDD framework (Gherkin syntax)
- **JUnit 4** — Test runner
- **Maven** — Build tool & dependency management
- **Page Object Model** — Design pattern untuk maintainability

---

## 📌 Prasyarat

Pastikan sudah terinstall:

- [Java 17+](https://www.oracle.com/java/technologies/downloads/) — cek dengan `java -version`
- [Maven 3.x](https://maven.apache.org/download.cgi) — cek dengan `mvn -version`
- [Google Chrome](https://www.google.com/chrome/) — versi terbaru (ChromeDriver otomatis)

> **Catatan:** Selenium 4 mengelola ChromeDriver secara otomatis, tidak perlu download manual.

---

## 🚀 Instalasi & Menjalankan

### 1. Clone Repository

```bash
git clone https://github.com/achmadfauzi-labs/QA_Automation.git
cd QA_Automation
```

### 2. Jalankan Semua Test

```bash
mvn test
```

### 3. Jalankan Feature Tertentu

```bash
mvn test -Dcucumber.features="src/test/resources/features/Login.feature"
```

### 4. Jalankan Berdasarkan Tag

```bash
# Windows PowerShell
mvn test "-Dcucumber.filter.tags=@smoke"

# Mac / Linux
mvn test -Dcucumber.filter.tags="@smoke"
```

### 5. Mode Headless (tanpa buka browser)

Uncomment baris berikut di `src/test/java/hooks/Hooks.java`:

```java
options.addArguments("--headless");
```

---

## 📁 Struktur Project

```
📦 bootcampafteroffice
├── 📁 src
│   └── 📁 test
│       ├── 📁 java
│       │   ├── 📁 hooks
│       │   │   └── Hooks.java          # Setup & teardown WebDriver
│       │   ├── 📁 pages                # Page Object Model
│       │   │   ├── LoginPage.java
│       │   │   ├── ProductPage.java
│       │   │   └── CartPage.java
│       │   ├── 📁 runner
│       │   │   └── TestRunners.java    # Cucumber test runner
│       │   └── 📁 steps                # Step definitions
│       │       ├── LoginStep.java
│       │       ├── ProductStep.java
│       │       └── CartStep.java
│       └── 📁 resources
│           └── 📁 features             # Gherkin feature files
│               ├── Login.feature
│               ├── Product.feature
│               └── Cart.feature
└── 📄 pom.xml
```

---

## 📊 Laporan Test

Setelah menjalankan test, laporan HTML otomatis dibuat di:

```
target/cucumber-reports.html
```

Buka file tersebut di browser untuk melihat hasil lengkap setiap skenario beserta screenshot otomatis jika ada test yang gagal.

---

## 🔑 Akun Test Sauce Demo

Akun yang tersedia untuk testing di https://www.saucedemo.com/:

| Username | Password | Keterangan |
|----------|----------|------------|
| `standard_user` | `secret_sauce` | User normal |
| `locked_out_user` | `secret_sauce` | User yang dikunci |
| `problem_user` | `secret_sauce` | User dengan bug UI |
| `performance_glitch_user` | `secret_sauce` | User dengan performa lambat |

---

## 👤 Author

**Nama Kamu**
- GitHub: [@achmadfauzi-labs](https://github.com/achmadfauzi-labs)
- LinkedIn: [linkedin.com/in/username](https://linkedin.com/in/achmad-fauzi-278a521bb)

---
