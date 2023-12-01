package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormWithFakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void fillFormTest() {


        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Ivanov")
                .setEmail("art@artem.com")
                .setGender("Other")
                .setuserNumber("1234567890")
                .setDateOfBirth("30","July","2008")
                .setSubject("Math")
                .setHobbi("Sports")
                .selectFile("img/1.png")
                .setAddress("Street 56")
                .selectState("NCR")
                .selectCity("Delhi")
                .submitForm();

        registrationPage.checkAppearedTable()
                .checkHeaderTextOfTable("Thanks for submitting the form")
                .checkResult("Student Name", "Alex Ivanov")
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
    @Test
    void minimumfillFomTest () {

            registrationPage.openPage()
                    .setFirstName("Alex")
                    .setLastName("Ivanov")
                    .setGender("Other")
                    .setuserNumber("1234567890")
                    .setDateOfBirth("30","July","2008")
                    .submitForm();
   ;

            registrationPage.checkAppearedTable()
                    .checkHeaderTextOfTable("Thanks for submitting the form")
                    .checkResult("Student Name", "Alex Ivanov")
                    .checkResult("Gender", "Other")
                    .checkResult("Mobile", "1234567890")
                    .checkResult("Date of Birth", "30 July,2008");
        }

    @Test
    void emptyFormNegativeTest() {


        registrationPage
                .openPage()
                .submitForm()
                .checkEmptyFormNotSended();


    }
}



