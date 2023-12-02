package tests;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import java.util.Locale;

import static utils.RandomUtils.getRandomString;

public class PracticeFormWithFakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    @Test
    void fillFormTest() {
        Configuration.holdBrowserOpen = true;
        Faker faker = new Faker(new Locale("de"));
        //
//
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                streetAddress = faker.address().streetAddress(),
                name = firstName + " " + lastName,
                gender = faker.options().option("Male", "Female", "Other"),
                phoneNumber = faker.phoneNumber().subscriberNumber(10);//







        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setuserNumber(phoneNumber)
                .setDateOfBirth("30","July","2008")
                .setSubject("Math")
                .setHobbi("Sports")
                .selectFile("img/1.png")
                .setAddress(streetAddress)
                .selectState("NCR")
                .selectCity("Delhi")
                .submitForm();

        registrationPage.checkAppearedTable()
                .checkHeaderTextOfTable("Thanks for submitting the form")
                .checkResult("Student Name", name)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "1.png")
                .checkResult("Address", streetAddress)
                .checkResult("State and City", "NCR Delhi");
    }
//    @Test
//    void minimumfillFomTest () {
//
//            registrationPage.openPage()
//                    .setFirstName(firstName)
//                    .setLastName("Ivanov")
//                    .setGender("Other")
//                    .setuserNumber("1234567890")
//                    .setDateOfBirth("30","July","2008")
//                    .submitForm();
//   ;
//
//            registrationPage.checkAppearedTable()
//                    .checkHeaderTextOfTable("Thanks for submitting the form")
//                    .checkResult("Student Name", "Alex Ivanov")
//                    .checkResult("Gender", "Other")
//                    .checkResult("Mobile", "1234567890")
//                    .checkResult("Date of Birth", "30 July,2008");
//        }
//
//    @Test
//    void emptyFormNegativeTest() {
//
//
//        registrationPage
//                .openPage()
//                .submitForm()
//                .checkEmptyFormNotSended();
//
//
//    }
}



