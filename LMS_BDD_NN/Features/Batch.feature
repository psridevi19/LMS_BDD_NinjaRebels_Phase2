@Batch
Feature: Manage Batch Page Accessed by either BatchUser/Admin/ Staff

Background:
  Given BatchUser Logged on to LMS Website 
  
  @ValidateBatchHeader
  Scenario: Validating the Manage Batch Header
  When BatchUser Clicks on Batch button
  Then BatchUser see header text as "Manage Batch "
  
  @ValidateBatchFooter
  Scenario: Validating the Manage Batch Footer
  When  BatchUser is on Manage Batch page
  Then  BatchUser see Footer text as "In total there are 21 batches."
  
  @ValidateBatchPaginator
  Scenario: Validating the Manage Batch Paginator
  When BatchUser is on Manage Batch page
  Then BatchUser see paginator text as "Showing 1 to 5 of 21 entries." 
  
  @Verifypaginator-nextbutton
  Scenario: Verify paginator -next button on the Batch page
  Given BatchUser is on Manage Batch page
  When BatchUser Clicks on Enabled paginator-next button
  Then BatchUser see paginator text changed to "Showing 6 to 10 of 21 entries."
  
  @Verifypaginator-prevoiusbutton
  Scenario: Verify paginator -prevoius button on the Batch page
  Given BatchUser is on Manage Batch page
  When BatchUser Clicks on Enabled paginator -prev button
  Then BatchUser see the text as "Showing 1 to 5 of 21 entries." 
  
  @Verifypaginator-lastbutton
  Scenario: Verify paginator -last button on the Batch page
  Given BatchUser is on Manage Batch page
  When BatchUser Clicks on Enabled paginator -last button
  Then BatchUser see Page number navigated to '10'
  
  @Verifypaginator-firstbutton
  Scenario: Verify paginator -first button on the Batch page
  Given BatchUser is on Manage Batch page
  When BatchUser Clicks on Enabled paginator -first button
  Then BatchUser see Page number navigated back to '1'
  
  @VerifySearch
  Scenario: Validate Search Feature
  Given BatchUser Logged on to LMS Website 
  When BatchUser is on Manage Batch page
  Then BatchUser see the Search Text box has text as "Search...".
  
  @SearchbyBatchName
  Scenario: Search by Batch Name
  Given BatchUser is on Manage Batch page
  When BatchUser enters Batch Name to be searched 
  Then Entries for the searched BatchName are shown.
    
   @SearchbyBatchDescription
   Scenario: Search by Batch Description
   Given BatchUser is on Manage Batch page
   When BatchUser enters Batch Description to be searched
   Then Entries for the searched Batch Description are shown.
  
   @SearchbyBatchStatus
   Scenario: Search by Batch Status
   Given BatchUser is on Manage Batch page
   When BatchUser enters Batch Status to be searched
   Then Entries for the searched Batch Status are shown.
  
   @SearchbyNoOfClasses 
   Scenario: Search by No Of Classes 
   Given BatchUser is on Manage Batch page
   When BatchUser enters Batch No Of Classes to be searched
   Then Entries for the searched Batch No Of Classes are shown.
  
   @SearchbyProgramName 
   Scenario: Search by Program Name 
   Given BatchUser is on Manage Batch page
   When BatchUser enters Batch Program Name to be searched
   Then Entries for the searched Batch Program Name are shown.

   @VerifyBatchNameinAscendingorder
   Scenario: Verify Batch Name are displayed in Ascending order
   Given BatchUser is on Manage Batch page
   When BatchUser Clicks on Batch Name Ascending Arrow
   Then BatchUser see the Batch Name displayed in Ascending order
   
   @VerifyBatchDescriptioninAscendingorder
   Scenario: Verify Batch Description are displayed in Ascending order
   Given BatchUser is on Manage Batch page
   When BatchUser Clicks on Batch Description Ascending Arrow
   Then BatchUser see the Batch Description displayed in Ascending order
  
   @VerifyBatchStatusinAscendingorder
   Scenario: Verify Batch Status are displayed in Ascending order
   Given BatchUser is on Manage Batch page
   When BatchUser Clicks on Batch Status Ascending Arrow
   Then BatchUser see the Batch Status displayed in Ascending order
  
   @VerifyNoOfClassesinAscendingorder
   Scenario: Verify No Of Classes are displayed in Ascending order
   Given BatchUser is on Manage Batch page
   When BatchUser Clicks on No Of Classes Ascending Arrow
   Then BatchUser see the No Of Classes displayed in Ascending order
  
   @VerifyProgramNameinAscendingorder
   Scenario: Verify Program Name are displayed in Ascending order
   Given BatchUser is on Manage Batch page
   When BatchUser Clicks on Program Name Ascending Arrow
   Then BatchUser see the Program Name displayed in Ascending order
   
   @VerifyBatchNameinDescendingorder
   Scenario: Verify Batch Name are displayed in Descending order
   Given BatchUser is on Manage Batch page
   When BatchUser Clicks on Batch Name Descending Arrow
   Then BatchUser see the Batch Name displayed in Descending order
   
   @VerifyBatchDescriptioninDescendingorder
   Scenario: Verify Batch Description are displayed in Descending order
   Given BatchUser is on Manage Batch page
   When BatchUser Clicks on Batch Description Descending Arrow
   Then BatchUser see the Batch Description displayed in Descending order
   
   @VerifyBatchStatusinDescendingorder
   Scenario: Verify Batch Status are displayed in Descending order
   Given BatchUser is on Manage Batch page
   When BatchUser Clicks on Batch Status Descending Arrow
   Then BatchUser see the Batch Status displayed in Descending order
   
   @VerifyNoOfClassesinDescendingorder
   Scenario: Verify No Of Classes are displayed in Descending order
   Given BatchUser is on Manage Batch page
   When BatchUser Clicks on No Of Classes Descending Arrow
   Then BatchUser see the No Of Classes displayed in Descending order
   
   @VerifyProgramNameinAscendingorder
   Scenario: Verify Program Name are displayed in Descending order
   Given BatchUser is on Manage Batch page
   When BatchUser Clicks on Program Name Descending Arrow
   Then BatchUser see the Program Name displayed in Descending order
   
   @NumberofrowsinaTable
   Scenario: Validate Number of rows in a table
   Given BatchUser Logged on to LMS Website
   When BatchUser is on Manage Batch page
   Then BatchUser counts number of rows as 5 in a table
   
   @EvaluateNewlyAddBatchName
   Scenario: BatchUser Verify Added New Batch Name
   Given BatchUser is on Manage Batch page
   When BatchUser Enters newly added  Batch Name in Search
   Then Entry for the newly added Batch Name is shown
   
   @EvaluateEditedBatchName
   Scenario: BatchUser Verifys Edited Details
   Given BatchUser is on Manage Batch page
   When BatchUser Enters newly edited  Batch Name in Search
   Then Entry for the newly edited Batch Name is shown
   
   @EvaluateDeletedBatchName
   Scenario: BatchUser Validate Deleted Batch Name
   Given BatchUser is on Manage Batch page
   When BatchUser Enters deleted Batch Name in Search
   Then BatchUser finds NO records
   
   @BatchUserAddANewBatchFunctionality
   Scenario: BatchUser Validate Add A New Batch button
   Given BatchUser is on Manage Batch page
   When BatchUser Clicks on + A New Batch button
   Then BatchUser see a Error message "Only Admin have Access"
   
   @BatchUserValidateEditbutton
   Scenario: BatchUser Validate First Edit button
   Given BatchUser is on Manage Batch page
   When BatchUser Clicks on Edit buttton  
   Then BatchUser see a Error message "Only Admin have Access"
   
   @BatchUserValidateDeletebutton
   Scenario: BatchUser Validate First Delete button
   Given BatchUser is on Manage Batch page
   When BatchUser Clicks on Delete buttton  
   Then BatchUser see a Error message "Only Admin have Access"
   
   @CheckBoxFunctionality
   Scenario: BatchUser Verifies Checkbox Functionality
   Given BatchUser is on Manage Batch page
   When BatchUser Selects First checkbox left to Batch Name
   Then BatchUser see all the checkboxes in the Batch page get selected
   
   @DeleteButtononLeft
   Scenario: Verify the state of Delete button on left 
   When BatchUser is on Manage Batch page
   Then BatchUser see the Delete button on the top left hand side as Disabled
   
   @MultipleProgramSelection
   Scenario: Validates Multiple Program Selection
   Given BatchUser is on Manage Batch page
   When BatchUser selects more than one Batch Name using checkbox
   Then BatchUser see the Delete button on the left side as Enabled
   
   @VerifyDeletedBatchNames
   Scenario: BatchUser Verify Deleted Batch Names
   Given BatchUser is on Manage Batch page
   When BatchUser enters deleted batch Names in Search
   Then BatchUser finds no results

   
  