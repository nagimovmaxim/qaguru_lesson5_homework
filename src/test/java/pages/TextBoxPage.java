package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    private final String pageUrl = "/text-box";
    private final SelenideElement userNameInput = $(byId("userName"));
    private final SelenideElement userEmailInput = $(byId("userEmail"));
    private final Map.Entry<String, String> userEmailBadProperty = new AbstractMap.SimpleImmutableEntry<>("border-color", "rgb(255, 0, 0)");
    private final SelenideElement currentAddressTextArea = $(byId("currentAddress"));
    private final SelenideElement permanentAddressTextArea = $(byId("permanentAddress"));
    private final SelenideElement submitButton = $(byId("submit"));
    private final SelenideElement outputDiv = $(byId("output"));

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

    public TextBoxPage checkOutputOnCorrectData(LinkedHashMap<String, String> correctFormData) {
        correctFormData.keySet().forEach(x -> {
            outputDiv.$(byId(x)).shouldHave(text(correctFormData.get(x)));
        });
        return this;
    }

    public TextBoxPage checkEmailOnError() {
        userEmailInput.shouldHave(cssValue(userEmailBadProperty.getKey(), userEmailBadProperty.getValue()));
        return this;
    }
}
