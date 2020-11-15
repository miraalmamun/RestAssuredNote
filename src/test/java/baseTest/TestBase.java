package baseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;

public class TestBase {

	public WebDriver driver;

	public WebDriver getDriver(String browserName) {

		if (browserName.equalsIgnoreCase("Mozilla")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "logs\\firefox.log");
			FirefoxOptions options = new FirefoxOptions();
			// options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			FirefoxProfile prof = new FirefoxProfile();// new profile
			prof.setPreference("dom.webnotifications.enabled", false);
			options.setProfile(prof);
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "logs\\chrome.log");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			ChromeOptions ops = new ChromeOptions();
			// ops.setBinary("");
			// ops.setPageLoadStrategy(PageLoadStrategy.EAGER);
			ops.addArguments("--disable-notifications");
			ops.addArguments("--start-maximized");
			ops.addArguments("--ignore-certificate-errors");
			driver = new ChromeDriver(ops);
		} else if (browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
			// System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY,
			// "true");
			EdgeOptions options = new EdgeOptions();
			// options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			// options.setBinary(new File(""));
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			driver = new EdgeDriver(options);
		}
		// dynamic wait- not pause
		// global time out- all driver.findelement
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// presence

		return driver;
	}

	/**
	 * Enter String one by one in a field
	 */

	public void TypeInField(String xpath, String value) {
		String val = value;
		WebElement element = driver.findElement(By.xpath(xpath));
		element.clear();

		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			element.sendKeys(s);
		}
	}

	@AfterMethod
	public void closeBrowser() {
		//driver.quit();
	}

}
