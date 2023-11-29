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
        $("#currentAddress").setValue("Street 56");

//        Select State
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

//        Select City
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

//        Check



        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));


        registrationPage.checkAppearedTable()
                .checkHeaderTextOfTable("Thanks for submitting the form")
                .checkResult("Sutdent Name", "Alex Ivanov")
                .checkResult("Student Email", "art@artem.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "1.png")
                .checkResult("Address", "Street 56")
                .checkResult("State and City", "NCR Delhi");
    }
}
