package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AssignmentPage;
import utilities.ContextUI;
import utilities.LoggerClass;
import utilities.UtilString;


public class AssignmentSteps {
	private WebDriver driver;
	private AssignmentPage assign;
	private ContextUI contextUI;

	public AssignmentSteps(ContextUI context)
	{
		LoggerClass.info("******AssignmentSteps*******");
		this.contextUI = context;
		assign = contextUI.getPageObjectManager().getAssignmentPage();
		driver = contextUI.getDriver();
	}
	
	@When("User enters username and password credentials")
	public void user_enters_username_and_password_credentials(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("User enters username and password");
		List<List<String>> data=dataTable.cells();
		driver.findElement(By.id("txtusername")).sendKeys(data.get(0).get(0));
	    driver.findElement(By.id("txtpassword")).sendKeys(data.get(0).get(1));
	    driver.findElement(By.id("login")).click();
		LoggerClass.info("login pass");
		
	}
    @Then("user lands on Home page")
	public void user_lands_on_home_page() {
		System.out.println("user navigated to home page");
	}
    @Given("User is logged on to LMS website")
    public void user_is_logged_on_to_lms_website() {
       System.out.println("LMS page opened");
       LoggerClass.info("LMS page opened");
    }
	@When("User Clicks on assignment page")
	public void user_clicks_on_assignment_page() {
		assign.clickassignment();
	}
    @Then("User should see a Header {string}")
	public void user_should_see_a_header(String string) {
    	 String title=driver.getTitle();
		 System.out.println("Title is "+title);
		 String expected_title="Manage Assignment";
		 Assert.assertEquals(title, expected_title);
		 System.out.println("Test passed");
		 LoggerClass.info("Test passed");
	    
	}

	@Then("User should see a Footer text {string}")
	public void user_should_see_a_footer_text(String string) {
		WebElement footer=driver.findElement(By.xpath("//u1[@data]"));
		List<WebElement> assign=footer.findElements(By.tagName("a"));
		int noOfentries=assign.size();
		System.out.println("The number of entries in footer"+noOfentries);
		
	}

	@Then("User should see a Paginator text {string}")
	public void user_should_see_a_paginator_text(String string) {
		String paginatortxt=driver.findElement(By.xpath("//div[@class='Showing 1 to 3 of entries']")).getText();
		System.out.println(paginatortxt);
		
		}

	@Given("User is on Assignment page")
	public void user_is_on_assignment_page() {
		System.out.println("User is on Assignment page");
	  }

	@When("User Clicks on Enabled paginator-next button")
	public void user_clicks_on_enabled_paginator_next_button() {
		String paginatortxt=driver.findElement(By.xpath("//div[@class='Showing 1 to 3 of entries']")).getText();
		System.out.println(paginatortxt);
		String displayedcount=driver.findElement(By.id(paginatortxt)).getText().split("")[6];
		System.out.println("Total no.of displayed count"+displayedcount);
		int paginationSize=driver.findElements(By.cssSelector("paginate>span>a")).size();
		List<String> names=new ArrayList<String>();
		for(int i=1;i<=paginationSize;i++) {
			String paginationaSelector = "#example_paginate>span("+i+")";
			driver.findElement(By.cssSelector(paginationaSelector)).click();
			List<WebElement> namesElements=driver.findElements(By.cssSelector("#paginator>tbody>tr>td"));
			for(WebElement namesElement: namesElements) {
				names.add(namesElement.getText());
			}
			
		}
		for(String name: names) {
			System.out.println(name);
		}
		int totalNames=names.size();
		System.out.println("Total no.of names"+totalNames);
		Assert.assertEquals(displayedcount, String.valueOf(totalNames));
		}

	@Then("User Should be navigated to next page")
	public void user_should_be_navigated_to_next_page() {
		System.out.println("user navigated to next page");
		LoggerClass.info("user navigated to next page");
	    
	}

	@Then("User Should be navigated to previous page")
	public void user_should_be_navigated_to_previous_page() {
		assign.previousbtn();
		System.out.println("user navigated to previous page");
	}
	

	@Then("User Should be navigated to Last page")
	public void user_should_be_navigated_to_last_page() {
		assign.lastbtn();
	   
	}
	@Then("User Should be navigated to First  page")
	public void user_should_be_navigated_to_first_page() {
		assign.firstbtn();
	    
	}
	@When("User clicks Search bar after entering Assignment name")
	public void user_clicks_search_bar_after_entering_assignment_name() {
		assign.searchbar();
		}

	@Then("The requested assignment details should be displayed")
	public void the_requested_assignment_details_should_be_displayed() {
		List<WebElement> assignname=driver.findElements(By.xpath("//tr/td[1]"));
		//List<WebElement> sdetlist= assignname.stream().filter(assigname->assigname.getText().contains("sdet")).collect(Collectors.toList());
	    Assert.assertEquals(assignname.size(),UtilString.ROWSIZE);
	    LoggerClass.info("Assignment details displayed");
	}
	@When("User Clicks on Assignment Name Ascending Arrow")
	public void user_clicks_on_assignment_name_ascending_arrow() {
	    //click on column
		//capture all webelements into list
		assign.assignmentnamesortascen();
	}

	@Then("User should see the Assignment Name displayed in Ascending order")
	public void user_should_see_the_assignment_name_displayed_in_ascending_order() {
		List<WebElement> assignnameList=driver.findElements(By.xpath("//tr/td[1]"));
		List<String> orignalassignnamelist=assignnameList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedassignnamelist=orignalassignnamelist.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(orignalassignnamelist.equals(sortedassignnamelist));
	}

	@When("User Clicks on Assignment Description Ascending Arrow")
	public void user_clicks_on_assignment_description_ascending_arrow() {
	   assign.assignmentDescriptionsortascen();
	}

	@Then("User should see the Assignment Description displayed in Ascending order")
	public void user_should_see_the_assignment_description_displayed_in_ascending_order() {
		List<WebElement> assigndescList=driver.findElements(By.xpath("//tr/td[2]"));
		List<String> orignalassigndesclist=assigndescList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedassigndesclist=orignalassigndesclist.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(orignalassigndesclist.equals(sortedassigndesclist));
	   
	}
	@When("User Clicks on Assignment Due Date Ascending Arrow")
	public void user_clicks_on_assignment_due_date_ascending_arrow() {
		assign.assignmentDateesortascen();
	   
	}

	@Then("User should see the Assignment Due Date displayed in Ascending order")
	public void user_should_see_the_assignment_due_date_displayed_in_ascending_order() {
		List<WebElement> assigndateList=driver.findElements(By.xpath("//tr/td[3]"));
		List<String> orignalassigndatelist=assigndateList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedassigndatelist=orignalassigndatelist.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(orignalassigndatelist.equals(sortedassigndatelist));
	   
	}

	@When("User Clicks on Assignment Grade Ascending Arrow")
	public void user_clicks_on_assignment_grade_ascending_arrow() {
		assign.assignmentgradesortascen();
	  
	}

	@Then("User should see the Assignment Grade displayed in Ascending order")
	public void user_should_see_the_assignment_grade_displayed_in_ascending_order() {
		List<WebElement> assigngradeList=driver.findElements(By.xpath("//tr/td[4]"));
		List<String> orignalassigngradelist=assigngradeList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedassigngradelist=orignalassigngradelist.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(orignalassigngradelist.equals(sortedassigngradelist));
	   
	   
	}
	@When("User Clicks on Assignment Name Descending Arrow")
	public void user_clicks_on_assignment_name_descending_arrow() {
	   assign.assignmentnamesortdes();
	}

	@Then("User should see the Assignment Name displayed in Descending order")
	public void user_should_see_the_assignment_name_displayed_in_descending_order() {
		List<WebElement> assignnameList=driver.findElements(By.xpath("//tr/td[1]"));
		List<String> orignalassignnamelist=assignnameList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedassignnamelist=orignalassignnamelist.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(orignalassignnamelist.equals(sortedassignnamelist));
	}

	@When("User Clicks on Assignment Description Descending Arrow")
	public void user_clicks_on_assignment_description_descending_arrow() {
	   assign.assignmentDescriptionsortdes();
	}

	@Then("User should see the Assignment Description displayed in Descending order")
	public void user_should_see_the_assignment_description_displayed_in_descending_order() {
		List<WebElement> assigndescList=driver.findElements(By.xpath("//tr/td[2]"));
		List<String> orignalassigndesclist=assigndescList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedassigndesclist=orignalassigndesclist.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(orignalassigndesclist.equals(sortedassigndesclist));
	   
	   
	}
	@When("User Clicks on Assignment Due Date Descending Arrow")
	public void user_clicks_on_assignment_due_date_descending_arrow() {
	  assign.assignmentDateesortdes();
	}

	@Then("User should see the Assignment Due Date displayed in Descending order")
	public void user_should_see_the_assignment_due_date_displayed_in_descending_order() {
		List<WebElement> assigndateList=driver.findElements(By.xpath("//tr/td[3]"));
		List<String> orignalassigndatelist=assigndateList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedassigndatelist=orignalassigndatelist.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(orignalassigndatelist.equals(sortedassigndatelist));
	   
	   }

	@When("User Clicks on Assignment Grade Descending Arrow")
	public void user_clicks_on_assignment_grade_descending_arrow() {
		assign.assignmentgradesortdes();
	   	}
	

	@Then("User should see the Assignment Grade displayed in Descending order")
	public void user_should_see_the_assignment_grade_displayed_in_descending_order() {
		List<WebElement> assigngradeList=driver.findElements(By.xpath("//tr/td[4]"));
		List<String> orignalassigngradelist=assigngradeList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedassigngradelist=orignalassigngradelist.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(orignalassigngradelist.equals(sortedassigngradelist));
	   
	   }
	@Given("Admin\\/User is on Manage Assignment page")
	public void admin_user_is_on_manage_assignment_page() {
	   System.out.println("admin/User is on Manage Assignment page");
	}

	@When("Admin\\/User clicks a Add New Assignment button")
	public void admin_user_clicks_a_add_new_assignment_button() {
	   assign.addassignment();
	}

	@Then("Admin\\/User should see a message {string}")
	public void admin_user_should_see_a_message(String string) {
		String actual_error=driver.findElement(By.xpath("//*[@id=errormsgaccess")).getText();
		String expected_error="Staff only have access to add New Assignment";
		Assert.assertEquals(actual_error, expected_error);
		//Assert.assertTrue(actual_error.contains("Please enter your all fields"));
		System.out.println("Test passed");
	}

	
	@When("Staff  clicks on Save after leaving all the fields empty")
	public void staff_clicks_on_save_after_leaving_all_the_fields_empty() {
		 assign.clicksave();
			 
	}

	  

	@Then("Staff should see an error message {string}")
	public void staff_should_see_an_error_message(String string) {
		String actual_error=driver.findElement(By.xpath("//*[@id=errormsgname")).getText();
		String expected_error="Name is required";
		Assert.assertEquals(actual_error, expected_error);
		//Assert.assertTrue(actual_error.contains("Please enter your all fields"));
		System.out.println("Test passed");
	}

	@Given("Staff is on Assignment Details page")
	public void staff_is_on_assignment_details_page() {
	   System.out.println("Assignment details page opened");
	}
	@When("Staff enters assignment name,assignment description,assignment Grade and Duedate and clicks save")
	public void staff_enters_assignment_name_assignment_description_assignment_grade_and_duedate_and_clicks_save(io.cucumber.datatable.DataTable dataTable) {
	   List<List<String>> data=dataTable.cells();
	   driver.findElement(By.id("txtassignmentname")).sendKeys(data.get(0).get(0));
	    driver.findElement(By.id("txtassigndescription")).sendKeys(data.get(0).get(1));
	    driver.findElement(By.id("grade")).sendKeys(data.get(0).get(2));
	    driver.findElement(By.id("duedate")).sendKeys(data.get(0).get(3));
	    
	  Select dropdownD=new Select(driver.findElement(By.name("Date")));
	  dropdownD.selectByValue("01");
	  Select dropdownM=new Select(driver.findElement(By.name("month")));
	  dropdownM.selectByValue("10");
	  Select dropdownY=new Select(driver.findElement(By.name("year")));
	  dropdownY.selectByValue("2022");
	  assign.clicksave();
     }
    @Then("Staff should see a message {string}")
	public void staff_should_see_a_message(String string) {
    	String expectedSuccessmsg="New Assignment added Successfully!";
    	String actualmessage=driver.findElement(By.xpath("//div[contains(@class,'successmessage')]")).getText();
    	Assert.assertEquals(actualmessage, expectedSuccessmsg);
    	LoggerClass.warn(actualmessage);
	    
	}

    @When("Staff enters assignment name,assignment description,assignment Grade and Duedate and clicks cancel")
    public void staff_enters_assignment_name_assignment_description_assignment_grade_and_duedate_and_clicks_cancel(io.cucumber.datatable.DataTable dataTable) {
    	 List<List<String>> data=dataTable.cells();
  	   driver.findElement(By.id("txtassignmentname")).sendKeys(data.get(0).get(0));
  	    driver.findElement(By.id("txtassigndescription")).sendKeys(data.get(0).get(1));
  	    driver.findElement(By.id("grade")).sendKeys(data.get(0).get(2));
  	    driver.findElement(By.id("duedate")).sendKeys(data.get(0).get(3));
  	    
  	  Select dropdownD=new Select(driver.findElement(By.name("Date")));
  	  dropdownD.selectByValue("01");
  	  Select dropdownM=new Select(driver.findElement(By.name("month")));
  	  dropdownM.selectByValue("12");
  	  Select dropdownY=new Select(driver.findElement(By.name("year")));
  	  dropdownY.selectByValue("2022");
  	  assign.clickcancel();
    }

	@Then("Staff should see a Assignment details window is closed")
	public void staff_should_see_a_assignment_details_window_is_closed() {
		System.out.println("Assignment details window is closed");
	  
	}

	
    @When("User clicks on Assignment")
	public void user_clicks_on_assignment() {
    	assign.clickassignment();
	    
	}
    @Then("User should see a newly added Assignment")
    public void user_should_see_a_newly_added_assignment() {
    	String actual_msg=driver.findElement(By.xpath("//*[@id=assignnewaddmsg")).getText();
		String expected_msg="New Assignment added Successfully";
		Assert.assertEquals(actual_msg, expected_msg);
		//Assert.assertTrue(actual_msg.contains("New Assignment added Successfully"));
		System.out.println("New Assignment added Successfully");
       LoggerClass.info("New Assignment added Successfully");
    }

	

	@Given("Staff is on Assignment  page")
	public void staff_is_on_assignment_page() {
		System.out.println("Staff is on assignment page");
	   }

	@When("Staff clicks manage button under Assignment Grade")
	public void staff_clicks_manage_button_under_assignment_grade() {
		assign.clkmanage();
	  }

	@Then("Staff should be navigated to Grade Window")
	public void staff_should_be_navigated_to_grade_window() {
		System.out.println("grade window opened");
		
	   }
	@When("Staff clicks an edit Assignment button")
	public void staff_clicks_an_edit_assignment_button() {
		assign.editassign();
	    }

	@Then("Staff should see a Assignment details window")
	public void staff_should_see_a_assignment_details_window() {
		 String assigndetailstitle=driver.getTitle();
		 System.out.println("Title is "+assigndetailstitle);
		 String expected_title=" Assignment Details";
		 Assert.assertEquals(assigndetailstitle, expected_title);
		 System.out.println("Test passed");
		 LoggerClass.info("Test passed");
		
	   }
	@When("Staff edits all the fields after clicking on Edit button")
	public void staff_edits_all_the_fields_after_clicking_on_edit_button() {
		assign.editassign();
		assign.editassignall();
		assign.clicksave();
	   	}

	@Then("The fields should be edited successfully")
	public void the_fields_should_be_edited_successfully() {
		String actual_msg=driver.findElement(By.xpath("//*[@id=assigneditmsg")).getText();
		String expected_msg="Assignment edited Successfully";
		Assert.assertEquals(actual_msg, expected_msg);
		//Assert.assertTrue(actual_msg.contains("Registered Successfully"));
		System.out.println("Assignment edited Successfully");
		LoggerClass.info("Assignment edited Successfully");
	   }

	
	  	@Given("User\\/Staff is on Assignment page")
	public void user_staff_is_on_assignment_page() {
	  		System.out.println("user/staff is on assignment page");
	   
	}

	@When("User\\/Staff clicks on Assignment Name")
	public void user_staff_clicks_on_assignment_name() {
		assign.assignmentname();
	   	}

	@Then("User\\/Staff should be navigated to Assignment Google form page")
	public void user_staff_should_be_navigated_to_assignment_google_form_page() {
		System.out.println("google form opened successfully");
	    	}

	@Given("Admin is on Assignment page")
	public void admin_is_on_assignment_page() {
		System.out.println("Assignment page opened by Admin");
	   	}

	@When("Admin clicks on Assignment Name")
	public void admin_clicks_on_assignment_name() {
		assign.assignmentname();
	   }

	@Then("Admin should see a warning message {string}")
	public void admin_should_see_a_warning_message(String string) {
		System.out.println("User and Staff should have access");
		}

	@Given("User\\/Staff is on Assignment  Google form page")
	public void user_staff_is_on_assignment_google_form_page() {
		System.out.println("google form opened");
	  	}

	@When("User\\/Staff enters all questions and clicks save")
	public void user_staff_enters_all_questions_and_clicks_save(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data=dataTable.cells();
		   driver.findElement(By.id("txtfirstlastname")).sendKeys(data.get(0).get(0));
		    driver.findElement(By.id("txtanimal")).sendKeys(data.get(0).get(1));
		    driver.findElement(By.id("txtcolor")).sendKeys(data.get(0).get(2));
		    assign.Googlsubmiteform();
	}

	@Then("User\\/Staff entered google forms successfully")
	public void user_staff_entered_google_forms_successfully() {
		String actual_msg=driver.findElement(By.xpath("//*[@id=googleformsuccessmsg")).getText();
		String expected_msg="Google form entered Successfully";
		Assert.assertEquals(actual_msg, expected_msg);
		//Assert.assertTrue(actual_msg.contains("Registered Successfully"));
		System.out.println("Google form entered Successfully");
	   }

	   	
	@When("User\\/Staff clicks on submit button after leaving all questions and mail id")
	public void user_staff_clicks_on_submit_button_after_leaving_all_questions_and_mail_id() {
		assign.Googlsubmiteform();
	    	}

	@Then("User\\/Staff should get a warning message {string}")
	public void user_staff_should_get_a_warning_message(String string) {
		String actual_msg=driver.findElement(By.xpath("//*[@id=googleformerrorsmsg")).getText();
		String expected_msg="you must enter all questions";
		Assert.assertEquals(actual_msg, expected_msg);
		System.out.println("you must answer to all questions");
		LoggerClass.warn("you must answer to all questions");
	   	}

	@When("User\\/Staff clicks clear form button after entering all questions and mail id")
	public void user_staff_clicks_clear_form_button_after_entering_all_questions_and_mail_id() {
		assign.clearGoogleform();
	    	}

	@Then("The Assignment Google form cleared successfully")
	public void the_assignment_google_form_cleared_successfully() {
		System.out.println("Google form cleared successfully");
	   
	}
	@Given("Staff is on Manage Assignment page")
	public void staff_is_on_manage_assignment_page() {
		String assignpage=driver.findElement(By.id("manageassignment")).getText();
		System.out.println(assignpage);
		}

	@When("Staff clicks on delete button on the righr side")
	public void staff_clicks_on_delete_button_on_the_righr_side() {
		assign.individualdelete();
	   	}

	@Then("Staff should see a Delete Confirmation window")
	public void staff_should_see_a_delete_confirmation_window() {
	   String ConfirmDelWindow=driver.findElement(By.xpath("//[*delete,contains('')]")).getText();
	   System.out.println(ConfirmDelWindow);
	}

	@Given("Staff is on Delete Confirmation window")
	public void staff_is_on_delete_confirmation_window() {
		System.out.println("Delete confirmation window opened");
	    	}

	@When("Staff clicks Yes")
	public void staff_clicks_yes() {
		assign.confirmdelYes();
		System.out.println("Assignment deleted successfully");
	   
	}

	@Then("Staff Should see \"Assignment Deleted Successfully")
	public void staff_should_see_assignment_deleted_successfully() {
		String actual_msg=driver.findElement(By.xpath("//*[@id=assigndeltmsg")).getText();
		String expected_msg="Assignment deleted Successfully";
		Assert.assertEquals(actual_msg, expected_msg);
		//Assert.assertTrue(actual_msg.contains("Registered Successfully"));
		System.out.println("Assignment deleted Successfully");
	  LoggerClass.info("Assignment deleted Successfully");
	}

	@When("Staff clicks No")
	public void staff_clicks_no() {
		assign.confirmdelNo();
	   
	}

	@Then("Confirmation delete window should be closed successfully")
	public void confirmation_delete_window_should_be_closed_successfully() {
		System.out.println("delete window closed");
	    	}

	@When("Staff clicks delete button on the top aftr selecting multiple checkbox")
	public void staff_clicks_delete_button_on_the_top_aftr_selecting_multiple_checkbox() {
		assign.topCheckbox();
		assign.confirmdelYes();
	   	}

	@Then("Staff should see a  Delete confirm window")
	public void staff_should_see_a_delete_confirm_window() {
		 String ConfirmDelWindow=driver.findElement(By.xpath("//[*delete,contains('')]")).getText();
		   System.out.println(ConfirmDelWindow);
	  }

	@Then("All Assignments are deleted Successfully")
	public void all_assignments_are_deleted_successfully() {
		String actual_msg=driver.findElement(By.xpath("//*[@id=allassigndeltmsg")).getText();
		String expected_msg="All Assignments are deleted Successfully";
		Assert.assertEquals(actual_msg, expected_msg);
		//Assert.assertTrue(actual_msg.contains("Registered Successfully"));
		System.out.println(" All Assignments are deleted Successfully");
		LoggerClass.info("All Assignments are deleted Successfully");
	  
	   	}

	@Given("User\\/Staff is on Assignments page")
	public void user_staff_is_on_assignments_page() {
		String assignpage=driver.findElement(By.id("manageassignment")).getText();
		System.out.println(assignpage);
	}

	@When("User\\/Staff clicks individual checkbox button")
	public void user_staff_clicks_individual_checkbox_button() {
	  assign.individualchkbox();
	 
	}

	@Then("User\\/Staff should see a delete button on the top left")
	public void user_staff_should_see_a_delete_button_on_the_top_left() {
		System.out.println("User should see a delete button" );
	    	}

	@Given("Admin is on Manage Assignment page")
	public void admin_is_on_manage_assignment_page() {
		String assignpage=driver.findElement(By.id("manageassignment")).getText();
		System.out.println(assignpage);
	  	}

	@When("Admin clicks individual checkbox button")
	public void admin_clicks_individual_checkbox_button() {
		assign.individualchkbox();
	   	}

	@Given("User\\/Staff is on Manage Assignment page")
	public void user_staff_is_on_manage_assignment_page() {
		String assignpage=driver.findElement(By.id("manageassignment")).getText();
		System.out.println(assignpage);
	    	}

	@When("User\\/Staff clicks check box on the left side to the Assignment Name")
	public void user_staff_clicks_check_box_on_the_left_side_to_the_assignment_name() {
		assign.topCheckbox();
	   
	}

	@Then("User\\/Staff should see a enabled delete button on the top left")
	public void user_staff_should_see_a_enabled_delete_button_on_the_top_left() {
		System.out.println("delete button enables on the top left");
		driver.findElement(By.id("deletetoplft")).click();
		Assert.assertTrue(true);
	  
	}





}
