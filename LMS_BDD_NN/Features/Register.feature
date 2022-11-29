		@Register
		Feature: Register Functionality

  	@Heading
  	Scenario: Validating the heading of the Registration form
    Given User is on LMS website
    When User lands on Registration page
    Then User should see the heading on the form as "Registration Form"

  	@LoginButtonVisibilty
  	Scenario: Validating the Login button visibility
    Given User is on LMS website
    When User lands on Registration page
    Then User should see a button with text "Log in" on the form

  	@LoginButton
  	Scenario: Validating the Login button functionality
    Given User is on the Registeration Page
    When User clicks on the Login button
    Then User should be navigated to Login page

  	@SignUpButtonVisibilty
  	Scenario: Validating the Sign Up button visibility
    Given User is on LMS website
    When User lands on Registration page
    Then User should see a button with text "Sign Up" on the form

 	 	@AllFieldsEmpty
  	Scenario: Validating the Sign Up form with all fields empty
    Given User is on the Registeration Page
    When User clicks submit button with all fields empty
    Then User should get a message "Enters all fields"

  	@ValidData
  	Scenario Outline: Validating Sign Up form with valid Credentials
    Given User is on the Registeration Page
    When User clicks Signup button after enters "<FirstName>" "<LastName>" "<Address>" "<StreetNmae>" "<City>" "<State>" "<Zip>" "<BirthDate>" "<PhoneMumber>" "<UserName>" "<Password>" and  "<Email>"
    Then Registeration should be successful
    Examples:
     | FirstName | LastName | Address | StreetName  | City  | State | Zip   | BirthDate  | PhoneNumber | UserName | Password | Email             |
     | Kalai     | Ganesan  | Apt@A2  | 32nd Street | Karur | TN    | 32121 | 23/11/2000 |  9039484893 | Kalai    | Kalai@23 | kalai23@gmail.com |

 	 @InvalidFirstName
  	Scenario Outline: Validating Sign up Functionality with invalid Credentials
    Given User is on the Registeration Page
    When User clicks Signup button after enters "<FirstName>" "<LastName>" "<Address>" "<StreetNmae>" "<City>" "<State>" "<Zip>" "<BirthDate>" "<PhoneMumber>" "<UserName>" "<Password>" and  "<Email>"
    Then User should see a error message

    Examples: 
      | FirstName | LastName | Address | StreetName  | City  | State | Zip   | BirthDate  | PhoneNumber | UserName | Password | Email             |
      | Kalai2312 | Ganesan  | Apt@A2  | 32nd Street | Karur | TN    | 32121 | 23/11/2000 |  9039484893 | Kalai    | Kalai@23 | kalai23@gmail.com |
      | Kalai     | Ganesan4 | Apt@A2  | 32nd Street | Karur | TN    | 32121 | 23/11/2000 |  9039484893 | Kalai    | Kalai@23 | kalai23@gmail.com |
      | Kalai     | Ganesan  | Apt     | 32nd Street | Karur | TN    | 32121 | 23/11/2000 |  9039484893 | Kalai    | Kalai@23 | kalai23@gmail.com |
      | Kalai     | Ganesan  | Apt@A2  | Street      | Karur | TN    | 32121 | 23/11/2000 |  9039484893 | Kalai    | Kalai@23 | kalai23@gmail.com |
      | Kalai     | Ganesan  | Apt@A2  | 32ndStreet  | Karur | TN    | 321   | 23/11/2000 |  9039484893 | Kalai    | Kalai@23 | kalai23@gmail.com |
      | Kalai     | Ganesan  | Apt@A2  | 32ndStreet  | Kar22 | TN    | 32121 | 23/11/2000 |  9039484893 | Kalai    | Kalai@23 | kalai23@gmail.com |
      | Kalai     | Ganesan  | Apt@A2  | 32ndStreet  | Karur |       | 32211 | 23/11/2000 |  9039484893 | Kalai    | Kalai@23 | kalai23@gmail.com |
      | Kalai     | Ganesan  | Apt@A2  | 32ndStreet  | Karur | TN    | 32121 | 23/11/2000 |    90394848 | Kalai    | Kalai@23 | kalai23@gmail.com |
      | Kalai     | Ganesan  | Apt@A2  | 32ndStreet  | Karur | TN    | 32121 |            | 9039484893  | Kalai    | Kalai@23 | kalai23@gmail.com |
      | Kalai     | Ganesan  | Apt@A2  | 32ndStreet  | Karur | TN    | 32121 | 23/11/2000 | 9039484893  | kalai23  | Kalai@23 | kalai23@gmail.com |
      | Kalai     | Ganesan  | Apt@A2  | 32ndStreet  | Karur | TN    | 32121 | 23/11/2000 | 9039484893  | Kalai    | Kalai    | kalai23@gmail.com |
      | Kalai     | Ganesan  | Apt@A2  | 32ndStreet  | Karur | TN    | 32121 | 23/11/2000 | 9039484893  | Kalai    | Kalai@23 | kalai23.com       |
   
       
