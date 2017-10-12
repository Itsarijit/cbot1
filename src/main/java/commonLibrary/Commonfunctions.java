package commonLibrary;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class Commonfunctions {	
	public void maximizeWindow(WebDriver driver) {

		final JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		Point targetPosition = new Point(0, 0);
		driver.manage().window().setPosition(targetPosition);
		String w = "return screen.availWidth";
		String h = "return screen.availHeight";
		int width = ((Long)jsExecutor.executeScript(w)).intValue();
		int height = ((Long)jsExecutor.executeScript(h)).intValue();
		Dimension targetSize = new Dimension(width, height);
		driver.manage().window().setSize(targetSize);
	}	
}
