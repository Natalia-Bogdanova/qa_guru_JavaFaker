package com.bogdanova.pages;

import com.bogdanova.pages.components.AddressComponent;
import com.bogdanova.pages.components.CalendarComponent;
import com.bogdanova.pages.components.ResultsTableComponent;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    private final static String TITLE_TEXT = "Student Registration Form";

    //Components
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    private AddressComponent addressComponent = new AddressComponent();

    //Elements
    private SelenideElement
            FirstNameInput = $("#firstName"),
            LastNameInput = $("#lastName"),
            EmailInput = $("#userEmail");

    //Actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        Selenide.zoom(0.6);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
       return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        FirstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        LastNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setEmail(String value) {
        EmailInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setuserNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }
    public RegistrationFormPage setBirthDate(String day,String month,String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);


        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }

    public RegistrationFormPage setAddress(String currentAddress, String state, String city) {
        addressComponent.setAddr(currentAddress, state, city);

        return this;
    }

    public RegistrationFormPage clickSubmit () {
        $("#submit").click();

        return this;
    }

    public RegistrationFormPage clickClose() {
        $("#closeLargeModal").click();

        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsTableComponent.checkVisible();

        return this;
    }
    public RegistrationFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);
        return this;
    }
}
