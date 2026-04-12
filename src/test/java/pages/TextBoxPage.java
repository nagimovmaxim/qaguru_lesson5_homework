package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CheckResponseComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    private final String pageUrl = "/text-box",
            errorPropertyName = "border-color",
            errorPropertyValue = "rgb(255, 0, 0)";
    private final SelenideElement userNameInput = $(byId("userName")),
            userEmailInput = $(byId("userEmail")),
            currentAddressTextArea = $(byId("currentAddress")),
            permanentAddressTextArea = $(byId("permanentAddress")),
            submitButton = $(byId("submit")),
            outputDiv = $(byId("output"));

    public TextBoxPage openPage() {
        open(this.pageUrl);
        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressTextArea.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressTextArea.setValue(value);
        return this;
    }

    public TextBoxPage submitFormClick() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkOutputOnCorrectData(String... params) {
        CheckResponseComponent.checkResponseOnCorrectData(outputDiv, params);
        return this;
    }

    public TextBoxPage checkEmailOnError() {
        userEmailInput.shouldHave(cssValue(errorPropertyName, errorPropertyValue));
        return this;
    }
}
