package com.angloinfo.testsuites;



import static com.jayway.restassured.RestAssured.given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.angloinfo.data.DirectoryListing;
import com.angloinfo.data.Member;
import com.angloinfo.pageobjects.CMSDirectorySubSection;
import com.angloinfo.pageobjects.CMSHeaderSection;
import com.angloinfo.pageobjects.CMSLoginPage;
import com.angloinfo.pageobjects.ClassifiedsListingPage;
import com.angloinfo.pageobjects.FEForgotPasswordPage;
import com.angloinfo.pageobjects.FEGlobalHomePage;
import com.angloinfo.pageobjects.FELoginPage;
import com.angloinfo.pageobjects.FELowerFooterSection;
import com.angloinfo.pageobjects.FERegionalNavigationBar;
import com.angloinfo.tools.WebDriverManager;
import com.angloinfo.tools.AuthManager;
import com.angloinfo.tools.UrlManager;
import com.angloinfo.tools.MailManager;


public class TestSuiteA {
	
	 String febaseurl;
	 String cmsbaseurl;
	 String accesstoken;
	 String apibaseurl; 
	 WebDriver driver;
	
	 WebDriverWait wait ;
	
	
	@Parameters({"environment"})
	@BeforeTest
	public void beforeTest(String env) {
		driver = WebDriverManager.getDriver();
		driver.manage().window().maximize();
		febaseurl = UrlManager.getFEbaseurl(env);
		cmsbaseurl = UrlManager.getCMSbaseurl(env);
		apibaseurl = UrlManager.getAPIbaseurl(env);
		accesstoken = AuthManager.getAccessToken(apibaseurl);
	}
	
	
	
	@Test(dataProvider = "dp",groups={"undercontruction"})
	public void testAddingDirectoryViaCMS(DirectoryListing dl) {
		
		CMSLoginPage CMSLoginPage_i1 = new CMSLoginPage(driver);
		CMSLoginPage_i1.goToPage(cmsbaseurl);
		CMSLoginPage_i1.typeEmail("dev@angloinfo.com");
		CMSLoginPage_i1.typePassword("penguin");
		CMSLoginPage_i1.clickLogin();
		CMSHeaderSection CMSHeaderSection_i1 = new CMSHeaderSection(driver);
		CMSHeaderSection_i1.switchLocation();
		CMSDirectorySubSection CMSManageDirectoryPage1 = new CMSDirectorySubSection(driver);
		CMSManageDirectoryPage1.goToPage(cmsbaseurl);
		CMSManageDirectoryPage1.addDirectoryListing(dl);
	}
	
	 @DataProvider
	  public Object[][] dp() {
	     return new Object[][] {
	    	 
	       new Object[] {new DirectoryListing()}
	     
	   }; 
	}
	 
	 @Test
	 public void testSignInViaEmail() {
			
			FELoginPage LoginPage_i1 = new FELoginPage(driver);
			LoginPage_i1.goToPage(febaseurl);
			LoginPage_i1.inputEmail("ainfo1001+7@gmail.com");
			LoginPage_i1.inputPassword("Anglo123");
			LoginPage_i1.clickLogin();	
			Assert.assertEquals(LoginPage_i1.getCurrentUrl(), febaseurl + "/buenos-aires/member/dashboard");
			Reporter.log("succesfull login");
	
			
			
		}
	 @Test
	 public void testResetPasswordMailRecieved() {
		FELoginPage LoginPage_i1 = new FELoginPage(driver);
		LoginPage_i1.goToPage(febaseurl);
		LoginPage_i1.clickForgotDetails();
		FEForgotPasswordPage FEForgotPasswordpage_i1 = new FEForgotPasswordPage(driver) ;
		FEForgotPasswordpage_i1.sendResetPasswordLink("ainfo1001+7@gmail.com");
		String subject = "Your AngloInfo Password Reset Link";
		Assert.assertEquals(
				 	MailManager.verifyEmailRecieved(subject, "ainfo1001+7@gmail.com", "anglo123")
					,true );
	 }
	 	
	 @Test
	 public void testLocationSwitcher() {
		 	FEGlobalHomePage FEGlobalHomePage_i1 = new FEGlobalHomePage(driver);
		 	FEGlobalHomePage_i1.goToPage(febaseurl);
		 	FEGlobalHomePage_i1.switchLocation();
		 
	 }
	 
	 @Test(dataProvider = "dp2" , threadPoolSize=1 , invocationCount = 1 , timeOut=50000)
	 public void testRegisterUserViaApi(Member regMember) {
		   given().
		   		auth().oauth2(accesstoken).
		   		queryParam("firstname",regMember.getFirstname()).
		  		queryParam("lastname",regMember.getLastname()).
		  		queryParam("email",regMember.getEmail()).
		  		queryParam("password",regMember.getPassword()).
		  		queryParam("username",regMember.getUsername()).
		  		queryParam("gender",regMember.getGender()).
		  		queryParam("location",regMember.getLocation()).
		  	when().
		  		post(apibaseurl+"/member/register").
		  	then().
		  		statusCode(200);
		  	
			String subject = "Email Verification";
			Assert.assertEquals(
					 	MailManager.verifyEmailRecieved(subject, "ainfo1001+7@gmail.com", "anglo123")
						,true );
			
		  
	  }
	  
	  @DataProvider
	  public Object[][] dp2() {
	    return new Object[][] {
	      new Object[] {new Member()},
	    
	    };
	  } 
	  
	@Test(groups={"undercontruction"})
	public void testLowerFooterLinks() {
		
		FEGlobalHomePage FEGlobalHomePage_i1 = new FEGlobalHomePage(driver);
		FEGlobalHomePage_i1.goToPage(febaseurl);
		FELowerFooterSection FELowerFooterSection_i1 = new FELowerFooterSection(driver);
		FELowerFooterSection_i1.clickPrivacyPolicyLink();
		FELowerFooterSection_i1.clickSiteMapLink();
		FELowerFooterSection_i1.clickTermsOfUserLink();
		FELowerFooterSection_i1.clickCookiesLink();	
	}
	
	@Test(groups={"undercontruction"})
	public void testEnquiryButton() {
		FEGlobalHomePage feGlobalHomePage = new FEGlobalHomePage(driver);
		feGlobalHomePage.goToPage(febaseurl);
		feGlobalHomePage.clickSignIn();
		FELoginPage feLoginPage = new FELoginPage(driver);
		feLoginPage.inputEmail("ainfo1001+7@gmail.com");
		feLoginPage.inputPassword("Anglo123");
		feLoginPage.clickLogin();
		ClassifiedsListingPage classifiedsListingsPage = new ClassifiedsListingPage(driver);
		classifiedsListingsPage.goToListing(febaseurl,"/zurich/classifieds/ad/zurich-classifiedstest21459256229");
		classifiedsListingsPage.enquire("iam writing to enquire");
		
		
		
	}
	
	@Test(groups = {"undercontruction","fixing"} )
	public void testRegionalMainNavigationLinks() {
		FEGlobalHomePage feGlobalHomePage2 = new FEGlobalHomePage(driver);
		feGlobalHomePage2.goToPage(febaseurl);
		feGlobalHomePage2.clickSignIn();
		FELoginPage feLoginPage2 = new FELoginPage(driver);
		feLoginPage2.inputEmail("ainfo1001+7@gmail.com");
		feLoginPage2.inputPassword("Anglo123");
		feLoginPage2.clickLogin();
		FERegionalNavigationBar feRegionalNavigationBar = new FERegionalNavigationBar(driver);
		feRegionalNavigationBar.clickDirectoryLink();
		feRegionalNavigationBar.clickClassifiedsLink();
		feRegionalNavigationBar.clickDiscussionsLink();
		feRegionalNavigationBar.clickEventsLink();
	}






	@AfterTest
	public void afterTest () {
		driver.close();
		driver.quit();
	}
}
