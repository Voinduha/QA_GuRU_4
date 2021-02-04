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
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Dan");
        $("#lastName").setValue("Vu");
        $("#userEmail").setValue("danvu@ya.ru");

        $("label[for='gender-radio-3']").click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1975");
        $("[aria-label='Choose Monday, April 14th, 1975']").click();

        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("label[for='hobbies-checkbox-3']").click();

        File file = new File("src/test/resources/ejik.jpg");
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("test");
        $("#react-select-3-input").setValue("N").pressEnter();
        $("#react-select-4-input").setValue("N").pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//div[@class='modal-content']").shouldHave(text("Dan Vu"));


        $x("//div[@class='table-responsive']").shouldHave(text("danvu@ya.ru"));
        $x("//div[@class='table-responsive']").shouldHave(text("Other"));
        $x("//div[@class='table-responsive']").shouldHave(text("1234567890"));
        $x("//div[@class='table-responsive']").shouldHave(text("14 April,1975"));
        $x("//div[@class='table-responsive']").shouldHave(text("Hindi"));
        $x("//div[@class='table-responsive']").shouldHave(text("Sports, Reading, Music"));
        $x("//div[@class='table-responsive']").shouldHave(text("ejik.jpg"));
        $x("//div[@class='table-responsive']").shouldHave(text("test"));
        $x("//div[@class='table-responsive']").shouldHave(text("NCR Gurgaon"));

    }
}
