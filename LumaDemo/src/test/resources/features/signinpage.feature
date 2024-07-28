Feature: To validate signin Page Functionality
			
As a user I want to login via valid ID password


 Background:
    Given I am on the Luma Home page
    When I able to click on "Sign In" Link
    Then I should be redirected to the Sign In Page
   
@ValidSignIn 
 Scenario: Sucessfully Login with Valid Credentials
   Given I have entered LoginId as "Jhom.doe@Test.com"
    When I enter LoginPassword as "User@12345"
    When I click on the Sign In button
    Then "Welcome, Jhon Doe!" text is present
    
    
@BlankSignIn 
 Scenario: Sucessfully Login with Valid Credentials
   Given I have entered LoginId as ""
    When I enter LoginPassword as ""
    When I click on the Sign In button
    Then Error message for Blank Email and Password is displayed
    
  @InvalidEmailPasswordCombination     
 Scenario Outline: Invalid Email password combination
    Given I have entered LoginId as "<email>"
    When I enter LoginPassword as "<password>"
    When I click on the Sign In button
    Then "<errorMessage>" Error is displayed on signIn Page

    Examples:
      | email  |password |errorMessage |
      | Jhom1.doe@Test.com |User@12345|The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.|
      |  Jhom.doe@Test.com | User@123456 |The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.|