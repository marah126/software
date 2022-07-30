Feature: Unregister user
 Scenario: successful unregister
 Given a user with ID "1234567" , name "Marah" , email " marah@gmail.com" , address "AlQuds street" ,postal code "M5M2T5" , and city "Nablus" id registered in the library
 And  admin is logged in
 When the try to unregister the user 
 Then the user is out of the library
 
Scenario: user has borrowed books
Given a user with ID "1234567" , name "Marah" , email " marah@gmail.com" , address "AlQuds street" ,postal code "M5M2T5" , and city "Nablus" id registered in the library
 And  admin is logged in
 And user has borrowed book
 When the try to unregister the user
 Then the user sould still in the library
 
 Scenario: user has fine unpaid 
 Given a user with ID "1234567" , name "Marah" , email " marah@gmail.com" , address "AlQuds street" ,postal code "M5M2T5" , and city "Nablus" id registered in the library
 And  admin is logged in
 And user has unpaid fine
 When the try to unregister the user
 Then the user sould still in the library
 