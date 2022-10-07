package com.bogdanova.tests;

import com.bogdanova.pages.RegistrationFormPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class TestPageObjectsTestMaxForm {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Vadim")
                .setLastName("Pirogkov")
                .setEmail("Pirogkov@gmail.com")
                .setGender("Other")
                .setuserNumber("9051112233")
                .setBirthDate("16","June", "1951")
                .setSubjects("Maths")
                .setHobbies("Reading")
                .setPicture("3.jpg")
                .setAddress("red light, Geeta Colony", "Haryana", "Panipat")
                .clickSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Vadim Pirogkov")
                .checkResult("Student Email", "Pirogkov@gmail.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "9051112233")
                .checkResult("Date of Birth", "16 June,1951")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "3.jpg")
                .checkResult("Address", "red light, Geeta Colony")
                .checkResult("State and City", "Haryana Panipat")
                .clickClose();
    }
}
