package com.orangehrm_hybridframework.testBase;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Parameters;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class TestBase {
		
		public WebDriver driver;
		
		@BeforeTest
		@Parameters({"browser","url"})
		public void setUP(String br, String url) {
			
			if(br.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Eclipse-workspace\\Selenium\\chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if(br.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Eclipse-workspace\\Selenium\\geckodriver.exe");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if(br.equals("IE")) {
				System.setProperty("webdriver.ie.driver", "C:\\Eclipse-workspace\\Selenium\\IEDriverServer.exe");
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			} else {
				System.out.println("Driver exe doesn't match with any above driver,Please recheck");
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@AfterMethod
		public void tearDown() { 
			driver.quit();
		}
		

}
