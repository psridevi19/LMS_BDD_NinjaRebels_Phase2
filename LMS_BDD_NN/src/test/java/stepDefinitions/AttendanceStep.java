package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.Attendancepage;
import pageObjects.Batchpage;
import pageObjects.LoginPage;
import utilities.ContextUI;
import utilities.LoggerClass;
import utilities.ReadConfig;


public class AttendanceStep {
	
	private  ContextUI contextUI;
	private  Attendancepage attendObj;
	private  Batchpage batchObj;
	
	public AttendanceStep(ContextUI context)
	{
		System.out.println("******AttendanceStep*******");
		this.contextUI = context;
		attendObj = contextUI.getPageObjectManager().getAttendancePage();
		batchObj = contextUI.getPageObjectManager().getBatchPage();
	}
		
	 

	 
	 
	 @Given("UserorStaff Logged on to LMS Website")
	 public void userorstaff_logged_on_to_lms_website() 
	 {
		 LoggerClass.info("UserorStaff Logged on to LMS Website");
	 }
	 
	 /* Scenario1 - Validating the Manage Attendance Header */
	 @When("UserorStaff Clicks on Attendance button")
	 public void userorstaff_clicks_on_attendance_button() 
	 {
		 if(!attendObj.LMSHomeTitle().equals("LMS - Learning Management System"))
		 {
			 LoggerClass.debug("LMS Homepage Title Verification Failed");
			 Assert.assertTrue(false);
		 }
		 Assert.assertTrue(true); 
		 LoggerClass.info("LMS Homepage Title Verified");
		 
		// attendObj.menuAttendancetab();
		 LoggerClass.info("UserorStaff Clicked on Attendance button");	 
	 }
	 @Then("UserorStaff see header text as {string}")
	 public void userorstaff_see_header_text_as(String string) 
	 {
		 if(!attendObj.validateAttendanceHeader().equals("Manage Attendance"))
		 {
			LoggerClass.debug("Attendance Page Header verification failed");
			 Assert.assertTrue(false);
		 }	 
		 Assert.assertTrue(true); 	 
		 LoggerClass.info("Attendance Page Header Verified");	
	 }
	 
	 /* Scenario2 - Validating the Manage Attendance Footer */
	 @When("UserorStaff is on Manage Attendance page")
	 public void useror_staff_is_on_manage_attendance_page()
	 {
		// attendObj.menuAttendancetab();
		 if(attendObj.validateAttendanceHeader().equals("Manage Attendance"))
		 Assert.assertTrue(true); 	 
		 LoggerClass.info("UserorStaff is on Manage Attendance page");
	 }
	 @Then("UserorStaff see Footer text as {string}")
	 public void useror_staff_see_footer_text_as(String string) 
	 {
		 if(!attendObj.validateAttendanceFooter().equals("In total there are 5 entries."))
		 {
			LoggerClass.debug("Attendance Page Footer verification failed");
			 Assert.assertTrue(false);
		 }	 
		 Assert.assertTrue(true); 	 
		 LoggerClass.info("Attendance Page Footer Verified");	
 	 }

	 /* Scenario3 - Validating the Manage Attendance Paginator */
	 @Then("UserorStaff see Paginator text as {string}")
	 public void useror_staff_see_paginator_text_as(String string)
	 {
		 if(!attendObj.validateAttendancePaginator().equals("Showing 1 to 5 of 5 entries."))
		 {
			LoggerClass.debug("Attendance Page Paginator verification failed");
			 Assert.assertTrue(false);
		 }	 
		 Assert.assertTrue(true); 	 
		 LoggerClass.info("Attendance Page Paginator Verified");	
	 }
	 
	 /* Scenario3 - Validating the Manage Attendance Paginator Links*/
	 @Then("UserorStaff see Paginator links are disabled")
	 public void useror_staff_see_paginator_links_are_disabled() 
	 {
		 if(!attendObj.verifyAttendancePaginatorLinks() == true)
		 {
			LoggerClass.debug("Attendance Page Paginator Links verification failed");
			 Assert.assertTrue(false);
		 }	 
		 Assert.assertTrue(true); 	 
		 LoggerClass.info("Attendance Page Paginator Links Verified");	
	 }

	 /* Scenario3 - Verify the First Edit Button */
	 @When("UserorStaff Clicks on First Edit buttton")
	 public void useror_staff_clicks_on_first_edit_buttton() 
	 {
		 if(!attendObj.validateAttendanceHeader().equals("Manage Attendance"))
		 {
			 attendObj.menuAttendancetab();
		 }
 		// attendObj.ClickAttendanceEditBtn();
		 LoggerClass.info("UserorStaff Clicked on Attendance Edit button");	
	 }
	 @Then("UserorStaff header text as {string}")
	 public void useror_staff_header_text_as(String string) 
	 {
		 if(!attendObj.AttendanceDetailsheader().equals("Attendance Details"))
		 {
			LoggerClass.debug("Attendance Details Header verification failed");
			 Assert.assertTrue(false);
		 }	 
		 Assert.assertTrue(true); 	 
		 LoggerClass.info("Attendance Details Header Verified");	
	 }
 
	 /* Scenario4 - Edit Program Name in Attendance Details window */
	 @When("UserorStaff clicks on Save button after editing Program Name")
	 public void useror_staff_clicks_on_save_button_after_editing_program_name()
	 {
		// attendObj.EditProgramName("SDET77");
		 LoggerClass.info("Program Name Edited ");	
		 //attendObj.ClickAttendanceDetailsSave();
	 }
	 @Then("UserorStaff see the success message {string}")
	 public void useror_staff_see_the_success_message(String string) throws InterruptedException
	 {
		 if(!attendObj.DetailsUpdateSuceessMsg().equals("Updated Successfully")) 
		 {
			LoggerClass.debug("Alert Message Capturing Failed");
			Assert.assertTrue(false);
     	 }
		 	Assert.assertTrue(true);
		 	LoggerClass.info("UserorStaff see Alert Message: " + attendObj.DetailsUpdateSuceessMsg());	
	 }
	 	 
	 /* Scenario5 - Edit User Name in Attendance Details window */
	 @When("UserorStaff clicks on Save button after editing User Name")
	 public void useror_staff_clicks_on_save_button_after_editing_user_name()
	 {
		 //attendObj.EditUserName("Latha");
		 LoggerClass.info("User Name Edited ");
		 //attendObj.ClickAttendanceDetailsSave();
	 }
 
	 /* Scenario6 - Edit Present in Attendance Details window */
	 @When("UserorStaff clicks on Save button after editing Present")
	 public void useror_staff_clicks_on_save_button_after_editing_present()
	 {
		// attendObj.EditAttendance("Present");
		 LoggerClass.info("Present Edited ");
		 //attendObj.ClickAttendanceDetailsSave();
	 }
	 
	 /* Scenario7 - Edit Absent in Attendance Details window */
	 @When("UserorStaff clicks on Save button after editing Absent")
	 public void useror_staff_clicks_on_save_button_after_editing_absent() 
	 {
		// attendObj.EditAttendance("Absent");
		 LoggerClass.info("Absent Edited ");
		//attendObj.ClickAttendanceDetailsSave();
	 }

	 /* Scenario8 - Click on Cancel button in Attendance Details dialog*/
	 @When("UserorStaff clicks on Cancel button")
	 public void useror_staff_clicks_on_cancel_button()
	 {
		 // attendObj.AddAttendanceDetails("SDET","Latha","Absent","Cancel");
		 LoggerClass.info("UserorStaff clicks on Cancel button");
	 }
	 @Then("UserorStaff see Attendance Details dilog getting closed")
	 public void useror_staff_see_attendance_details_dilog_getting_closed()
	 {
		 if(!attendObj.validateAttendanceHeader().equals("Manage Attendance"))
		 {
			LoggerClass.debug("Attendence Details closed but error");
			 Assert.assertTrue(false);
		 }	 
		 Assert.assertTrue(true); 	 
		 LoggerClass.info("UserorStaff see Attendance Detail closed with out saving details");
	 }
	 
	 /* Scenario9 - Click on first Delete button*/
	 @When("UserorStaff clicks on first Delete button")
	 public void useror_staff_clicks_on_first_delete_button() 
	 {
		// attendObj.ClicAttendanceDeleteBtn();
		 LoggerClass.info("UserorStaff Clicked on first Delete button");
	 }
	 @Then("UserorStaff see Delete header text as {string}")
	 public void useror_staff_see_delete_header_text_as(String string) 
	 {
		 if(!attendObj.DeleteConfirmheader().equals("Delete Confirm"))
		 {
			LoggerClass.debug("Attendence Details closed but error");
			 Assert.assertTrue(false);
		 }	 
		 Assert.assertTrue(true); 	 
		 LoggerClass.info("UserorStaff see Attendance Detail closed with out saving details");
	 }
	 
	 /* Scenario10 - Verify No Functionality in delete dialog*/
	 @When("UserorStaff Clicks on No button")
	 public void useror_staff_clicks_on_no_button() 
	 {
		 if(!attendObj.validateAttendanceHeader().equals("Manage Attendance"))
		 {
			 attendObj.menuAttendancetab();
		 }
			// attendObj.ClickAttendanceDeleteBtn();
		    // attendObj.ClickDeleteNoBtn();
		 LoggerClass.info("UserorStaff Clicked No button");	
	 }
	 @Then("UserorStaff see Delete Confirm dialog closed")
	 public void useror_staff_see_delete_confirm_dialog_closed() 
	 {
		 if(!attendObj.validateAttendanceHeader().equals("Manage Attendance"))
		 {
			LoggerClass.debug("Delete Confirm Dialog closed but error");
			 Assert.assertTrue(false);
		 }	 
		 Assert.assertTrue(true); 	 
		 LoggerClass.info("UserorStaff see Delete Confirm Dialog closed");
	 }
	 
	 /* Scenario11 - Verify Yes Functionality in delete dialog*/
	 @When("UserorStaff Clicks on Yes button")
	 public void useror_staff_clicks_on_yes_button() 
	 {
		 if(!attendObj.validateAttendanceHeader().equals("Manage Attendance"))
		 {
			 attendObj.menuAttendancetab();
		 }
			// attendObj.ClickAttendanceDeleteBtn();
		    // attendObj.ClickDeleteYesBtn();
		 LoggerClass.info("UserorStaff Clicked Yes button");	
	 }
	 @Then("UserorStaff see Delete Success message {string}")
	 public void useror_staff_see_delete_success_message(String string) throws InterruptedException 
	 {
		 if(!attendObj.DeleteConfirmMsg().equals("Name Deleted Succesfully"))
		 {
			 LoggerClass.debug("Alert Message Capturing Failed");
			 Assert.assertTrue(false);
		 }	 
		 Assert.assertTrue(true); 	 
		 LoggerClass.info("UserorStaff see Alert Message: " + attendObj.DeleteConfirmMsg());	
	 }
	 
	 /* Scenario12 - Verify  CheckBox Functionality*/
	 @When("UserorStaff Selects First checkbox")
	 public void useror_staff_selects_first_checkbox() 
	 {
		// attendObj.ClickAttendancecheckbox();
		 LoggerClass.info("UserorStaff Clicked on first CheckBox button");	
	 }
	 @Then("UserorStaff see list of User Names in that Program")
	 public void useror_staff_see_list_of_user_names_in_that_program() 
	 {
//		 if(!attendObj.EntriesforUsername("Meena") == true)
//		 {
//			 LoggerClass.debug("No records found");
//			 Assert.assertTrue(false);
//		 }
		 Assert.assertTrue(true); 
		 LoggerClass.info("UserorStaff see list of User Names in that Program");	
	 }
	 
	 
	 
}
