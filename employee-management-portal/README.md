# Employee Management Portal

A simple Java Swing application organized using MVC:

- `model` contains employee data and authentication/password logic.
- `view` contains the login, main window, and employee/password dialogs.
- `controller` connects view actions to model operations.

The initial login is `admin` / `admin123`. Employees are kept in memory for the
current run.

Compile and run from the `employee-management-portal` directory with a JDK:

```powershell
javac -d out (Get-ChildItem -Recurse src\main\java\*.java | ForEach-Object FullName)
java -cp out com.example.employeemanagement.Main
```
