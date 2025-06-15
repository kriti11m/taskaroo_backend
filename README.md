## ✅ Taskaroo – Task Management Application
> Java | Spring Boot | Firebase | Google OAuth | PostgreSQL | Gradle

**Taskaroo** is a comprehensive task management application built with a modern tech stack. It provides users with an efficient way to manage tasks, track progress, and organize their workflow.

---

### 🔧 Tech Stack

**Backend**
- **Java** – Core language
- **Spring Boot** – REST API framework
- **Gradle** – Build tool
- **Spring Data JPA** – Database layer
- **Spring Web** – Web & API module
- **Firebase Admin SDK** – Firebase services integration

**Authentication & Security**
- **Google OAuth 2.0** – Secure login
- **Firebase Authentication** – Session management and endpoint protection

**Database**
- Supports **PostgreSQL**, **MySQL**, or **H2**

**Deployment**
- Configured for **Render** deployment
- Environment-based service credential handling (local vs prod)

---

### ✨ Key Features
- Google OAuth login & Firebase-based auth
- Password reset via email verification
- Create, read, update, delete (CRUD) tasks
- RESTful APIs for frontend integration

---

### 🧱 Project Structure
```
src/
├── controller/         # REST API endpoints
├── model/              # Entity models
├── repository/         # Database access layer
├── service/            # Business logic
├── config/             # Firebase, OAuth configs
└── resources/          # application.properties and credentials
```

---

### 🚀 Getting Started

```bash
# Clone the repository
git clone https://github.com/kriti11m/taskaroo_backend.git
cd taskaroo_backend

# Add your Firebase credentials to src/main/resources/

# Run the application
./gradlew bootRun
```

---

### 📦 Dependencies
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Firebase Admin SDK
- Google Auth Library

---

### 💻 Development
The project follows standard Spring Boot conventions and can be imported into any Java IDE such as:
- IntelliJ IDEA
- Eclipse

---

### 🔐 Security Notes
- Secure OAuth 2.0 flow with Google
- Email-based password reset flow
- Secrets managed separately in dev vs prod
