@Batch
Feature: Manage Batch Page Accessed by either User/Admin/ Staff

Background:
  Given User Logged on to LMS Website 
  
  @ValidateBatchHeader
  Scenario: Validating the Manage Batch Header
  When User Clicks on Batch button
  Then User see header text as "Manage Batch "
  
  @ValidateBatchFooter
  Scenario: Validating the Manage Batch Footer
  When  User is on Manage Batch page
  Then  User see Footer text as "In total there are 21 batches."
  
  @ValidateBatchPaginator
  Scenario: Validating the Manage Batch Paginator
  When User is on Manage Batch page
  Then User see paginator text as "Showing 1 to 5 of 21 entries." 
  
  @Verifypaginator-nextbutton
  Scenario: Verify paginator -next button on the Batch page
  Given User is on Manage Batch page
  When User Clicks on Enabled paginator-next button
  Then User see paginator text changed to "Showing 6 to 10 of 21 entries."
  
  @Verifypaginator-prevoiusbutton
  Scenario: Verify paginator -prevoius button on the Batch page
  Given User is on Manage Batch page
  When User Clicks on Enabled paginator -prev button
  Then User see the text as "Showing 1 to 5 of 21 entries." 
  
  @Verifypaginator-lastbutton
  Scenario: Verify paginator -last button on the Batch page
  Given User is on Manage Batch page
  When User Clicks on Enabled paginator -last button
  Then User see Page number navigated to '10'
  
  @Verifypaginator-firstbutton
  Scenario: Verify paginator -first button on the Batch page
  Given User is on Manage Batch page
  When User Clicks on Enabled paginator -first button
  Then User see Page number navigated back to '1'
  
  @VerifySearch
  Scenario: Validate Search Feature
  Given User Logged on to LMS Website 
  When User is on Manage Batch page
  Then User see the Search Text box has text as "Search...".
  
  @SearchbyBatchName
  Scenario: Search by Batch Name
  Given User is on Manage Batch page
  When User enters Batch Name to be searched 
  Then Entries for the searched BatchName are shown.
    
   @SearchbyBatchDescription
   Scenario: Search by Batch Description
   Given User is on Manage Batch page
   When User enters Batch Description to be searched
   Then Entries for the searched Batch Description are shown.
  
   @SearchbyBatchStatus
   Scenario: Search by Batch Status
   Given User is on Manage Batch page
   When User enters Batch Status to be searched
   Then Entries for the searched Batch Status are shown.
  
   @SearchbyNoOfClasses 
   Scenario: Search by No Of Classes 
   Given User is on Manage Batch page
   When User enters Batch No Of Classes to be searched
   Then Entries for the searched Batch No Of Classes are shown.
  
   @SearchbyProgramName 
   Scenario: Search by Program Name 
   Given User is on Manage Batch page
   When User enters Batch Program Name to be searched
   Then Entries for the searched Batch Program Name are shown.

   @VerifyBatchNameinAscendingorder
   Scenario: Verify Batch Name are displayed in Ascending order
   Given User is on Manage Batch page
   When User Clicks on Batch Name Ascending Arrow
   Then User see the Batch Name displayed in Ascending order
   
   @VerifyBatchDescriptioninAscendingorder
   Scenario: Verify Batch Description are displayed in Ascending order
   Given User is on Manage Batch page
   When User Clicks on Batch Description Ascending Arrow
   Then User see the Batch Description displayed in Ascending order
  
   @VerifyBatchStatusinAscendingorder
   Scenario: Verify Batch Status are displayed in Ascending order
   Given User is on Manage Batch page
   When User Clicks on Batch Status Ascending Arrow
   Then User see the Batch Status displayed in Ascending order
  
   @VerifyNoOfClassesinAscendingorder
   Scenario: Verify No Of Classes are displayed in Ascending order
   Given User is on Manage Batch page
   When User Clicks on No Of Classes Ascending Arrow
   Then User see the No Of Classes displayed in Ascending order
  
   @VerifyProgramNameinAscendingorder
   Scenario: Verify Program Name are displayed in Ascending order
   Given User is on Manage Batch page
   When User Clicks on Program Name Ascending Arrow
   Then User see the Program Name displayed in Ascending order
   
   @VerifyBatchNameinDescendingorder
   Scenario: Verify Batch Name are displayed in Descending order
   Given User is on Manage Batch page
   When User Clicks on Batch Name Descending Arrow
   Then User see the Batch Name displayed in Descending order
   
   @VerifyBatchDescriptioninDescendingorder
   Scenario: Verify Batch Description are displayed in Descending order
   Given User is on Manage Batch page
   When User Clicks on Batch Description Descending Arrow
   Then User see the Batch Description displayed in Descending order
   
   @VerifyBatchStatusinDescendingorder
   Scenario: Verify Batch Status are displayed in Descending order
   Given User is on Manage Batch page
   When User Clicks on Batch Status Descending Arrow
   Then User see the Batch Status displayed in Descending order
   
   @VerifyNoOfClassesinDescendingorder
   Scenario: Verify No Of Classes are displayed in Descending order
   Given User is on Manage Batch page
   When User Clicks on No Of Classes Descending Arrow
   Then User see the No Of Classes displayed in Descending order
   
   @VerifyProgramNameinAscendingorder
   Scenario: Verify Program Name are displayed in Descending order
   Given User is on Manage Batch page
   When User Clicks on Program Name Descending Arrow
   Then User see the Program Name displayed in Descending order
   
   @NumberofrowsinaTable
   Scenario: Validate Number of rows in a table
   Given User Logged on to LMS Website
   When User is on Manage Batch page
   Then User counts number of rows as 5 in a table
   
   @EvaluateNewlyAddBatchName
   Scenario: User Verify Added New Batch Name
   Given User is on Manage Batch page
   When User Enters newly added  Batch Name in Search
   Then Entry for the newly added Batch Name is shown
   
   @EvaluateEditedBatchName
   Scenario: User Verifys Edited Details
   Given User is on Manage Batch page
   When User Enters newly edited  Batch Name in Search
   Then Entry for the newly edited Batch Name is shown
   
   @EvaluateDeletedBatchName
   Scenario: User Validate Deleted Batch Name
   Given User is on Manage Batch page
   When User Enters deleted Batch Name in Search
   Then User finds NO records
   
   @UserAddANewBatchFunctionality
   Scenario: User Validate Add A New Batch button
   Given User is on Manage Batch page
   When User Clicks on + A New Batch button
   Then User see a Error message "Only Admin have Access"
   
   @UserValidateEditbutton
   Scenario: User Validate First Edit button
   Given User is on Manage Batch page
   When User Clicks on Edit buttton  
   Then User see a Error message "Only Admin have Access"
   
   @UserValidateDeletebutton
   Scenario: User Validate First Delete button
   Given User is on Manage Batch page
   When User Clicks on Delete buttton  
   Then User see a Error message "Only Admin have Access"
   
   @CheckBoxFunctionality
   Scenario: User Verifies Checkbox Functionality
   Given User is on Manage Batch page
   When User Selects First checkbox left to Batch Name
   Then User see all the checkboxes in the Batch page get selected
   
   @DeleteButtononLeft
   Scenario: Verify the state of Delete button on left 
   When User is on Manage Batch page
   Then User see the Delete button on the top left hand side as Disabled
   
   @MultipleProgramSelection
   Scenario: Validates Multiple Program Selection
   Given User is on Manage Batch page
   When User selects more than one Batch Name using checkbox
   Then User see the Delete button on the left side as Enabled
   
   @VerifyDeletedBatchNames
   Scenario: User Verify Deleted Batch Names
   Given User is on Manage Batch page
   When User enters deleted batch Names in Search
   Then User finds no results

   
  