@User
Feature: ManageUser

Background:
Given  User Logged on to LMS website

  @Page/HeaderValidation
  Scenario: Validating landing in Manage page
    Given User is on any page after Login
    When  User clicks the Tab User
    Then  User should see the Manage user page

 @FooterValidation
  Scenario: Validating table footer
   Given User Logged on to LMS website
   When  User lands on Manage User page
   Then  User should see the table footer as "In total there are 4 users"
    
    @Pagination
    Scenario: Verifying pagination links
    Given User Logged on to LMS website
    When  User lands on Manage User page
    Then  User sees pagination links are disabled
    
    Scenario: Validate the presence of pagination
    Given User is on any page after Login
    When  User lands on Manage User page
    Then  User should see the pagination controls below data table
    
    Scenario: Validate the Pagination control with less rows
    Given User Logged on to LMS website
    When  User clicks the Tab User
    Then  User Pagination control should be disabled
    
   Scenario: Validate the Pagination control with more than five rows
    Given User Logged on to LMS website
    When  Manage user table has more than five rows
    Then  Pagination control should be enabled  
    
   Scenario: Verifiy the entry details below data table
   Given User Logged on to LMS website
   When  User lands on Manage User page
   Then  User should see the text "Showing 1 to 4 of 4 entries" below the user table.
   
@Search
   Scenario: verify search text box
    Given User Logged on to LMS website
    When  User lands on Manage User page
    Then  User see the Search Text box 
    
    Scenario: verify search text box
    Given User Logged on to LMS website
    When  User enters Name to be searched
    Then  User namewith the rows should be displayed
    
 @AddNewUserFunctionality  
 Scenario: Validate the presence of Add new user button
    Given User Logged on to LMS website
    When  User lands on Manage User page
    Then  User should see the button with text  Add New User  
    
   Scenario: Verify the functionality of Add new user button
    Given User Logged on to LMS website
    When  User clicks Add New User
    Then  User should see the "User details" dialog box
    
  @Tableheader  
   Scenario: Validating Table header
    Given User is on any page after Login
    When  User lands on Manage User page
    Then  User should see the table header as "Empty checkbox-icon , ID with sort icon, Name with Sort icon, Email Address with sort icon,Contact Number with sort icon, Batch with sort icon, Skill with Sort icon, Edit/Delete as column names
 
 Scenario: Verify the functionality of sort icon present in table header
    Given User Logged on to LMS website
    When  User lands on Manage User page
    Then  User Table rows should be sorted
    
 Scenario: Verify the functionality of sort icon present in table header
    Given  User lands on Manage User page
    When  User checks empty checkbox in header
    Then  User Check box in all the rows of user table should be checked
    
  @Deleteicon
   Scenario: Verify the presence of Delete icon in manage user page
   Given User is on any page after Login
   When User lands on Manage User page
   Then User should see the delete icon at the top left corner of the user table
   
   Scenario: Validating Confirm dialog box by selecting Yes
   Given User lands on Manage User page
   When User  clicks button with text "Yes"
   Then User Selected rows should be deleted and popup should be shown with success message "User deleted"
    
    Scenario: Validating Confirm dialog box by clicking close(x) icon
   Given User lands on Manage User page
   When  User clicks the close(x)icon
   Then User should see Confirm dialog box should be closed
   
  @Edit/Deleteiconineachrow
   Scenario: Validate the presence of Edit/Delete icon
   Given User is on any page after Login
   When User lands on Manage User page 
   Then User should see the buttons with edit/delete icon in each row of Edit/Delete coulmn
   
   @ID
   Scenario: Verify ID functionality
   Given User lands on Manage User page
   When  User clicks ID in any row
   Then User see dialog box displayed with user information
   
   @UserDetailsWindow
   Scenario: Verify the heading of User Details window
   Given User lands on Manage User page
   When  User clicks Add New User
   Then User should see the "User details" dialog box
   
   @Cancelbutton
   Scenario: Validate Functionality of Cancel button
   Given User lands on Manage User page
   When  User clicks on cancel button
   Then User see User Details window getting  closed
   
   @Cancel(x)icon
   Scenario: Validate Functionality of Cancel(X)icon
   Given User lands on Manage User page
   When  User clicks on cancel (X)icon
   Then User Details window should be closed
   
   @Submitbutton
   Scenario: Verify the presence of Submit button in User Details window
   Given User lands on Manage User page
   When  User clicks Add New User
   Then  should see a button with text as Submit in user details window
   
   @LabelText
   Scenario: Verify the presence of Label Texts
   Given User lands on Manage User page
   When  User clicks Add New User
   Then  should see the placeholders with Text As "First name","Middle name", Last name","Email adress","Phone no", "Address","City", "State","Postal Code"."Program","UG Program","PG Program","Skill","Experience","Admin/User/Staff Role",Visa status","Batch","Comments"
  
  @Dropdown 
  Scenario: Verify drop down menu for state
   Given User lands on Manage User page
   When  User clicks Add New User
   Then User should select from the drop down menu for state
   
   
  Scenario: Verify drop down menu for user role
   Given User lands on Manage User page
   When  User clicks Add New User
   Then User should select from the drop down menu for user role
   
  
   @Submitbuttonfunctionality
   Scenario: Validating the User Details window with all fields empty
   Given User lands on Manage User page
   When  User clicks submit button with all details empty
   Then  User should see a Error message "Mandatory Fields cannot be empty"
   
    Scenario: Adding new User
   Given User lands on Manage User page
   When  User clicks submit button with all details filled
   Then  User sees Success message  "New User Created"  is  Should be Saved.
   
   @Namefield
    Scenario: Validating the User Details window with few fields empty
   Given User lands on Manage User page
   When  User clicks submit button with all details empty
   Then  User see error message "Name is required"
   
   @EmailId
    Scenario: Validating the Email address
   Given User lands on Manage User page
   When  User clicks submit button with all details empty
   Then  User see error message "Invalid Email address"
   
  @Address2button 
  Scenario: Validating the presence of Address2 button
   Given User lands on Manage User page
   When  User clicks submit button with all details empty
   Then  User should see the button with text   "+ Add C/O, Apt, Suite, Unit" 
   
   @PhoneNumber
   Scenario: Validating the Phone number
   Given User lands on Manage User page
   When  Enters more than ten digits
   Then  User sees error message "Invalid Input"
   
   @PostalCode
    Scenario: Validating Postal Code
   Given User lands on Manage User page
   When  User Enters more than 5 digits
   Then  User sees error message "Invalid Input"
   
   @State
   Scenario: Validating State dropdown
   Given User lands on Manage User page
   When  User clicks on state dropdown
   Then  User see list of states in Alphabetical Order
   
   @UGProgram
      Scenario: Validating UG Program Dropdown
   Given User lands on Manage User page
   When  User clicks on UG Program dropdown
   Then  User  see list of UG Program 
   
   @ValidatingAddressline
    Scenario: Validating Address line  in User Details window
   Given User is on "User Details"window
   When  User clicks the button "+ Add C/O, Apt, Suite, Unit"
   Then  User should see the input field with Label "New Address2"