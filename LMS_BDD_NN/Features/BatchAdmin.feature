Feature: Manage Batch Page Accessed by Admin

Background:
  Given Admin Logged on to LMS Website 
  
   @Admin
   Scenario: Admin Validate Add A New Batch button
   Given Admin is on Manage Batch page 
   When Admin Clicks on + A New Batch button
   Then Admin see header text as "Batch Details"
   
   @Admin
   Scenario: No details Entered in Batch Details window
   Given Admin Clicks on + A New Batch button
   When Admin Clicks on Save button with out entering details 
   Then Admin see Error message "Name is required"
   
   @Admin
   Scenario: Enters Only Name in Batch Details Dialog
   Given Admin Clicks on + A New Batch button
   When Admin Clicks on Save button after entering Name details 
   Then Admin see Error message as "Description is required"
     
   @Admin
   Scenario: Selects only a Program name from Dropdown in Batch Details window 
   Given Admin Clicks on + A New Batch button
   And Clicks on DropDown Menu in Batch Details window
   When Admin Clicks on Save button after selecting a Program Name only from the dropdown
   Then Admin see Error message "Name is required"
   
   @Admin
   Scenario: Selects Status only in Batch Details window
   Given Admin Clicks on + A New Batch button
   When Admin Clicks on Save button after selecting Status alone 
   Then Admin see Error message "Name is required"
   
   @Admin 
   Scenario: Enters Only Number Of Classes in Batch Details window
   Given Admin Clicks on + A New Batch button
   When Admin Clicks on Save button after entering Only Number Of Classes
   Then Admin see Error message "Name is required"
      
   @Admin 
   Scenario: Click on Cancel button in Batch Details window
   Given Admin Clicks on + A New Batch button
   When Admin Clicks on Cancel button
   Then Admin see a Batch Details window getting closed
   
   @Admin 
   Scenario: Enters Only Description in Batch Details window
   Given Admin Clicks on + A New Batch button
   When Admin Clicks on Save button with entering only Description details 
   Then Admin see Error message "Name is required"
   
   @Admin
   Scenario: Enter All details in Batch Details window
   Given Admin Clicks on + A New Batch button
   When Admin Clicks on Save button after entering all detail
   Then Admin see Success message "New Batch Created"
  
   @Admin 
   Scenario: Admin Validate First Edit button
   Given Admin is on Manage Batch page 
   When Admin Clicks on first Edit buttton 
   Then Admin see header text as "Batch Details"
   
   @Admin
   Scenario: Admin Edits batch Name in Batch Details window
   Given Admin Clicks on first Edit buttton 
   When Admin Clicks on Save button after updating Name 
   Then Admin see Updated message as "Updated Name"
   
   @Admin
   Scenario: Admin Edits batch Description in Batch Details window
   Given Admin Clicks on first Edit buttton 
   When Admin Clicks on Save button after updating Description 
   Then Admin see Update message as "Updated Description"
   
   @Admin  
   Scenario: Admin Edits Program Name in Batch Details window
   Given Admin Clicks on first Edit buttton 
   When Admin Clicks on Save button after updating Program ame 
   Then Admin see message as "Updated Program Name"
   
   @Admin 
   Scenario: Admin Edits Status in Batch Details window
   Given Admin Clicks on first Edit buttton 
   When Admin Clicks on Save button after updating Status
   Then Admin see Update message1 as "Updated Status"
   
   @Admin 
   Scenario: Admin Edits No of Classes in Batch Details window
   Given Admin Clicks on first Edit buttton 
   When Admin Clicks on Save button after updating No of Classes
   Then Admin see Update message2 as "Updated No of Classes"
   
   @Admin 
   Scenario: Admin Verify Delete Functionality
   Given Admin is on Manage Batch page 
   When Admin Clicks on third Delete button located on the right side 
   Then Admin see Delete header text as "Delete Confirm"
   
   @Admin 
   Scenario: Admin Click on No button in Delete Confirm dialog
   Given Admin is on Manage Batch page 
   And Admin Clicks on third Delete button located on the right side 
   When Admin Clicks on No button
   Then Admin see Delete Confirm dialog closed
   
   @Admin 
   Scenario: Admin Click on Yes button in Delete Confirm dialog
   Given Admin is on Manage Batch page 
   And Admin Clicks on third Delete button located on the right side 
   When Admin Clicks on Yes button
   Then Admin see Delete Success message "Program Deleted Succesfully"
   
   @Admin 
   Scenario: Validate Deletion of Multiple Records
   Given Admin is on Manage Batch page
   And  Admin selects more than one Batch Name using checkbox
   When Admin Clicks on Enabled Delete button on the top left hand side
   Then Admin see Delete header text as "Delete Confirm"
   
   @Admin
   Scenario: Admin Click on No button in Delete Confirm dialog
   Given  Admin is on Manage Batch page 
   And  Admin Clicks on Enabled Delete button on the top left hand side
   When Admin Clicks on No button
   Then Admin see Delete Confirm dialog closed
   
   @Admin
   Scenario: Admin Click on Yes button in Delete Confirm dialog
   Given Admin is on Manage Batch page 
   And Admin Clicks on Enabled Delete button on the top left hand side
   When Admin Clicks on Yes button
   Then Admin see Delete Success message "Program Deleted Succesfully"
   
   @Admin
   Scenario: Admin Verify the Edit Functionality in Attendance page
   Given Admin is on Manage Attendance page
   When Admin Clicks on First Edit buttton  
   Then Admin see Attendance Error message "Admin Has View Only Permission"
   
   @Admin 
   Scenario: Admin Verify the Delete Functionality in Attendance page
   Given Admin is on Manage Attendance page
   When Admin Clicks on First Delete buttton  
   Then Admin see Attendance Error message "Admin Has View Only Permission"
   
   
   
   
   
   