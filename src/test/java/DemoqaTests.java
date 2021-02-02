import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
    @Test
    void textFields() {
        open("https://demoqa.com/automation-practice-form");    // Open URL
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Dan");                            // Type name
        $("#lastName").setValue("Vu");                              // Type lastname
        $("#userEmail").setValue("danvu@ya.ru");                    // Type email


        $("label[for='gender-radio-3']").click();                   // Click radio button
        $("#userNumber").setValue("1234567890");                    // Set mobile


        $("#dateOfBirthInput").click();

        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1975");
        $("[aria-label='Choose Monday, April 14th, 1975']").click();

        $("#subjectsInput").setValue("hi").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("label[for='hobbies-checkbox-3']").click();

        File file = new File("src/test/java/resources/ejik.jpg");
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("test"); // Тут адрес

        $("#react-select-3-input").setValue("N").pressEnter();
        $("#react-select-4-input").setValue("N").pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[1]/td[2]")).shouldHave(text("Dan Vu"));           //Name
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")).shouldHave(text("danvu@ya.ru"));     //mail
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[3]/td[2]")).shouldHave(text("Other"));           //Gender
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[4]/td[2]")).shouldHave(text("1234567890"));      //mobile
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[5]/td[2]")).shouldHave(text("14 April,1975"));   // Birth
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[6]/td[2]")).shouldHave(text("Hindi"));   //Subjects
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[7]/td[2]")).shouldHave(text("Sports, Reading, Music"));  //Hobbies
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[8]/td[2]")).shouldHave(text("ejik.jpg")); // Picture
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[9]/td[2]")).shouldHave(text("test")); //address
        $(By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[10]/td[2]")).shouldHave(text("NCR Gurgaon")); //state and city

                    }
    }
