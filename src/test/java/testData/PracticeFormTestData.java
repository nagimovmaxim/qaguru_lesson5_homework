package testData;

import testUtils.Creator;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class PracticeFormTestData {
    private LinkedHashMap<String, String> correctFormData = new LinkedHashMap<>();
    private LinkedHashMap<String, String> errorMarkers = new LinkedHashMap<>();
    private final Set<Integer> numFieldsForShortSubmit = new HashSet<>();
    private String userEmailIncorrect;
    private String userNumberIncorrect;


    public PracticeFormTestData() throws Exception {
        userEmailIncorrect = "qwert";
        userNumberIncorrect = "qwert";

        numFieldsForShortSubmit.addAll(Set.of(1, 3, 4));

        correctFormData.put("Student Name", Creator.getRandomLetterString(10) + " " + Creator.getRandomLetterString(10));
        correctFormData.put("Student Email", Creator.getRandomLetterString(10) + "@" + Creator.getRandomLetterString(5) + ".com");
        correctFormData.put("Gender", "Other");
        correctFormData.put("Mobile", Creator.getRandomNumericString(10));
        correctFormData.put("Date of Birth", "31 December,1999");
        correctFormData.put("Subjects", "Maths");
        correctFormData.put("Hobbies", "Reading");
        correctFormData.put("Picture", "images.jpg");
        correctFormData.put("Address", Creator.getRandomLetterString(50));
        correctFormData.put("State and City", "NCR Delhi");

        errorMarkers.put("firstName", "border-color;rgb(220, 53, 69)");
        errorMarkers.put("lastName", "border-color;rgb(220, 53, 69)");
        errorMarkers.put("maleRadioBorder", "border-color;rgb(220, 53, 69)");
        errorMarkers.put("maleRadio", "color;rgba(220, 53, 69, 1)");
        errorMarkers.put("femaleRadioBorder", "border-color;rgb(220, 53, 69)");
        errorMarkers.put("femaleRadio", "color;rgba(220, 53, 69, 1)");
        errorMarkers.put("otherRadioBorder", "border-color;rgb(220, 53, 69)");
        errorMarkers.put("otherRadio", "color;rgba(220, 53, 69, 1)");
        errorMarkers.put("userNumber", "border-color;rgb(220, 53, 69)");
        errorMarkers.put("userEmail", "border-color;rgb(220, 53, 69)");
    }

    public String getFirstName() {
        return correctFormData.get("Student Name").split(" ")[0];
    }

    public String getLastName() {
        return correctFormData.get("Student Name").split(" ")[1];
    }

    public String getUserEmail() {
        return correctFormData.get("Student Email");
    }

    public String getGender() {
        return correctFormData.get("Gender");
    }

    public String getUserNumber() {
        return correctFormData.get("Mobile");
    }

    public String getDateOfBirth() {
        return correctFormData.get("Date of Birth");
    }

    public String getSubjects() {
        return correctFormData.get("Subjects");
    }

    public String getHobbies() {
        return correctFormData.get("Hobbies");
    }

    public String getPicture() {
        return correctFormData.get("Picture");
    }

    public String getCurrentAddress() {
        return correctFormData.get("Address");
    }

    public String getStateAndCity() {
        return correctFormData.get("State and City");
    }

    public LinkedHashMap<String, String> getCorrectFormData() {
        return correctFormData;
    }

    public Set<Integer> getNumFieldsForShortSubmit() {
        return numFieldsForShortSubmit;
    }

    public String getFirstNameErrorMarker() {
        return errorMarkers.get("firstName");
    }

    public String getLastNameErrorMarker() {
        return errorMarkers.get("lastName");
    }

    public String getMaleRadioBorderErrorMarker() {
        return errorMarkers.get("maleRadioBorder");
    }

    public String getMaleRadioErrorMarker() {
        return errorMarkers.get("maleRadio");
    }

    public String getFemaleRadioBorderErrorMarker() {
        return errorMarkers.get("femaleRadioBorder");
    }

    public String getFemaleRadioErrorMarker() {
        return errorMarkers.get("femaleRadio");
    }

    public String getOtherRadioBorderErrorMarker() {
        return errorMarkers.get("otherRadioBorder");
    }

    public String getOtherRadioErrorMarker() {
        return errorMarkers.get("otherRadio");
    }

    public String getUserEmailErrorMarker() {
        return errorMarkers.get("userEmail");
    }

    public String getUserNumberErrorMarker() {
        return errorMarkers.get("userNumber");
    }

    public String getUserEmailIncorrect() {
        return userEmailIncorrect;
    }

    public String getUserNumberIncorrect() {
        return userNumberIncorrect;
    }
}
