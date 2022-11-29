#Author: sridevi@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@login
Feature: Login feature

  @tag1
  Scenario: Validating the login url
    Given user is on Browser
    When user opens the LMS website  
    Then user should be navigated to login page
    
  @tag2
  Scenario Outline: Validating login functionality with valid credentials
    Given Any role is on Login Page
    When Any role clicks login button after entering valid credentials "<Username>" "<Password>" "<Role>" "<Code>"
    Then Any role see header text as "Manage Program"

	Examples:

	  | Username | Password | Role | Code  |
 		| admin    | admin123 | Admin| 23478 |
  	| staff12  | staff@1  | Staff| 56842 |
  	| lms  		 | lms      | User | 			 |
  	
		
  
  @tag3 
  Scenario Outline: Validating login functionality with invalid credentials
    Given Any role is on Login Page
    When Any role clicks login button after entering invalid credentials "<Username>" "<Password>" "<Role>" "<Code>"
    Then Any role should see a error message "<ExpErrorMsg>"

	Examples:
	
	| Username  | Password |	Role  | Code | ExpErrorMsg | 
	| lms 		  | lsms__   | Admin  | 23478|Entered Invalid Password |
	| lms&&			| lms@12	 | Admin  | 23478|Entered Invalid Username |
	| invalidusr| lsms__	 | Admin	|      |The code is required |
	| lmsstaff 	| lsms__   | Staff  | 56842|Entered Invalid Password |
	| Staff&&	  | lms@12	 | Staff  |	56842|Entered Invalid Username |
	| invalidusr| lsms__	 | Staff	|      |The code is required |
	| lms 		  | lsms__   | user   | 		 |Entered Invalid Password |
	| lms&&			| lms@12	 | user		|			 |Entered Invalid Username |
	| invalidusr| lsms__	 | user   |      |The username and password  are incorrect |
	| lms 		  | lsms__   | user   |      |Enter valid Password |
	
	@tag4
	  Scenario: Validate forgot password link
	    Given user is on Login Page
	    When user clicks Forgot password link
	    Then User Should see Enter Email text box
	    
	@tag5
	  Scenario: Validate forgot password with  email id
	    Given user is on Login Page and sees Enter Email text box
	    When user  clicks continue after entering valid email address  
	    Then user should be redirected to enter verification code page and verification code will be sent to email

@tag6
	  Scenario: Validate verifiction code
	    Given user is on Enter verification code Page
	    When user  clicks continue after entering verification code   
	    Then user should be redirected reset password page
	    
@tag7
	  Scenario: Validate click here link in verification code page
	    Given user is on Enter verification code Page
	    When user clicks Click here link to resend 
	    Then The verification code should be resend to email
	    
@tag8 
		Scenario: Validate Reset password with Valid password
		Given user is on Reset Password Page
		When user clicks submit button after entering new password and retype password
	  Then user  should be redirected to login page
		

		@tag9 
		Scenario Outline: Validate Reset password with invalid password
		Given user is on Reset Password Page
		When user  clicks submit button after entering new password "<NewPassword>" and retype password "<RetypePassword>"
	  Then user  should see an error message "<ErrorMsg>"

Examples:

		| NewPassword | RetypePassword | ErrorMsg |
		|Lmsgftf@12   | Lmsgftf@1      | password and retype password are mismatched |
		|Lms@12   		| Lms@12      	 | The password must contain 8 characters |
		|lmsgftf@12   | lmsgftf@12     | The password must contain one Capital letter |
		|Lmsgftf@rf   | Lmsgftf@rf     | The password must contain one Number |
		|Lmsgftf12    | Lmsgftf12      | The password must contain one Special character |

@tag10 
		Scenario: Validate Reset password with cancel button
		Given user is on Reset Password Page
		When user clicks cancel button after entering new password and retype password 
	  Then user  should see a refreshed reset password page with empty fields
