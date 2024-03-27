create table Employee (
    EmployeeId int primary key auto_increment,
    First_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    DateOfBirth date,
    Gender char(1),
    Email varchar(100),
    PhoneNumber varchar(20),
    Address varchar(255),
    Position varchar(100),
    JoiningDate date,
    TerminationDate date
);

create table Payroll (
    PayrollID int primary key auto_increment,
    EmployeeId int,
    foreign key (EmployeeId) references Employee(EmployeeID),
    PayPeriodStartDate date,
    PayPeriodEndDate date,
    BasicSalary decimal(10, 2),
    OvertimePay decimal(10, 2),
    Deductions decimal(10, 2),
    NetSalary decimal(10, 2)
);

create table Tax (
    TaxID int primary key auto_increment,
    EmployeeId int,
    foreign key (EmployeeId) references Employee(EmployeeId),
    TaxYear int,
    TaxableIncome decimal(10, 2),
    TaxAmount decimal(10, 2)
);
drop table financialrecord;
create table FinancialRecord (
    RecordID int primary key auto_increment,
    EmployeeId int,
    foreign key (EmployeeId) references Employee(EmployeeId),
    RecordDate date,
    Description varchar(255),
    Amount decimal(10, 2),
    RecordType varchar(20)
);

insert into Employee (First_name, last_name, DateOfBirth, Gender, Email, PhoneNumber, Address, Position, JoiningDate, TerminationDate)
values
('Rajesh', 'Kumar', '1990-05-15', 'M', 'rajesh.kumar@example.com', '1234567890', 'Bangalore', 'Software Engineer', '2020-01-01', NULL),
('Priya', 'Sharma', '1985-08-20', 'F', 'priya.sharma@example.com', '2345678901', 'Mumbai', 'Project Manager', '2019-06-15', NULL),
('Vikram', 'Singh', '1992-12-10', 'M', 'vikram.singh@example.com', '3456789012', ' Delhi', 'Software Engineer', '2021-03-10', NULL),
('Anjali', 'Patel', '1988-07-25', 'F', 'anjali.patel@example.com', '4567890123', 'Chennai', 'HR Manager', '2022-05-01', NULL),
('Amit', 'Sharma', '1991-03-05', 'M', 'amit.sharma@example.com', '5678901234', ' Kolkata', 'Finance Analyst', '2023-09-20', NULL),
('Neha', 'Gupta', '1987-09-30', 'F', 'neha.gupta@example.com', '6789012345', 'Hyderabad', 'Marketing Manager', '2018-12-05', NULL),
('Rahul', 'Yadav', '1993-06-12', 'M', 'rahul.yadav@example.com', '7890123456', ' Pune', 'Software Engineer', '2017-04-30', NULL),
('Sneha', 'Rajput', '1995-01-28', 'F', 'sneha.rajput@example.com', '8901234567', ' Ahmedabad', 'Product Manager', '2016-10-15', NULL),
('Rakesh', 'Mishra', '1989-11-03', 'M', 'rakesh.mishra@example.com', '9012345678', ' Jaipur', 'Sales Manager', '2024-02-20', NULL),
('Pooja', 'Verma', '1986-04-17', 'F', 'pooja.verma@example.com', '0123456789', ' Lucknow', 'Operations Manager', '2023-07-01', NULL);
use payxpert;


insert into Payroll (EmployeeID, PayPeriodStartDate, PayPeriodEndDate, BasicSalary, OvertimePay, Deductions, NetSalary)
values
    (1, '2024-02-01', '2024-02-29', 50000.00, 2000.00, 5000.00, 47000.00),
    (2, '2024-02-01', '2024-02-29', 45000.00, 1500.00, 4000.00, 41500.00),
    (3, '2024-02-01', '2024-02-29', 55000.00, 2500.00, 6000.00, 51500.00),
    (4, '2024-02-01', '2024-02-29', 48000.00, 1800.00, 4500.00, 44300.00),
    (5, '2024-02-01', '2024-02-29', 60000.00, 3000.00, 7000.00, 53000.00),
    (6, '2024-02-01', '2024-02-29', 52000.00, 2000.00, 5500.00, 46500.00),
    (7, '2024-02-01', '2024-02-29', 48000.00, 1600.00, 5000.00, 42400.00),
    (8, '2024-02-01', '2024-02-29', 45000.00, 1800.00, 4000.00, 41200.00),
    (9, '2024-02-01', '2024-02-29', 52000.00, 2200.00, 5500.00, 44700.00),
    (10, '2024-02-01', '2024-02-29', 49000.00, 2000.00, 4800.00, 42200.00);

insert into Tax (EmployeeID, TaxYear, TaxableIncome, TaxAmount)
select 
    p.EmployeeID,
    year(p.PayPeriodStartDate) as TaxYear,
    p.BasicSalary + p.OvertimePay - p.Deductions as TaxableIncome,
    (p.BasicSalary + p.OvertimePay - p.Deductions) * 0.2 as TaxAmount 
from Payroll p
limit 10; 

insert into FinancialRecord (EmployeeID, RecordDate, Description, Amount, RecordType)
values
    (1, '2024-02-05', 'Bonus', 5000.00, 'Income'),
    (2, '2024-02-10', 'Travel Expense', 2000.00, 'Expense'),
    (3, '2024-02-15', 'Training Course Fee', 3000.00, 'Expense'),
    (4, '2024-02-20', 'Office Supplies', 1000.00, 'Expense'),
    (5, '2024-02-25', 'Sales Commission', 6000.00, 'Income'),
    (6, '2024-02-28', 'Internet Bill', 800.00, 'Expense'),
    (7, '2024-02-05', 'Consultancy Fee', 4000.00, 'Income'),
    (8, '2024-02-10', 'Marketing Campaign', 3500.00, 'Expense'),
    (9, '2024-02-15', 'Rent', 7000.00, 'Expense'),
    (10, '2024-02-20', 'Product Sales', 12000.00, 'Income');




