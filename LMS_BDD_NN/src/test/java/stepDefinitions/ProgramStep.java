package stepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ProgramPage;
import utilities.ContextUI;
import utilities.LoggerClass;
import utilities.UtilString;

public class ProgramStep {
	
	private  ContextUI contextUI;
	private LoginPage login;
	private ProgramPage program;
	
	public ProgramStep(ContextUI context)
	{
		System.out.println("******ProgramStep*******");
		this.contextUI = context;
		login = contextUI.getPageObjectManager().getLoginPage();
		program = contextUI.getPageObjectManager().getProgramPage();
	}
	

	
	//HeaderValidation
	@Given("User Logged on to LMS Website")
	public void user_logged_on_to_lms_website() {
	   
		login.loginAsUser(contextUI.username, contextUI.password);
	}

	@When("User is on Manage Program page")
	public void user_is_on_manage_program_page() {
		program.goToProgramPage();
		LoggerClass.info("User is in manage program page");

	}

	@Then("User see header text as {string}")
	public void user_see_header_text_as(String programHeader) {
		
		if(login.isInProgramPage(programHeader))
		{
			LoggerClass.info("User is in manage program page");
			Assert.assertTrue(true);
		}
			
		else
		{
			LoggerClass.info("User is not in manage program page");
			Assert.assertFalse(false);
		}
	}
	
	
	//FooterValidation
	@Then("User see Footer text as {string}")
	public void user_see_footer_text_as(String footer) {
		LoggerClass.info("Verifying Footer Text");
		if(program.getProgramFooter().equals(footer))
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
		
	}
	
	//PaginatorValidation1
	@Then("User see the text as {string}")
	public void user_see_the_text_as(String paginatorText) {
		LoggerClass.info("Verifying Paginator Text");
		if(program.getProgramPaginatorText().equals(paginatorText))
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}
	
	//PaginatorValidation2
	@When("User clicks on Enabled paginator {string} button")
	public void user_clicks_on_enabled_paginator_button(String paginatorDirection) {
	  
		if(paginatorDirection.equals("next"))
		{
			program.verifyPaginatorNext();
		}
		else if(paginatorDirection.equals("prev"))
		{
			program.verifyPaginatorPrev();
		}
		else if(paginatorDirection.equals("last"))
		{
			program.verifyPaginatorLast();
		}
		else if(paginatorDirection.equals("first"))
		{
			program.verifyPaginatorFirst();
		}
	}

	@Then("User see Paginator {string} text as {string}")
	public void user_see_paginator_text_as(String direction,String text) {
		LoggerClass.info("User sees the paginator text :"+text);
		if(program.getPaginatorTextDisplayed(text, direction))
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}
	
	//PaginatorValidation3
	@Then("User see Page number navigated to {string} with {string}")
	public void user_see_page_number_navigated_to_with(String number, String direction) {
	
		LoggerClass.info("User sees the page number navigated to");
		if(program.isInNavigatedPage(number,direction))
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
			
	}

	//SearchFunctionality
	@Then("User see the Search Text box has text as {string}")
	public void user_see_the_search_text_box_has_text_as(String searchText) {
		LoggerClass.info("User sees the text in the search box as : "+searchText);
	   if(program.getSearchBoxText().equals(searchText))
		   Assert.assertTrue(true);
	   else
		   Assert.assertTrue(false);
	}

	//SearchFunctionality
	@When("User enters {string} to be searched")
	public void user_enters_to_be_searched(String searchText) {
		LoggerClass.info("Search keyword entered by user :"+searchText);
		program.enterSearchText(searchText);
	}
	
	@Then("User see the entries for the searched {string} are shown")
	public void user_see_the_entries_for_the_searched_are_shown(String searchText) {
		LoggerClass.info("Validating the entries for search keyword");
		program.validateSearchResultEntries(searchText);  //Imp pending
	}
	
	
	//AscendingAndDescendingOrder  //Imp pending
	
	@When("User clicks on column name {string} and order {string}")
	public void user_clicks_on_column_name_and_order(String colName, String order) {
		LoggerClass.info("User clicks the "+ colName +" for "+ order +" ordering");
	    program.orderTheColumn(colName,order);
	}
	@Then("User see the column name {string} displayed in order {string}")
	public void user_see_the_column_name_displayed_in_order(String colName, String order) {
		LoggerClass.info("Is "+ colName +" ordered in "+ order +" order");
		program.isColumnOrdered(colName,order);
	}
	
	//AddNewProgram
	@Given("Admin is on Manage Program page")
	public void admin_is_on_manage_program_page() {
	   LoggerClass.info("Admin is on Manage program Page");
	   login.loginAsAdminStaff(UtilString.ADMIN_USERNAME, UtilString.ADMIN_PASSWORD, "Admin", UtilString.ADMIN_CODE);
	}
	
	@When("Admin clicks on A New Program button")
	public void admin_clicks_on_a_new_program_button() {
		LoggerClass.info("Admin clicks a new program button");
	    program.clickAddNewProgram();
	}
	
	@Then("Admin see header text as {string}")
	public void admin_see_header_text_as(String header) {
		Assert.assertEquals(program.getAddNewProgramHeader(), header,"Admin is not in manage user page");
	}
	
	
	@When("Admin clicks on Save button with out entering details name {string} description {string}")
	public void admin_clicks_on_save_button_with_out_entering_details_name_description(String name, String description) {
		program.validateAddNewProgram(name,description);
	}

	@Then("Admin see Error message {string}")
	public void admin_see_error_message(String errMsg) {
		LoggerClass.info("Admin sees the error message :"+errMsg);
		Assert.assertTrue(program.getErrorMessage(errMsg));
	}

	
	@When("Admin clicks on Save button after entering all details name {string} description {string}")
	public void admin_clicks_on_save_button_after_entering_all_details_name_description(String name, String description) {
		program.validateAddNewProgram(name,description); 
	}

	@Then("Admin see Success message {string}")
	public void admin_see_success_message(String successMessage) {
		LoggerClass.info("Admin sees the error message :"+successMessage);
		Assert.assertTrue(program.getSuccessMessage(successMessage));
	}

	@When("Admin clicks on Save button after entering program Name {string} alone")
	public void admin_clicks_on_save_button_after_entering_program_name_alone(String programName) {
		program.validateAddNewProgram(programName,UtilString.EMPTY);
	}

	@When("Admin clicks on Save button after entering description {string} alone")
	public void admin_clicks_on_save_button_after_entering_description_alone(String description) {
		program.validateAddNewProgram(UtilString.EMPTY,description);
	}

	@When("Admin clicks on Save button after selecting status alone")
	public void admin_clicks_on_save_button_after_selecting_status_alone() {
		program.validateAddNewProgram(UtilString.EMPTY,UtilString.EMPTY);
	}
	
	@When("Admin clicks on Cancel button")
	public void admin_clicks_on_cancel_button() {
		program.verifyCancelButton();
	}

	@Then("Admin see a Program Details window getting closed")
	public void admin_see_a_program_details_window_getting_closed() {
		Assert.assertTrue(program.isProgramDetailsClosed(),"Program details window is not closed");
	}

	@When("User enters newly added  Program Name {string} in Search")
	public void user_enters_newly_added_program_name_in_search(String searchPName) {
		LoggerClass.info("Search text : "+searchPName);
		program.enterSearchText(searchPName);
	}

	@Then("User sees an entry for the newly added Program Name")
	public void user_sees_an_entry_for_the_newly_added_program_name() {
	    Assert.assertTrue(program.validateSearchResultEntries(""),"Search not in table");
	}

	@When("User clicks on A New Program button")
	public void user_clicks_on_a_new_program_button() {
		LoggerClass.info("User clicks a new program button");
	    program.clickAddNewProgram();
	}

	@Then("User sees Add new program button is disabled")
	public void user_sees_add_new_program_button_is_disabled() {
		LoggerClass.info("User sees add new program disabled");
		Assert.assertFalse(program.isAddnewProgramButtonEnabled());
	}

	@Then("User  counts number of rows as number {string} in a table")
	public void user_counts_number_of_rows_as_number_in_a_table(String NoOfRows) {
		LoggerClass.info("Number of rows displayed :"+program.numberOfRows());
		Assert.assertEquals(program.numberOfRows(), Integer.parseInt(NoOfRows));
	}
	
	@When("Admin clicks on Edit buttton")
	public void admin_clicks_on_edit_buttton() {
		LoggerClass.info("Admin clicks on edit button");
		program.verifyEditButton();
	}
	
	@When("Admin clicks on Save button after updating Program Name {string}")
	public void admin_clicks_on_save_button_after_updating_program_name(String pgmName) {
		LoggerClass.info("Admin updating program name");
	    program.updatePgmName(pgmName);
	}
	
	@When("Admin  Clicks on Save Button after updating Program Description {string}")
	public void admin_clicks_on_save_button_after_updating_program_description(String pgmDescription) {
		LoggerClass.info("Admin updating program Description");
		program.updatePgmDescription(pgmDescription);
	}
	
	@When("Admin clicks on Save button after Changing Program status {string}")
	public void admin_clicks_on_save_button_after_changing_program_status(String pgmStatus) {
		LoggerClass.info("Admin updating program Status");
		program.updatePgmStatus(pgmStatus);
	}
	
	@When("User enters edited Program Name {string} in Search")
	public void user_enters_edited_program_name_in_search(String searchKey) {
		LoggerClass.info("Search text : "+searchKey);
		program.enterSearchText(searchKey);
	}
	
	@Then("User sees an entry {string} for the newly edited Program Name {string}")
	public void user_sees_an_entry_for_the_newly_edited_program_name(String searchText, String colName) {
		Assert.assertTrue(program.isTextPresentInColumn(searchText,colName),"Search not in table");
	}
	
	@When("User clicks on Edit button")
	public void user_clicks_on_edit_button() {
		LoggerClass.info("User clicks on edit button");
		program.verifyEditButton();
	}
	
	@Then("User sees Edit button is disabled")
	public void user_sees_edit_button_is_disabled() {
		LoggerClass.info("User sees Edit disabled");
		Assert.assertFalse(program.isEditButtonEnabled());
	}
	
	@When("Admin clicks on any Delete button located on the right side")
	public void admin_clicks_on_any_delete_button_located_on_the_right_side() {
		LoggerClass.info("Admin clicks on delete button");
		program.verifyDeleteButton();
	}
	
	@Then("Admin see confimation text as {string}")
	public void admin_see_confimation_text_as(String text) {
		LoggerClass.info("Admin can see delete confirmation :"+UtilString.DELETE_CONFIRM);
	    Assert.assertTrue(program.isDeleteConfirm(text));
	}
	
	@When("Admin clicks on confirm delete {string} button")
	public void admin_clicks_on_confirm_delete_button(String text) {
		LoggerClass.info("Admin clicks "+text+" button");
	    //program.confirmDelete(text);
	}
	
	@Then("Admin can see confirm dialog box closed")
	public void admin_can_see_confirm_dialog_box_closed() {
		LoggerClass.info("Admin can see delete confirmation ");
		Assert.assertTrue(program.isConfirmDeleteBoxClosed(),"Confirm Dialog box is still open");
	}
	
	@When("Admin enters deleted Program Name {string} in Search")
	public void admin_enters_deleted_program_name_in_search(String pgmName) {
		LoggerClass.info("Search keyword entered by Admin :"+pgmName);
		program.enterSearchText(pgmName);
	}
	
	@Then("Admin finds no results for search {string} in {string}")
	public void admin_finds_no_results_for_search_in(String pgmName, String colName) {
		Assert.assertFalse(program.isTextPresentInColumn(pgmName,colName),"Search present in the table");
	}

	@When("User clicks on Delete button")
	public void user_clicks_on_delete_button() {
		LoggerClass.info("User clicks on delete button");
		program.verifyDeleteButton();
	}
	
	@Then("User sees Delete button is disabled")
	public void user_sees_delete_button_is_disabled() {
		LoggerClass.info("User sees Delete disabled");
		Assert.assertFalse(program.isDeleteButtonEnabled());
	}
	
	@Given("Admin Logged on to LMS Website")
	public void admin_logged_on_to_lms_website() {
		LoggerClass.info("Admin is on to LMS Website");
	}
	
	@Then("Admin see the Delete button on the top left hand side as Disabled")
	public void Admin_see_the_delete_button_on_the_top_left_hand_side_as_disabled() {
		LoggerClass.info("Validating the delete on top button");
		
	    Assert.assertFalse(program.isDeleteOnTopEnabled(),"Delete on top is not disabled");
	}
	
	@When("Admin selects more than one Program Name using checkbox")
	public void admin_selects_more_than_one_program_name_using_checkbox() {
		LoggerClass.info("Admin selects more than one program name using check box");
		program.selectMultipleCheckBox();
	}
	
	@Then("Admin see the Delete button on the top left hand side as Enabled")
	public void admin_see_the_delete_button_on_the_top_left_hand_side_as_enabled() {
		LoggerClass.info("Validating the delete on top button by selecting multiple check boxes");
		Assert.assertTrue(program.isDeleteOnTopEnabled(),"Delete on top is not enabled");
	}
	
	
	@When("Admin clicks on Enabled Delete button on the top left hand side")
	public void admin_clicks_on_enabled_delete_button_on_the_top_left_hand_side() {
		LoggerClass.info("Admin clicks delete button on top");
		program.clickDeleteButtonTop();
	}
	
	@Given("Admin clicks on Enabled Delete button after selecting more than one Program Name")
	public void admin_clicks_on_enabled_delete_button_after_selecting_more_than_one_program_name() {
		LoggerClass.info("Admin clicks Enabled delete button on top");
		program.clickDeleteButtonTop();
	}

	@Then("User see check box is disabled")
	public void user_see_check_box_is_disabled() {
		LoggerClass.info("User should see check box disabled");
	    Assert.assertFalse(program.isCheckboxEnabled(),"check box is not disabled for the user");
	}
	
	@When("Admin Selects First checkbox left to Program Name")
	public void admin_selects_first_checkbox_left_to_program_name() {
		LoggerClass.info("Admin selects first Check box");
	    program.selectCheckboxTableHead();
	}
	
	@Then("Admin see all the checkboxes in the Program page get selected")
	public void admin_see_all_the_checkboxes_in_the_program_page_get_selected() {
		LoggerClass.info("Admin should see all checkbox should get selected");
		Assert.assertTrue(program.isAllCheckBoxSelected(),"Checkbox is not selected for the Admin");
	}
	
}
