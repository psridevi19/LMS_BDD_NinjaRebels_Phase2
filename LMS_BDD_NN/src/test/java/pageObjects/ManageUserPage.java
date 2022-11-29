package pageObjects;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert.ThrowingRunnable;


public class ManageUserPage {
	

	
	
	  public WebDriver driver;
	  public ManageUserPage(WebDriver driver)
	    {
	      this.driver = driver;
	      PageFactory.initElements(driver,this);
	    }
	  /*The <div> tag is a block level element.*/
	    /*The <span> tag is an inline element. */
	  
	  @FindBy(xpath = "//span[text()='User']") WebElement Usertab;
	    @FindBy(xpath = "//div[text() =' Manage User']") WebElement UserHeader;
	    @FindBy(xpath = "//div[text() = ' In total there are 4 users. ']") WebElement UserFooter;
	    
	    @FindBy(xpath = "//span[text() = 'Showing 1 to 4 of 4 entries']") WebElement userPaginator;
	    @FindBy(xpath = "//button[text()='paginator angle-right']") WebElement paginatorNext;
	    @FindBy(xpath = "//button[text() ='paginator angle-left']") WebElement paginatorPrevoius;
	    @FindBy(xpath = "//button[text() ='paginator angle-double-right']") WebElement paginatorLast;
	    @FindBy(xpath = "//button[text() ='paginator angle-double-left']") WebElement paginatorFirst;
	    @FindBy(xpath = "//button[text() ='Pagination control should be disabled']") WebElement paginatorcontrol;
	    @FindBy(xpath = "//button[text() ='Manage user table has more than 5 rows']") WebElement mufiverows;
	    @FindBy(xpath = "//tbody[contains(text(),txt)]//tr/td[2]")List<WebElement> batchdetailsdisplay;
	    @FindBy(xpath = "//button[text() = 'Showing 1 to 4 of 4 entries ']")WebElement userPaginator1;
	    @FindBy(xpath = "//input[contains(text(), Search...)]") WebElement searchtext;
	    @FindBy(xpath = "//input[contains(text(), validateSearch)]") WebElement validateSearch1;
	    @FindBy(xpath = "//AddNew User button functionality']")WebElement addnew;
	    @FindBy(xpath = "//tkc[contains(text(),sdet38)]//tr/td[2]")List<WebElement> batchname1;
	    @FindBy(xpath = "//tng[contains(text(),sdet38)]//tr/td[2]")List<WebElement> batchname;
	  @FindBy(xpath = "//button[text()='+ New user aded']") WebElement newuserbtn;
	  @FindBy (xpath = "//div[text() ='user Details']") WebElement userdialoguebox; 
	  @FindBy (xpath = "//div[text() ='Table Header']") WebElement THeader;  
	  @FindBy (xpath = "//div[text() ='sorted rows']") WebElement ascOrder;
	  @FindBy (xpath = "//abc[contains(text(),table header checkbox)]/") boolean THCheckbox;
	  @FindBy(xpath = "//gbody[contains(text(),Deleteicon)]//tr[9]/") WebElement Deleteicon;
	  @FindBy (xpath = "//div[text() ='Deleteiconbutton']") WebElement Deleteicon1;
	  @FindBy(xpath = "//close buttonicon']")WebElement CloseIcon;
	  @FindBy(xpath = "//ID checkbox button']")WebElement IDbtn;
	  @FindBy (xpath = "//div[text() ='user dialogue box Details']") WebElement UDBox; 
	  @FindBy(xpath = "//cancelbutton']")WebElement Canbtn;
	  @FindBy (xpath = "//div[text() ='user Details window closed']") WebElement winclo;
	  @FindBy(xpath = "//cancel(X)icon']")WebElement CanIcon;
	  @FindBy (xpath = "//div[text() ='user Details window closed with icon']") WebElement winIcon;
	  @FindBy(xpath = "//submit button']")WebElement subBtn;
	  @FindBy(xpath = "//PlaceholdertextFirstname']")WebElement Fn;
	  @FindBy(xpath = "//Placeholdertextmiddlename']")WebElement Mn;
	  @FindBy(xpath = "//Placeholdertextlastname']")WebElement Ln;
	  @FindBy(xpath = "//Placeholdertextemailaddress']")WebElement ED;
	  @FindBy(xpath = "//Placeholdertextphonenumber']")WebElement PN;
	  @FindBy(xpath = "//Placeholdertextaddress']")WebElement Addr;
	  @FindBy(xpath = "//Placeholdertextcity']")WebElement CT;
	  @FindBy(xpath = "//Placeholdertextstate']")WebElement state;
	  @FindBy(xpath = "//Placeholdertextpostalcode']")WebElement PC;
	  @FindBy(xpath = "//Placeholdertextprogram']")WebElement prog;
	  @FindBy(xpath = "//PlaceholdertextUGprogram']")WebElement UGp;
	  @FindBy(xpath = "//PlaceholdertextPGprogram']")WebElement PGp;
	  @FindBy(xpath = "//Placeholdertextskill']")WebElement skill;
	  @FindBy(xpath = "//PlaceholdertextEXperience']")WebElement EXp;
	  @FindBy(xpath = "//PlaceholdertextUserrole']")WebElement Urole;
	  @FindBy(xpath = "//Placeholdertextvisastatus']")WebElement VS;
	  @FindBy(xpath = "//Placeholdertextbatch']")WebElement Batch;
	  @FindBy(xpath = "//Placeholdertextcomments']")WebElement Comnt;  
	  @FindBy(xpath = "//drop down menu from userdialogue box']")WebElement dropD;
	  @FindBy(xpath = "//drop down menu from userdialogue box for user role']")WebElement userrole;
	  @FindBy(xpath = "//submit button with all details empty']")WebElement subEmpty;
	  @FindBy(xpath = "//user error message ']")WebElement errorMsg;
	  @FindBy(xpath = "//name field error ']")WebElement errorName;
	  @FindBy(xpath = "//invalid email id error ']")WebElement errorEmail;
	  
	  
	  
	  
	  public String UserHeader()
	  {
	    return UserHeader.getText();  
	  }
	  public void menuusertab() 
	  {
	    
	    Usertab.click();
	    }
	    
	    public String UserFooter() {
	    
	      return UserFooter.getText();
	    }
	    
	      
	    public boolean userPaginatorlinks() {
	      if (!paginatorNext.isEnabled() && paginatorLast.isEnabled())
	        {
	          return true;
	        }
	        else return false;  
	    }
	    public boolean Paginationcontrol() {
	      if (!paginatorcontrol.isEnabled() && paginatorcontrol.isEnabled())
	       {
	            return true;
	          }
	          else return false;  
	      }
	    public boolean mufiverows() {
	      
	      return false;
	    }
	  
	    public String userPaginator11() {
	      
	      return userPaginator1.getText();
	    }
	  
	    public String validateSearch1() {
	      
	      return validateSearch1.getText();
	    }
	    public void getcolumndata() 
	    {
	      
	    }
	    public void batchname111(String searchdata) 
	    {
	      searchtext.clear();
	        searchtext.sendKeys(searchdata, Keys.ENTER);
	      }
	    
	      
	    public boolean batchdetailsdisplay1(String searchdata) {
	      
	      return false;}
	    
	    public void batchname1(String searchdata) {
	    
	    }  
	    public String addnew()
	    {
	      return addnew.getText();  
	    }
	  
	  
	      public void newuserbtn() {
	        
	        if (newuserbtn.isEnabled())
	          newuserbtn.click();  
	        
	    }
	      public String userdialoguebox() {
	      return  userdialoguebox.getText();
	        
	        
	      }
	      public String THeader()
	      {
	        return THeader.getText();  
	      }
	      
	      
	      public boolean ascOrder (String columnName) {
	        ascOrder.click();
	        return true;
	        
	}
	      public boolean ascOrder1(String columnName) {
	        
	        return false;
	      }
	      public boolean THCheckbox()
	      {
	        
	          return THCheckbox ;
	      
	        
	      }

	      public boolean Deleteicon()
	      {
	        if(Deleteicon.isEnabled()) 
	        Deleteicon.click();
	        return THCheckbox;
	      }
	      
	  public boolean Deleteicon1() {
	        
	        if (Deleteicon.isSelected())
	          Deleteicon.click();
	        return false;  
	        
	    }
	  public void CloseIcon() {
		  
		  if (CloseIcon.isEnabled())
		    CloseIcon.click();
		  }
		public void IDbtn() {
		  
		  if (IDbtn.isEnabled())
		    IDbtn.click();  
		  
		}
		public String UDBox() {
		return  UDBox.getText();
		  
		  
		}
		public void Canbtn() {
		  
		  if (Canbtn.isEnabled())
		    Canbtn.click();  

		}
		public String winclo() {
		return  winclo.getText();
		  
		}
		public boolean CanIcon() {
		  
		  if (CanIcon.isEnabled())
		    CanIcon.click();
		  return CanIcon != null;  

		}
		public boolean winIcon() {
		return  winIcon.getText() != null;
		  
		}
		public void subBtn() {
		  
		  if (subBtn.isEnabled())
		    subBtn.click();  
		}
		public void Fn() {
		  
		  if (Fn.isEnabled())
		    Fn.click();

		}
		public void Mn() {
		  
		  if (Mn.isEnabled())
		    Mn.click();  
		  
		}  
		public void Ln() {
		  
		  if (Ln.isEnabled())
		    Ln.click();
		return;  
		}
		public void ED() {
		  
		  if (ED.isEnabled())
		    ED.click();
		}
		public void PN() {
		  
		  if (PN.isEnabled())
		    PN.click();
		}
		public void Addr() {
		  
		  if (Addr.isEnabled())
		    Addr.click();
		}
		public void CT() {
		  
		  if (CT.isEnabled())
		    CT.click();
		}
		public void state() {
		  
		  if (state.isEnabled())
		    state.click();
		}
		public void PC() {
		  
		  if (PC.isEnabled())
		    PC.click();
		}
		public void prog() {
		  
		  if (prog.isEnabled())
		    prog.click();
		    
		}
		public void UGp() {
		  
		  if (UGp.isEnabled())
		    UGp.click();
		}
		public void PGp() {
		  
		  if (PGp.isEnabled())
		    PGp.click();
		}
		public void skill() {
		  
		  if (skill.isEnabled())
		    skill.click();
		}
		public void EXp() {
		  
		  if (EXp.isEnabled())
		    EXp.click();
		}
		public void Urole() {
		  
		  if (Urole.isEnabled())
		    Urole.click();
		}
		public void VS() {
		  
		  if (VS.isEnabled())
		    VS.click();
		}
		public void Batch() {
		  
		  if (Batch.isEnabled())
		    Batch.click();
		}
		public void Comnt() {
		  
		  if (Comnt.isEnabled())
		    Comnt.click();
		}
		public void dropD() {
		  
		  if (dropD.isEnabled())
		    dropD.click();
		}
		public void userrole() {
		  
		  if (userrole.isEnabled())
		    userrole.click();
		}
		public void subEmpty() {
		  
		  if (subEmpty.isEnabled())
		    subEmpty.click();
		}
		public String errorMsg() {
		  
		  return errorMsg.getText();
		}
		public String errorName() {
		  
		  return errorName.getText();
		}
		public String errorEmail() {
		  
		  return errorEmail.getText();
		}
		}


