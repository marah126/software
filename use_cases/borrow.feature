Feature: borrow book
Description:Only register user can borrow book, and each book has one copy 

Background: borrow

Given these usere registered in the library 
		| 1234567 | Marah | marah@gmail.com |AlQuds street|M5M2T5|Nablus|
		| 1478523 | Sarah | sarah@gmail.com |Masaken|S3S1T5|Nablus|
		| 1236547 | Yafa | yafa@gmail.com |water street|Y3Y1T5|Nablus|
And  these books contained in the library  
		| XP Programming Book | Kent Beck |Kent99 |
		| C++ Development | Alu and Sami |Alu07 |
		| Cucumber Java | Seb Rose | Rose54 |
		| programming C++ | Deitel | Deitel4 |		
		| Java programming | Ashraf Armoush | Ashraf22 |
And these books borrowed 
		| 1234567|XP Programming Book | Kent Beck |Kent99 |

Scenario: unregistered user
Given there is a user has ID "2984754" , name "Ahmad" , email "ahm@gmail.com" , address "Nablus street" ,postal code "H3H1T5" , and city "Nablus"
And there is a book with title " XP Programming Book " , auther "Kent Beck " and code "Kent99"
When the user tries to borrow this book
Then error massage "This user is not registered" should display 

Scenario: unavailable book
Given there is a user has ID "1234567" , name "Marah" , email " marah@gmail.com" , address "AlQuds street" ,postal code "M5M2T5" , and city "Nablus"
And there is a book with title " software  Book " , auther "haya sam  " and code "haya55"
When the user tries to borrow this book
Then error massage "This book is not available in the library" should display 

Scenario: available book but borrowed
Given there is a user has ID "1234567" , name "Marah" , email " marah@gmail.com" , address "AlQuds street" ,postal code "M5M2T5" , and city "Nablus"
And there is a book with title " XP Programming Book " , auther "Kent Beck " and code "Kent99"
And the book is borrowed 
When the user tries to borrow this book
Then error massage "you cant borrow this book because it is borrowed by some one else" should display


Scenario: successful borrowing
Given there is a user has ID "1234567" , name "Marah" , email " marah@gmail.com" , address "AlQuds street" ,postal code "M5M2T5" , and city "Nablus"
And there is a book with title " C++ Development " , auther " Alu and Sami" and code "Alu07"
And the book is not borrowed 
When the user tries to borrow this book
Then the boorowing should success

Scenario: user tries to borrow moe than maximum books
Given there is a user has ID "1234567" , name "Marah" , email " marah@gmail.com" , address "AlQuds street" ,postal code "M5M2T5" , and city "Nablus"
And this user has borrowed maximum books
And there is a book with title " programming C++ " , auther " Deitel" and code "Deitel4"
When the user tries to borrow this book
Then error massage "you cant borrow this book you have borrowed maximum books" should display 


Scenario: User cannot borrow books if he has late books
Given a book with code "xyz" is in the library 
And a book with code "Beck99" is in the library
And the user is registered with the library
When the user borrows the book with code "Beck99"
And 21 days have passed 
And the user borrows the book with code "xyz"
Then the book with code "xyz" is not borrowed by the user 
And the error message "You can't borrow any new book because you have an overdue books" is given

Scenario: User cannot borrow books if he has fine 
Given a book with code "Beck99" is in the library 
And a book with code "xyz" is in the library
And the user is registered with the library
When the user borrows the book with code "Beck99"
And 21 days have passed 
Then the user has to pay a fineof 30 NIS
When the user returns the book with code "Beck99"
Then the user has to pay a fineof 30 NIS
When the user borrows the book with code "xyz"
Then the book with code "xyz" is not borrowed by the user 
And the error message "Can't borrow book , you have fines" is given