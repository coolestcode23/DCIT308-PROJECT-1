# Pharmacy Management System

This Pharmacy Management System is a Java-based application designed to streamline the management of a pharmacy. Developed using IntelliJ IDEA and MySQL as the database, this system offers a range of features to efficiently handle various pharmacy operations.

## Features

- **Add Drugs**: Easily add new drugs to the inventory with necessary details.
- **Remove Drugs**: Remove drugs from the inventory when they are no longer available or needed.
- **Search Drugs**: Quickly search for drugs in the inventory using different criteria.
- **Sales Tracking**: Retrieve sales records based on date and time to monitor transactions and generate reports.
- **Receipt Printing**: Print a particular receipt in pdf format.

## Technologies Used

- **Java**: The core programming language for the application.
- **IntelliJ IDEA**: The integrated development environment (IDE) used for development.
- **MySQL**: The relational database management system used for storing and managing data.


### Installation

1. **Clone the Repository**
   ```sh
   git clone https://github.com/ankuobed/pharmacy-system.git
   cd pharmacy-system
   ```

2. **Setup MySQL Database**
   - Create a new database in MySQL.
   - On macos run `mysql -u username -p < ./database_setup.sql`.
   - On windows run `Get-Content ./database_setup.sql | mysql -u username -p`.
   - Replace the PASSWORD constant in the DatabaseConnection file with your database password.

4. **Run the Application**
   - Open the project in IntelliJ IDEA.
   - Build and run the project.

## Usage

- **Adding Drugs**: Navigate to the 'Add Drugs' section, fill in the details, and click 'Add'.
- **Removing Drugs**: Go to the 'Remove Drugs' section, select the drug to be removed, and click 'Remove'.
- **Searching Drugs**: Use the 'Search Drugs' feature to find drugs based on name, category, etc.
- **Sales Tracking**: Use the 'Sales' section to view and retrieve sales data based on specific date and time ranges.

## Contributing

Contributions are welcome! Please fork this repository and submit pull requests for any improvements or new features.
