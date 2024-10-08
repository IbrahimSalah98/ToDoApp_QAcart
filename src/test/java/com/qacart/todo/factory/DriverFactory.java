package com.qacart.todo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
  private WebDriver driver ;

  public WebDriver intilaizeDriver (){

      String browser = System.getProperty("browser" , "chrome") ;
      switch (browser) {
          case "chrome" :
              WebDriverManager.chromedriver().setup();
              driver = new ChromeDriver() ;
              break;
          case "fire" :
              WebDriverManager.firefoxdriver().setup();
              driver = new FirefoxDriver();
              break;
          default:
              throw new RuntimeException("The browser not supported") ;
      }


      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
      driver.manage().window().maximize();

      return driver;
  }


}
