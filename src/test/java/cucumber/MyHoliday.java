package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MyHoliday {

    @Given("I live in Moscow")
    public void i_live(){
        System.out.println("I live in Moscow");
    }

    @And("I want to go on a holiday")
    public void iWantToGoOnAHoliday() {
        System.out.println("I want to go on a holiday");
    }

    @And("We are 10 Adult")
    public void weAre10Adult(){
        System.out.println("We are 10 Adult");
    }

    @And("We want to book from 2021 to 2022")
    public void bookFromTo(){
        System.out.println("We want to book from 2021 to 2022");
    }

    @And("I go to travel Agent")
    public void iGoToAgent(){
        System.out.println("I go to travel Agent");
    }

    @Then("he should be able to book in budget od $10000")
    public void bookingBudget(){
        System.out.println("he/she should be able to book in budget od $10000");
    }

    @And("He should provide option to cancel")
    public void heShouldProvideOptionToCancel() {
        System.out.println("He should provide option to cancel");
    }
    @But("He should not ask for advance")
    public void shouldNotAskAdvance(){
        System.out.println("He should not ask for advance");
    }

    @And("We are {int} Adults")
    public void weAreAdults(int arg0) {
        System.out.println("We are "+arg0 + " adults");
    }
}
