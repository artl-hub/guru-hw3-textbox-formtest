package pages.components;

import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultComponent {

    public void checkResult(String key, String value) {
        $("selector").$(byText(key)).parent()
                .shouldHave(text(value));
    }

//    public void   checkAppearedTable(){
//        $(".modal-dialog").should(appear);
//
//
//    }

}
