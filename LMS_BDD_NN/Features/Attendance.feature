Feature: Manage Attendance Page Accessed by either User/Staff

Background:
  Given UserorStaff Logged on to LMS Website 
  
  @ValidateAttendanceHeader
  Scenario: Validating the Manage Attendance Header
  When UserorStaff Clicks on Attendance button
  Then UserorStaff see header text as "Manage Attendance"
   
  @ValidateAttendanceFooter
  Scenario: Validating the Manage Attendance Footer
  When  UserorStaff is on Manage Attendance page
  Then  UserorStaff see Footer text as "In total there are 5 entries."
  
  @ValidateAttendancePaginator
  Scenario: Validating the Manage Attendance Paginator
  When  UserorStaff is on Manage Attendance page
  Then  UserorStaff see Paginator text as "Showing 1 to 5 of 5 entries."
  
  @ValidateAttendancePaginatorlinks
  Scenario: Validating the Manage Attendance Paginator Links
  When  UserorStaff is on Manage Attendance page
  Then  UserorStaff see Paginator links are disabled
  
  @ValidateEditbutton
  Scenario: Verify the First Edit button
  Given UserorStaff is on Manage Attendance page
  When UserorStaff Clicks on First Edit buttton  
  Then UserorStaff header text as "Attendance Details"
  
  @EditProgramName
  Scenario: Edit Program Name in Attendance Details dialog
  Given UserorStaff Clicks on First Edit buttton  
  When UserorStaff clicks on Save button after editing Program Name
  Then UserorStaff see the success message "Updated Successfully"
  
  @EditUserName
  Scenario: Edit User Name in Attendance Details dialog
  Given UserorStaff Clicks on First Edit buttton  
  When UserorStaff clicks on Save button after editing User Name
  Then UserorStaff see the success message "Updated Successfully"
  
  @EditPresent
  Scenario: Edit Present in Attendance Details dialog
  Given UserorStaff Clicks on First Edit buttton  
  When UserorStaff clicks on Save button after editing Present
  Then UserorStaff see the success message "Updated Successfully"
  
  @EditAbsent
  Scenario: Edit Absent in Attendance Details dialog
  Given UserorStaff Clicks on First Edit buttton  
  When UserorStaff clicks on Save button after editing Absent
  Then UserorStaff see the success message "Updated Successfully"
  
  @ValidateCancelbutton
  Scenario: Click on Cancel button in Attendance Details dialog
  Given UserorStaff Clicks on First Edit buttton  
  When UserorStaff clicks on Cancel button
  Then UserorStaff see Attendance Details dilog getting closed
  
  @VerifyDeleteFunctionality
  Scenario: Verify the First Delete button
  Given UserorStaff is on Manage Attendance page
  When UserorStaff clicks on first Delete button
  Then UserorStaff see Delete header text as "Delete Confirm"
  
  @VerifyDeleteFunctionality
  Scenario: Verify the First Delete button
  Given UserorStaff is on Manage Attendance page
  When UserorStaff clicks on first Delete button
  Then UserorStaff see Delete header text as "Delete Confirm"
  
   @VerifyNoFunctionality
   Scenario: Click on No button in Delete Confirm dialog
   Given UserorStaff clicks on first Delete button
   When UserorStaff Clicks on No button
   Then UserorStaff see Delete Confirm dialog closed
   
   @VerifyYesFunctionality
   Scenario: Click on Yes button in Delete Confirm dialog
   Given UserorStaff clicks on first Delete button
   When UserorStaff Clicks on Yes button
   Then UserorStaff see Delete Success message "Name Deleted Succesfully"
   
   @CheckBoxFunctionality
   Scenario: Verifies Checkbox Functionality
   Given UserorStaff is on Manage Attendance page
   When UserorStaff Selects First checkbox
   Then UserorStaff see list of User Names in that Program

   
   

