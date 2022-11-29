package stepDefinitions;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.Attendancepage;
import pageObjects.Batchpage;
import utilities.ContextUI;
import utilities.LoggerClass;
import utilities.ReadConfig;

public class BatchStep{

	private  ContextUI contextUI;
	private  Attendancepage attendObj;
	private  Batchpage batchObj;
	
	public BatchStep(ContextUI context)
	{
		System.out.println("******BatchStep*******");
		this.contextUI = context;
		batchObj = contextUI.getPageObjectManager().getBatchPage();
	}
	

	 @Given("User Logged on to LMS Website")
	 public void user_logged_on_to_lms_website() 
	 {
		 LoggerClass.info("User logged on LMS website");
	 }
	 
	 /* Scenario1 - Validating the Manage Batch Header */
	 @When("User Clicks on Batch button")
	 public void user_clicks_on_batch_button()
	 {    	
		// batchObj.menuBatchtab();
		 LoggerClass.info("User landed on Manage Batch page");
	 }
	 @Then("User see header text as {string}")
	 public void user_see_header_text_as(String string) 
	 {
 		if(!batchObj.validateBatchHeader().equals("Manage Batch")) 
	    {
		   LoggerClass.debug("Batch Page Header verification failed");
		   Assert.assertTrue(false);
		 }
		   Assert.assertTrue(true);
		   LoggerClass.info("Batch Page Header Verified");
	 }
	
	 /* Scenario2 - Validating the Manage Batch Footer */
	 @Given("User is on Manage Batch page")
	 public void user_is_on_manage_batch_page() 
	 {
		// batchObj.menuBatchtab();
		 LoggerClass.info("User landed on Manage Batch page");
	 }
 	 @Then("User see Footer text as {string}")
	 public void user_see_footer_text_as(String string) 
	 {
		 if(!batchObj.validateBatchFooter().equals("In total there are 21 batches.")) 
		 {
			LoggerClass.debug("Batch Page Footer verification failed");
			Assert.assertTrue(false);
      	 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Batch Page Footer Verified");
	 }
	
	 /* Scenario3 - Validating the Manage Batch Paginator */
	 @Then("User see paginator text as {string}")
	 public void user_see_paginator_text_as(String string) 
	 {
		 if(!batchObj.validateBatchPaginator().equals("Showing 1 to 5 of 21 entries.")) 
		 {
			 LoggerClass.debug("Batch Page paginator verification failed");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Batch Page Paginator Verified");
	 }

	/* Scenario4 - Verify paginator -next button on the Batch page*/
	@When("User Clicks on Enabled paginator-next button")
	public void user_clicks_on_enabled_paginator_next_button() 
	{
		if(!batchObj.verifyBatchPaginatorNext().equals("true"))
		{
			LoggerClass.debug("Batch Paginator-Next Button is Not Enabled");
			Assert.assertTrue(false);
		}
		   Assert.assertTrue(true);
		   LoggerClass.info("Batch Paginator-Next Button is Enabled");
	}
	@Then("User see paginator text changed to {string}")
	public void user_see_paginator_text_changed_to(String string) 
	{
		if(!batchObj.validateBatchPaginator2().equals("Showing 6 to 10 of 21 entries.")) 
		 {
			 LoggerClass.debug("Batch Page Paginator verification failed");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Batch Page Paginator Verified");
	}

	/* Scenario5- Verify Paginator -prevoius button */
	@When("User Clicks on Enabled paginator -prev button")
	public void user_clicks_on_enabled_paginator_prev_button() 
	{
		//batchObj.verifyBatchPaginatorNext(); 
		if(!batchObj.verifyBatchPaginatorPrevoius().equals("true"))
		{
			LoggerClass.debug("Batch Paginator-Prevoius Button is Not Enabled");
			Assert.assertTrue(false);
		}
		   Assert.assertTrue(true);
		   LoggerClass.info("Batch Paginator-Prevoius Button is Enabled");
	}
	@Then("User see the text as {string}")
	public void user_see_the_text_as(String string)
	{
		if(!batchObj.validateBatchPaginator().equals("Showing 1 to 5 of 21 entries.")) 
		 {
			 LoggerClass.debug("Batch Page Paginator verification failed");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Batch Page Paginator Verified");
	}

	/* Scenario6- Verify paginator -last button */
	@When("User Clicks on Enabled paginator -last button")
	public void user_clicks_on_enabled_paginator_last_button() 
	{
		if(!batchObj.verifyBatchPaginatorLast().equals("true"))
		{
			LoggerClass.debug("Batch Paginator-Last Button is Not Enabled");
			Assert.assertTrue(false);
		}
		   Assert.assertTrue(true);
		   LoggerClass.info("Batch Paginator-Last Button is Enabled");
	}
	@Then("User see Page number navigated to {string}")
	public void user_see_page_number_navigated_to(String string) 
	{
		if(!batchObj.validateBatchPagination5().equals("5")) 
		 {
			 LoggerClass.debug("Batch Page Paginator5 verification failed");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Batch Page Paginator5 Verified");
	}

	/* Scenario6- Verify paginator -first button */
	@When("User Clicks on Enabled paginator -first button")
	public void user_clicks_on_enabled_paginator_first_button() 
	{
		//batchObj.verifyBatchPaginatorLast();
		if(!batchObj.verifyPaginatorFirst().equals("true"))
		{
			LoggerClass.debug("Batch Paginator-First Button is Not Enabled");
			Assert.assertTrue(false);
		}
		   Assert.assertTrue(true);
		   LoggerClass.info("Batch Paginator-First Button is Enabled");
	}
	@Then("User see Page number navigated back to {string}")
	public void user_see_page_number_navigated_back_to(String string) 
	{
		if(!batchObj.validateBatchPagination1().equals("1")) 
		 {
			 LoggerClass.debug("Batch Page Paginator1 verification failed");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Batch Page Paginator1 Verified");
	}
	
	/* Scenario7- Verify Search */
	@Then("User see the Search Text box has text as {string}.")
	public void user_see_the_search_text_box_has_text_as(String string)
	{
		if(!batchObj.validateSearch().equals("Search...")) 
		 {
			 LoggerClass.debug("Batch Page Search verification failed");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Batch Page Search Verified");
	}
	
	/* Scenario8- Search by Batch Name */
	@When("User enters Batch Name to be searched")
	public void user_enters_batch_name_to_be_searched()
	{
		//batchObj.BatchDetailsSearch("sdet 1001");
		LoggerClass.info("Batch Name:sdet 1001 is Searched ");
	}
	@Then("Entries for the searched BatchName are shown.")
	public void entries_for_the_searched_batch_name_are_shown() throws InterruptedException 
	{
		if(!batchObj.EntriesforBatchName("sdet 1001") == true) 
		 {
			 LoggerClass.debug("Entry for Batch Name:sdet 1001 is failed");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Entry for Batch Name:sdet 1001 is dispalyed ");
	}

	/* Scenario9- Search by Batch Description */
	@When("User enters Batch Description to be searched")
	public void user_enters_batch_description_to_be_searched() 
	{
		//batchObj.BatchDetailsSearch("asds");
		LoggerClass.info("Batch Description: asds is Searched ");
	}
	@Then("Entries for the searched Batch Description are shown.")
	public void entries_for_the_searched_batch_description_are_shown() throws InterruptedException
	{
		if(!batchObj.EntriesforBatchDescription("asds") == true) 
		 {
			 LoggerClass.debug("Entry for Batch Description: asds is failed");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Entry for Batch Description: asds is dispalyed ");
	}
	
	/* Scenario10- Search by Batch Status */
	@When("User enters Batch Status to be searched")
	public void user_enters_batch_status_to_be_searched() 
	{
		//batchObj.BatchDetailsSearch("ACTIVE");
		LoggerClass.info("Batch Status: ACTIVE is Searched ");
	}
	@Then("Entries for the searched Batch Status are shown.")
	public void entries_for_the_searched_batch_status_are_shown() throws InterruptedException 
	{
		if(!batchObj.EntriesforBatchStatus("ACTIVE") == true) 
		 {
			 LoggerClass.debug("Entry for Batch Status: ACTIVE is failed");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Entry for Batch Status: ACTIVE is dispalyed");
	}
	
	/* Scenario11- Search by No Of Classes  */
	@When("User enters Batch No Of Classes to be searched")
	public void user_enters_batch_no_of_classes_to_be_searched()
	{
		//batchObj.BatchDetailsSearch("99");
		LoggerClass.info("Batch No of Classes: 99 is Searched ");
	}
	@Then("Entries for the searched Batch No Of Classes are shown.")
	public void entries_for_the_searched_batch_no_of_classes_are_shown() throws InterruptedException
	{
		if(!batchObj.EntriesforBatchNoofClasses("99") == true) 
		 {
			 LoggerClass.debug("Entry for Batch No Of Classes: 99 is failed");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Entry for Batch No Of Classes: 99 is dispalyed");
	}
	
	/* Scenario12- Search by Program Name   */
	@When("User enters Batch Program Name to be searched")
	public void user_enters_batch_program_name_to_be_searched()
	{
		//batchObj.BatchDetailsSearch("Angular123456");
		LoggerClass.info("Batch Program Name: Angular123456 is Searched ");
	}
	@Then("Entries for the searched Batch Program Name are shown.")
	public void entries_for_the_searched_batch_program_name_are_shown() throws InterruptedException
	{
		if(!batchObj.EntriesforBatchProgram("Angular123456") == true) 
		 {
			 LoggerClass.debug("Entry for Batch Program Names: Angular123456 is failed");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Entry for Batch Program Names: Angular123456 is dispalyed");
	}

	/* Scenario13- Batch Name are displayed in Ascending order   */
	@When("User Clicks on Batch Name Ascending Arrow")
	public void user_clicks_on_batch_name_ascending_arrow() 
	{
		//batchObj.clickbatchHeaderforAscending("Batch Name");
		LoggerClass.info("Clicked on Batch Name Ascending Arrow");
	}
	@Then("User see the Batch Name displayed in Ascending order")
	public void user_see_the_batch_name_displayed_in_ascending_order() 
	{
		if(!batchObj.verifyAscendingFunctionality("Batch Name") == true) 
		 {
			 LoggerClass.debug("Batch Name Not displayed in Ascending order");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Batch Name displayed in Ascending order");	
	}	
	
	/* Scenario14- Batch Description are displayed in Ascending order   */
	@When("User Clicks on Batch Description Ascending Arrow")
	public void user_clicks_on_batch_description_ascending_arrow() 
	{
		//batchObj.clickbatchHeaderforAscending("Batch Description");
		LoggerClass.info("Clicked on Batch Description Ascending Arrow");
	}
	@Then("User see the Batch Description displayed in Ascending order")
	public void user_see_the_batch_description_displayed_in_ascending_order() 
	{	
		if(!batchObj.verifyAscendingFunctionality("Batch Description") == true) 
		 {
			 LoggerClass.debug("Batch Description Not displayed in Ascending order");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Batch Description displayed in Ascending order");	
	}
	
	/* Scenario15- Batch Status are displayed in Ascending order   */
	@When("User Clicks on Batch Status Ascending Arrow")
	public void user_clicks_on_batch_status_ascending_arrow() 
	{
		batchObj.clickbatchHeaderforAscending("Batch Status");
		LoggerClass.info("Clicked on Batch Status Ascending Arrow");
	}
	@Then("User see the Batch Status displayed in Ascending order")
	public void user_see_the_batch_status_displayed_in_ascending_order() 
	{
		if(!batchObj.verifyAscendingFunctionality("Batch Status") == true) 
		 {
			 LoggerClass.debug("Batch Status Not displayed in Ascending order");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Batch Status displayed in Ascending order");	
	}
	
	/* Scenario16- No Of Classes are displayed in Ascending order   */
	@When("User Clicks on No Of Classes Ascending Arrow")
	public void user_clicks_on_no_of_classes_ascending_arrow()
	{
		batchObj.clickbatchHeaderforAscending("No Of Classes");
		LoggerClass.info("Clicked on No Of Classes Ascending Arrow");
	}
	@Then("User see the No Of Classes displayed in Ascending order")
	public void user_see_the_no_of_classes_displayed_in_ascending_order() 
	{
		if(!batchObj.verifyAscendingFunctionality("No Of Classes") == true) 
		 {
			 LoggerClass.debug("No Of Classes Not displayed in Ascending order");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("No Of Classes displayed in Ascending order");	
	}
	
	/* Scenario17- Program Name are displayed in Ascending order   */
	@When("User Clicks on Program Name Ascending Arrow")
	public void user_clicks_on_program_name_ascending_arrow() 
	{
		batchObj.clickbatchHeaderforAscending("Program Name");
		LoggerClass.info("Clicked on Program Name Ascending Arrow");
	}
	@Then("User see the Program Name displayed in Ascending order")
	public void user_see_the_program_name_displayed_in_ascending_order() 
	{
		if(!batchObj.verifyAscendingFunctionality("Program Names") == true) 
		 {
			 LoggerClass.debug("Program Name Not displayed in Ascending order");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Program Name displayed in Ascending order");	
	}
	
	/* Scenario18 - Batch Name are displayed in Descending order   */
	@When("User Clicks on Batch Name Descending Arrow")
	public void user_clicks_on_batch_name_descending_arrow()
	{
		batchObj.clickbatchHeaderforDescending("Batch Name");
		LoggerClass.info("Clicked on Batch Name Descending Arrow");
	}
	@Then("User see the Batch Name displayed in Descending order")
	public void user_see_the_batch_name_displayed_in_descending_order()
	{
		if(!batchObj.verifyDescendingFunctionality("Batch Name") == true) 
		 {
			 LoggerClass.debug("Batch Name displayed in Descending order");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Batch Name displayed in Descending order");	
	}
	
	/* Scenario19 - Batch Description are displayed in Descending order   */
	@When("User Clicks on Batch Description Descending Arrow")
	public void user_clicks_on_batch_description_descending_arrow()
	{
		batchObj.clickbatchHeaderforDescending("Batch Description");
		LoggerClass.info("Clicked on Batch Description Description Arrow");
	}
	@Then("User see the Batch Description displayed in Descending order")
	public void user_see_the_batch_description_displayed_in_descending_order() 
	{
		if(!batchObj.verifyDescendingFunctionality("Batch Description") == true) 
		 {
			 LoggerClass.debug("Batch Description Not displayed in Description order");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Batch Description displayed in Description order");	
	}
	
	/* Scenario20 - Batch Status are displayed in Descending order   */
	@When("User Clicks on Batch Status Descending Arrow")
	public void user_clicks_on_batch_status_descending_arrow() 
	{
		batchObj.clickbatchHeaderforDescending("Batch Status");
		LoggerClass.info("Clicked on Batch Status Descending Arrow");
	}
	@Then("User see the Batch Status displayed in Descending order")
	public void user_see_the_batch_status_displayed_in_descending_order() 
	{
		if(!batchObj.verifyDescendingFunctionality("Batch Status") == true) 
		 {
			 LoggerClass.debug("Batch Status Not displayed in Descending order");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Batch Status displayed in Descending order");	
	}

	/* Scenario21 - No Of Classes are displayed in Descending order   */
	@When("User Clicks on No Of Classes Descending Arrow")
	public void user_clicks_on_no_of_classes_descending_arrow() 
	{
		batchObj.clickbatchHeaderforDescending("No Of Classes");
		LoggerClass.info("Clicked on No Of Classes Descending Arrow");
	}
	@Then("User see the No Of Classes displayed in Descending order")
	public void user_see_the_no_of_classes_displayed_in_descending_order() 
	{
		if(!batchObj.verifyDescendingFunctionality("No Of Classes") == true) 
		 {
			 LoggerClass.debug("No Of Classes Not displayed in Descending order");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("No Of Classes displayed in Descending order");	
	}

	/* Scenario22 - No Of Classes are displayed in Descending order   */
	@When("User Clicks on Program Name Descending Arrow")
	public void user_clicks_on_program_name_descending_arrow()
	{
		batchObj.clickbatchHeaderforDescending("Program Name");
		LoggerClass.info("Clicked on Program Name Descending Arrow");
	}
	@Then("User see the Program Name displayed in Descending order")
	public void user_see_the_program_name_displayed_in_descending_order() 
	{
		if(!batchObj.verifyDescendingFunctionality("Program Names") == true) 
		 {
			 LoggerClass.debug("Program Name Not displayed in Descending order");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Program Name displayed in Descending order");	
	}
	
	/* Scenario23 - Validate Number of rows in a table   */
	@Then("User counts number of rows as {int} in a table")
	public void user_counts_number_of_rows_as_in_a_table(Integer int1) 
	{
		Assert.assertEquals(int1, batchObj.noOfRowsDisplayed());
		LoggerClass.info("User counts number of rows as 5 in a table");
	}
	
	/* Scenario 33 - User Verify Added New Batch Name*/
	@When("User Enters newly added  Batch Name in Search")
	public void user_enters_newly_added_batch_name_in_search() 
	{
		batchObj.BatchDetailsSearch("SDET77");
		LoggerClass.info("User search for new Batch Name:SDET77");
	}
	@Then("Entry for the newly added Batch Name is shown")
	public void entry_for_the_newly_added_batch_name_is_shown() 
	{
		if(!batchObj.searchNewDetailsInTable("SDET77","frontend","INACTIVE","15","SDETtest") == true) 
		 {
			 LoggerClass.debug("Entry for the newly added Batch Name is Not shown");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Entry for the newly added Batch Name is shown");	
	}
	
	/* Scenario37 - User Validate Add A New Batch button  */
	@When("User Clicks on + A New Batch button")
	public void user_clicks_on_a_new_batch_button()
	{
		//batchObj.ClickAddnewBatch();
		LoggerClass.info("User Clicks on + A New Batch button");
	}
	@Then("User see a Error message {string}")
	public void user_see_a_error_message(String string) throws InterruptedException 
	{
		 if(!batchObj.UserorStaffAddnewBatchErrormessage().equals("Only Admin have Access")) 
		 {
			LoggerClass.debug("Alert Message Capturing Failed");
			Assert.assertTrue(false);
     	 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Alert Message: " + batchObj.UserorStaffAddnewBatchErrormessage());
   	}
	
	/* Scenario 42 -User Verifys Edited Details */	
	@When("User Enters newly edited  Batch Name in Search")
	public void user_enters_newly_edited_batch_name_in_search() 
	{
		batchObj.BatchDetailsSearch("testtest1");
		LoggerClass.info("User search for newly edited Batch Name:testtest1");
	}
	@Then("Entry for the newly edited Batch Name is shown")
	public void entry_for_the_newly_edited_batch_name_is_shown() 
	{
		if(!batchObj.searchNewDetailsInTable("testtest1","asdas2","INACTIVE","1000","SDETtest1") == true) 
		 {
			 LoggerClass.debug("Entry for the newly added Batch Name is Not shown");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("Entry for the newly added Batch Name is shown");	
	}
	
	/* Scenario 44 - User Validate Deleted Batch Name */	
	@When("User Enters deleted Batch Name in Search")
	public void user_enters_deleted_batch_name_in_search()
	{
		batchObj.BatchDetailsSearch("AngularSDK");
		LoggerClass.info("User search for Deleted Batch Name:AngularSDK");
	}
	@Then("User finds NO records")
	public void user_finds_no_records() 
	{
		if(!batchObj.searchNewDetailsInTable("AngularSDK","Testttt","ACTIVE","99","Angular123456") == true) 
		 {
			 LoggerClass.debug("Problem in displaying the records");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("User finds No records ");
	}
	
	/* Scenario 47 - User Validate First Edit button   */
	@When("User Clicks on Edit buttton")
	public void user_clicks_on_edit_buttton()
	{
		batchObj.ClickBatchEditBtn();
		LoggerClass.info("User Clicks on First Batch Edit button");
	}

	/* Scenario 51 - User Validates First Delete button  */
	@When("User Clicks on Delete buttton")
	public void user_clicks_on_delete_buttton() 
	{
		batchObj.ClickBatchDeleteBtn();
		LoggerClass.info("User Clicks on First Batch Delete button");
	}
	
	/* Scenario 58 - User Verifies Checkbox Functionality */
	@When("User Selects First checkbox left to Batch Name")
	public void user_selects_first_checkbox_left_to_batch_name()
	{
		batchObj.ClickBatchcheckbox();
		LoggerClass.info("User Clicks on First checkbox left to Batch Name");
	}
	@Then("User see all the checkboxes in the Batch page get selected")
	public void user_see_all_the_checkboxes_in_the_batch_page_get_selected() throws InterruptedException 
	{
		if(!batchObj.BatchCheckboxFunctionality() == true) 
		 {
			 LoggerClass.debug("Problem in selecting all the checkboxes");
			 Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("User see all the checkboxes in the Batch page get selected");
	}
	
	/* Scenario 52 -  Verify the state of Delete button on left  */
	@Then("User see the Delete button on the top left hand side as Disabled")
	public void user_see_the_delete_button_on_the_top_left_hand_side_as_disabled() 
	{
		if(!batchObj.leftDeleteBtnStatus() == false)
		 {
			LoggerClass.debug("User see the Delete button on the left as Enabled");
			Assert.assertTrue(false);
    	 }
		 	Assert.assertTrue(true);
			LoggerClass.info("User see the Delete button on the left as Disabled");
	}

	/* Scenario 53 - Validates Multiple Program Selection  */
	@When("User selects more than one Batch Name using checkbox")
	public void user_selects_more_than_one_batch_name_using_checkbox() throws InterruptedException
	{
		batchObj.ClickBatchcheckbox();
		LoggerClass.info("Use Clicks on First checkbox left to Batch Name");
		
		if(!batchObj.BatchCheckboxFunctionality()== true)
		 {
			LoggerClass.debug("User see the Delete button on the left as Disabled");
			Assert.assertTrue(false);
   	 }
		 	Assert.assertTrue(true);
			LoggerClass.info("User see all the checkboxes in the Batch page get selected");
	}
	@Then("User see the Delete button on the left side as Enabled")
	public void user_see_the_delete_button_on_the_left_side_as_enabled() 
	{
		if(!batchObj.leftDeleteBtnStatus() == true)
		 {
			LoggerClass.debug("User see the Delete button on the left as Disabled");
			Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("User see the Delete button on the left as Enabled");
	}
	
	/* Scenario 57 - User Verify Deleted Batch Names */
	@When("User enters deleted batch Names in Search")
	public void user_enters_deleted_batch_names_in_search()
	{
		batchObj.BatchDetailsSearch("testset");
		LoggerClass.info("Deleted batch name is entered for Search ");
	}
	@Then("User finds no results")
	public void user_finds_no_results()
	{
		if(!batchObj.verifyDeletedrecords("testset") == true)
		 {
			LoggerClass.debug("Deletion failed");
			Assert.assertTrue(false);
		 }
		 	Assert.assertTrue(true);
			LoggerClass.info("User finds No results of deleted Batch names");

	}
	
	
}	
	