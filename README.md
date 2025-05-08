# 🕹️ GameZ Store – JavaFX Game Store App
This is a simple desktop application for a fictional game store built using **JavaFX** and **SceneBuilder**. 
It allows users to log in, select games, add them to a cart, apply discounts, calculate totals with tax, and clear the cart. 
It's a beginner-friendly GUI project that demonstrates key JavaFX and FXML concepts.

## 🚀 Features
- 🔐 Login screen with username pass-through
- 🛒 Game cart system with quantity and pricing
- 💲 Discount code support (`SANDYCLAWS`)
- 🧾 Subtotal, tax, and grand total calculations
- ❌ Clear cart button
- 📦 JavaFX TableView for order summaries

## 🧰 Tech Stack
- Java 11+
- JavaFX 24.0.1
- SceneBuilder
- Maven + JavaFX Maven Plugin

## 📁 Project Structure
```sql
src/
├── main/
│ ├── java/a/learning/
│ │ ├── App.java
│ │ ├── GameController.java
│ │ ├── GameItem.java
│ │ └── LoginController.java
│ └── resources/a/learning/
|   ├── Images
│   ├── login.fxml
│   ├── game.fxml
│   └── learning.css
pom.xml
```
## 🛠️ How to Run (Maven + JavaFX 24)
> ✅ Prerequisites:
> - Java 11 or newer installed
> - Maven installed

### 🚀 Run the app:

```bash
mvn clean javafx:run
```

## 🧩 Editing the UI
You can open (`login.fxml`) and (`game.fxml`) in SceneBuilder to modify the layout visually.

Download: https://gluonhq.com/products/scene-builder/

## 🔧 Future Improvements
- Save cart state between sessions
- Add product filtering or search
- Connect to a backend or database
- Display game thumbnails

## 🤝 Contributing
Contributions are welcome! If you’d like to improve this project or add features:

1. Fork the repository
2. Create a new branch (git checkout -b feature/your-feature-name)
3. Commit your changes (git commit -m 'Add feature')
4. Push to your branch (git push origin feature/your-feature-name)
5. Open a Pull Request

For major changes, open an issue first to discuss what you’d like to propose.
