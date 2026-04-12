package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.components.CalendarComponent;
import pages.components.CheckResponseComponent;
import pages.components.StateAndCityComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {
    private final String pageUrl = "/automation-practice-form",
            errorPropertyName = "border-color",
            errorPropertyValue = "rgb(220, 53, 69)";
    private final SelenideElement firstNameInput = $(byId("firstName")),
            lastNameInput = $(byId("lastName")),
            userEmailInput = $(byId("userEmail")),
            genderInput = $(byId("genterWrapper")),
            userNumberInput = $(byId("userNumber")),
            dateOfBirthInput = $(byId("dateOfBirthInput")),
            subjectsInput = $(byId("subjectsInput")),
            hobbiesInput = $(byId("hobbiesWrapper")),
            pictureInput = $(byId("uploadPicture")),
            currentAddressTextArea = $("textarea[id=currentAddress]"),
            submitButton = $(byId("submit")),
            responseTable = $(byClassName("table-responsive")),
            maleRadio = $(by("for", "gender-radio-1")),
            femaleRadio = $(by("for", "gender-radio-2")),
            otherRadio = $(by("for", "gender-radio-3"));

    public PracticeFormPage openPage() {
        open(this.pageUrl);
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public PracticeFormPage clickGender(String value) {
        genderInput.$(byValue(value)).click();
        return this;
    }

    public PracticeFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String year, String month, String day) {
        dateOfBirthInput.click();
        CalendarComponent.set(year, month, day);
        return this;
    }

    public PracticeFormPage setSubjects(String value) {
        subjectsInput.setValue(value).sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage clickHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String value) {
        currentAddressTextArea.setValue(value);
        return this;
    }

    public PracticeFormPage setStateAndCity(String state, String city) {
        StateAndCityComponent.set(state, city);
        return this;
    }

    public PracticeFormPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public PracticeFormPage checkResponseTableOnAppearance() {
        responseTable.should(appear);
        return this;
    }

    public PracticeFormPage checkResponseTableOnCorrectData(String... params) {
        CheckResponseComponent.checkResponseOnCorrectData(responseTable.$("tbody"), params);
        return this;
    }

    public PracticeFormPage checkRequiredElementsOnEmptyData() {
        firstNameInput.shouldHave(cssValue(errorPropertyName, errorPropertyValue));
        lastNameInput.shouldHave(cssValue(errorPropertyName, errorPropertyValue));
        maleRadio.shouldHave(cssValue(errorPropertyName, errorPropertyValue));
        femaleRadio.shouldHave(cssValue(errorPropertyName, errorPropertyValue));
        otherRadio.shouldHave(cssValue(errorPropertyName, errorPropertyValue));
        userNumberInput.shouldHave(cssValue(errorPropertyName, errorPropertyValue));
        return this;
    }

    public PracticeFormPage checkUserEmailOnIncorrectData() {
        userEmailInput.shouldHave(cssValue(errorPropertyName, errorPropertyValue));
        return this;
    }

    public PracticeFormPage checkUserNumberOnIncorrectData() {
        userNumberInput.shouldHave(cssValue(errorPropertyName, errorPropertyValue));
        return this;
    }
}
