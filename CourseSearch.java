package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Kate on 07/05/2016.
 */
public class CourseSearch {


    public String course_title_to_find = null;

    public String course_type_to_find = null;

    public String course_code_to_find = null;

    public Boolean show_active_courses = true;

    public String sort_field = "start date";

    public String sort_direction = "ascending";

    private static WebDriver driver;

    public void initialise() {
        if (driver != null) {
            try {
                driver.navigate().to("http://www.w3schools.com/html/html_tables.asp");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                driver.close();
            }
        }
        if (driver == null) {
            try {
                driver = new FirefoxDriver();
                driver.navigate().to("http://www.w3schools.com/html/html_tables.asp");
                //driver.navigate().to("http://dev.ice.admin.cam.ac.uk/ice/admin/");
                driver.findElement(By.id("userid")).sendKeys("");
                driver.findElement(By.id("pwd")).sendKeys("");
                driver.findElement(By.name("submit")).click();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void close() {
        driver.close();
    }

    public void reset() {
        course_title_to_find = null;
        course_type_to_find = null;
        course_code_to_find = null;
        show_active_courses = true;
        sort_field = "start date";
        sort_direction = "ascending";
    }

    public void populate(String title_text, String type_text, String code_text) {
        doPopulate(title_text, type_text, code_text, true, "y");
    }


    public void populate(String title_text, String type_text, String code_text, Boolean show_active, String sort_order) {
        doPopulate(title_text, type_text, code_text, show_active, sort_order);
    }

    private void doPopulate(String title_text, String type_text, String code_text, Boolean show_active, String sort_order) {
        try {
            if (title_text.length() > 0) {
                driver.findElement(By.id("iceForm:j_idt99:j_idt100:title")).sendKeys(title_text);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //driver.findElement(By.id("user_last_name")).sendKeys(type_text);
        try {
            if (code_text.length() > 0) {
                driver.findElement(By.id("iceForm:j_idt99:j_idt118:courseCode_input")).sendKeys(code_text);
            }
        } catch (Exception e2) {
            System.out.println(e2.getMessage());
        }
        // show_active
        //driver.findElement(By.id("user_last_name")).sendKeys(code_text);
        // sort_order
        //driver.findElement(By.id("user_last_name")).sendKeys(code_text);
    }

    public void search() {
        driver.findElement(By.id("iceForm:j_idt99:j_idt143")).click();
    }

    public void verifyResults() {
        // loop through the results table verify that each cell is consistent with the search criteria
        System.out.println("verifyResults");
    }
}
