package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.Attendancepage;
import pageObjects.Batchpage;
import utilities.ContextUI;
import utilities.LoggerClass;

public class BatchAdminStep {
	
		private  ContextUI contextUI;
		private  Attendancepage attendObj;
		private  Batchpage batchObj1;
		
		public BatchAdminStep(ContextUI context)
		{
			System.out.println("******BatchBatchAdminStep*******");
			this.contextUI = context;
			batchObj1 = contextUI.getPageObjectManager().getBatchPage();
		}
		


		/* Scenario 26 - BatchAdmin Validate Add A New Batch button */
		@Given("BatchAdmin Logged on to LMS Website")
		public void BatchAdmin_logged_on_to_lms_website() 
		{
			LoggerClass.info("BatchAdmin logged on LMS website");
		}
		@Given("BatchAdmin is on Manage Batch page")
		public void BatchAdmin_is_on_manage_batch_page() 
		{
			//batchObj1.menuBatchtab();
			LoggerClass.info("BatchAdmin landed on Manage Batch page");
		}
		@When("BatchAdmin Clicks on + A New Batch button")
		public void BatchAdmin_clicks_on_a_new_batch_button() 
		{
			//batchObj1.ClickAddnewBatch();
			LoggerClass.info("BatchAdmin Clicks on + A New Batch button");
		}
		@Then("BatchAdmin see header text as {string}")
		public void BatchAdmin_see_header_text_as(String string)
		{
	 		if(!batchObj1.BatchDetailsDialog().equals("Batch Details")) 
		    {
			   LoggerClass.debug("Batch Details Header verification failed");
			   Assert.assertTrue(false);
			 }
			   Assert.assertTrue(true);
			   LoggerClass.info("Batch Details Header Verified");
		}
		
		/* Scenario 27 - No details Entered in Batch Details Dialog*/
		@When("BatchAdmin Clicks on Save button with out entering details")
		public void BatchAdmin_clicks_on_save_button_with_out_entering_details() 
		{
			//batchObj1.ClickBatchDeatailsSave();
			LoggerClass.info("BatchAdmin Clicks on Save Button with out entering details");
		}
		@Then("BatchAdmin see Error message {string}")
		public void BatchAdmin_see_error_message(String string)
		{
			if(!batchObj1.BatchDetailsInputError().equals("Name is required.")) 
		    {
			   LoggerClass.debug("Name is required Error Message verification failed");
			   Assert.assertTrue(false);
			 }
			   Assert.assertTrue(true);
			   LoggerClass.info("Name is required Error Message validated");
		}

		/* Scenario 27 - Enters Only Name in Batch Details Dialog*/
		@When("BatchAdmin Clicks on Save button after entering Name details")
		public void BatchAdmin_clicks_on_save_button_after_entering_name_details() 
		{
			//batchObj1.BatchDetailsName("SDET77");
			//batchObj1.ClickBatchDeatailsSave();
			LoggerClass.info("BatchAdmin Clicks on Save Button with out entering details");
		}
		@Then("BatchAdmin see Error message as {string}")
		public void BatchAdmin_see_error_message_as(String string)
		{
			if(!batchObj1.BatchDetailsInputError1().equals("Description is required.")) 
		    {
			   LoggerClass.debug("Description is required Error Message verification failed");
			   Assert.assertTrue(false);
			 }
			   Assert.assertTrue(true);
			   LoggerClass.info("Description is required Error Message validated");
		}
		
		/* Scenario 28 -Selects only a Program name from Dropdown in Batch Details window */
		@Given("Clicks on DropDown Menu in Batch Details window")
		public void clicks_on_drop_down_menu_in_batch_details_window() 
		{
		//	batchObj1.BatchDetailsProgramName("frontend");
			LoggerClass.info("BatchAdmin Clicks on DropDown Menu in Batch Details window");
		}
		@When("BatchAdmin Clicks on Save button after selecting a Program Name only from the dropdown")
		public void BatchAdmin_clicks_on_save_button_after_selecting_a_program_name_only_from_the_dropdown()
		{
			//batchObj1.ClickBatchDeatailsSave();
			LoggerClass.info("BatchAdmin Clicks on Save button after selecting a Program Name only from the dropdown");
		}
		
		/* Scenario 29 -Selects Status only in Batch Details window*/
		@When("BatchAdmin Clicks on Save button after selecting Status alone")
		public void BatchAdmin_clicks_on_save_button_after_selecting_status_alone() 
		{
			//batchObj1.BatchDetailsStatus("ACTIVE");
			//batchObj1.ClickBatchDeatailsSave();
			LoggerClass.info("BatchAdmin Clicks on Save Button after selecting Status alone");
		}
		
		/* Scenario 30 -Enters Only Number Of Classes in Batch Details window*/
		@When("BatchAdmin Clicks on Save button after entering Only Number Of Classes")
		public void BatchAdmin_clicks_on_save_button_after_entering_only_number_of_classes() 
		{
			//batchObj1.BatchDetailsNumofClasses("15");
			//batchObj1.ClickBatchDeatailsSave();
			LoggerClass.info("BatchAdmin Clicks on Save Button after entering only Number of classes");
		}
		
		/* Scenario 31 -Click on Cancel button in Batch Details window*/
		@When("BatchAdmin Clicks on Cancel button")
		public void BatchAdmin_clicks_on_cancel_button()
		{
			//batchObj1.ClickBatchDeatailsCancel();
		//	batchObj1.AddBatchDetails("SDET77","frontend","INACTIVE","15","SDETtest","Cancel");
			LoggerClass.info("BatchAdmin Clicks on Cancel button");
		}
		@Then("BatchAdmin see a Batch Details window getting closed")
		public void BatchAdmin_see_a_batch_details_window_getting_closed() 
		{
	 		if(!batchObj1.validateBatchHeader().equals("Manage Batch")) 
		    {
	 			LoggerClass.debug("Batch Details Dialog doesn't closed");
			   Assert.assertTrue(false);
			 }
			   Assert.assertTrue(true);
			   LoggerClass.info("BatchAdmin see Batch Page Header");
		}
		
		/* Scenario 32 - Enters Only Description in Batch Details window*/
		@When("BatchAdmin Clicks on Save button with entering only Description details")
		public void BatchAdmin_clicks_on_save_button_with_out_entering_only_description_details()
		{
			//batchObj1.BatchDetailsDescription("frontend");
			//batchObj1.ClickBatchDeatailsSave();
			 LoggerClass.info("BatchAdmin Clicks on Save Button after entering only Description");
		}
			
		/* Scenario 33 - Enter All details in Batch Details window*/
		@When("BatchAdmin Clicks on Save button after entering all detail")
		public void BatchAdmin_clicks_on_save_button_after_entering_all_detail()
		{
			//batchObj1.AddBatchDetails("SDET77","frontend","INACTIVE","15","SDETtest","Save");
			 LoggerClass.info("BatchAdmin Clicks on Save button after entering all detail");
		}
		@Then("BatchAdmin see Success message {string}")
		public void BatchAdmin_see_success_message(String string) throws InterruptedException 
		{
			 if(!batchObj1.NewBatchSuceessMsg().equals("New Batch Created")) 
			 {
				 LoggerClass.debug("Alert Message Capturing Failed");
				Assert.assertTrue(false);
	     	 }
			 	Assert.assertTrue(true);
			 	 LoggerClass.info("Sucess Alert Message: " + batchObj1.NewBatchSuceessMsg());
		}
		
		/* Scenario 38 - BatchAdmin Validate First Edit button in Batch Page window */
		@When("BatchAdmin Clicks on first Edit buttton")
		public void BatchAdmin_clicks_on_edit_buttton()
		{
			// batchObj1.validatefirstBatchEditbtn();
			 LoggerClass.info("BatchAdmin Clicks on Edit buttton");
		}
		
		/* Scenario 39 -BatchAdmin Edits Batch Name in Batch Page window*/
		@When("BatchAdmin Clicks on Save button after updating Name")
		public void BatchAdmin_clicks_on_save_button_after_updating_name() 
		{
			// batchObj1.BatchDetailsName("testtest1");
			// batchObj1.ClickBatchDeatailsSave();
			 LoggerClass.info("BatchAdmin Edits batch Name in Batch Details window");
		}
		@Then("BatchAdmin see Updated message as {string}")
		public void BatchAdmin_see_updated_message_as(String string) throws InterruptedException 
		{
			if(!batchObj1.UpdatedNameSucessMsg().equals("Updated Name")) 
			 {
				 LoggerClass.debug("Alert Message Capturing Failed");
				 Assert.assertTrue(false);
	     	 }
			 	 Assert.assertTrue(true);
			 	 LoggerClass.info("Sucess Update Message: " + batchObj1.UpdatedNameSucessMsg());
		}
		
		/* Scenario 39 -BatchAdmin Edits first Batch Description in Batch Page window*/
		@When("BatchAdmin Clicks on Save button after updating Description")
		public void BatchAdmin_clicks_on_save_button_after_updating_description() 
		{	
			//batchObj1.BatchDetailsDescription("asdas2");
			//batchObj1.ClickBatchDeatailsSave();
			 LoggerClass.info("BatchAdmin Edits batch Description in Batch Details window");
		}
		@Then("BatchAdmin see Update message as {string}")
		public void BatchAdmin_see_update_message_as(String string) throws InterruptedException 
		{
			if(!batchObj1.UpdatedDescriptionSucessMsg().equals("Updated Description")) 
			 {
				 LoggerClass.debug("Alert Message Capturing Failed");
				 Assert.assertTrue(false);
	     	 }
			 	 Assert.assertTrue(true);
			 	 LoggerClass.info("Sucess Update Message: " + batchObj1.UpdatedDescriptionSucessMsg());
		}
		
		/* Scenario 39 -BatchAdmin Edits first Progran Name in Batch Page window */
		@When("BatchAdmin Clicks on Save button after updating Program ame")
		public void BatchAdmin_clicks_on_save_button_after_updating_program_ame() 
		{
			//batchObj1.BatchDetailsProgramName("SDETtest1");
			//batchObj1.ClickBatchDeatailsSave();
			 LoggerClass.info("BatchAdmin Edits Batch Progran Name in Batch Details window");
		}
		@Then("BatchAdmin see message as {string}")
		public void BatchAdmin_see_message_as(String string) throws InterruptedException
		{
			if(!batchObj1.UpdatedProgramNameSucessMsg().equals("Updated Program Name")) 
			 {
				 LoggerClass.debug("Alert Message Capturing Failed");
				Assert.assertTrue(false);
	     	 }
			 	Assert.assertTrue(true);
			 	 LoggerClass.info("Sucess Update Message: " + batchObj1.UpdatedProgramNameSucessMsg());
		}
		
		/* Scenario 40 -BatchAdmin Edits first Batch Status in Batch Page window */
		@When("BatchAdmin Clicks on Save button after updating Status")
		public void BatchAdmin_clicks_on_save_button_after_updating_status() 
		{
			//batchObj1.BatchDetailsStatus("INACTIVE");
			//batchObj1.ClickBatchDeatailsSave();
			 LoggerClass.info("BatchAdmin Edits Batch Status in Batch Details window");
		}
		@Then("BatchAdmin see Update message1 as {string}")
		public void BatchAdmin_see_update_message1_as(String string) throws InterruptedException 
		{
			if(!batchObj1.UpdatedStatusSucessMsg().equals("Updated Status")) 
			 {
				 LoggerClass.debug("Alert Message Capturing Failed");
				Assert.assertTrue(false);
	     	 }
			 	Assert.assertTrue(true);
			 	 LoggerClass.info("Sucess Update Message: " + batchObj1.UpdatedStatusSucessMsg());
		}
		
		/* Scenario 41 -BatchAdmin Edits first No.Of Classes in Batch Page window */	
		@When("BatchAdmin Clicks on Save button after updating No of Classes")
		public void BatchAdmin_clicks_on_save_button_after_updating_no_of_classes() 
		{
			// batchObj1.BatchDetailsNumofClasses("1000");
			// batchObj1.ClickBatchDeatailsSave();
			 LoggerClass.info("BatchAdmin Edits No of Classes in Batch Details window");
		}
		@Then("BatchAdmin see Update message2 as {string}")
		public void BatchAdmin_see_update_message2_as(String string) throws InterruptedException 
		{
			if(!batchObj1.UpdatedClassesSucessMsg().equals("Updated No of Classes")) 
			 {
				 LoggerClass.debug("Alert Message Capturing Failed");
				Assert.assertTrue(false);
	     	 }
			 	Assert.assertTrue(true);
			 	 LoggerClass.info("Sucess Update Message: " + batchObj1.UpdatedClassesSucessMsg());
		}
		
		/* Scenario 41 - BatchAdmin Verify Delete Functionality */	
		@When("BatchAdmin Clicks on third Delete button located on the right side")
		public void BatchAdmin_clicks_on_third_Delete_button_located_on_the_right_side() 
		{
			//batchObj1.ClickThirdDelete();
			 LoggerClass.info("BatchAdmin selects third row to Delete");
		}
		@Then("BatchAdmin see Delete header text as {string}")
		public void BatchAdmin_see_delete_header_text_as(String string)
		{
			if(!batchObj1.DeleteConfirmHeader().equals("Delete Confirm")) 
			{
				 LoggerClass.debug(" Delete Confirm header verification failed");
				Assert.assertTrue(false);
			}
		 		Assert.assertTrue(true);
		 		 LoggerClass.info("BatchAdmin see Delete header text as Delete Confirm");
		}
		
		/* Scenario 42 - BatchAdmin Click on No button in Delete Confirm dialog */	
		@When("BatchAdmin Clicks on No button")
		public void BatchAdmin_clicks_on_no_button() 
		{
			// batchObj1.ClickNoBtnDelete();
			 LoggerClass.info("BatchAdmin Cancels third row to Delete");
		}
		@Then("BatchAdmin see Delete Confirm dialog closed")
		public void BatchAdmin_see_delete_confirm_dialog_closed()
		{
	 		if(!batchObj1.validateBatchHeader().equals("Manage Batch")) 
		    {
	 			 LoggerClass.debug("Delete Confirm Dialog doesn't closed");
			   Assert.assertTrue(false);
			 }
			   Assert.assertTrue(true);
			   LoggerClass.info("BatchAdmin see Batch Page Header");
		}
		
		/* Scenario 43 - BatchAdmin Click on Yes button in Delete Confirm dialog */	
		@When("BatchAdmin Clicks on Yes button")
		public void BatchAdmin_clicks_on_yes_button() 
		{
			// batchObj1.ClickYesBtnDelete();
			 LoggerClass.info("BatchAdmin Deletes third row");
		}
		@Then("BatchAdmin see Delete Success message {string}")
		public void BatchAdmin_see_delete_success_message(String string) throws InterruptedException 
		{
			if(!batchObj1.DeleteConfirmMsg().equals("Batch Deleted Succesfully")) 
			 {
				 LoggerClass.debug("Alert Message Capturing Failed");
				Assert.assertTrue(false);
	     	 }
			 	Assert.assertTrue(true);
			 	 LoggerClass.info("Sucess Delete Message: " + batchObj1.DeleteConfirmMsg());
		}
		
		/* Scenario 54 - Verify Deletion of Multiple Records  */
		@Given("BatchAdmin selects more than one Batch Name using checkbox")
		public void BatchAdmin_selects_more_than_one_batch_name_using_checkbox() throws InterruptedException
		{
			 batchObj1.ClickBatchcheckbox();
			 LoggerClass.info("Use Clicks on First checkbox left to Batch Name");
			 Assert.assertTrue(batchObj1.BatchCheckboxFunctionality());
			 LoggerClass.info("User see all the checkboxes in the Batch page get selected");
		}
		@When("BatchAdmin Clicks on Enabled Delete button on the top left hand side")
		public void BatchAdmin_clicks_on_enabled_delete_button_on_the_top_left_hand_side()
		{
			if(!batchObj1.leftDeleteBtnStatus() == false)
			 {
				 LoggerClass.debug("User see the Delete button on the left as Enabled");
				Assert.assertTrue(false);
			 }
			 	 Assert.assertTrue(true);
			 	 LoggerClass.info("User see the Delete button on the left as Disabled");
				
				batchObj1.ClickleftDeleteBtn();
		}
		@Then("User see Delete header text as {string}")
		public void user_see_delete_header_text_as(String string) 
		{
			if(!batchObj1.DeleteConfirmHeader().equals("Delete Confirm")) 
			{
				 LoggerClass.debug(" Delete Confirm header verification failed");
				Assert.assertTrue(false);
			}
		 		Assert.assertTrue(true);
		 		 LoggerClass.info("BatchAdmin see Delete header text as Delete Confirm");
		}
		
		/* Scenario 55 -  BatchAdmin Verify the Edit Functionality in Attendance page  */
		@Given("BatchAdmin is on Manage Attendance page")
		public void BatchAdmin_is_on_manage_attendance_page() 
		{
			if(!batchObj1.navigateToAttendancePage().equals("Manage Attendance")) 
			{
				LoggerClass.debug("Manage Attendance page header verification failed");
				Assert.assertTrue(false);
			}
			 Assert.assertTrue(true);
			 LoggerClass.info("BatchAdmin is on Manage Attendance page");	
			 
		}
		@When("BatchAdmin Clicks on First Edit buttton")
		public void BatchAdmin_clicks_on_first_edit_buttton()
		{
			batchObj1.ClickAttendanceEditBtn();
			LoggerClass.info("BatchAdmin Clicks on First Edit buttton in Attendance Page");
		}
		@Then("BatchAdmin see Attendance Error message {string}")
		public void BatchAdmin_see_attendance_error_message(String string) 
		{
			if(!batchObj1.AttendanceErrorMsg().equals("BatchAdmin Has View Only Permission")) 
			 {
				LoggerClass.debug("Alert Message Capturing Failed");
				Assert.assertTrue(false);
	     	 }
			 	Assert.assertTrue(true);
				System.out.println("Attendance Error Message: " + batchObj1.AttendanceErrorMsg());
			    LoggerClass.info("BatchAdmin Has View Only Permission in Attendance Page ");
			
		}
		/* Scenario 5 - BatchAdmin Verify the Delete Functionality in Attendance page  */
		
		@When("BatchAdmin Clicks on First Delete buttton")
		public void BatchAdmin_clicks_on_first_delete_buttton()
		{
			batchObj1.ClickAttendanceDeleteBtn();
			LoggerClass.info("BatchAdmin Clicks on First Delete buttton in Attendance Page");
		}
		
		
		
		
		
}	
		
		
		
		
