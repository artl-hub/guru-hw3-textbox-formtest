package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPageObjectTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Ivanov")
                .setEmail("art@artem.com")
                .setGender("Other")
                .setuserNumber("\"1234567890\"")
                .setDateOfBirth("30","July","2008")
        ;

//        Date

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
//        $(".table-responsive").shouldHave(text("Alex"));
//        $(".table-responsive").shouldHave(text("Ivanov"));
//        $(".table-responsive").shouldHave(text("art@artem.com"));

        registrationPage.checkResult("Sutdent Name", "Alex Ivanov")
                .checkResult("Student Email", "art@artem.com" );


        $(".table-responsive").shouldHave(text("Other"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("30 July,2008"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("1.png"));
        $(".table-responsive").shouldHave(text("Bohnsdor 56"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));

    }
}
