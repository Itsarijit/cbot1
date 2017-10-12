/**
 * Created by d-lt27hk on 10/10/2017.
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.remote.DesiredCapabilities;
import com.decryption.Decryption;

public class localRunFB {

    public static WebDriver driver;
    //static DesiredCapabilities cap;

    //@Parameters({"remoteurl"})
    public static void main(String args[]) throws MalformedURLException, InterruptedException {

        //System.out.println(remoteurl);

        selectBrowser("chrome");

        //driver.navigate().to("https://t4.ingcbportal.intranet/xsso/");
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        try{

            if(driver.findElement(By.xpath("//input[@id='email' or @name='email']")).isDisplayed()){
                driver.findElement(By.xpath("//input[@id='email' or @name='email']")).sendKeys(Constants.user_name);
                driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Decryption.getDecryptedText(Constants.user_Password));
                Thread.sleep(1000);
                driver.findElement(By.xpath("//input[@data-testid='royal_login_button']")).click();
                Thread.sleep(1000);
                driver.navigate().to("https://www.facebook.com/messages/t/1689290361143684");
                Thread.sleep(3000);
                List<WebElement> prev_messeges = driver.findElements(By.cssSelector("span._3oh-._58nk"));
                int prev_messeges_Cnt = prev_messeges.size();
                System.out.println("******************OLD Message***************************");
                for(int i=0 ; i<prev_messeges_Cnt;i++){
                    System.out.println("Message :"+ i + " : " + prev_messeges.get(i).getText());
                }
                Actions builder = new Actions(driver);
                Action insermessage = builder
                        .sendKeys("hello" + prev_messeges_Cnt,Keys.ENTER)
                        .build();
                insermessage.perform();
                Thread.sleep(5000);
                List<WebElement> current_messeges = driver.findElements(By.cssSelector("span._3oh-._58nk"));
                int current_messeges_Cnt = current_messeges.size();
                System.out.println("*********************New Message************************");
                for(int i=prev_messeges_Cnt  ; i<current_messeges_Cnt;i++){
                    System.out.println("Message :"+ i + " : " + current_messeges.get(i).getText());
                }

                driver.quit();
                //driver.close();
            }
        }catch(Exception e){
            System.out.println(e);
            driver.quit();
            //driver.close();
        }

    }

    public static void selectBrowser(String browserName){

        switch(browserName){

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\JavaJars\\Drivers\\geckodriver.exe");
                DesiredCapabilities cap = DesiredCapabilities.firefox();
                ProfilesIni profileIni= new ProfilesIni();
                //FirefoxProfile profile = profileIni.getProfile(new File("D:\\Selenium Profile"));
                FirefoxProfile profile = new FirefoxProfile(new File("C:\\Data\\ffProfileING"));
                profile.setAcceptUntrustedCertificates(true);
                profile.setAssumeUntrustedCertificateIssuer(false);
                cap.setCapability(FirefoxDriver.PROFILE, profile);
                driver =new FirefoxDriver(cap);
                break;

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\JavaJars\\Drivers\\chromedriver.exe");
                driver =new ChromeDriver();

                break;

            case "internetExplorer":
                System.setProperty("webdriver.ie.driver", "C:\\JavaJars\\Drivers\\IEDriverServer.exe");
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,"about:blank");
                //caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,"http://localhost:16356/");
                //caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                driver =new InternetExplorerDriver(caps);
                break;

        }


    }

}

