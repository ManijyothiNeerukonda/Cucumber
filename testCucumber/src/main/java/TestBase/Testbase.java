package TestBase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Testbase {

	//Loading properties
	public static WebDriver driver;
	private static Properties properties;
	 private final String propertyFilePath="C:\\Users\\MANIJYOTHI\\git\\Projects\\testCucumber\\configs\\Configuation.properties";
	 public Testbase(){
			try {
				properties = new Properties();
				FileInputStream ip = new FileInputStream(propertyFilePath);
				properties.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);

			}
		}
		
	public static void initialization() {
		String browserName=properties.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");	
		
		driver = new ChromeDriver(); 
	}
	else if(browserName.equals("FF")){
		driver = new FirefoxDriver(); 
	}
	
	else {
		System.setProperty("Webdriver.ie.driver", "C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe");
		driver= new InternetExplorerDriver();
		
	}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(properties.getProperty("url"));
	
	}
	
	
	
	
}
