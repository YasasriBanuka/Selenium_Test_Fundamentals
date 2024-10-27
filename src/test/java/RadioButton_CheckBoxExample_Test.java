import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class RadioButton_CheckBoxExample_Test {
    WebDriver driver;// use for all methods


    //check before running the test

    @BeforeMethod
    public void openLinkTestPage() {
       driver = new ChromeDriver();
        //fixed browser pc screen size
       driver.manage().window().maximize();

    }

    @Test
    public void radioButtonTest (){

        driver.get("https://www.leafground.com/radio.xhtml");
        // 1) click Fire fox radiobutton
        driver.findElement(By.xpath("//label[@for='j_idt87:console1:1']")).click();
        String expectedTitle = "Firefox";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Actual Title same as expected");
        }else{
            System.out.println("Actual Title not same as expected");
        }

        //<<<<<<<<<<<<<<<<RADIO>>>>>>>>>>>>>>>>>>>>>>>>
        // 2) Find the default select radio button
        boolean chromeRadioOption= driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxRadioOption= driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariRadioOption= driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeRadioOption= driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        // check is select or not
        if(chromeRadioOption){
            // why add String below statement : when i add getText keyword , getText() already return String , and also i use String .
          String chromeS =  driver.findElement(By.xpath("//label[@for='j_idt87:console2:0'] ")).getText();
            System.out.println( "default select radio button" + chromeS);
        } else if (firefoxRadioOption) {
            String Firefox =  driver.findElement(By.xpath("//label[@for='j_idt87:console2:1'] ")).getText();
            System.out.println( "default select radio button" + Firefox);
        } else if (safariRadioOption) {
            String Safari =  driver.findElement(By.xpath("//label[@for='j_idt87:console2:2'] ")).getText();
            System.out.println( "default select radio button" + Safari);
        }else if (edgeRadioOption) {
            String edge =  driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println( "default select radio button" + edge);
        }

        // 2 way : Professional way

//        List<WebElement> radio = driver.findElements(By.xpath("//table[@id='j_idt87:console2']//td//input "));
//        int radioCount = radio.size();
//        System.out.println("Radio size" + radioCount);
//
//        int a = -1;
//
//        for (WebElement radioElement : radio ){
//            a++;
//            WebElement defaultElementRadioButton = driver.findElement (By.xpath("//label[@for='j_idt87:console2:2" + a + "']"));
//            String defaultRadioButtonText = defaultElementRadioButton.getText();
//            System.out.println("Default Selected Radio Button is " + defaultRadioButtonText);
//            break;
//        }


        WebElement myAgeGroup =  driver.findElement(By.id("j_idt87:age:0"));
        boolean isCheck = myAgeGroup.isSelected();
        if (!isCheck){
           // myAgeGroup.click();
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }

      // step 2 : add java

//      String myAge = "1-20 year"; // i you want change this age to current age  then change String myAge = "17-29" - change value;
//        List<WebElement> ageGroups = driver.findElements(By.xpath(
//                "//div[@id='j_idt87:age']//label"));  // covered all labels age related in this Xpath
//
//        // use foreach loop
//        for(WebElement element : ageGroups){
//            String elementText = element.getText();
//
//            if(elementText.equals(myAge)){
//               WebElement myRadioOption =  driver.findElement(By.xpath(
//                       // here use Advanced xpath
//                       "//lable[text()= '" + elementText + "'] /parent::div//input"));
//                if(!myRadioOption.isSelected()) {
//                    element.click();
//                }
//                break;
//            }
//        }

    }


    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<CHECKBOX TESTING>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    // when you use isSelected () key checkbox must start input tag:
    @Test
    public void CheckBoxtest(){
        // 1) select wanted checkboxes and verifying those selected status

        driver.get("https://www.leafground.com/checkbox.xhtml");

        // get all labels
        List<WebElement>  checkBoxList =  driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        // for each Loop
         for(WebElement element :checkBoxList){
             // then check one by one checkbox qual to other checkbox
             if(!(element.getText().equals("Others"))){
                 // not equal other check box then click another checkboxes
                 element.click();
             }
        }
         // here find one by one element : here find Start input tage elements  [here this keyword "isSelected();" mainly use when the tage is start input tag]
         for(int i = 1; i<=checkBoxList.size() ;i++){
             boolean checkBoxListStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)["+ i +"]")).isSelected();
             System.out.println("checkbox" + i + "Selected status is :" + checkBoxListStatus);


         }

    }


}
