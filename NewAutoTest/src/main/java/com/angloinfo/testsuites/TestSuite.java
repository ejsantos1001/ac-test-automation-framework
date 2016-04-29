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
import com.angloinfo.pageobjects.DirectoryListingPage;
import com.angloinfo.pageobjects.FEForgotPasswordPage;
import com.angloinfo.pageobjects.FEGlobalHomePage;
import com.angloinfo.pageobjects.FELoginPage;
import com.angloinfo.pageobjects.FEMemberSettingsPage;
import com.angloinfo.pageobjects.FEMyAngloInfoNavi;
import com.angloinfo.tools.WebDriverManager;
import com.angloinfo.tools.AuthManager;
import com.angloinfo.tools.UrlManager;
import com.angloinfo.tools.MailManager;


public class TestSuite {
	
	 String febaseurl;
	 String cmsbaseurl;
	 String accesstoken;
	 String apibaseurl; 
	 WebDriver driver;
	
	 WebDriverWait wait ;
	
	
	@Parameters({"environment"})
	@BeforeTest(groups={"working","fixing"})
	public void beforeTest(String env) {
		System.out.println("test");
		driver = WebDriverManager.getDriver();
		driver.manage().window().maximize();
		febaseurl = UrlManager.getFEbaseurl(env);
		cmsbaseurl = UrlManager.getCMSbaseurl(env);
		apibaseurl = UrlManager.getAPIbaseurl(env);
		accesstoken = AuthManager.getAccessToken(apibaseurl);
	}
	
	
	
	
	 @DataProvider
	  public Object[][] dp() {
	     return new Object[][] {
	    	 
	       new Object[] {new DirectoryListing()}
	     
	   }; 
	}
	
	@Test(dataProvider = "dp",groups={"underconstruction"})
	public void addADirectoryViaTheCMS (DirectoryListing dl) {
		
		CMSLoginPage CMSLoginPage_i1 = new CMSLoginPage(driver);
		CMSLoginPage_i1.goToPage(cmsbaseurl);
		CMSLoginPage_i1.typeEmail("dev@angloinfo.com");
		CMSLoginPage_i1.typePassword("penguin");
		CMSLoginPage_i1.clickLogin();
		Reporter.log("user is logged in");
		CMSHeaderSection CMSHeaderSection_i1 = new CMSHeaderSection(driver);
		CMSHeaderSection_i1.switchLocation();
		CMSDirectorySubSection CMSManageDirectoryPage1 = new CMSDirectorySubSection(driver);
		CMSManageDirectoryPage1.goToPage(cmsbaseurl);
		CMSManageDirectoryPage1.addDirectoryListing(dl);
		DirectoryListingPage directoryListingPage = new DirectoryListingPage(driver);
		directoryListingPage.goToListing(CMSManageDirectoryPage1.getDirectorypageUrlTest());
		Assert.assertEquals(dl.getName(), directoryListingPage.getListingTitle(),"Listing Exist in FE");
		

	}
	

	 
	 @Test(groups={"working"})
	 public void signIn(String username,String password) {
			
		 	Reporter.log("given the user has a valid email");
			FELoginPage LoginPage_i1 = new FELoginPage(driver);
			LoginPage_i1.goToPage(febaseurl);
			LoginPage_i1.login("ainfo1001+stg7@gmail.com", "Anglo123" );
			Assert.assertEquals(LoginPage_i1.getCurrentUrl(), febaseurl + "/member/dashboard");
			Reporter.log("succesfull login");
			
			
			
		}
	 @Test(groups={"working"})
	 public void receiveResetPasswordEmail() {
		FELoginPage LoginPage_i1 = new FELoginPage(driver);
		LoginPage_i1.goToPage(febaseurl);
		LoginPage_i1.clickForgotDetails();
		FEForgotPasswordPage FEForgotPasswordpage_i1 = new FEForgotPasswordPage(driver) ;
		FEForgotPasswordpage_i1.sendResetPasswordLink("ainfo1001+7@gmail.com");
		String subject = "Your AngloInfo Password Reset Link";
		Assert.assertEquals(
				 	MailManager.verifyEmailRecieved(subject, "ainfo1001+7@gmail.com", "anglo123",30)
					,true,"Reset password email recieved" );
	 }
	 	
	 @Test(groups={"working"})
	 public void switchRegionViaLocationSwitcher() {
		 	FEGlobalHomePage FEGlobalHomePage_i1 = new FEGlobalHomePage(driver);
		 	FEGlobalHomePage_i1.goToPage(febaseurl);
		 	FEGlobalHomePage_i1.switchLocation();
		 
	 }
	 
	 
	  @DataProvider
	  public Object[][] dp2() {
	    return new Object[][] {
	      new Object[] {new Member()},
	    
	    };
	  } 
	 
	 @Test(groups={"working"},dataProvider = "dp2" , threadPoolSize=1 , invocationCount = 1 , timeOut=50000)
	 public void regsiterUserViaAPI(Member regMember) {
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
					 	MailManager.verifyEmailRecieved(subject, "ainfo1001+7@gmail.com", "anglo123",30)
						,true,"Verification mail recieved" );
			
		  
	  }
	 
	
	  
	
	
	@Test(groups={"working"})
	public void recieveListingEnquiryEmail() {
		FEGlobalHomePage feGlobalHomePage = new FEGlobalHomePage(driver);
		feGlobalHomePage.goToPage(febaseurl);
		feGlobalHomePage.clickSignIn();
		FELoginPage feLoginPage = new FELoginPage(driver);
		feLoginPage.inputEmail("ainfo1002+stg101@gmail.com");
		feLoginPage.inputPassword("Anglo123");
		feLoginPage.clickLogin();
		ClassifiedsListingPage classifiedsListingsPage = new ClassifiedsListingPage(driver);
		classifiedsListingsPage.goToListing(febaseurl,"/zurich/classifieds/ad/zurich-enquiry-test-b");
		classifiedsListingsPage.enquire("iam writing to enquire");
		
		String subject = "Enquiry about your listing";
		Assert.assertEquals(
				 	MailManager.verifyEmailRecieved(subject, "ainfo1001@gmail.com", "anglo123", 30)
					,true );
		
		
	}
	
	
	

	 @DataProvider
	  public Object[][] dp3() {
	    return new Object[][] {
	      new Object[] {new Member()},
	    
	    };
	  } 
	
	 
	@Test(groups={"working"}, dataProvider="dp3")
	public void updateProfileName(Member member) {
		
		String firstname = member.getFirstname();
		String lastname = member.getLastname();
		FELoginPage feLoginPage = new FELoginPage(driver);
		feLoginPage.goToPage(febaseurl);
		feLoginPage.login("ainfo1001+stg101@gmail.com","Anglo123");
		FEMyAngloInfoNavi feMyAngloInfoNavi = new FEMyAngloInfoNavi(driver);
		feMyAngloInfoNavi.navigateToSettings();
		FEMemberSettingsPage feMemberSettingsPage = new FEMemberSettingsPage(driver);
		feMemberSettingsPage.updateProfileName(firstname, lastname);
		Assert.assertEquals(feMemberSettingsPage.getFirstName(), firstname);
		Assert.assertEquals(feMemberSettingsPage.getLastName(), lastname);
		
	}
	
	
	
	
	
	
	
	
	@AfterTest(alwaysRun=true)
	public void afterTest () {
		driver.close();
		driver.quit();
	}
}
