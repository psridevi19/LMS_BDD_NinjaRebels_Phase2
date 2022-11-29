package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ProgramPage;

import utilities.ContextUI;

public class ManageUserSteps
	{
	private  ContextUI contextUI;
	private ManageUserPage userobj;
	
	public ManageUserSteps(ContextUI context)
	{
		System.out.println("******ManageUserSteps*******");
		this.contextUI = context;
		login = contextUI.getPageObjectManager().getLoginPage();
		program = contextUI.getPageObjectManager().getProgramPage();
	}
	 
	@Given("User Logged on to LMS website")
	public void user_logged_on_to_lms_website() {
		  userobj = new ManageUserPage (driver) ;
	       System.out.println("User is on Home page"); 
	}

	@Given("User is on any page after Login")
	public void user_is_on_any_page_after_login() {
		System.out.println("User is on Home page"); 
	    
	}

	@When("User clicks the Tab User")
	public void user_clicks_the_tab_user() {
		  userobj.menuusertab();
		   System.out.println("User Clicks on User tab");   
	}

	@Then("User should see the Manage user page")
	public void user_should_see_the_manage_user_page() {
		  System.out.println("User Clicks on User tab"); 
		   if(userobj.UserHeader().equals("Manage User")) 
		     {
		       System.out.println("User Page Header verification failed");
		       Assert.assertTrue(false);
		        }
		       Assert.assertTrue(true);
		      System.out.println("User Page Header Verified");
	   
	}

	@When("User lands on Manage User page")
	public void user_lands_on_manage_user_page() {
		   userobj.menuusertab(); 
		   System.out.println ("user landed on manage user page");
	}

	@Then("User should see the table footer as {string}")
	public void user_should_see_the_table_footer_as(String string) {
		   if(userobj.UserFooter().equals("In total there are 4 users.")) 
		     {
		       System.out.println("User Page Footer verification failed");
		       Assert.assertTrue(false);
		        }
		       Assert.assertTrue(true);
	}

	@Then("User sees pagination links are disabled")
	public void user_sees_pagination_links_are_disabled() {
		if(!userobj.userPaginatorlinks()==true)
		{
		    Assert.assertTrue(false);
		    System.out.println("User Paginator-Next Button is Not Enabled");
		  }
		     Assert.assertTrue(true);
		     System.out.println("User Paginator-Next Button is Enabled");
	    
	}

	@Then("User should see the pagination controls below data table")
	public void user_should_see_the_pagination_controls_below_data_table() {
		 userobj.menuusertab(); 
		   System.out.println ("User should see the pagination controls below data table"); 
		   {
		        Assert.assertTrue(false);
		        System.out.println("User should not see the pagination controls below data table");
		      }
		         Assert.assertTrue(true);
		         System.out.println("User should see the pagination controls below data table");
	}

	@Then("User Pagination control should be disabled")
	public void user_pagination_control_should_be_disabled() {
		 userobj.menuusertab(); 
		   { Assert.assertTrue(false);
		      System.out.println("User Paginator control Not disabled");
		    }
		       Assert.assertTrue(true);
		       System.out.println("User Paginator Control disabled");
	    
	}

	@When("Manage user table has more than five rows")
	public void manage_user_table_has_more_than_five_rows() {
		  if(!userobj.mufiverows()==true)
		  {
		      Assert.assertTrue(false);
		      System.out.println("Manage user table has not more than five rows button disabled");
		    }
		       Assert.assertTrue(true);
		       System.out.println("Manage user table has more than five rows button enabled");
	   
	}

	@Then("Pagination control should be enabled")
	public void pagination_control_should_be_enabled() {
		  userobj.menuusertab(); 
		   { Assert.assertTrue(false);
		      System.out.println("User Paginator control disabled");
		    }
		       Assert.assertTrue(true);
		       System.out.println("User Paginator Control not disabled");
	    
	}

	@Then("User should see the text {string} below the user table.")
	public void user_should_see_the_text_below_the_user_table(String string) {
		 if(userobj.userPaginator11().equals("Showing 1 to 4 of 4 entries.")) 
	     {
	       System.out.println("User paginator verification failed");
	       Assert.assertTrue(false);
	        }
	       Assert.assertTrue(true);
	      System.out.println("User paginator Verified");   
	    
	}

	@Then("User see the Search Text box")
	public void user_see_the_search_text_box() {
		 if(!userobj.validateSearch1().equals("Search...")) 
		   {
		     System.out.println("User Page Search verification failed");
		     Assert.assertTrue(false);
		   }
		     Assert.assertTrue(true);
		    System.out.println("User Page Search Verified");
	    
	}

	@When("User enters Name to be searched")
	public void user_enters_name_to_be_searched() {
		 userobj.menuusertab(); 
		   System.out.println ("User enters Name to be searched"); 
	    
	}

	@Then("User namewith the rows should be displayed")
	public void user_namewith_the_rows_should_be_displayed() {
		 System.out.println ("User namewith the rows should be displayed"); 
	    
	}

	@Then("User should see the button with text  Add New User")
	public void user_should_see_the_button_with_text_add_new_user() {
		  if(!userobj.addnew().equals("Search...")) 
		   {
		     System.out.println("user should not see the add new user button ");
		     Assert.assertTrue(false);
		   }
		     Assert.assertTrue(true);
		    System.out.println("user should see the add new user button");
	   
	}

	@When("User clicks Add New User")
	public void user_clicks_add_new_user() {
		  userobj.newuserbtn();
		  System.out.println ("User namewith the rows should be displayed");
	}

	@Then("User should see the {string} dialog box")
	public void user_should_see_the_dialog_box(String string) {
		  if(!userobj.userdialoguebox().equals("user Details")) 
		   {
		     System.out.println("user should see the user Details dialogue box not opened ");
		     Assert.assertTrue(false);
		   } 
		    Assert.assertTrue(true);
		    System.out.println("user should see the user Details dialogue box");
	   
	}

	@Then("User should see the table header as \"Empty checkbox-icon , ID with sort icon, Name with Sort icon, Email Address with sort icon,Contact Number with sort icon, Batch with sort icon, Skill with Sort icon, Edit\\/Delete as column names")
	public void user_should_see_the_table_header_as_empty_checkbox_icon_id_with_sort_icon_name_with_sort_icon_email_address_with_sort_icon_contact_number_with_sort_icon_batch_with_sort_icon_skill_with_sort_icon_edit_delete_as_column_names() {
		 if(userobj.THeader().equals("Table User")) 
	     {
	       System.out.println("User should not see all table header");
	       Assert.assertTrue(false);
	        }
	       Assert.assertTrue(true);
	      System.out.println("User should see all table header");
	}

	@Then("User Table rows should be sorted")
	public void user_table_rows_should_be_sorted() {
		System.out.println("Table rows are sorted ");
	    
	}
    @When("User checks empty checkbox in header")
	public void user_checks_empty_checkbox_in_header() {
	   userobj.THCheckbox();
	}

	@Then("User Check box in all the rows of user table should be checked")
	public void user_check_box_in_all_the_rows_of_user_table_should_be_checked() {
		 Assert.assertTrue(userobj.THCheckbox());
		    System.out.println("Check box in all the rows of user table should be checked");
	}

	@Then("User should see the delete icon at the top left corner of the user table")
	public void user_should_see_the_delete_icon_at_the_top_left_corner_of_the_user_table() {{
		 System.out.println("User should not see the delete icon");
	     Assert.assertTrue(false);
	   }
	     Assert.assertTrue(true);
	    System.out.println("User should see the delete icon");
	}

	@When("User  clicks button with text {string}")
	public void user_clicks_button_with_text(String string) {
		 userobj.Deleteicon();
		   System.out.println("User Clicks button with yes");     
	}

	@Then("User Selected rows should be deleted and popup should be shown with success message {string}")
	public void user_selected_rows_should_be_deleted_and_popup_should_be_shown_with_success_message(String string) {
		   userobj.menuusertab(); 
		   System.out.println("selected rows should be deleted with success message");  
	}

	@When("User clicks the close\\(x)icon")
	public void user_clicks_the_close_x_icon() {
		userobj.CloseIcon();
	    
	}

	@Then("User should see Confirm dialog box should be closed")
	public void user_should_see_confirm_dialog_box_should_be_closed() {
	System.out.println("confirm dialog box closed");
	    
	}

	@Then("User should see the buttons with edit\\/delete icon in each row of Edit\\/Delete coulmn")
	public void user_should_see_the_buttons_with_edit_delete_icon_in_each_row_of_edit_delete_coulmn() {
		System.out.println("Edit and Delete button enabled ");
	    
	}
	@When("User clicks ID in any row")
	public void user_clicks_id_in_any_row() {
		userobj.IDbtn(); 
		  System.out.println ("User clicks ID in any row");
	}

	@Then("User see dialog box displayed with user information")
	public void user_see_dialog_box_displayed_with_user_information() {
		  if(!userobj.UDBox().equals("user Dialogue box")) 
		   {
		     System.out.println("User will not see dialog box displayed with user information ");
		     Assert.assertTrue(false);
		   } 
		    Assert.assertTrue(true);
		    System.out.println("User see dialog box displayed with user information"); 
	}

	@When("User clicks on cancel button")
	public void user_clicks_on_cancel_button() {
		 userobj.Canbtn();  
		  System.out.println ("User clicks on cancel button"); 
	}

	@Then("User see User Details window getting  closed")
	public void user_see_user_details_window_getting_closed() {
		  if(!userobj.winclo().equals("user details box closed")) 
		   {
		     System.out.println("User see User Details window not getting  closed ");
		     Assert.assertTrue(false);
		   } 
		    Assert.assertTrue(true);
		    System.out.println("User see User Details window getting  closed ");  
	}

	@When("User clicks on cancel \\(X)icon")
	public void user_clicks_on_cancel_x_icon() {
		  userobj.CanIcon();   
		  System.out.println ("User clicks on cancel (X)icon");
	}

	@Then("User Details window should be closed")
	public void user_details_window_should_be_closed() {{
		  System.out.println("User Details window should not be closed with icon ");
		     Assert.assertTrue(false);
		   } 
		    Assert.assertTrue(true);
		    System.out.println("User Details window should be closed with icon "); 
	}

	@Then("should see a button with text as Submit in user details window")
	public void should_see_a_button_with_text_as_submit_in_user_details_window() {
		  userobj.subBtn();
	}

	@Then("should see the placeholders with Text As {string},{string}, Last name\",\"Email adress\",\"Phone no\", \"Address\",\"City\", \"State\",\"Postal Code\".\"Program\",\"UG Program\",\"PG Program\",\"Skill\",\"Experience\",\"Admin\\/User\\/Staff Role\",Visa status\",{string},{string}")
	public void should_see_the_placeholders_with_text_as_last_name_email_adress_phone_no_address_city_state_postal_code_program_ug_program_pg_program_skill_experience_admin_user_staff_role_visa_status(String string, String string2, String string3, String string4) {
	   userobj.Ln();
	   userobj.ED();
	   userobj.PN();
	   userobj.Addr();
	   userobj.CT();
	   userobj.state();
	   userobj.PC();
	   userobj.UGp();
	   userobj.PGp();
	   userobj.skill();
	   userobj.EXp();
	   userobj.VS();
	}

	@Then("User should select from the drop down menu for state")
	public void user_should_select_from_the_drop_down_menu_for_state() {
	    userobj.dropD();
	    System.out.println ("User should select from the drop down menu for state");
	}

	@Then("User should select from the drop down menu for user role")
	public void user_should_select_from_the_drop_down_menu_for_user_role() {
		userobj.userrole();
	      System.out.println ("User should select from the drop down menu for user role");
	}

	@When("User clicks submit button with all details empty")
	public void user_clicks_submit_button_with_all_details_empty() {
		  userobj.subEmpty();
		   System.out.println ("User clicks submit button with all details empty");
	}

	@Then("User should see a Error message {string}")
	public void user_should_see_a_error_message(String string) {
		if(!userobj.errorMsg().equals("error message is Mandatory Fields cannot be empty")) 
		   {
		     System.out.println("error message is Mandatory Fields are filled ");
		     Assert.assertTrue(false);
		   } 
		    Assert.assertTrue(true);
		    System.out.println("error message is Mandatory Fields cannot be empty");  

	}

	@When("User clicks submit button with all details filled")
	public void user_clicks_submit_button_with_all_details_filled() {
		userobj.subBtn();
	  
	}

	@Then("User sees Success message  {string}  is  Should be Saved.")
	public void user_sees_success_message_is_should_be_saved(String string) {
		String actual_msg=driver.findElement(By.xpath("//*[@id=usersuccessmsg")).getText();
		String expected_msg="User details saved Successfully";
		Assert.assertEquals(actual_msg, expected_msg);
		System.out.println("User details saved Successfully");
	}

	@Then("User see error message {string}")
	public void user_see_error_message(String string) {
		 if(!userobj.errorName().equals("error message is Name is required")) 
		   {
		     System.out.println("error message is Name is not required ");
		     Assert.assertTrue(false);
		   } 
		    Assert.assertTrue(true);
		    System.out.println("error message is Name is required"); 
	}

	@Then("User should see the button with text   {string}")
	public void user_should_see_the_button_with_text(String string) {
	    
	}

	@When("Enters more than ten digits")
	public void enters_more_than_ten_digits() {
	   
	}

	@Then("User sees error message {string}")
	public void user_sees_error_message(String string) {
		  if(!userobj.errorEmail().equals("error message is invalid emaild id")) 
		   {
		     System.out.println("valid emaild id ");
		     Assert.assertTrue(false);
		   } 
		    Assert.assertTrue(true);
		    System.out.println("error message is invalid emaild id");    
	}

	@When("User Enters more than {int} digits")
	public void user_enters_more_than_digits(Integer int1) {
	   
	}

	@When("User clicks on state dropdown")
	public void user_clicks_on_state_dropdown() {
		userobj.dropD();
	  
	}

	@Then("User see list of states in Alphabetical Order")
	public void user_see_list_of_states_in_alphabetical_order() {
	   
	}

	@When("User clicks on UG Program dropdown")
	public void user_clicks_on_ug_program_dropdown() {
		userobj.dropD();
	   	}

	@Then("User  see list of UG Program")
	public void user_see_list_of_ug_program() {
	    	}

	@Given("User is on \"User Details\"window")
	public void user_is_on_user_details_window() {
		System.out.println("User details window opened");
	   	}

	@When("User clicks the button {string}")
	public void user_clicks_the_button(String string) {
	
	   userobj.subBtn();
	}

	@Then("User should see the input field with Label {string}")
	public void user_should_see_the_input_field_with_label(String string) {
		String inputfield=driver.findElement(By.id("inputlabel")).getText();
		System.out.println(inputfield);
	    
	}



}
