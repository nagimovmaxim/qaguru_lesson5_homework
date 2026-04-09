package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import testData.PracticeFormTestData;

public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    PracticeFormTestData testData;

    @BeforeEach
    @Description("Параметризация тестовых данных")
    void parametrizationTestData() throws Exception {
        testData = new PracticeFormTestData();
    }

    @Test
    @Description("Негативная проверка на неправильное заполенние телефона")
    void negativePhoneErrorPracticeFormTest() {
        practiceFormPage.openPage()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .clickGender(testData.getGender())
                .setUserNumber(testData.getUserNumberIncorrect())
                .clickSubmit()
                .checkUserNumberOnIncorrectData(testData.getUserNumberErrorMarker());
    }

    @Test
    @Description("Негативная проверка на неправильное заполнение почты")
    void negativeMailErrorPracticeFormTest() {
        practiceFormPage.openPage()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .clickGender(testData.getGender())
                .setUserNumber(testData.getUserNumber())
                .setUserEmail(testData.getUserEmailIncorrect())
                .clickSubmit()
                .checkUserEmailOnIncorrectData(testData.getUserEmailErrorMarker());
    }

    @Test
    @Description("Негативная проверка на незаполнение всех обязательных полей")
    void negativeShortSubmitPracticeFormTest() {
        practiceFormPage.openPage()
                .clickSubmit()
                .checkFirstNameOnEmptyData(testData.getFirstNameErrorMarker())
                .checkLastNameOnEmptyData(testData.getLastNameErrorMarker())
                .checkMaleRadioBorderOnEmptyData(testData.getMaleRadioBorderErrorMarker())
                .checkMaleRadioOnEmptyData(testData.getMaleRadioErrorMarker())
                .checkFemaleRadioBorderOnEmptyData(testData.getFemaleRadioBorderErrorMarker())
                .checkFemaleRadioOnEmptyData(testData.getFemaleRadioErrorMarker())
                .checkOtherRadioBorderOnEmptyData(testData.getOtherRadioBorderErrorMarker())
                .checkOtherRadioOnEmptyData(testData.getOtherRadioErrorMarker())
                .checkUserNumberOnEmptyData(testData.getUserNumberErrorMarker());
    }

    @Test
    @Description("Позитивно проверяются только обязательные поля формы")
    void positiveShortSubmitPracticeFormTest() {
        practiceFormPage.openPage()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .clickGender(testData.getGender())
                .setUserNumber(testData.getUserNumber())
                .clickSubmit()
                .checkResponseTableOnAppearance()
                .checkResponseTableOnShortCorrectData(testData.getCorrectFormData(), testData.getNumFieldsForShortSubmit());

    }

    @Test
    @Description("Позитивно проверяются все поля формы, а не только обязательные")
    void positiveFullSubmitPracticeFormTest() {
        practiceFormPage.openPage()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .setUserEmail(testData.getUserEmail())
                .clickGender(testData.getGender())
                .setUserNumber(testData.getUserNumber())
                .setDateOfBirth(testData.getDateOfBirth())
                .setSubjects(testData.getSubjects())
                .clickHobbies(testData.getHobbies())
                .uploadPicture(testData.getPicture())
                .setCurrentAddress(testData.getCurrentAddress())
                .setStateAndCity(testData.getStateAndCity())
                .clickSubmit()
                .checkResponseTableOnAppearance()
                .checkResponseTableOnCorrectData(testData.getCorrectFormData());
    }
}