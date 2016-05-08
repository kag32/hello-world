package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kate on 06/05/2016.
 */
public class htmlTable {
    WebDriver driver = null;

    //driver = new FirefoxDriver();
    //driver.navigate().to("http://www.google.com");
    // .//*[@id='main']/table[1]/tbody/tr[1]/th[1]/text()
    @Given("^I am on w3schools website")
    public void w3SchoolsWebsite() throws Throwable {
        driver = new FirefoxDriver();
        driver.navigate().to("http://www.w3schools.com/html/html_tables.asp");
    }

    @When("^process table$")
    public void processTable() throws Throwable {
        Thread.sleep(1000);
        String table_xpath = ".//*[@id='main']/table[1]/tbody/tr[1]/th[1]";
        WebElement ele = driver.findElement(By.xpath(table_xpath));
        System.out.println("");
        System.out.println(ele.getText());
        /*
        ele = driver.findElement(By.xpath(".//*[@id='main']/table[1]/tbody/tr[1]/th[2]"));
        System.out.println("");
        System.out.println(ele.getText());
        */
        int ix = 2;
        try {
            while (ix > 0) {
                // loop is exited when an exception occurs because ix increases beyond the end of the table
                ele = driver.findElement(By.xpath(".//*[@id='main']/table[1]/tbody/tr[" + ix + "]/td[2]"));
                System.out.println("");
                System.out.println(ele.getText());
                ix = ix + 1;
            }
        } catch (Exception e) {
            if (!e.getMessage().contains("Unable to locate element:") & ix > 2) {
                System.out.println("");
                System.out.println(e.getMessage());
                Assert.assertFalse(true);
            }
            //String stringDate = "16jan31 12:44";
            //DateFormat dateFormat = new SimpleDateFormat("yyMMMdd kk:mm", Locale.ENGLISH);
            //Date result = dateFormat.parse(stringDate);

            String mydata = "Beginner's Italian  Certificate/Diploma  01 Jun 2015 to 02 Jun 2015 ";
            try {
                String course_start_date_s ="";
                String course_end_date_s ="";
                Pattern pattern = Pattern.compile("[01][0-9] (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}");
                Matcher matcher = pattern.matcher(mydata);
                while (matcher.find()) {
                    System.out.println(matcher.group(0));
                    if (course_start_date_s.contentEquals("")) {
                        // set course start date to first date found
                        course_start_date_s = matcher.group(0);
                    }
                    else
                    {
                        if (course_end_date_s.contentEquals("")){
                            //set course end date to second date found
                            course_end_date_s = matcher.group(0);
                        }
                        else
                        {
                            // more than two dates found.  We want the last two so shuffle
                            course_start_date_s = course_end_date_s;
                            course_end_date_s = matcher.group(0);
                        }

                    }
                    System.out.println("Course Start Date; " + course_start_date_s);
                    System.out.println("Course End Date; " + course_end_date_s);
                    DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
                    Date result = dateFormat.parse(course_start_date_s);
                    Date today = new Date();
                    System.out.println(result.toString());
                    if (result.after(new Date())) {
                        System.out.println(result.toString() + " is after " + today.toString());
                    } else {
                        System.out.println(result.toString() + " is before " + today.toString());
                    }
                }
            } catch (Exception e2) {
                System.out.println("");
                System.out.println(e2.getMessage().toString());
            }
        }
    }

}
