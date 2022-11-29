@Assignment
Feature: Manage Assignment Page

  	Background: 
    Given User is on LMS website
    When User enters username and password credentials  
      | lms      | lms@123  |
    Then user lands on Home page

  	@Headervalidation
  	Scenario: Validate Assignment Heading
    Given User is logged on to LMS website
    When User Clicks on assignment page
    Then User should see a Header "Manage Assignment"

  	@Footervalidation
  	Scenario: Validate Assignment Footer
    Given User is logged on to LMS website
    When User Clicks on assignment page
    Then User should see a Footer text "In Total there are 3 assignments"

  	@paginator
  	Scenario: Validating Assignment Paginator
    When User Clicks on assignment page
    Then User should see a Paginator text "Showing 1 to 3 of entries"

  	@paginatornext
  	Scenario: Verify paginator - next button on the assignment page
    Given User is on Assignment page
    When User Clicks on Enabled paginator-next button
    Then User Should be navigated to next page

  	@paginatorprevious
  	Scenario: Verify paginator -previous button on the Assignment page
    Given User is on Assignment page
    When User Clicks on Enabled paginator-next button
    Then User Should be navigated to previous page

  	Scenario: Verify paginator -last button on the Assignment page
    Given User is on Assignment page
    When User Clicks on Enabled paginator-next button
    Then User Should be navigated to Last page

  	@tag7
  	Scenario: Verify paginator -first button on the Program page
    Given User is on Assignment page
    When User Clicks on Enabled paginator-next button
    Then User Should be navigated to First  page

  	@tag8
  	Scenario: Validate Search Feature
    Given User is logged on to LMS website
    When User clicks Search bar after entering Assignment name
    Then The requested assignment details should be displayed

  	@tag9
 		Scenario: Verify Assignment Name are displayed in Ascending order
    Given User is on Assignment page
    When User Clicks on Assignment Name Ascending Arrow
    Then User should see the Assignment Name displayed in Ascending order

 		@tag10
  	Scenario: Verify Assignment Description are displayed in Ascending order
    Given User is on Assignment page
    When User Clicks on Assignment Description Ascending Arrow
    Then User should see the Assignment Description displayed in Ascending order

  	@tag11
 		Scenario: Verify Assignment Duedate are displayed in Ascending order
    Given User is on Assignment page
    When User Clicks on Assignment Due Date Ascending Arrow
    Then User should see the Assignment Due Date displayed in Ascending order

  	@tag12
  	Scenario: Verify Assignment Grade  are displayed in Ascending order
    Given User is on Assignment page
    When User Clicks on Assignment Grade Ascending Arrow
    Then User should see the Assignment Grade displayed in Ascending order

  	@tag13
  	Scenario: Verify Assignment Name are displayed in Descending order
    Given User is on Assignment page
    When User Clicks on Assignment Name Descending Arrow
    Then User should see the Assignment Name displayed in Descending order

  	@tag14
  	Scenario: Verify Assignment Description are displayed in Descending order
    Given User is on Assignment page
    When User Clicks on Assignment Description Descending Arrow
    Then User should see the Assignment Description displayed in Descending order

  	@tag15
  	Scenario: Verify Assignment Duedate are displayed in Descending order
    Given User is on Assignment page
    When User Clicks on Assignment Due Date Descending Arrow
    Then User should see the Assignment Due Date displayed in Descending order

  	@tag15
 		Scenario: Verify Assignment Grade are displayed in Descending order
    Given User is on Assignment page
    When User Clicks on Assignment Grade Descending Arrow
    Then User should see the Assignment Grade displayed in Descending order

  	@Admin
  	Scenario: Validate Add New Assignment button
    Given Admin/User is on Manage Assignment page
    When Admin/User clicks a Add New Assignment button
    Then Admin/User should see a message "Staff only have access to add New Assignment"

  	@Nodetails
  	Scenario: No details Entered in  Assignment Details window
    Given Staff is on Assignment Details page
    When Staff  clicks on Save after leaving all the fields empty
    Then Staff should see an error message "Name is required"

  	@Alldetailsentered
  	Scenario: Staff Validate Assignment Details window with entering all fields
    Given Staff is on Assignment Details page
    When Staff enters assignment name,assignment description,assignment Grade and Duedate and clicks save
   
     | sdet         |  java               |  A  | 10/01/2022    |
    Then Staff should see a message "New Assignment successfully added"

 		@clickcancel
 		Scenario: Staff Click Cancel in Assignment Details window
    Given Staff is on Assignment Details page
    When Staff enters assignment name,assignment description,assignment Grade and Duedate and clicks cancel
    
    | sql         |  Tables              |  B  | 12/01/2022    |
    Then Staff should see a Assignment details window is closed

  	@Newassignmnet
 		Scenario: validate New assignment
    Given User is on Assignment page
    When User clicks on Assignment
    Then User should see a newly added Assignment

 	 @managebutton
  	Scenario: Validate  Manage button in Assignment Grade
    Given Staff is on Assignment  page
    When Staff clicks manage button under Assignment Grade
    Then Staff should be navigated to Grade Window

  	@EditbtnValidation
  	Scenario: Staff Validates Edit button
    Given Staff is on Assignment  page
    When Staff clicks an edit Assignment button
    Then Staff should see a Assignment details window

  	@Editfunctionality
  	Scenario: Edit functionality in Assignment page
    Given Staff is on Assignment  page
    When Staff edits all the fields after clicking on Edit button
    Then The fields should be edited successfully

  	@Googleform
  	Scenario: User/staff clicks Assignment Name
    Given User/Staff is on Assignment page
    When User/Staff clicks on Assignment Name
    Then User/Staff should be navigated to Assignment Google form page

  	@Admin
  	Scenario: Admin clicks Assignment Name
    Given Admin is on Assignment page
    When Admin clicks on Assignment Name
    Then Admin should see a warning message "you dont have access"

  	@tag15
  	Scenario: User/Staff validate assignment Google form with entering all fields
    Given User/Staff is on Assignment  Google form page
    When User/Staff enters all questions and clicks save
    | kalai Ganeshan | Tiger | Black |
    Then User/Staff entered google forms successfully

  	@tag
 	  Scenario: User/Staff validate assignment Google form leaving empty
    Given User/Staff is on Assignment  Google form page
    When User/Staff clicks on submit button after leaving all questions and mail id
    Then User/Staff should get a warning message "Must enter the mandatory fields"

  	@tag
  	Scenario: User/Staff Validate Assignment google form after cliclking clear button
    Given User/Staff is on Assignment  Google form page
    When User/Staff clicks clear form button after entering all questions and mail id
    Then The Assignment Google form cleared successfully
    
    @staffdelete
    Scenario: Staff clicks delete button
    Given Staff is on Manage Assignment page
    When Staff clicks on delete button on the righr side
    Then Staff should see a Delete Confirmation window
    
    @Staffdeleteyes
    Scenario: Staff click Yes in Delete confirmation window
    Given Staff is on Delete Confirmation window
    When Staff clicks Yes
    Then Staff Should see "Assignment Deleted Successfully
    
    @staffdeleteno
    Scenario: Staff clicks No button in Delete confirmation window
    Given  Staff is on Delete Confirmation window
    When Staff clicks No
    Then Confirmation delete window should be closed successfully
    
    @DeleteMultipleAssignment
    Scenario: Staff  validate delete button on the top left
    Given Staff is on Manage Assignment page
    When Staff clicks delete button on the top aftr selecting multiple checkbox
    Then Staff should see a  Delete confirm window
    
    @yesdelete
     Scenario: Staff click Yes in Delete confirmation window
    Given Staff is on Delete Confirmation window
    When Staff clicks Yes
    Then All Assignments are deleted Successfully
    
    @nodelete
     Scenario: Staff click No in Delete confirmation window
    Given Staff is on Delete Confirmation window
    When Staff clicks No
    Then Confirmation delete window should be closed successfully
    
    @chkbox
     Scenario: User/Staff validate individual checkbox
    Given User/Staff is on Assignments page
    When User/Staff clicks individual checkbox button 
    Then User/Staff should see a delete button on the top left
    
    @Admin
     Scenario: Admin validate individual checkbox
    Given Admin is on Manage Assignment page
    When Admin clicks individual checkbox button 
    Then Admin should see a warning message "Admin dont have access "
    
    @leftsidechkbox
     Scenario: User/Staff validate check box on the left side to the Assignment Name
    Given User/Staff is on Manage Assignment page
    When User/Staff clicks check box on the left side to the Assignment Name
    Then User/Staff should see a enabled delete button on the top left 
    




