
Feature: To check new account creation Functionality

  As a new user of the Luma website
  I want to be able to create account

  Background:
    Given I am on the Luma Home page
    When I able to click on "Create an Account" Link
    Then I should be redirected to the Create Account page

  Scenario: Sucessfully create New Account
    Given I have enterd First Name "Jhon" and last Name "Doe"
    When I have entered emailId as "Jhom.doe@Test.com"
    When I enter password as "User@12345"
    When I enter confirm password as "User@12345"
    When I click on the Create an Account button
    Then message "Thank you for registering with Main Website Store." or message "There is already an account with this email address. If you are sure that it is your email address, " is displayed
	
 Scenario Outline: Invalid EmailId or Blank EmailID Test
    Given I have enterd First Name "Jhon" and last Name "Doe"
    When I have entered emailId as "<emailID>"
    When I enter password as "User@12345"
    When I enter confirm password as "User@12345"
    When I click on the Create an Account button
    Then Invalid Email Message is displayed

    Examples:
      | emailID          | 
      | invalid@emailcom |
      | abcccc            | 
      | validemail.com   |
      | |
      
 @InvalidPass     
 Scenario Outline: Invalid password 
   
    When I enter password as "<password>"
   Then "<errorMessage>" Error is displayed

    Examples:
      | password  | errorMessage |
      | invalid123 |Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.|
      | 123456789 |Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters. |
      | abcA!2   |Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.|
      | ABC |Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.|
 @InvalidPasswordCombination     
 Scenario Outline: Invalid password ConfirmPass combination
    Given I have enterd First Name "Jhon" and last Name "Doe"
    When I have entered emailId as "Jhom.doe@Test.com"
    When I enter password as "<password1>"
   When I enter confirm password as "<password2>"
   When I click on the Create an Account button
   Then "<errorMessage>" Error is displayed

    Examples:
      | password  |password2 |errorMessage |
      | Pass@124 ||This is a required field.|
      |  Pass@124 | Pass@1244 |Please enter the same value again.|
 
 @AllFieldBlank
 Scenario: Sucessfully All Field Blank
    Given I have enterd First Name "" and last Name ""
    When I have entered emailId as ""
    When I enter password as ""
    When I enter confirm password as ""
    When I click on the Create an Account button
    Then Validate Error Message of All fields
	