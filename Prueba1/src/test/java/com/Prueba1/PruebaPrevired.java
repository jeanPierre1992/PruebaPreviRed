package com.Prueba1;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PruebaPrevired {
	
	private WebDriver driver;
	//Blusa
	By BlusaLocator = By.xpath("(//a[@title='Blouse'])[2]");
	By Color1 = By.xpath("//div/ul/li/a[@id='color_11']");
	By AnadirCarro = By.xpath("//button[@name='Submit']");
	By SeguirComprando = By.xpath("//div/span/span/i[@class='icon-chevron-left left']");
	By Mujer = By.xpath("//a[@title='Women']");
	By Tops = By.xpath("//a[@title='Tops']/img");
	By Blouses = By.xpath("(//a[@title='Blouses'])[2]");
	
	//Vestido
	By Vestidos = By.xpath("(//a[@title='Dresses'])[2]");
	By VestidosVerano = By.xpath("(//a[@title='Summer Dresses'])[3]");
	//By VestidosVeranoSel = By.xpath("(//div/a[@title='Printed Summer Dress'])[2]");
	By Inicio = By.xpath("//a[@title='My Store']");
	By VestidosVeranoSel = By.xpath("(//a[@title='Printed Summer Dress']/img)[1]");
	By Comprar = By.xpath("(//a/span/i[@class='icon-chevron-right right'])[2]");
	By AnadirCarro2 = By.xpath("//button/span[contains(text(),'Add to cart')]");
	
	//Compara carrito
	By Compara1 = By.xpath("(//a[contains(text(),'Blouse')])[3]");
	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/");
	}
	
	@Test
	public void TestPreviRed() throws InterruptedException {
		
		//Realiza la compra de la Blusa negra talla L
		driver.findElement(Mujer).click();
		driver.findElement(Tops).click();
		driver.findElement(Blouses).click();
		Thread.sleep(3000);
		driver.findElement(BlusaLocator).click();
		Thread.sleep(3000);
		WebElement ddown = driver.findElement(By.cssSelector("select[name=group_1]"));
		
		Select select = new Select(ddown);
		select.selectByValue("3");
	
		driver.findElement(Color1).click();
		driver.findElement(AnadirCarro).click();
		Thread.sleep(3000);
		driver.findElement(SeguirComprando).click();
		
		//Realiza la compra del Vestido de verano talla S
		Thread.sleep(3000);
		
		driver.findElement(Inicio).click();
//		driver.findElement(Vestidos).click();
//		Thread.sleep(3000);
//		driver.findElement(VestidosVerano).click();
		Thread.sleep(3000);
		driver.findElement(VestidosVeranoSel).click();
		Thread.sleep(3000);
		//select.selectByValue("1");
		driver.findElement(AnadirCarro2).click();
		Thread.sleep(3000);
		driver.findElement(Comprar).click();
		
		//Compara carrito
		assertEquals("Blouse", driver.findElement(Compara1).getText());
		
		
	}


	@After
	public void tearDown() {
//		driver.quit();
	}
}	
