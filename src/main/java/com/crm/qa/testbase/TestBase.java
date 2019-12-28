package com.crm.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utils.TestUtil;
import com.crm.qa.utils.WebEventListener;

public class TestBase {

public	static WebDriver driver;
public	static Properties prop;
public static EventFiringWebDriver e_driver;
public static WebEventListener event_listener;

	public TestBase() {
		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\SHIVAM\\eclipse-workspace\\freeCrmProject\\src\\"
					+ "main\\java\\com\\crm\\qa\\config\\config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}
	public static void initialization() {
		
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SHIVAM\\Downloads\\driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\SHIVAM\\Downloads\\driver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browserName.equals("IE")) {
			System.setProperty("webdriver.IE.driver", "C:\\Users\\SHIVAM\\Downloads\\driver\\IEDriver.exe");
			driver=new InternetExplorerDriver();
		}
		e_driver=new EventFiringWebDriver(driver);
		event_listener=new WebEventListener();
		e_driver.register(event_listener);
		driver=e_driver;
		
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
		
	}

}
