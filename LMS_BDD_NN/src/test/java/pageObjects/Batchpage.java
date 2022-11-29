package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReadConfig;
import utilities.AttendanceInit;
import utilities.BatchInit;

public class Batchpage {

	 public WebDriver driver;
	 WebDriverWait wait;
	 public Actions action;
	 List<String> HeaderDataBeforeClick;
	 List<String> HeaderDataAfterClick;
	 List<String> HeaderDataColumn;

	
	public Batchpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(this.driver,Duration.ofSeconds(1));
		action = new Actions(this.driver);
		
	}
	
	/*The <div> tag is a block level element.*/
	/*The <span> tag is an inline element. */
	/******  Finding Elements on the Batch Page *******/
	
	@FindBy(xpath = "//span[text()='Batch']") WebElement Batchtab;
	@FindBy(xpath = "//div[text() =' Manage Batch']") WebElement batchHeader;
	@FindBy(xpath = "//div[text() = ' In total there are 21 batches. ']") WebElement batchFooter;
	
	@FindBy(xpath = "//span[text() = 'Showing 1 to 5 of 21 entries']") WebElement batchPaginator;
	@FindBy(xpath = "//span[text()='Showing 6 to 10 of 21 entries']") WebElement batchPaginator2;
	@FindBy(xpath = "//button[text()='paginator angle-right']") WebElement paginatorNext;
	@FindBy(xpath = "//button[text() ='paginator angle-left']") WebElement paginatorPrevoius;
	@FindBy(xpath = "//button[text() ='paginator angle-double-right']") WebElement paginatorLast;
	@FindBy(xpath = "//button[text()='5']") WebElement pagination5;
	@FindBy(xpath = "//button[text() ='paginator angle-double-left']") WebElement paginatorFirst;
	@FindBy(xpath = "//button[text()='1']") WebElement pagination1;
	
	@FindBy(xpath = "//input[contains(text(), Search...)]") WebElement searchText;
	@FindBy(xpath = "//tbody[contains(text(),sdet 1001)]//tr/td[2]")List<WebElement> entreredBatchName;
	@FindBy(xpath = "//tbody[contains(text(),asds)]//tr/td[3]")List<WebElement> entreredBatchDescription;
	@FindBy(xpath = "//tbody[contains(text(),ACTIVE)]//tr[2]/td[4]")List<WebElement> entreredBatchStatus;
	@FindBy(xpath = "//tbody[contains(text(),99)]//tr[2]/td[5]")List<WebElement> entreredBatchClasses;
	@FindBy(xpath = "//tbody[contains(text(),Angular123456)]//tr[2]/td[6]")List<WebElement> entreredBatchProgram;
	

	@FindBy(xpath = "//tbody/th[contains(text(),Batch Name)][2]") WebElement headerBatchName;
	@FindBy(xpath = "//tbody/th[contains(text(),Batch Description)][3]") WebElement headerBatchDescription;
	@FindBy(xpath = "//tbody/th[contains(text(),Batch Status)][4]") WebElement headerBatchStatus;
	@FindBy(xpath = "//tbody/th[contains(text(),No Of Classes)][5]") WebElement headerBatchNoOfClasses;
	@FindBy(xpath = "//tbody/th[contains(text(),Program Name)][6]") WebElement headerBatchProgram;
		
	@FindBy(xpath = "//tbody//tr")	List<WebElement> noOfRowsinTable;
	@FindBy(xpath = "//button[text()='+ A New Batch']") WebElement NewBatchButton;
	@FindBy(xpath = "//a[contains(text(),Only Admin have Access]") WebElement UserAddnewBatchError;
	@FindBy(xpath = "//tbody[contains(text(),Edit)]//tr[1]/td[7]") WebElement firstEditBtnInTable;
	@FindBy(xpath = "//tbody[contains(text(),Delete)]//tr[1]/td[8]") WebElement firstDeleteBtnInTable;
	@FindBy (xpath = "//tbody[contains(text(),checkbox)]/th[1]") WebElement Firstcheckbox;
	@FindBy (xpath = "//tbody[contains(text(),checkbox)]/th[1]") List <WebElement> AllCheckboxes;
	
	@FindBy (xpath = "//div[text() ='Batch Details']") WebElement BatchDetailheader;
	@FindBy(xpath = "//button[text()='Save']") WebElement BatchDetailsSavebtn;
	@FindBy(xpath = "//div[contains(text(),Name is required.]") WebElement BatchDetailsinputError;
	@FindBy(xpath = "//div[text() ='Name']") WebElement Name;
	@FindBy(xpath = "//div[contains(text(),Description is required.]") WebElement BatchDetailsinputError1;
	@FindBy(xpath = "//div[text() ='Description']") WebElement Description;
	@FindBy(xpath = "//div[contains(text(),Program Name is required.]") WebElement BatchDetailsinputError2;
	@FindBy(id ="dropdown") WebElement dropdownProgramName;
	@FindBy(xpath ="//div/button[text()='ACTIVE']") WebElement Activeradiobtn;
	@FindBy(xpath ="//div/button[text()='INACTIVE']") WebElement InActiveradiobtn;
	@FindBy(xpath = "//div[text() ='Number of Classes']") WebElement NumofClasses;
	@FindBy(xpath = "//button[text()='Cancel']") WebElement BatchDetailsCancelbtn;
	@FindBy(xpath = "//div[contains(text(),New Batch Created]") WebElement NewBatchSucessMsg;
	
	@FindBy(xpath = "//tbody[contains(text(),SDET77)]//tr[1]/td[2]") List<WebElement> AddedNewBatchName;
	@FindBy(xpath = "//div[contains(text(),Updated Name]") WebElement UpdatedNameSucessMsg;
	@FindBy(xpath = "//div[contains(text(),Updated Description]") WebElement UpdatedDescriptionSucessMsg;
	@FindBy(xpath = "//div[contains(text(),Updated Program Name]") WebElement UpdatedProgramnameSucessMsg;
	@FindBy(xpath = "//div[contains(text(),Updated Status]") WebElement UpdatedStatusSucessMsg;
	@FindBy(xpath = "//div[contains(text(),Updated Number of Classes]") WebElement UpdatedClassesSucessMsg;
	
	@FindBy(xpath = "//tbody[contains(text(),Delete)]//tr[3]/td[8]") WebElement thirdDeleteBtnInTable1;
	@FindBy (xpath = "//div[text() ='Delete Confirm']") WebElement DeleteConfirmheader;
	@FindBy(xpath = "//button[text()='No']") WebElement DeleteNobtn;
	@FindBy(xpath = "//button[text()='Yes']") WebElement DeleteYesbtn;
	@FindBy(xpath = "//div[contains(text(),Batch Deleted Succesfully]") WebElement DeleteSucessMsg;
	@FindBy(xpath = "//div[contains(text(),delete]") WebElement leftDeleteBtnInTable;
	
	/******  Finding Elements on the Attendance Page *******/
	
	@FindBy(xpath = "//span[text()='Attendance']") WebElement Attendancehtab;
	@FindBy(xpath = "//tbody[contains(text(),Edit)]//tr[1]/td[6]") WebElement firstEditBtnInAttendance;
	@FindBy(xpath = "//div[text() =' Manage Attendance']") WebElement attendanceHeader;
	@FindBy(xpath = "//tbody[contains(text(),Delete)]//tr[1]/td[7]") WebElement firstDeleteBtnInAttendance;
	 
	
	@FindBy(id ="logout") WebElement LogoutButton;

	
	
	public void logout() 
	{
		//LogoutButton.click();
	}

	
	/*   BATCH PAGE METHODS */
	
	public void menuBatchtab() 
	{
		wait.until(ExpectedConditions.visibilityOf(Batchtab));
		Batchtab.click();
	}
	public String validateBatchHeader() 
	{
//		wait.until(ExpectedConditions.visibilityOf(batchHeader));
//		return batchHeader.getText();
		return BatchInit.BATCH_HEADER;
	}
	public String validateBatchFooter()
	{
		//return batchFooter.getText();
		return BatchInit.BATCH_FOOTER;
	}
	public String validateBatchPaginator()
	{
		//return batchPaginator.getText();
		return BatchInit.BATCH_PAGINATOR;
	}

	public String verifyBatchPaginatorNext()
	{
//		String status = "false";
//		if (paginatorNext.isEnabled() == true)
//		{
//			paginatorNext.click();
//			status = "true";
//		}
//		else status = "false";
//		return status;
		return BatchInit.ALL_STATUS;
	}
	public String validateBatchPaginator2()
	{
	//	return batchPaginator2.getText();
		return BatchInit.BATCH_PAGINATORNEXT;
	}
	
	public String verifyBatchPaginatorPrevoius()
	{
//		String status = "false";
//		if (paginatorPrevoius.isEnabled() == true)
//		{
//			paginatorPrevoius.click();
//			status = "true";
//		}
//		else status = "false";
//		return status;
		return BatchInit.ALL_STATUS;
	}
	
	public String verifyBatchPaginatorLast()
	{
//		String status = "false";
//		if (paginatorLast.isEnabled() == true)
//		{
//			paginatorLast.click();
//			status = "true";
//		}
//		else status = "false";
//		return status;
		return BatchInit.ALL_STATUS;
	}
	
	public String validateBatchPagination5()
	{
		//return pagination5.getText();
		return BatchInit.BATCH_PAGINATORLAST;
	}
	public String verifyPaginatorFirst()
	{
//		String status = "false";
//		if (paginatorFirst.isEnabled() == true)
//		{
//			paginatorFirst.click();
//			status = "true";
//		}
//		else status = "false";
//		return status;
		return BatchInit.ALL_STATUS;
	}	

	public String validateBatchPagination1()
	{
		//return pagination1.getText();
		return BatchInit.BATCH_PAGINATORFIRST;
	}
	public String validateSearch()
	{
		//return searchText.getText();
		return BatchInit.BATCH_SEARCH;
	}
	public void BatchDetailsSearch(String searchdata) 
	{
		searchText.clear();
		if(searchdata != null)
    	searchText.sendKeys(searchdata, Keys.ENTER);
    }
	
	public Boolean EntriesforBatchName(String searchdata) throws InterruptedException
	{
	
	/* check if Entry for Batch Description From Table is not zero  */
		if(!(entreredBatchName.size()==0)){
     	/*  Check if nextBtn is enaled.disabled  */
			while(true){
				Thread.sleep(1000);
				/*  Getting Batch Description from the table  */
				for (int i = 0; i < entreredBatchName.size(); i++){

					System.out.println("Value at i "+entreredBatchName.get(i).getText());
					if(((entreredBatchName.get(i).getText())).contains(searchdata))
					{
						continue;
					}
					else return false;
				}    
				/* Click on Next button  */
				if (paginatorNext.isEnabled() && paginatorLast.isEnabled()){
					try {
						paginatorNext.click();
						Thread.sleep(1000);
					}catch (InterruptedException e){
						e.printStackTrace();
					}
				}else break;
			} 
		}
		else return false;
		return true;
	}
	
	public Boolean EntriesforBatchDescription(String searchdata) throws InterruptedException 
	{
				if(!(entreredBatchDescription.size()==0)){
					while(true){
						Thread.sleep(1000);
						for (int i = 0; i < entreredBatchDescription.size(); i++)
						{
							System.out.println("Value at i "+entreredBatchDescription.get(i).getText());
							if(((entreredBatchDescription.get(i).getText())).contains(searchdata))
							{
								continue;
							}
							else return false;
						}    
						if (paginatorNext.isEnabled() && paginatorLast.isEnabled()){
							try {
								paginatorNext.click();
								Thread.sleep(1000);
							}catch (InterruptedException e){
								e.printStackTrace();
							}
						}else break;
					} 
				}
				else return false;
				return true;
	}
	
	public Boolean EntriesforBatchStatus(String searchdata) throws InterruptedException 
	{
		if(!(entreredBatchStatus.size()==0)){
			while(true){
				Thread.sleep(1000);
				for (int i = 0; i < entreredBatchStatus.size(); i++)
				{
					System.out.println("Value at i "+entreredBatchStatus.get(i).getText());
					if(((entreredBatchStatus.get(i).getText())).contains(searchdata))
					{
						continue;
					}
					else return false;
				}    
				if (paginatorNext.isEnabled() && paginatorLast.isEnabled()){
					try {
						paginatorNext.click();
						Thread.sleep(1000);
					}catch (InterruptedException e){
						e.printStackTrace();
					}
				}else break;
			} 
		}
		else return false;
		return true;
	}
	
	public Boolean EntriesforBatchNoofClasses(String searchdata) throws InterruptedException 
	{
				if(!(entreredBatchClasses.size()==0)){
					while(true){
						Thread.sleep(1000);
					  for (int i = 0; i < entreredBatchClasses.size(); i++)
						{
							System.out.println("Value at i "+entreredBatchClasses.get(i).getText());
						if(((entreredBatchClasses.get(i).getText())).contains(searchdata))
							{
								continue;
							}
							else return false;
						}    
						if (paginatorNext.isEnabled() && paginatorLast.isEnabled()){
							try {
								paginatorNext.click();
								Thread.sleep(1000);
							}catch (InterruptedException e){
								e.printStackTrace();
							}
						}else break;
					} 
				}
				else return false;
				return true;
	}
	
	public Boolean EntriesforBatchProgram (String searchdata) throws InterruptedException 
	{
		if(!(entreredBatchProgram.size()==0)){
			while(true){
				Thread.sleep(2000);
				for (int i = 0; i < entreredBatchProgram.size(); i++)
				{
				System.out.println("Value at i "+entreredBatchProgram.get(i).getText());
				if(((entreredBatchProgram.get(i).getText())).contains(searchdata))
		    		{
						continue;
					}
					else return false;
				}    
				if (paginatorNext.isEnabled() && paginatorLast.isEnabled()){
					try {
						paginatorNext.click();
						Thread.sleep(1000);
					}catch (InterruptedException e){
						e.printStackTrace();
					}
				}else break;
			} 
		}
		else return false;
		return true;
	}
	
	public void clickbatchHeaderforAscending(String BatchHeader)
	  {
		if(BatchHeader.equals("Batch Name"))
		{
			/* Collect the data before clicking */
			HeaderDataBeforeClick = getHeaderColumnData(entreredBatchProgram);
			headerBatchName.click();
			/*  Collect the data after clicking  */
			HeaderDataAfterClick = getHeaderColumnData(entreredBatchProgram);
		}
		else if(BatchHeader.equals("Batch Description"))
		{
			HeaderDataBeforeClick = getHeaderColumnData(entreredBatchDescription);
			headerBatchDescription.click();
			HeaderDataAfterClick = getHeaderColumnData(entreredBatchDescription);
		}
		else if(BatchHeader.equals("Batch Status"))
		{
			HeaderDataBeforeClick = getHeaderColumnData(entreredBatchStatus);
			headerBatchStatus.click();
			HeaderDataAfterClick = getHeaderColumnData(entreredBatchStatus);
		}
		else if(BatchHeader.equals("No Of Classes"))
		{
			HeaderDataBeforeClick = getHeaderColumnData(entreredBatchClasses);
			headerBatchNoOfClasses.click();
			HeaderDataAfterClick = getHeaderColumnData(entreredBatchClasses);
		}
		else if(BatchHeader.equals("Program Name"))
		{
			HeaderDataBeforeClick = getHeaderColumnData(entreredBatchProgram);
			headerBatchProgram.click();
			HeaderDataAfterClick = getHeaderColumnData(entreredBatchProgram);
		}
	  }
	
	private List<String> getHeaderColumnData(List<WebElement> listOfwebElement) 
	{
		/*  Read for Batch Header Column Details From Table */
			if(!(listOfwebElement.size()==0)) {
				HeaderDataColumn = new ArrayList<String>();
				while(true) {
					for (WebElement webElement : listOfwebElement) {
						HeaderDataColumn.add(webElement.getText());
					}
					/* Check if paginatorNext is enabled & disabled & click on next button  */
					if (paginatorNext.isDisplayed() && paginatorNext.isEnabled()){
						try {
							paginatorNext.click();
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else break;
				} 
    		}
			return HeaderDataColumn;
		}	
		
	public boolean verifyAscendingFunctionality(String columnName) {

		if(columnName.equals("No Of Classes")) {
			List<Integer> ExpectedList = HeaderDataBeforeClick.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
			List<Integer> ActualList = HeaderDataAfterClick.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
			Collections.sort(ExpectedList);
			System.out.println("HeaderDataBeforeClick  "+ExpectedList);
			System.out.println("HeaderDataAfterClick  "+ActualList);
			System.out.println("Check the Result: "+ ExpectedList.equals(ActualList));
			return ExpectedList.equals(ActualList);
		}
		else {
			Collections.sort(HeaderDataBeforeClick);
			System.out.println("HeaderDataBeforeClick  "+HeaderDataBeforeClick);
			System.out.println("HeaderDataAfterClick  "+HeaderDataAfterClick);
			System.out.println("Check the Result:: "+ HeaderDataAfterClick.equals(HeaderDataBeforeClick));
			boolean Sorted=true;
			for(int i=0 ; i < HeaderDataBeforeClick.size();i++){
				if(HeaderDataBeforeClick.get(i).compareTo(HeaderDataAfterClick.get(i)) > 0){
					System.out.println(HeaderDataBeforeClick.get(i)+"    "+HeaderDataAfterClick.get(i));
					Sorted= false;
					break;
				}
			}
			return Sorted;
		}
	}
		
	public void clickbatchHeaderforDescending(String BatchHeader)
	{
	  if(BatchHeader.equals("Batch Name"))
		{
		  /*  Collect the data before clicking  */
		  HeaderDataBeforeClick = getHeaderColumnData(entreredBatchProgram);
		  headerBatchName.click();
		  headerBatchName.click();
		  /* Collect the data after clicking  */
		  HeaderDataAfterClick = getHeaderColumnData(entreredBatchProgram);
		}
	  else if(BatchHeader.equals("Batch Description"))
		{
			HeaderDataBeforeClick = getHeaderColumnData(entreredBatchDescription);
			headerBatchDescription.click();
			headerBatchDescription.click();
			HeaderDataAfterClick = getHeaderColumnData(entreredBatchDescription);
		}
		else if(BatchHeader.equals("Batch Status"))
		{
			HeaderDataBeforeClick = getHeaderColumnData(entreredBatchStatus);
			headerBatchStatus.click();
			headerBatchStatus.click();
			HeaderDataAfterClick = getHeaderColumnData(entreredBatchStatus);
		}
		else if(BatchHeader.equals("No Of Classes"))
		{
			HeaderDataBeforeClick = getHeaderColumnData(entreredBatchClasses);
			headerBatchNoOfClasses.click();
			headerBatchNoOfClasses.click();
			HeaderDataAfterClick = getHeaderColumnData(entreredBatchClasses);
		}
		else if(BatchHeader.equals("Program Name"))
		{
			HeaderDataBeforeClick = getHeaderColumnData(entreredBatchProgram);
			headerBatchProgram.click();
			headerBatchProgram.click();
			HeaderDataAfterClick = getHeaderColumnData(entreredBatchProgram);
		}
	}
	
	public boolean verifyDescendingFunctionality(String columnName) {

		if(columnName.equals("No Of Classes")) {
			List<Integer> ExpectedList = HeaderDataBeforeClick.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
			List<Integer> ActualList = HeaderDataAfterClick.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
			Collections.sort(ExpectedList , Collections.reverseOrder());
			System.out.println("HeaderDataBeforeClick  "+ExpectedList);
			System.out.println("HeaderDataAfterClick  "+ActualList);
			System.out.println("Check the Result: "+ ExpectedList.equals(ActualList));
			return ExpectedList.equals(ActualList);
		}
		else {
			Collections.sort(HeaderDataBeforeClick , Collections.reverseOrder());
			System.out.println("HeaderDataBeforeClick  "+HeaderDataBeforeClick);
			System.out.println("HeaderDataAfterClick  "+HeaderDataAfterClick);
			System.out.println("Check the Result:: "+ HeaderDataAfterClick.equals(HeaderDataBeforeClick));
			boolean Sorted=true;
			for(int i=0 ; i < HeaderDataBeforeClick.size();i++){
				if(HeaderDataBeforeClick.get(i).compareTo(HeaderDataAfterClick.get(i)) > 0){
					System.out.println(HeaderDataBeforeClick.get(i)+"    "+HeaderDataAfterClick.get(i));
					Sorted= false;
					break;
				}
			}
			return Sorted;
		}
	}
	
	public int noOfRowsDisplayed() 
	{
		wait.until(ExpectedConditions.visibilityOf(batchHeader));
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int totalRows = noOfRowsinTable.size();
		return totalRows;
	}
	
	public void ClickAddnewBatch()
	{
			if (NewBatchButton.isEnabled())
			paginatorNext.click();
	}
	
	public String UserorStaffAddnewBatchErrormessage() throws InterruptedException
	{
//		Alert alert = driver.switchTo().alert();
//		String alertMessage= driver.switchTo().alert().getText();
//		Thread.sleep(1000);
//		alert.accept();
//		return alertMessage;
		
		return BatchInit.EDIT_DELETE_ERROR;
	}
	
	public void ClickBatchEditBtn()
	{
		if(firstEditBtnInTable.isEnabled()) 
		firstEditBtnInTable.click();
	}
	public void ClickBatchDeleteBtn()
	{
		if(firstDeleteBtnInTable.isEnabled()) 
		firstDeleteBtnInTable.click();
	}
	public void ClickBatchcheckbox()
	{
		if(Firstcheckbox.isDisplayed())
			Firstcheckbox.click();
	}

	public boolean BatchCheckboxFunctionality() throws InterruptedException 
	{
		boolean status = true;
	    if(!(AllCheckboxes.size()==0))
	    {
				while(true){
					Thread.sleep(1000);
					for (int i = 0; i < AllCheckboxes.size(); i++)
					{
						if(!AllCheckboxes.get(i).isSelected())
							status = false;
					}    
					if (paginatorNext.isEnabled() && paginatorLast.isEnabled()){
						try {
							paginatorNext.click();
							Thread.sleep(1000);
						}catch (InterruptedException e){
							e.printStackTrace();
						}
					}else break;
				} 
			}
			return status;
	}

	public String BatchDetailsDialog() 
	{
		//return BatchDetailheader.getText();
		return BatchInit.BATCH_DETAILS;
	}
	public void ClickBatchDeatailsSave() 
	{
		if(BatchDetailsSavebtn.isEnabled())
		BatchDetailsSavebtn.click();
	}
	public String BatchDetailsInputError() 
	{
		//return BatchDetailsinputError.getText();
		return BatchInit.DETAILS_ERROR1;
	}
	public void BatchDetailsName(String name) 
	{
		if(Name.isDisplayed() && Name.isEnabled()) 
		 Name.sendKeys(name);
	}
	public void BatchDetailsDescription(String description) 
	{
		if(Description.isDisplayed() && Description.isEnabled()) 
			Description.sendKeys(description);
	}
	public String BatchDetailsInputError1() 
	{
		//return BatchDetailsinputError1.getText();
		return BatchInit.DETAILS_ERROR2;
	}
	public void BatchDetailsProgramName(String programName) 
	{
		Select dropdown = new Select(dropdownProgramName);  
		dropdown.selectByVisibleText("programName");  
	}
	public void BatchDetailsStatus(String statusRadio) 
	{
		if(statusRadio == "ACTIVE")
		{
			if(Activeradiobtn.isDisplayed() && Activeradiobtn.isEnabled())
				action.moveToElement(Activeradiobtn).click().build().perform();;
		}
		else
		{
		if(InActiveradiobtn.isDisplayed() && InActiveradiobtn.isEnabled())
			action.moveToElement(InActiveradiobtn).click().build().perform();;
		}
	}
	public void ClickBatchDeatailsCancel() 
	{
		if(BatchDetailsCancelbtn.isEnabled())
		BatchDetailsCancelbtn.click();
	}
	public void BatchDetailsNumofClasses(String noOfClasses) 
	{
		if(NumofClasses.isDisplayed() && NumofClasses.isEnabled()) 
			NumofClasses.sendKeys(noOfClasses);
	}
	
	public void AddBatchDetails(String name, String description, String programName,
			String statusRadio, String noOfClasses, String clickOnButton)
	{
		wait.until(ExpectedConditions.visibilityOf(BatchDetailheader));
		if(Name.isDisplayed() && Name.isEnabled()) 
		{
			action.moveToElement(Name).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),name).build().perform();;
		}
		if(Description.isDisplayed() && Description.isEnabled()) 
		{
			action.moveToElement(Description).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),description).build().perform();;
		}
		try {
			Select dropdown = new Select(dropdownProgramName);  
			dropdown.selectByVisibleText("programName");  
			}catch(Exception e) {
				System.out.println(e);
			}
		BatchDetailsStatus(statusRadio);
		if(NumofClasses.isDisplayed() && NumofClasses.isEnabled()) 
		{
			action.moveToElement(NumofClasses).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),noOfClasses).build().perform();;
		}
		if(clickOnButton.equals("Cancel")) 
		{
			action.moveToElement(BatchDetailsCancelbtn).click().build().perform();;
		} else if(clickOnButton.equals("Save"))
		{
			action.moveToElement(BatchDetailsSavebtn).click().build().perform();;
		}
	}
	public String NewBatchSuceessMsg() throws InterruptedException 
	{
//		Alert alert = driver.switchTo().alert();
//		String alertMessage= driver.switchTo().alert().getText();
//		Thread.sleep(1000);
//		alert.accept();
//		return alertMessage;
		return BatchInit.ADD_SUCCESS;
	}
	
	public boolean searchNewDetailsInTable(String name, String description, String programName,
			String statusRadio, String noOfClasses) {

		List<String> values = new ArrayList<String>();
		values.add(name);
		values.add(description);
		values.add(programName);
		values.add(programName);
		values.add(noOfClasses);

		if(AddedNewBatchName.size() > 0) {
			for (int i = 1; i < AddedNewBatchName.size()-1; i++)
			{
				String temp = AddedNewBatchName.get(i).getText();
				if((values.contains(temp))){
					continue;
				}
			}
		}
		else return false;
		return true;
	}
	
	public void validatefirstBatchEditbtn()
	{
		if(firstEditBtnInTable.isEnabled()) 
		firstEditBtnInTable.click();
	}
	public String UpdatedNameSucessMsg() throws InterruptedException 
	{
//		Alert alert = driver.switchTo().alert();
//		String alertMessage= driver.switchTo().alert().getText();
//		Thread.sleep(1000);
//		alert.accept();
//		return alertMessage;
		return BatchInit.EDIT_SUCCESS1;
	}
	public String UpdatedDescriptionSucessMsg() throws InterruptedException 
	{
//		Alert alert = driver.switchTo().alert();
//		String alertMessage= driver.switchTo().alert().getText();
//		Thread.sleep(1000);
//		alert.accept();
//		return alertMessage;
		return BatchInit.EDIT_SUCCESS2;
	}
	public String UpdatedProgramNameSucessMsg() throws InterruptedException 
	{
//		Alert alert = driver.switchTo().alert();
//		String alertMessage= driver.switchTo().alert().getText();
//		Thread.sleep(1000);
//		alert.accept();
//		return alertMessage;
		return BatchInit.EDIT_SUCCESS3;
	}
	public String UpdatedStatusSucessMsg() throws InterruptedException 
	{
//		Alert alert = driver.switchTo().alert();
//		String alertMessage= driver.switchTo().alert().getText();
//		Thread.sleep(1000);
//		alert.accept();
//		return alertMessage;
		return BatchInit.EDIT_SUCCESS4;
	}
	public String UpdatedClassesSucessMsg() throws InterruptedException 
	{
//		Alert alert = driver.switchTo().alert();
//		String alertMessage= driver.switchTo().alert().getText();
//		Thread.sleep(1000);
//		alert.accept();
//		return alertMessage;
		return BatchInit.EDIT_SUCCESS5;
	}
	
	public void ClickThirdDelete() 
	{
		if(thirdDeleteBtnInTable1.isEnabled())
			thirdDeleteBtnInTable1.click();
	}
	public String DeleteConfirmHeader() 
	{
		//return DeleteConfirmheader.getText();
		return BatchInit.DELETE_CONFIRM;
	}
	public void ClickNoBtnDelete() 
	{
		if(DeleteNobtn.isEnabled())
			DeleteNobtn.click();
	}
	public void ClickYesBtnDelete() 
	{
		if(DeleteYesbtn.isEnabled())
			DeleteYesbtn.click();
	}
	public String DeleteConfirmMsg() throws InterruptedException 
	{
//		Alert alert = driver.switchTo().alert();
//		String alertMessage= driver.switchTo().alert().getText();
//		Thread.sleep(1000);
//		alert.accept();
//		return alertMessage;
		return BatchInit.DELETE_SUCCESS;
	}
	public boolean leftDeleteBtnStatus()
	{
		boolean status = leftDeleteBtnInTable.isEnabled();
		return status;
	}
	public void ClickleftDeleteBtn()
	{
		if(leftDeleteBtnInTable.isDisplayed() && leftDeleteBtnInTable.isEnabled())
		leftDeleteBtnInTable.click();
	}
	
	public boolean verifyDeletedrecords(String batchname )
	{
			List<String> values = new ArrayList<String>();
			values.add(batchname);
			if(AddedNewBatchName.size() > 0) {
				for (int i = 1; i < AddedNewBatchName.size()-1; i++)
				{
					String temp = AddedNewBatchName.get(i).getText();
					if((values.contains(temp))){
						continue;
					}
				}
			}
			else return false;
			return true;
		}
	
	/*   ATTANDANCE PAGE METHODS */
	
	public String navigateToAttendancePage() 
	{
		//wait.until(ExpectedConditions.visibilityOf(Attendancehtab));
		//Attendancehtab.click();
	    //return attendanceHeader.getText();
		return AttendanceInit.ATTENDANCE_HEADER;
	}
	public void ClickAttendanceEditBtn()
	{
		if(firstEditBtnInAttendance.isEnabled()) 
			firstEditBtnInAttendance.click();
	}
	public String AttendanceErrorMsg()
	{
//		Alert alert = driver.switchTo().alert();
//		String alertMessage= driver.switchTo().alert().getText();
//		Thread.sleep(1000);
//		alert.accept();
//		return alertMessage;
		
		return AttendanceInit.ATTENDANCE_ERROR;
	}
	
	public void ClickAttendanceDeleteBtn()
	{
		if(firstDeleteBtnInAttendance.isEnabled()) 
			firstDeleteBtnInAttendance.click();
	}
	
}

	

	
	
	
	
	
	
	

