package com.eargo.automation.base;

import io.cucumber.java.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestBase {

	public enum OS {
		WINDOWS, LINUX, MAC
	};

	public static WebDriver wbDv;
	public static Properties prop;
	public static EventFiringWebDriver driver;
	// public static WebEventListener eventListner;
	public static WebDriverWait wait;
	private static OS os = null;

	public ExtentReports extent;
	public static ExtentTest scenarioDef;
	public static ExtentTest features;

	public static String screenshotLocation = System.getProperty("user.dir") + File.separator + "report";
	public static String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
	public static String reportLocation = System.getProperty("user.dir") + File.separator + "report";

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + File.separator + "src"
					+ File.separator + "test" + File.separator + "resources" + File.separator + "env.properties");
			prop.load(fis);

		} catch (IOException e) {

			e.getMessage();
		}
	}

	public static void initialization() {

		
		System.out.println("Opening the browser: " + prop.getProperty("browserName"));
		// System.out.println("Running: " + scenario.getName());

		switch (getOS()) {

		case WINDOWS:
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers"
					+ File.separator + "chromedriver_win32" + File.separator + "chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers"
					+ File.separator + "geckodriver-v0.26.0-win64" + File.separator + "geckodriver.exe");
			break;

		case MAC:
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers"
					+ File.separator + "chromedriver_mac64" + File.separator + "chromedriver");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers"
					+ File.separator + "geckodriver-v0.26.0-macos" + File.separator + "geckodriver");
			break;

		case LINUX:
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers"
					+ File.separator + "chromedriver_linux64" + File.separator + "chromedriver");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers"
					+ File.separator + "geckodriver-v0.26.0-linux64" + File.separator + "geckodriver");
			break;

		default:
			break;

		}

		switch (prop.getProperty("browserName").toUpperCase()) {

		case "FIREFOX":
			wbDv = new FirefoxDriver();
			break;

		case "CHROME":
			wbDv = new ChromeDriver();
			break;

		case "SAFARI":
			wbDv = new SafariDriver();
			break;

		default:
			System.out.println("Incompitable Browser.");
			wbDv = new ChromeDriver();

		}

		driver = new EventFiringWebDriver(wbDv);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(prop.getProperty("testSiteURL"));

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}
	
	public static void tearDownTest() {
		System.out.println("--- tearDownTest ---");
		// if (scenario.isFailed()) {
		// Take screenshot
		try {

			// String screenshot = scenario.getName().replaceAll("[^a-zA-Z]+", "");
			// System.out.println("screenshot:" + screenshot);
			// takeScreenshot(screenshot);

		} catch (Exception e) {

			e.printStackTrace();
		}

		// System.out.println("scenario:" + scenario.getName());
		// }

		System.out.println("Closing the browser: " + prop.getProperty("browserName").toUpperCase());

		driver.close();
		driver.quit();
	
	}

	public void BeforeEveryStep(Scenario scenario) {
		System.out.println("Before every step " + scenario.getId());
	}

	public void AfterEveryStep(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
		System.out.println("After every step " + scenario.getId());
	}

	public static OS getOS() {

		if (os == null) {

			String operSys = System.getProperty("os.name").toLowerCase();

			if (operSys.contains("win")) {

				os = OS.WINDOWS;

			} else if (operSys.contains("nix") || operSys.contains("nux") || operSys.contains("aix")) {

				os = OS.LINUX;

			} else if (operSys.contains("mac")) {

				os = OS.MAC;
			}
		}

		return os;
	}

	public void takeScreenshot(String sceanario) throws IOException {

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshot.toPath(),
				new File(screenshotLocation + File.separator + timeStamp + File.separator + sceanario + ".png")
						.toPath());
		scenarioDef.fail("details").addScreenCaptureFromPath(screenshotLocation + "screenshot.png");
	}

}
