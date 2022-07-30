Feature: returning  books for library after borrowing it based on title,author or code
	
	Scenario:  for  successful return
	Given there is a user  ID "1234567" , name "Marah" , email "marah@gmail.com" , address "ALQuds street" , postal code "H3H1T5" , city "Nablus" 
	And there is a book with title "XP Programming Book " , auther "Kent Beck " , code "Kent99 "
	And user is registered in library
	And the user has borrowed this book
	When action (return) happens  
	Then the book not be borrowed
	
	
	Scenario: user return a book that not borrowed by this user
	Given there is a user  ID "1234567" , name "Marah" , email "marah@gmail.com" , address "ALQuds street" , postal code "H3H1T5" , city "Nablus" 
	And there is a book with title "XP Programming Book " , auther "Kent Beck " , code "Kent99 "
	And user is registered in library
	When action (return) happens  
	Then error message should  display "this book is not borrowed by you"
	
	
	
	Scenario: user not registered
	Given there is a user  ID "2984754" , name "Ahmad" , email "ahm@gmail.com" , address "Nablus street" , postal code "H3H1T5" , city "Nablus" 
	When action (return) happens  
	Then error message should  display "this user is not registered"