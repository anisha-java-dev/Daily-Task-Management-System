# Daily-Task-Management-System

A **Java Console-Based Daily Task Management System** developed using **JDBC** and **MySQL**. This application helps users manage their daily tasks efficiently by allowing them to add, update, search, delete, and track task progress.

---

## 🚀 Features

- ➕ Add New Task
- 📄 View All Tasks
- 🔍 Search Task by Name
- ✅ Mark Task as Completed
- 🗑️ Delete Task
- ⏳ Show Pending Tasks
- 📊 View Task Progress
- 📅 Automatically Store Task Created Date & Time
- 🎯 Set Task Deadline
- ⚠️ Exception Handling for Invalid Input
- ✔️ Input Validation for Task Name

---

## 🛠️ Technologies Used

- Java
- JDBC
- MySQL
- Collection Framework
- Exception Handling
- PreparedStatement
- LocalDate & LocalTime
- Scanner Class

---

## 🗄️ Database

**Database Name:** `DailyTaskDatabase`

**Table Name:** `DailyTask`

### Table Structure

| Column | Data Type |
|---------|-----------|
| id | INT (Primary Key, Auto Increment) |
| task_name | VARCHAR(255) |
| status | VARCHAR(255) |
| created_date | DATE |
| created_time | TIME |
| deadline | DATE |

---

## 📌 Project Workflow

1. Connect Java with MySQL using JDBC.
2. Display the main menu.
3. User selects an operation.
4. Perform CRUD operation on the database.
5. Display the result.
6. Repeat until the user exits.

---

## 📋 Menu

```text
******** Daily Task Management System ********

1. Add Task
2. View Tasks
3. Search Task
4. Update Task Status
5. Delete Task
6. Show Pending Tasks
7. View Progress
8. Exit
```

---

## 📊 Progress Calculation

Progress is calculated using the formula:

```
Progress = (Completed Tasks / Total Tasks) × 100
```

Progress Messages:

- 🏆🔥 Excellent (90% and above)
- 😊👍 Good (60% - 89%)
- 😐⚡ Keep Going (30% - 59%)
- 😴📌 Start Completing Tasks (Below 30%)

---

## 📷 Sample Output

```text
******** Daily Task Management System ********

1. Add Task
2. View Tasks
3. Search Task
4. Update Task
5. Delete Task
6. Show Pending Tasks
7. View Progress
8. Exit

Enter your choice:
```

---

## 🎯 Learning Outcomes

This project helped me understand:

- Java Programming
- JDBC Connectivity
- CRUD Operations
- MySQL Database
- PreparedStatement
- Exception Handling
- Input Validation
- Date & Time API
- Console-Based Application Development

---

## 🔮 Future Enhancements

- Login & Registration
- GUI using Java Swing or JavaFX
- Email Notifications
- Reminder System
- Task Categories
- Priority Levels
- Export Tasks to PDF/Excel

---

## 👩‍💻 Author

**Anisha Chavan**

- B.Sc. Computer Science
- Java Full Stack Developer (Fresher)
- Passionate about Java, JDBC, SQL, and Software Development

---

⭐ If you like this project, don't forget to give it a star!
