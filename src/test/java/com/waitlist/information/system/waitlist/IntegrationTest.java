package com.waitlist.information.system.waitlist;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IntegrationTest {

   private WebDriver driver;

   @BeforeEach
   public void setUp(){
      // Setup initial drivers for testing UI integration with backend
      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200"
          ,"--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
      driver = new ChromeDriver(options);
   }

   @Test
   public void invalidLogin(){
      driver.get("http://localhost:3000/login");
      WebElement username=driver.findElement(By.id("name"));
      WebElement password=driver.findElement(By.id("password"));
      WebElement login= driver.findElement(By.id("submitButton"));
      username.sendKeys("");
      password.sendKeys("password");
      login.click();
      String actualUrl="http://localhost:3000/login";
      String expectedUrl= driver.getCurrentUrl();
      Assert.assertEquals(expectedUrl,actualUrl);
   }

   @Test
   public void invalidRestaurantSignUp(){
      driver.get("http://localhost:3000/signup");
      WebElement username=driver.findElement(By.id("name"));
      WebElement address=driver.findElement(By.id("address"));
      WebElement phoneNumber=driver.findElement(By.id("phoneNumber"));
      WebElement password=driver.findElement(By.id("password"));
      WebElement login= driver.findElement(By.id("submitButton"));
      username.sendKeys("");
      address.sendKeys("123 Street");
      password.sendKeys("password");
      phoneNumber.sendKeys("416-444-4444");
      login.click();
      String actualUrl="http://localhost:3000/signup";
      String expectedUrl= driver.getCurrentUrl();
      Assert.assertEquals(expectedUrl,actualUrl);
   }

   @Test
   public void invalidJoinWaitList(){
      driver.get("http://localhost:3000/");
      WebElement name=driver.findElement(By.id("name"));
      WebElement email=driver.findElement(By.id("email"));
      WebElement phone=driver.findElement(By.id("phone"));
      WebElement partySize=driver.findElement(By.id("partySize"));
      WebElement login= driver.findElement(By.id("submitButton"));
      name.sendKeys("Joe");
      email.sendKeys("joejoegmail.com");
      phone.sendKeys("416-555-7777");
      partySize.sendKeys("7");
      login.click();
      String actualUrl="http://localhost:3000/";
      String expectedUrl= driver.getCurrentUrl();
      Assert.assertEquals(expectedUrl,actualUrl);
   }

   @Test
   public void fillInLoginForm(){
      driver.get("http://localhost:3000/login");
      WebElement username=driver.findElement(By.id("name"));
      WebElement password=driver.findElement(By.id("password"));
      WebElement login= driver.findElement(By.id("submitButton"));
      username.sendKeys("Pizza World");
      password.sendKeys("password");
      login.click();
   }

   @Test
   public void fillJoinWaitListForm(){
      driver.get("http://localhost:3000/");
      WebElement name=driver.findElement(By.id("name"));
      WebElement email=driver.findElement(By.id("email"));
      WebElement phone=driver.findElement(By.id("phone"));
      WebElement partySize=driver.findElement(By.id("partySize"));
      WebElement login= driver.findElement(By.id("submitButton"));
      name.sendKeys("Joe");
      email.sendKeys("joe@joegmail.com");
      phone.sendKeys("416-555-7777");
      partySize.sendKeys("7");
      login.click();
   }

   @Test
   public void fillInRestaurantSignUpForm(){
      driver.get("http://localhost:3000/signup");
      WebElement username=driver.findElement(By.id("name"));
      WebElement address=driver.findElement(By.id("address"));
      WebElement phoneNumber=driver.findElement(By.id("phoneNumber"));
      WebElement password=driver.findElement(By.id("password"));
      WebElement login= driver.findElement(By.id("submitButton"));
      username.sendKeys("Pizza World");
      address.sendKeys("123 Street");
      password.sendKeys("password");
      phoneNumber.sendKeys("416-444-4444");
      login.click();
   }
}
