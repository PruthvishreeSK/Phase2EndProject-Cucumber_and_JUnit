package steps;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StarHealthTest {

	WebDriver driver;
	
	
	@Given("User launches the Star Health application")
	public void user_launches_the_star_health_application_with() {
	    
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	    driver.get("https://www.starhealth.in/");
	    
	    driver.manage().deleteAllCookies();
	    
	}

	@Then("User validates the Star Health home page title using a JUnit assertion")
	public void user_validates_the_star_health_home_page_title_using_a_j_unit_assertion() {
	    String title = driver.getTitle();
	    System.out.println(title);
		assertEquals(title,"Star Health Insurance: Medical, Accident and Travel insurance policies");
	}

	@When("User clicks on the Buy Now button")
	public void user_clicks_on_the_buy_now_button() throws InterruptedException {
	    driver.findElement(By.xpath("(//span[@class='btn-text'])[1]")).click();
	    Thread.sleep(3000);
	}

	@Then("User types following details")
	public void user_types_following_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		
		List<List<String>> userList = dataTable.asLists(String.class);
		
		for(List<String> e : userList)
		{
			driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[1]")).clear();
			driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[1]")).sendKeys(e.get(0));
			
			driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[2]")).sendKeys(e.get(1));
			
			driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[3]")).sendKeys(e.get(2));
			
			Thread.sleep(3000);
		}
	}

	@Then("User clicks on I need health insurance from the drop-down menu and selects My Family")
	public void user_clicks_on_i_need_health_insurance_from_the_drop_down_menu_and_selects_my_family() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input']")).click();
		 
		 Thread.sleep(3000);
		 
		 driver.findElement(By.xpath("(//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button'])[1]")).click();
		 Thread.sleep(3000);
	}

	@Then("User validates that the mobile number is the same as the previously entered number using a JUnit assertion")
	public void user_validates_that_the_mobile_number_is_the_same_as_the_previously_entered_number_using_a_j_unit_assertion() {
	   
		String displayed_number = driver.findElement(By.xpath("(//input[@class='MuiInputBase01355 MuiInput01340 c01308 MuiInputBase01356 MuiInput01341 MuiInputBase01361'])[1]")).getDomAttribute("value");
	   System.out.println(displayed_number);
	   assertEquals("9999999999",displayed_number);
	}

	@When("User clicks on the Star Health logo")
	public void user_clicks_on_the_star_health_logo() throws InterruptedException {
	    driver.findElement(By.xpath("//img[@class='jss341']")).click();
	    Thread.sleep(4000);
	}

	@After
	public void closetabs()
	{
		driver.quit();
	}

	
}
