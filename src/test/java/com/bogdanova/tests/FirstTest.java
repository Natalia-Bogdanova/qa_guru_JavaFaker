package com.bogdanova.tests;

        import com.codeborne.selenide.Condition;
        import com.codeborne.selenide.Configuration;
        import com.codeborne.selenide.Selenide;
        import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import javax.xml.namespace.QName;

        import static com.bogdanova.tests.TestData.*;
        import static com.codeborne.selenide.Condition.text;
        import static com.codeborne.selenide.Selectors.byText;
        import static com.codeborne.selenide.Selenide.*;

public class FirstTest {

    String firstName = "Vadim";
    String lastName = "Pirogkov";
    String email = "Pirogkov@gmail.com";
    String phone = "9051112233";
    String day = "16";
    String month = "June";
    String year = "1951";

//    String firstName;
//    String lastName;
//    String email;
//    String phone;
//    String day;
//    String month;
//    String year;
//        @BeforeEach
//        void prepareTestData(){
//            String firstName = "Vadim";
//    lastName = "Pirogkov";
//    email = "Pirogkov@gmail.com";
//    phone = "9051112233";
//    day = "16";
//    month = "June";
//    year = "1951";
//        }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        Selenide.zoom(0.9);
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
        $("#currentAddress").setValue("red light, Geeta Colony");
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