@Admin
Feature: Manage Batch Page Accessed by BatchAdmin

Background:
  Given BatchAdmin Logged on to LMS Website 
  
   @Admin
   Scenario: BatchAdmin Validate Add A New Batch button
   Given BatchAdmin is on Manage Batch page 
   When BatchAdmin Clicks on + A New Batch button
   Then BatchAdmin see header text as "Batch Details"
   
   @Admin
   Scenario: No details Entered in Batch Details window
   Given BatchAdmin Clicks on + A New Batch button
   When BatchAdmin Clicks on Save button with out entering details 
   Then BatchAdmin see Error message "Name is required"
   
   @Admin
   Scenario: Enters Only Name in Batch Details Dialog
   Given BatchAdmin Clicks on + A New Batch button
   When BatchAdmin Clicks on Save button after entering Name details 
   Then BatchAdmin see Error message as "Description is required"
     
   @Admin
   Scenario: Selects only a Program name from Dropdown in Batch Details window 
   Given BatchAdmin Clicks on + A New Batch button
   And Clicks on DropDown Menu in Batch Details window
   When BatchAdmin Clicks on Save button after selecting a Program Name only from the dropdown
   Then BatchAdmin see Error message "Name is required"
   
   @Admin
   Scenario: Selects Status only in Batch Details window
   Given BatchAdmin Clicks on + A New Batch button
   When BatchAdmin Clicks on Save button after selecting Status alone 
   Then BatchAdmin see Error message "Name is required"
   
   @Admin 
   Scenario: Enters Only Number Of Classes in Batch Details window
   Given BatchAdmin Clicks on + A New Batch button
   When BatchAdmin Clicks on Save button after entering Only Number Of Classes
   Then BatchAdmin see Error message "Name is required"
      
   @Admin 
   Scenario: Click on Cancel button in Batch Details window
   Given BatchAdmin Clicks on + A New Batch button
   When BatchAdmin Clicks on Cancel button
   Then BatchAdmin see a Batch Details window getting closed
   
   @Admin 
   Scenario: Enters Only Description in Batch Details window
   Given BatchAdmin Clicks on + A New Batch button
   When BatchAdmin Clicks on Save button with entering only Description details 
   Then BatchAdmin see Error message "Name is required"
   
   @Admin
   Scenario: Enter All details in Batch Details window
   Given BatchAdmin Clicks on + A New Batch button
   When BatchAdmin Clicks on Save button after entering all detail
   Then BatchAdmin see Success message "New Batch Created"
  
   @Admin 
   Scenario: BatchAdmin Validate First Edit button
   Given BatchAdmin is on Manage Batch page 
   When BatchAdmin Clicks on first Edit buttton 
   Then BatchAdmin see header text as "Batch Details"
   
   @Admin
   Scenario: BatchAdmin Edits batch Name in Batch Details window
   Given BatchAdmin Clicks on first Edit buttton 
   When BatchAdmin Clicks on Save button after updating Name 
   Then BatchAdmin see Updated message as "Updated Name"
   
   @Admin
   Scenario: BatchAdmin Edits batch Description in Batch Details window
   Given BatchAdmin Clicks on first Edit buttton 
   When BatchAdmin Clicks on Save button after updating Description 
   Then BatchAdmin see Update message as "Updated Description"
   
   @Admin  
   Scenario: BatchAdmin Edits Program Name in Batch Details window
   Given BatchAdmin Clicks on first Edit buttton 
   When BatchAdmin Clicks on Save button after updating Program ame 
   Then BatchAdmin see message as "Updated Program Name"
   
   @Admin 
   Scenario: BatchAdmin Edits Status in Batch Details window
   Given BatchAdmin Clicks on first Edit buttton 
   When BatchAdmin Clicks on Save button after updating Status
   Then BatchAdmin see Update message1 as "Updated Status"
   
   @Admin 
   Scenario: BatchAdmin Edits No of Classes in Batch Details window
   Given BatchAdmin Clicks on first Edit buttton 
   When BatchAdmin Clicks on Save button after updating No of Classes
   Then BatchAdmin see Update message2 as "Updated No of Classes"
   
   @Admin 
   Scenario: BatchAdmin Verify Delete Functionality
   Given BatchAdmin is on Manage Batch page 
   When BatchAdmin Clicks on third Delete button located on the right side 
   Then BatchAdmin see Delete header text as "Delete Confirm"
   
   @Admin 
   Scenario: BatchAdmin Click on No button in Delete Confirm dialog
   Given BatchAdmin is on Manage Batch page 
   And BatchAdmin Clicks on third Delete button located on the right side 
   When BatchAdmin Clicks on No button
   Then BatchAdmin see Delete Confirm dialog closed
   
   @Admin 
   Scenario: BatchAdmin Click on Yes button in Delete Confirm dialog
   Given BatchAdmin is on Manage Batch page 
   And BatchAdmin Clicks on third Delete button located on the right side 
   When BatchAdmin Clicks on Yes button
   Then BatchAdmin see Delete Success message "Program Deleted Succesfully"
   
   @Admin 
   Scenario: Validate Deletion of Multiple Records
   Given BatchAdmin is on Manage Batch page
   And  BatchAdmin selects more than one Batch Name using checkbox
   When BatchAdmin Clicks on Enabled Delete button on the top left hand side
   Then BatchAdmin see Delete header text as "Delete Confirm"
   
   @Admin
   Scenario: BatchAdmin Click on No button in Delete Confirm dialog
   Given  BatchAdmin is on Manage Batch page 
   And  BatchAdmin Clicks on Enabled Delete button on the top left hand side
   When BatchAdmin Clicks on No button
   Then BatchAdmin see Delete Confirm dialog closed
   
   @Admin
   Scenario: BatchAdmin Click on Yes button in Delete Confirm dialog
   Given BatchAdmin is on Manage Batch page 
   And BatchAdmin Clicks on Enabled Delete button on the top left hand side
   When BatchAdmin Clicks on Yes button
   Then BatchAdmin see Delete Success message "Program Deleted Succesfully"
   
   @Admin
   Scenario: BatchAdmin Verify the Edit Functionality in Attendance page
   Given BatchAdmin is on Manage Attendance page
   When BatchAdmin Clicks on First Edit buttton  
   Then BatchAdmin see Attendance Error message "BatchAdmin Has View Only Permission"
   
   @Admin 
   Scenario: BatchAdmin Verify the Delete Functionality in Attendance page
   Given BatchAdmin is on Manage Attendance page
   When BatchAdmin Clicks on First Delete buttton  
   Then BatchAdmin see Attendance Error message "BatchAdmin Has View Only Permission"
   
   
   
   
   
   