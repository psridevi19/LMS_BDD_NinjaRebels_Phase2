#Author: sridevivcet@gmail.com


@Program
Feature: Program 

	Background: User Logged on to LMS Website
	Given User Logged on to LMS Website 
  
  @HeaderValidation
  Scenario: Validating the Manage Program Header
    Given User Logged on to LMS Website
    When User is on Manage Program page
    Then User see header text as "Manage Program"
    
  @FooterValidation
  Scenario: Validating the Manage Program Footer
    Given User Logged on to LMS Website
    When User is on Manage Program page 
    Then User see Footer text as "In total there are 9 programs."
    
  @PaginatorValidation
  Scenario: Validating the Manage Program Paginator
    Given User Logged on to LMS Website
    When User is on Manage Program page 
    Then User see the text as "Showing 1 to 5 of 9 entries" 
    
  @PaginatorValidation
  Scenario Outline: Verify paginator button  on the Program page
    Given User is on Manage Program page
    When User clicks on Enabled paginator "<direction>" button
    Then User see Paginator "<direction>" text as "<paginationText>"
   
    Examples:
    | direction | paginationText |
 		| prev		  | Showing 1 to 5 of 9 entries |
 		| next		  | Showing 6 to 9 of 9 entries |
 		
 	@PaginatorValidation
  Scenario Outline: Verify paginator First Last button  on the Program page
    Given User is on Manage Program page
    When User clicks on Enabled paginator "<direction>" button
    Then User see Page number navigated to "<number>" with "<direction>"
   
 	 Examples:
  
    | direction | number |
 		| last		  | 2 |
 		| first		  | 1 |
  
	@SearchFunctionality
  Scenario: Validate Search Feature
    Given User Logged on to LMS Website
    When User is on Manage Program page
    Then User see the Search Text box has text as "Search"
  
  @SearchFunctionality
  Scenario Outline: Validate Search by  Program Name,Program Description,Program Status
    Given User is on Manage Program page
    When User enters "<SearchKeyWord>" to be searched
    Then User see the entries for the searched "<SearchKeyWord>" are shown
    
    Examples:
    | SearchKeyWord |
    | Program Name |
    | Program Description |
    | Program Status |
    
  @AscendingAndDescendingOrder
  Scenario Outline: Validate Ascending order and descending order for columns
    Given User is on Manage Program page
    When User clicks on column name "<column name>" and order "<order>"
    Then User see the column name "<column name>" displayed in order "<order>"
    
    Examples:
    
    | column name  				| order |
 		| Program Name 				| Ascending  |
    | Program Description | Ascending  |
    | Program Status 			| Ascending  |
    | Program Name 				| Descending |
    | Program Description | Descending |
    | Program Status 			| Descending |
    
    
  @Admin
  Scenario: Validate Add A New Program button
    Given Admin is on Manage Program page
    When Admin clicks on A New Program button
    Then Admin see header text as "Program Details"
    
  @Admin
  Scenario: Validate Add A New Program functionality with no details
    Given Admin clicks on A New Program button
    When Admin clicks on Save button with out entering details name "" description "" 
    Then Admin see Error message "Name is required"
    
    @Admin
  Scenario: Validate Add A New Program functionality with all details
    Given Admin clicks on A New Program button
    When Admin clicks on Save button after entering all details name "Java" description "Sdet" 
    Then Admin see Success message "New Program Created"
    
    @Admin
  Scenario: Validate Add A New Program functionality with only entering program name
    Given Admin clicks on A New Program button
    When Admin clicks on Save button after entering program Name "Java" alone
    Then Admin see Error message "Description is required"
    
    @Admin
  Scenario: Validate Add A New Program functionality with only entering description
    Given Admin clicks on A New Program button
    When Admin clicks on Save button after entering description "Sdet" alone
    Then Admin see Error message "Name is required"
   
       @Admin
  Scenario: Validate Add A New Program functionality with only selecting status
    Given Admin clicks on A New Program button
    When Admin clicks on Save button after selecting status alone
    Then Admin see Error message "Name is required"
    
      @Admin
  Scenario: Validate Cancel button in Program Details window
    Given Admin clicks on A New Program button
    When Admin clicks on Cancel button
    Then Admin see a Program Details window getting closed
    
      @VerifyNewAddedProgramName
  Scenario: Verify Added New Program Name
    Given User is on Manage Program page 
    When User enters newly added  Program Name "Java" in Search
    Then User sees an entry "Java" for the newly added Program Name "Program Name" 
    
    @ValidateAddNewProgramAsUser
     Scenario: User/Staff Validate Add A New Program button
    Given User is on Manage Program page 
    When User clicks on A New Program button
    Then User sees Add new program button is disabled
    
    @NumberOfRows
    Scenario: Validate Number of rows in a table
    Given User Logged on to LMS Website
    When User is on Manage Program page
    Then User  counts number of rows as number "5" in a table
    
    @Admin
    Scenario: Validates Edit button in Program Details window
    Given Admin is on Manage Program page
    When Admin clicks on Edit buttton  
    Then Admin see header text as "Program Details"
    
    @Admin
    Scenario: Validates Edit Program Name in Program Details window
    Given Admin clicks on Edit buttton
    When Admin clicks on Save button after updating Program Name "Java" 
    Then Admin see Success message "Updated Program Name"
    
    @Admin
    Scenario: Validates Edit Program Description in Program Details window
    Given Admin clicks on Edit buttton
    When Admin  Clicks on Save Button after updating Program Description "Sdet"
    Then Admin see Success message "Updated Description"
    
    @Admin
    Scenario: Validates Edit Program Status in Program Details window
    Given Admin clicks on Edit buttton
    When Admin clicks on Save button after Changing Program status "active" 
    Then Admin see Success message "Updated Description"
    
    @Admin
    Scenario: Validates Cancel button in Program Details window
    Given Admin clicks on Edit buttton
    When Admin clicks on Cancel button
    Then Admin see a Program Details window getting closed
    
    @VerifyEditedDetails
    Scenario: Verify Edited Program Name/Program Description 
    Given User is on Manage Program page 
    When User enters edited Program Name "Java" in Search
    Then User sees an entry "Java" for the newly edited Program Name "Program Name"
    
    @ValidateEditAsUser
    Scenario: User/Staff Validate Edit button
    Given User is on Manage Program page 
    When User clicks on Edit button
    Then User sees Edit button is disabled
    
    @Admin
    Scenario: Validates Delete Functionality
    Given Admin is on Manage Program page
    When Admin clicks on any Delete button located on the right side
    Then Admin see confimation text as "Delete Confirm"
    
    @Admin
    Scenario: Validate Yes button in Delete Confirm window
    Given Admin clicks on any Delete button located on the right side
    When Admin clicks on confirm delete "Yes" button
    Then Admin see Success message "Program Deleted Succesfully"
    
    @Admin
    Scenario: Validate No button in Delete Confirm window
    Given Admin clicks on any Delete button located on the right side
    When Admin clicks on confirm delete "No" button
    Then Admin can see confirm dialog box closed
    
    @Admin
    Scenario: Validate deleted Program Name in search
    Given Admin is on Manage Program page 
    When Admin enters deleted Program Name "Testing" in Search 
    Then Admin finds no results for search "Testing" in "Program Name" 
    
    @ValidateDeleteAsUser
    Scenario: User/Staff Validate Delete button
    Given User is on Manage Program page 
    When User clicks on Delete button
    Then User sees Delete button is disabled
    
    @Admin
    Scenario: Validate the state of Delete button on left hand side
    Given Admin Logged on to LMS Website
    When Admin is on Manage Program page
    Then Admin see the Delete button on the top left hand side as Disabled 
    
    @Admin
    Scenario: Validates Multiple Program Selection
    Given Admin is on Manage Program page
    When Admin selects more than one Program Name using checkbox
    Then Admin see the Delete button on the top left hand side as Enabled
    
    @Admin
    Scenario: Validates Deletion of Multiple Records
    Given Admin selects more than one Program Name using checkbox
    When Admin clicks on Enabled Delete button on the top left hand side
    Then Admin see confimation text as "Delete Confirm"
    
    @Admin
    Scenario: Validate Yes button in Delete Confirm window
    Given Admin clicks on Enabled Delete button after selecting more than one Program Name
    When Admin clicks on confirm delete "Yes" button
    Then Admin see Success message "Program Deleted Succesfully"
    
    @Admin
    Scenario: Validate No button in Delete Confirm window
    Given Admin clicks on Enabled Delete button after selecting more than one Program Name
    When Admin clicks on confirm delete "No" button
    Then Admin can see confirm dialog box closed
    
    @Admin
    Scenario: Validate deleted Program Name in search
    Given Admin is on Manage Program page 
    When Admin enters deleted Program Name "Testing" in Search 
    Then Admin finds no results for search "Testing" in "Program Name" 
    
    @Admin
    Scenario: Validate user deleting multiple Program Names
    Given User is on Manage Program page 
    Then User see check box is disabled
    
    @Admin1
    Scenario: Validate Checkbox Functionality
    Given Admin is on Manage Program page
    When Admin Selects First checkbox left to Program Name 
    Then Admin see all the checkboxes in the Program page get selected