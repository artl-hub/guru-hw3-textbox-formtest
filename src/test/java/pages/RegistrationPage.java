package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            modalDialog = $(".modal-dialog")
                    ;
    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultComponent checkResultComponent = new CheckResultComponent();

    public RegistrationPage openPage() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('#adplus-anchor').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        return this;


    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setuserNumber(String value) {
        userNumberInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);


        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        checkResultComponent.checkResult(key,value);

        return this;
    }

    public RegistrationPage  checkAppearedTable(){ // надо как то перенести в ChekResult или удалить эту проверку, посмотреть в видео
        modalDialog.should(appear);

        return this;
    }

    public RegistrationPage checkHeaderTextOfTable(String value){
        $("#example-modal-sizes-title-lg").shouldHave(text(value));
    return this;
    }








}
