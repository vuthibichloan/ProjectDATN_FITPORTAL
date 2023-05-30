package keyword;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;


import io.github.bonigarcia.wdm.WebDriverManager;
import utils.LogUtils;



public class ActionKeywords {
	public static WebDriver driver;
	private static WebDriverWait wait;
	public static Properties OR = new Properties(System.getProperties());

	private static WebElement GetElement(String locatorType, String locatorValue) {
		WebElement element;

		if (locatorType.equalsIgnoreCase("className"))
			element = driver.findElement(By.className(locatorValue));
		else if (locatorType.equalsIgnoreCase("cssSelector"))
			element = driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.equalsIgnoreCase("id"))
			element = driver.findElement(By.id(locatorValue));
		else if (locatorType.equalsIgnoreCase("partialLinkText"))
			element = driver.findElement(By.partialLinkText(locatorValue));
		else if (locatorType.equalsIgnoreCase("name"))
			element = driver.findElement(By.name(locatorValue));
		else if (locatorType.equalsIgnoreCase("xpath"))
			element = driver.findElement(By.xpath(locatorValue));
		else if (locatorType.equalsIgnoreCase("tagName"))
			element = driver.findElement(By.tagName(locatorValue));
		else
			element = driver.findElement(By.xpath(locatorValue));

		return element;
	}


	public static WebDriver getDriver() {
		return driver;
	}
	// Khoi tao cau hinh cua cac Browser de dua vao Switch Case
	private static WebDriver initChromeDriver() {
		LogUtils.info("Launching Chrome browser...");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	private static WebDriver initFirefoxDriver() {
		System.out.println("Launching Firefox browser...");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	private static WebDriver initOperaDriver() {
		System.out.println("Launching Opera browser...");
		WebDriverManager.operadriver().setup();
		// driver=new OperaDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}


	public static WebDriver openBrowser(String browserType) throws Exception {
		switch (browserType.trim().toLowerCase()) {
		case "chrome":
			driver = initChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			break;
		case "firefox":
			driver = initFirefoxDriver();
			break;
		case "opera":
			driver = initOperaDriver();
			break;
		default:
			//System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
			driver = initChromeDriver();
		}
		// wait=new WebDriverWait(driver,Duration.ofSeconds(timeoutWait));
		Thread.sleep(5000);
		return driver;
	}


	public static void navigate(String url) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			LogUtils.info("Navigate to " + url);
			wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
			driver.get(url);
			driver.manage().window().maximize();
			driver.navigate().refresh();
		} catch (Exception e) {
			System.out.println("Error..." + e.getStackTrace());
		}
	}


	public static void quitDriver() {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	// Keyword lấy url 
		public static boolean verifyUrl(String expect) throws InterruptedException {
			waitForPageLoaded();
			Thread.sleep(5000);			
			String actual = driver.getCurrentUrl();
			LogUtils.info("Expected result: " + expect);
			LogUtils.info("Actual result: " + actual);
			if (actual.equals(expect)) {
				return true;
			} else
				return false;
		}
		
		
	public static void setText(String locatorType, String locatorValue, String value) {
		WebElement element = GetElement(locatorType, locatorValue);
		waitForPageLoaded();
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
	}
	
	//Sinh viên
	public static boolean verifySearchStudent(String value) throws InterruptedException {
        WebElement timkiemSV = driver.findElement(By.xpath("//td[contains(text(),'Không tồn tại bản ghi nào.')]"));
        String expect= timkiemSV.getText();
        waitForPageLoaded();
        LogUtils.info("Expected Result: " + value);
        LogUtils.info("Actual Result: " + expect);
        if (value.equals(expect))
        {
            return true;
        }
        else return false;
    }

	//Giáo viên
	public static boolean verifySearchTeacher(String value) throws InterruptedException {
        WebElement timkiemGV = driver.findElement(By.xpath("//td[contains(text(),'Không tồn tại bản ghi nào.')]"));
        String expect= timkiemGV.getText();
        waitForPageLoaded();
        LogUtils.info("Expected Result: " + value);
        LogUtils.info("Actual Result: " + expect);
        if (value.equals(expect))
        {
            return true;
        }
        else return false;
    }

	//Đợt làm ĐATN
	public static boolean verifySearchProject(String value) throws InterruptedException {
        WebElement timkiemDot = driver.findElement(By.xpath("//td[contains(text(),'Không tồn tại bản ghi nào.')]"));
        String expect= timkiemDot.getText();
        waitForPageLoaded();
        LogUtils.info("Expected Result: " + value);
        LogUtils.info("Actual Result: " + expect);
        if (value.equals(expect))
        {
            return true;
        }
        else return false;
    }
	
	//Đăng nhập
	public static boolean verifyLoginTrue(String value) throws InterruptedException {
        WebElement loginTrue = driver.findElement(By.xpath("//span[contains(text(),'Bàn làm việc')]"));
        String expect= loginTrue.getText();
        waitForPageLoaded();
        LogUtils.info("Expected Result: " + value);
        LogUtils.info("Actual Result: " + expect);
        if (value.equals(expect))
        {
            return true;
        }
        else return false;
    }
	public static boolean verifyLoginFalse(String value) throws InterruptedException {
        WebElement loginFalse = driver.findElement(By.xpath("//div[starts-with(@id, 'note')]"));
        String expect= loginFalse.getText();
        waitForPageLoaded();
        LogUtils.info("Expected Result: " + value);
        LogUtils.info("Actual Result: " + expect);
        if (value.equals(expect))
        {
            return true;
        }
        else return false;
    }
	
	public static void clickElement(String locatorType, String locatorValue) throws InterruptedException {
		WebElement element;
		element = GetElement(locatorType, locatorValue);
		//Thread.sleep(2000);
		waitForPageLoaded();
		//wait=new WebDriverWait(driver,Duration.ofSeconds(timeoutWait));
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public static void waitForPageLoaded() {
		try {
			wait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
							.equals("complete");
				}
			});
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load request.");
		}
	}

	public static boolean verifyText(String locatorType, String locatorValue, String text) {        
		WebElement element = GetElement(locatorType, locatorValue);
        String expect= element.getText();
        waitForPageLoaded();
        LogUtils.info("Expected Result: " + text);
        LogUtils.info("Actual Result: " + expect);
        if (text.equals(expect))
        {
            return true;
        }
        else 
        	return false;
	}

	public static void screenshot(String CaseName) throws IOException {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// Tạo tham chiếu của TakesScreenshot với driver hiện tại
		TakesScreenshot ts = (TakesScreenshot) driver;
		// Gọi hàm capture screenshot - getScreenshotAs
		File source = ts.getScreenshotAs(OutputType.FILE);
		// Kiểm tra folder tồn tại. Nêu không thì tạo mới folder
		File theDir = new File("./Screenshots/");
		if (!theDir.exists()) {
			theDir.mkdirs();
		}
		// lấy tên của test case xong gán cho tên File chụp màn hình luôn
		FileHandler.copy(source, new File("./Screenshots/" + CaseName + ".png"));
	}


}



