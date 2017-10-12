package commonLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighLightElement {
	
	
	
	public  void highlightElement(WebDriver driver, By by) {
		
		//WebElement element = WaitHandler.waitToGetElement(driver, by);
		WebElement element = driver.findElement(by);
		String originalStyle = element.getAttribute("style");
		JavascriptExecutor js = (JavascriptExecutor) driver;	
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		
		js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
	} 
}

