package com.bogdanova.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.bogdanova.utils.RandomUtils.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FakerTests {
    Faker faker = new Faker();
    String firstName = faker.name().firstName(); // Emory
    String lastName = faker.name().lastName(); // Barton
    String email = "";
    String currentAddress = faker.address().streetAddress();
    String phone = "";
    String day = "16";
    String month = "June";
    String year = "1951";

    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("practice-form-wrapper").shouldHave(text("Student Registration Form"));
        Selenide.zoom(0.9);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--selected").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFromClasspath("3.jpg");
        $("#currentAddress").setValue(currentAddress);
        $(byText("Select State")).click();
        $(byText("Haryana")).click();
        $(byText("Select City")).click();
        $(byText("Panipat")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive table").shouldHave(text(firstName), text(lastName),
                text(email), text(day + " " + month + "," + year),
//                text("Pirogkov@gmail.com"),
                text("Male"),
                text(phone),
//                text("16 June,1951"),
                text("Maths"),
                text("Reading"),
                text("3.jpg"),
                text("red light, Geeta Colony"),
                text("Haryana Panipat"));
        $("#closeLargeModal").click();
    }
}