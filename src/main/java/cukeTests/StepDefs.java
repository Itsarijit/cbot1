package cukeTests;

import cucumber.api.Format;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import commonLibrary.HighLightElement;
import config.Constants;
import org.apache.commons.lang.StringUtils;
import uimap.LoginPage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


import commonLibrary.Commonfunctions;

import static org.testng.Assert.assertEquals;

public class StepDefs {
	private Scenario scenario;
	private WebDriver driver;
	private DesiredCapabilities cap;
    private String brosercookie = null;
	private static HighLightElement highLighter = new HighLightElement();
	private static Commonfunctions common = new Commonfunctions();
    @Before
    public void beforescenario(Scenario scenario){
        this.scenario = scenario;
        System.out.println("This is before Scenario: " + scenario.getName().toString());
     }
    

    @Given("^\"([^\"]*)\" session is new$")
    public void session_is_new(String arg1) throws Throwable {
		driver =  OpenBrowserHelp.getOpenBrowserHelp(arg1).getDriver();
		System.out.println("New session started with browser :: " + arg1);
    }
    @When("^User try to navigate \"([^\"]*)\" it redirect to \"([^\"]*)\"$")
    public void user_try_to_navigate_it_redirect_to(String arg1, String arg2) throws Throwable {
  	  driver.navigate().to(arg1);
  	  Thread.sleep(5000);
  	  assertEquals(true, driver.getCurrentUrl().equalsIgnoreCase(arg2));
    }

    @When("^User enters valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_valid_and(String arg1, String arg2) throws Throwable {
 		  driver.findElement(By.name("xsso_username")).sendKeys(arg1);
		  driver.findElement(By.name("xsso_password")).sendKeys(arg2);
		  //screenshot(driver);
		  driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		  Thread.sleep(3000);
		  if(driver.findElement(By.xpath("//div[@id='containerDiv']")).isDisplayed()){
			  System.out.println("Suucessfully logged in");
		  }
    }
    
    @Then("^User get into \"([^\"]*)\"$")
    public void user_get_into(String arg1) throws Throwable {
    	assertEquals(true, driver.getCurrentUrl().equalsIgnoreCase(arg1));
    	//driver.quit();
    }
    
    @Given("^\"([^\"]*)\" session is old\\(From Last Scenario\\)$")
    public void session_is_old_From_Last_Scenario(String arg1) throws Throwable {
    	driver =  OpenBrowserHelp.getOpenBrowserHelp(arg1).getDriver();
    }

    @When("^User try to navigate \"([^\"]*)\" it goes directly without Login$")
    public void user_try_to_navigate_it_goes_directly_without_Login(String arg1) throws Throwable {

    	  driver.navigate().to(arg1);
      	  Thread.sleep(2000);
      	  assertEquals(true, driver.getCurrentUrl().equalsIgnoreCase(arg1));

    }
    @Then("^user log-out without closing browser$")
    public void user_log_out_without_closing_browser() throws Throwable {
		  if(driver.findElement(By.xpath("//div[@id='containerDiv']")).isDisplayed()){			 
			  driver.findElement(By.xpath("//span[@class='icon-menu-rotate icon-menu-rotate--down icon-cancel']")).click();
			  Thread.sleep(3000);
			  driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).click();
			  Thread.sleep(3000);
			  assertEquals(true, driver.getCurrentUrl().equalsIgnoreCase("https://t4.ingcbportal.intranet/xsso/bye.html"));
		  }
    }
    @Then("^user close Browser$")
    public void user_close_Browser() throws Throwable {
    	driver.quit();
    }
    @Given("^\"([^\"]*)\" session is new and navigated to \"([^\"]*)\"$")
    public void session_is_new_and_navigated_to(String arg1, String arg2) throws Throwable {
		driver =  OpenBrowserHelp.getNewBrowserHelp(arg1).getDriver();
  	  	driver.navigate().to(arg2);
  	  	Thread.sleep(2000);
    }

    @Then("^browser title contains \"([^\"]*)\"$")
    public void browser_title_contains(String arg1) throws Throwable {
    	assertEquals(true, driver.getTitle().contains(arg1));
    }

    @When("^User search for \"([^\"]*)\"$")
    public void user_search_for(String arg1) throws Throwable {
	    driver.findElement(By.xpath("//input[@name='k']")).clear();
	    driver.findElement(By.xpath("//input[@name='k']")).sendKeys("Savings");
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector("button.k2-search-section-submit.k2-action")).click();
	    Thread.sleep(3000);
    }

    @Then("^Current url should contain \"([^\"]*)\"$")
    public void current_url_should_contain(String arg1) throws Throwable {
    	assertEquals(true, driver.getCurrentUrl().contains(arg1));
    }

    @When("^User navigates to day-to-day-banking tab$")
    public void user_navigates_to_day_to_day_banking_tab() throws Throwable {
	    driver.findElement(By.linkText("Day-to-day banking")).click();
	    Thread.sleep(3000);
    }

    @When("^User navigates to lending tab$")
    public void user_navigates_to_lending_tab() throws Throwable {
	    driver.findElement(By.linkText("Lending")).click();
	    Thread.sleep(3000);
    }

    @When("^User navigates to savings tab$")
    public void user_navigates_to_savings_tab() throws Throwable {
	    driver.findElement(By.linkText("Savings")).click();
	    Thread.sleep(3000);
    }

    @Then("^browser session is closed$")
    public void browser_session_is_closed() throws Throwable {
    	driver.quit();
    }

    @Given("^FB user is \"([^\"]*)\"$")
    public void fb_user_is(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^user \"([^\"]*)\" tries to loog in$")
    public void user_tries_to_loog_in(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        //this.brosercookie = arg1 + "cookie";
    }

    @Then("^user \"([^\"]*)\" should be logged in$")
    public void user_should_be_logged_in(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //System.out.println(this.brosercookie);
    }
    @Given("^FaceBook user is \"([^\"]*)\"$")
    public void facebook_user_is(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

/*        if (StringUtils.isEmpty(this.brosercookie)){
            this.brosercookie = arg1 + "cookie" + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS").format(new Date());;
            System.out.println("Assigned cookie" +this.brosercookie );
        }else{
            System.out.println("existcookie" + scenario.getName().toString());
        }*/
    }

    @When("^\"([^\"]*)\" says in chat \"([^\"]*)\"$")
    public void says_in_chat(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //Replace Parameters
        String strReq = arg2;
        String patternStringP = "\\{(.+?)\\}";
        Pattern pattern = Pattern.compile(patternStringP);
        Matcher matcher = pattern.matcher(strReq);
        while (matcher.find())
        {
            System.out.println("Parameter Found: "+matcher.group(1));
            strReq = strReq.replace(matcher.group(1),"modified_param");
        }

        //Find Buttons
        String patternStringB = "(\\[.+?\\])";
        Pattern patternB = Pattern.compile(patternStringB);
        Matcher matcherB = patternB.matcher(strReq);
        while (matcherB.find())
        {
            System.out.println("Buttons Found: "+matcherB.group(1));
            strReq = strReq.replace(matcherB.group(1),"Button_Action");
        }
    }

    @Then("^Marie says to \"([^\"]*)\" \"([^\"]*)\"$")
    public void marie_says_to(String arg1, String arg2) throws Throwable {
        String strRes = arg2;
        String patternStringP = "\\{(.+?)\\}";
        Pattern pattern = Pattern.compile(patternStringP);
        Matcher matcher = pattern.matcher(strRes);
        while (matcher.find())
        {
            System.out.println("Parameter Found: "+matcher.group(1) + " :: value is " + getUserParam(arg1,matcher.group(1)));
            strRes = strRes.replace(matcher.group(1),"modified_param");
        }

        //Find Buttons
        String patternStringB = "(\\[.+?\\])";
        Pattern patternB = Pattern.compile(patternStringB);
        Matcher matcherB = patternB.matcher(strRes);
        while (matcherB.find())
        {
            System.out.println("Buttons Found: "+matcherB.group(1));
            strRes = strRes.replace(matcherB.group(1),"Button_Action");
        }
    }
    public String getUserParam(String user, String param) throws IOException, ParseException {
        // parsing file "JSONExample.json"
        String fileNmae = user.split("_")[0]+"_" + user.split("_")[1];
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(fileNmae+".json").getFile());
        Object obj = new JSONParser().parse(new FileReader(file));
        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        // getting firstName and lastName
        JSONArray users = (JSONArray) jo.get("users");
        JSONObject usr = (JSONObject)users.get(Integer.parseInt(user.split("_")[2])-1);

        String paramVal = (String) usr.get(param);
        return paramVal;
    }
    @After
    public void afterscenario(Scenario scenario) {
    	//driver.quit();
    	System.out.println("This is after Scenario: " + scenario.getName().toString());
    }

}
