# Online Banking System

This project is a Java-based Online Banking System that supports different types of accounts and payment methods. It demonstrates the use of object-oriented programming concepts such as inheritance, polymorphism, and interfaces.

## Project Structure

```
online-banking-system
├── src
│   └── com
│       └── banking
│           ├── accounts
│           │   ├── Account.java
│           │   ├── SavingsAccount.java
│           │   └── CurrentAccount.java
│           ├── payments
│           │   ├── Payment.java
│           │   ├── SecurePayment.java
│           │   ├── OnlineTransaction.java
│           │   ├── UPIPayment.java
│           │   └── CardPayment.java
│           └── Main.java
├── README.md
└── .gitignore
```

## Features

- **Account Types**: The system supports different account types, including Savings and Current accounts, each with specific properties and behaviors.
- **Payment Methods**: It includes various payment methods such as UPI and Card payments, demonstrating the use of interfaces for payment processing.
- **Runtime Polymorphism**: The system showcases runtime polymorphism through the use of an Account reference to handle different account types.

## Setup Instructions

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Compile the Java files using a Java compiler.
4. Run the `Main` class to see the system in action.

## Usage Examples

- Create instances of `SavingsAccount` and `CurrentAccount` to manage different types of accounts.
- Use `UPIPayment` and `CardPayment` classes to process payments.
- Demonstrate polymorphism by calling the `displayDetails()` method on an `Account` reference.

## Contributing

Feel free to fork the repository and submit pull requests for any improvements or features you would like to add.

## License

This project is open-source and available under the MIT License.