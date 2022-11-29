package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class AssignmentPage {
	public WebDriver driver;

	@FindBy(id="Assignment")
	WebElement Assignment;
	@FindBy(id="username")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="login")
	WebElement login;
	@FindBy(id="title")
	WebElement title;
	@FindBy(id="Total there are 3 assignments")
	WebElement footershowingentries;
	@FindBy(id="Showing 1 to 3 of entries") 
	WebElement totalassignments;
	@FindBy(id="search-field")
	WebElement searchbox;
	@FindBy(xpath="/input[@type='checkbox']")
	WebElement checkboxclick;
	@FindBy(id="assignname")
	WebElement Assignmentname;
	@FindBy(id="assigngrade")
	WebElement Assignmentgrade;
	@FindBy(id="assigndescription")
	WebElement Assignmentdescription;
	@FindBy(id="assignduedate")
	WebElement Assignmentduedate;
	@FindBy(id="btnsave")
	WebElement save;
	@FindBy(id="clkcancelbtn")
	WebElement cancel;
	@FindBy(how = How.CSS, css = "checkbxassignment")
	WebElement checkbxassignment;
	@FindBy(how = How.CSS, css = "sidedelete")
	WebElement sidedelete;
	@FindBy(how = How.CSS, css = "yesconfirmdelete")
	WebElement yesconfirmdelete;
	
	@FindBy(how = How.CSS, css = "footertotalassignments")
	WebElement footertotalassignments; 
	@FindBy(how = How.CSS, css = "noconfirmdelete")
	WebElement noconfirmdelete; 
	@FindBy(how = How.CSS, css = "assignnameheader")
	WebElement assignmentnameheader; 
	@FindBy(how = How.CSS, css = "headerdelete")
	WebElement headerdelete; 
//    @FindBy(xpath="")
//	WebElement newassignment; 
	@FindBy(id="savebtn")
	WebElement savenewassignment; 
//	@FindBy(xpath="")
//	WebElement namenewassignment; 
//	@FindBy(xpath="")
//	WebElement descnewassignment; 
//	@FindBy(xpath="")
	WebElement gradenewassignment; 
	@FindBy(how = How.CSS, css = "duedatenewassignment")
	WebElement duedatenewassignment; 
	@FindBy(how = How.CSS, css = "newassignmentnamemain")
	WebElement newassignmentnamemain; 
	@FindBy(how = How.CSS, css = "cancelnewassignment")
	WebElement cancelnewassignment; 
	@FindBy(xpath="//tr/th[3]")
	WebElement assignmentnameforsortingascen; 
	@FindBy(xpath="//tr/th[1]")
	WebElement assignmentdescforsortingascen; 
	@FindBy(xpath="//tr/th[2]")
	WebElement assignmentdateforsortingascen;
	@FindBy(xpath="//tr/th[3]")
	WebElement assignmentgradeforsortingascen;
	@FindBy(xpath="//tr/th[4]")
	WebElement assignmentnameforsortingades; 
	@FindBy(xpath="//tr/th[1]")
	WebElement assignmentdescforsortingdes; 
	@FindBy(xpath="//tr/th[2]")
	WebElement assignmentdateforsortingdes;
	@FindBy(xpath="//tr/th[3]")
	WebElement assignmentgradeforsortingdes;
	@FindBy(xpath="//tr/th[4]")
	WebElement paginationnextbutton; 
	@FindBy(how = How.CSS, css = "paginationprevbutton")
	WebElement paginationprevbutton; 
	@FindBy(how = How.CSS, css = "paginationlastbutton")
	WebElement paginationlastbutton; 
	@FindBy(how = How.CSS, css = "paginationfirstbutton")
	WebElement paginationfirstbutton; 
	@FindBy(id="Addassignment")
	WebElement addnew;
	@FindBy(id="btnmanage")
	WebElement clkmanage;
	@FindBy(id="editassign")
	WebElement editbtn;
	@FindBy(id="clrgooglebtn")
	WebElement cleargooglebtn;
	@FindBy(id="submitgooglebtn")
	WebElement submitgooglebtn;
	@FindBy(xpath="//tr/td[1]")
	WebElement topcheckbox;
	
	

	
	public AssignmentPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    public void clickassignment() {
		Assignment.click();
}
    
    public void textinsearch() {
		searchbox.sendKeys("Dev Assignment");
	}
//	public void click() {
//		// TODO Auto-generated method stub
//		
//	}
	public void addassignment() {
		addnew.click();
		
	}
	public void clicksave() {
		savenewassignment.click();
	}
	public void clickcancel() {
		cancelnewassignment.click();
	}
	public void clkmanage() {
		clkmanage.click();
		
	}
	public void editassign() {
		editbtn.click();
	}
	public void assignmentname() {
		Assignmentname.click();
	}
    public void editassignall() {
    	Assignment.clear();
    	Assignmentname.sendKeys("sdet2");
    	Assignmentdescription.clear();
    	Assignmentdescription.sendKeys("python");
    	Assignmentgrade.clear();
    	Assignmentgrade.sendKeys("B");
    	Assignmentduedate.clear();
    	Assignmentduedate.sendKeys("11/02/2022");
    	
    }
    public void clearGoogleform() {
    	cleargooglebtn.clear();
    }
    public void Googlsubmiteform() {
        submitgooglebtn.click();
    }
    public void assignmentnamesortascen() {
        assignmentnameforsortingascen.click();
    }
    public void assignmentDescriptionsortascen() {
        assignmentdescforsortingascen.click();
    }
    public void assignmentDateesortascen() {
        assignmentdateforsortingascen.click();
    }
    public void assignmentgradesortascen() {
        assignmentgradeforsortingascen.click();
    }
    public void assignmentnamesortdes() {
    	assignmentnameforsortingades.click();
		
    }
    public void assignmentDescriptionsortdes() {
        assignmentdescforsortingdes.click();
    }
    public void assignmentDateesortdes() {
        assignmentdateforsortingdes.click();
    }
    public void assignmentgradesortdes() {
        assignmentgradeforsortingdes.click();
    }
    public void searchbar() {
    	searchbox.sendKeys("sdet");
    	
    }
    public void nextbtn() {
    	paginationnextbutton.click();
    }
    public void previousbtn() {
    	paginationprevbutton.click();
    }
    public void lastbtn() {
    	paginationlastbutton.click();
    }
    public void firstbtn() {
    	paginationfirstbutton.click();
    }
    public void individualdelete() {
    	sidedelete.click();
    	}
    public void confirmdelYes() {
    	yesconfirmdelete.click();
    }
    public void confirmdelNo() {
    	noconfirmdelete.click();
    }
    public void topCheckbox() {
    	topcheckbox.click();
    	
    }
    public void individualchkbox() {
    checkbxassignment.click();
    	
    }
}


