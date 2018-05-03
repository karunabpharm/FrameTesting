Feature: FaceBook Login Functionality Testing
Scenario Outline: Validating Login Functionality
Given Open Chrome Browser and Navigate to FaceBook Home Page
When User Enters Valid "<UserId>" And Valid "<PassWord>" And Click On SigIn Button
Then user Shouild able to Sucessfully LogIn and close the Application

Examples:
| karunabpharm|07429186166Kk|
| karunabpharm@gmail.com|07429186166Kk|


 