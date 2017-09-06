package com.javatpoint;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GoFetchResults {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		UDSQL_REP_DETAIL_T2_DAO dao = (UDSQL_REP_DETAIL_T2_DAO) ctx.getBean("edao");
		List<UDSQL_REP_DETAIL_T2> results = dao.findAll();
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://107.170.101.241:8080/getTableColumn/");
		for (UDSQL_REP_DETAIL_T2 result : results) {
			// System.out.println(result.getUnid() + " " + result.getSql_text());
			String query = result.getSql_text();
			WebElement element_enter = driver.findElement(By.xpath("//*[@id='sqlText']"));
			element_enter.clear();
			element_enter.findElement(By.xpath("//html/body/div/form/div[1]/textarea")).sendKeys(query);
			element_enter.findElement(By.xpath("//html/body/div/form/div[1]/input[6]")).click();
			WebDriverWait wait = new WebDriverWait(driver, 360);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
			// Thread.sleep(5000);
			driver.switchTo().frame("result");
			WebElement text = driver.findElement(By.xpath("//html/body/textarea"));
			String S = text.getText();
//			System.out.println(result.getUnid() + S);
			dao.saveSQL(result.getUnid(), S);
			//dao.saveSQLWithSP(result.getUnid(), S);
			driver.navigate().refresh();
			//Thread.sleep(5000);
			//driver.close();
		}

	}

}
