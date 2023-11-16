import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {
    @BeforeAll
    static void beforAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; //default 4000
    }


    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        String userName = "Alex";

        $("#firstName").setValue(userName);
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("art@artem.com");

//        Removing Nuisance Elements
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('#adplus-anchor').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        //     radio-button
        $("#genterWrapper").$(byText("Other")).click();

        //      userNumber
        $("#userNumber").setValue("1234567890");

//        Date
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

//        Subjects
        $("#subjectsInput").setValue("Math").pressEnter();

//        Hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();

//        Select picture (upload)
        $("#uploadPicture").uploadFromClasspath("img/1.png");

//        Address
        $("#currentAddress").setValue("Bohnsdor 56");

//        Select State
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

//        Select City
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

//        Check
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text("Ivanov"), text("art@artem.com"),
                text("Other"), text("1234567890"), text("30 July,2008"), text("Maths"), text("Sports"),
                text("1.png"), text("Bohnsdor 56"), text("NCR Delhi"));


    }
}
