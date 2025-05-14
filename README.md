# 🕹️ GameZ Store – JavaFX Game Store App
This is a simple desktop application for a fictional game store built using **JavaFX** and **SceneBuilder**.  
It features user authentication, game browsing, cart functionality, discount handling, and order summary calculations.  
It's a beginner-friendly GUI project that demonstrates key JavaFX, FXML, and database integration concepts.

## 🚀 Features
- 🔐 User Registration & Login System
  - New users can securely register with a username, email, and password.
  - Existing users can log in and access the game store.
- 🛒 Game cart system with adjustable quantity and dynamic pricing
- 💲 Discount code support (`SANDYCLAWS`)
- 🧾 Subtotal, tax, and grand total calculations
- ❌ Clear cart button
- 📦 JavaFX TableView for order summaries
- 🎨 FXML-based UI built with SceneBuilder

## 🧰 Tech Stack
- Java 11+
- JavaFX 24.0.1
- SceneBuilder
- Maven + JavaFX Maven Plugin
- Apache Commons Codec (for SHA-256 password hashing)
- SQL Server (or other JDBC-compatible DB)

## 📁 Project Structure
```sql
src/
├── main/
│ ├── java/a/learning/
│ │ ├── App.java
│ │ ├── DatabaseConnection.java
│ │ ├── GameCardController.java
│ │ ├── GameController.java
│ │ ├── GameDAO.java
│ │ ├── GameItem.java
│ │ ├── LoginController.java
│ │ ├── User.java
│ │ └── UserDAO.java
│ └── resources/a/learning/
| | ├── Images
│ | ├── login.fxml
│ | ├── game.fxml
│ | ├── GameCard.fxml
│ | └── learning.css
| └── config.properties.example
pom.xml
```
## 🛠️ How to Run (Maven + JavaFX 24)
> ✅ Prerequisites:
> - Java 11 or newer installed
> - Maven installed
> - SQL Server or other JDBC-compatible database set up with a users and games table

## 🗄️ Database Setup

Run the `GameDB.sql` file to create the necessary tables:

In SQL Server or any compatible DB tool:
```bash
RUN GameDB.sql;
```

### 🚀 Run the app:

```bash
mvn clean javafx:run
```

## 🧩 Editing the UI
You can open (`login.fxml`) and (`game.fxml`) in SceneBuilder to modify the layout visually.

Download: https://gluonhq.com/products/scene-builder/

## 🔧 Future Improvements
- Save cart state between sessions
- Display game thumbnails
- Add user profiles

## 🤝 Contributing
Contributions are welcome! If you’d like to improve this project or add features:

1. Fork the repository
2. Create a new branch (git checkout -b feature/your-feature-name)
3. Commit your changes (git commit -m 'Add feature')
4. Push to your branch (git push origin feature/your-feature-name)
5. Open a Pull Request

For major changes, open an issue first to discuss what you’d like to propose.
