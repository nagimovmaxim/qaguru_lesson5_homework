package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.components.CalendarComponent;
import pages.components.StateAndCityComponent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {
    private final String pageUrl = "/automation-practice-form";
    private final SelenideElement firstNameInput = $(byId("firstName"));
    private final SelenideElement lastNameInput = $(byId("lastName"));
    private final SelenideElement userEmailInput = $(byId("userEmail"));
    private final SelenideElement genderInput = $(byId("genterWrapper"));
    private final SelenideElement userNumberInput = $(byId("userNumber"));
    private final SelenideElement dateOfBirthInput = $(byId("dateOfBirthInput"));
    private final SelenideElement subjectsInput = $(byId("subjectsInput"));
    private final SelenideElement hobbiesInput = $(byId("hobbiesWrapper"));
    private final SelenideElement pictureInput = $(byId("uploadPicture"));
    private final SelenideElement currentAddressTextArea = $("textarea[id=currentAddress]");
    private final SelenideElement submitButton = $(byId("submit"));
    private final SelenideElement responseTable = $(byClassName("table-responsive"));
    private final SelenideElement maleRadioBorder = $(byId("gender-radio-1"));
    private final SelenideElement maleRadio = $(by("for", "gender-radio-1"));
    private final SelenideElement femaleRadioBorder = $(byId("gender-radio-2"));
    private final SelenideElement femaleRadio = $(by("for", "gender-radio-2"));
    private final SelenideElement otherRadioBorder = $(byId("gender-radio-3"));
    private final SelenideElement otherRadio = $(by("for", "gender-radio-3"));

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

    public PracticeFormPage setDateOfBirth(String date) {
        String year = date.split(",")[1];
        String month = date.split(",")[0].split(" ")[1];
        String day = date.split(",")[0].split(" ")[0];
        dateOfBirthInput.click();
        new CalendarComponent().set(year, month, day);
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

    public PracticeFormPage setStateAndCity(String value) {
        String state = value.split(" ")[0];
        String city = value.split(" ")[1];
        new StateAndCityComponent().set(state, city);
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

    public PracticeFormPage checkResponseTableOnCorrectData(LinkedHashMap<String, String> correctFormData) {
        responseTable.$("tbody").$$("tr").forEach(x -> {
            x.$$("td").get(1).shouldHave(text(correctFormData.get(x.$$("td").get(0).text())));
        });
        return this;
    }

    public PracticeFormPage checkResponseTableOnShortCorrectData(LinkedHashMap<String, String> correctFormData, Set<Integer> numFieldsForShortSubmit) {
        responseTable.$("tbody").$$("tr").forEach(x -> {
            String key = x.$$("td").get(0).text();
            Integer numField = (new ArrayList<>(correctFormData.keySet())).indexOf(key) + 1;
            if (numFieldsForShortSubmit.contains(numField)) {
                x.$$("td").get(1).shouldHave(text(correctFormData.get(key)));
            }
        });
        return this;
    }

    public PracticeFormPage checkFirstNameOnEmptyData(String value) {
        String propertyName = value.split(";")[0];
        String propertyValue = value.split(";")[1];
        firstNameInput.shouldHave(cssValue(propertyName, propertyValue));
        return this;
    }

    public PracticeFormPage checkLastNameOnEmptyData(String value) {
        String propertyName = value.split(";")[0];
        String propertyValue = value.split(";")[1];
        lastNameInput.shouldHave(cssValue(propertyName, propertyValue));
        return this;
    }

    public PracticeFormPage checkMaleRadioBorderOnEmptyData(String value) {
        String propertyName = value.split(";")[0];
        String propertyValue = value.split(";")[1];
        maleRadioBorder.shouldHave(cssValue(propertyName, propertyValue));
        return this;
    }

    public PracticeFormPage checkMaleRadioOnEmptyData(String value) {
        String propertyName = value.split(";")[0];
        String propertyValue = value.split(";")[1];
        maleRadio.shouldHave(cssValue(propertyName, propertyValue));
        return this;
    }

    public PracticeFormPage checkFemaleRadioBorderOnEmptyData(String value) {
        String propertyName = value.split(";")[0];
        String propertyValue = value.split(";")[1];
        femaleRadioBorder.shouldHave(cssValue(propertyName, propertyValue));
        return this;
    }

    public PracticeFormPage checkFemaleRadioOnEmptyData(String value) {
        String propertyName = value.split(";")[0];
        String propertyValue = value.split(";")[1];
        femaleRadio.shouldHave(cssValue(propertyName, propertyValue));
        return this;
    }

    public PracticeFormPage checkOtherRadioBorderOnEmptyData(String value) {
        String propertyName = value.split(";")[0];
        String propertyValue = value.split(";")[1];
        otherRadioBorder.shouldHave(cssValue(propertyName, propertyValue));
        return this;
    }

    public PracticeFormPage checkOtherRadioOnEmptyData(String value) {
        String propertyName = value.split(";")[0];
        String propertyValue = value.split(";")[1];
        otherRadio.shouldHave(cssValue(propertyName, propertyValue));
        return this;
    }

    public PracticeFormPage checkUserNumberOnEmptyData(String value) {
        String propertyName = value.split(";")[0];
        String propertyValue = value.split(";")[1];
        userNumberInput.shouldHave(cssValue(propertyName, propertyValue));
        return this;
    }

    public PracticeFormPage checkUserEmailOnIncorrectData(String value) {
        String propertyName = value.split(";")[0];
        String propertyValue = value.split(";")[1];
        userEmailInput.shouldHave(cssValue(propertyName, propertyValue));
        return this;
    }

    public PracticeFormPage checkUserNumberOnIncorrectData(String value) {
        String propertyName = value.split(";")[0];
        String propertyValue = value.split(";")[1];
        userNumberInput.shouldHave(cssValue(propertyName, propertyValue));
        return this;
    }
}
