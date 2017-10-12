package cukeTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import config.Constants;

public class OpenBrowserHelp {
	private RemoteWebDriver driver;
	private DesiredCapabilities cap;
	private static OpenBrowserHelp browserHelp;

	private OpenBrowserHelp(String arg1) throws MalformedURLException {
		switch(arg1){
		
		case "firefox":
			cap = new DesiredCapabilities().firefox();
			cap.setPlatform(Platform.ANY);
			cap.setBrowserName("firefox");
			
			ProfilesIni profileIni= new ProfilesIni();			
			FirefoxProfile profile = profileIni.getProfile("ING");
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(true);
			
			cap.setCapability(FirefoxDriver.PROFILE, profile);
			//cap.setCapability("marionette", true);
			break;
			
		case "chrome":
			cap = new DesiredCapabilities().chrome();
			cap.setPlatform(Platform.ANY);
			cap.setBrowserName("chrome");
			break;
			
		case "internetExplorer":
			cap = new DesiredCapabilities().internetExplorer();
			cap.setPlatform(Platform.ANY);
			cap.setBrowserName("internet explorer");
			
			//cap.setVersion("accc");
			break;
			
		}
		driver = new RemoteWebDriver(new URL(Constants.hub),cap);
	}

	public static OpenBrowserHelp getOpenBrowserHelp(String arg2) throws MalformedURLException {
	    if (null == browserHelp) {
	    	System.out.println("Starting New Browser Session");
	        browserHelp = new OpenBrowserHelp(arg2);
	    }
	    return browserHelp;
	}
	
	public static OpenBrowserHelp getNewBrowserHelp(String arg2) throws MalformedURLException {

	    browserHelp = new OpenBrowserHelp(arg2);
	    return browserHelp;
	}

	WebDriver getDriver() {
	    return driver;
	}

	void setDriver(RemoteWebDriver driver) {
	    this.driver = driver;
	}
}
