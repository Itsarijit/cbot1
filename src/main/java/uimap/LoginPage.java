/**
 * 
 */
package uimap;
import org.openqa.selenium.By;

public class LoginPage {
		
		// Login page objects
		public static final By TXTBX_USER_NAME = By.name("j_username");
		public static final By TXTBX_PASSWORD = By.name("j_password");
		public static final By LST_LANGUAGE = By.name("j_locale");

		public static final By BTN_SIGN_IN1 = By.id("signin-btn-btnInnerEl");
		public static final By BTN_SIGN_IN = By.xpath("//span[@class='x-btn-button' and contains(text(), 'Sign In')]");
		
		public static final By BTN_USER_BUTTON = By.xpath("//a[@class='x-btn-button' and contains(@id, 'xcp_user_button')]");
		public static final By SIGN_OUT = By.xpath("//span[contains(@id, 'button') and contains(text(), 'Sign out')]");
		public static final By DOSSIER_TYPE = By.xpath("//label[contains(text(), 'Dossier Type')]/following::input[contains(@name, 'xcp_dropdown_list')][1]");
}
