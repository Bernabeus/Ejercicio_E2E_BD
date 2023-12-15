package com.pichincha.automationtest.glue.demo;


import com.pichincha.automationtest.model.pruebae2e.User;
import com.pichincha.automationtest.tasks.prueba2e2.HousingCalculation;
import com.pichincha.automationtest.ui.pruebae2e.PageCalculate;
import com.pichincha.automationtest.util.EnvironmentConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static com.pichincha.automationtest.ui.pruebae2e.PageCalculate.RESULT_FEE;
import static com.pichincha.automationtest.ui.pruebae2e.PageCalculate.RESULT_EXPENSES;
import static com.pichincha.automationtest.ui.pruebae2e.PageCalculate.RESULT_RATE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@Slf4j
public class SerenityBDDWebGlue {

    EnvironmentConfig environmentConfig = new EnvironmentConfig();


    @Given("que el usuario {actor} ingresa a la calculadora online")
    public void queElActorIngresaALaCalculadoraOnline(Actor actor) {
        givenThat(actor).attemptsTo(
                Open.browserOn().the(PageCalculate.class)
        );
    }

    @When("el selecciona el producto {string} e ingresa sus datos para el calculo {string}, {string}, {string} y {string}")
    public void ySeSeleccionaElProductoConLosDatosDeCalculoY(String product, String cost, String term, String year, String amortization) {
        User dataUser = new User(product, cost, term, year, amortization);

        when(theActorInTheSpotlight()).wasAbleTo(
                HousingCalculation.withInformation(dataUser)
        );
    }

    @Then("se deberia mostrar los resultados del calculo {string}, {string}, {string}")
    public void seDeberiaMostrarElResultadoDelCalculo(String fee, String expenses, String rate) {

        then(theActorInTheSpotlight()).should(
                seeThat(the(RESULT_FEE), isPresent()),
                seeThat(the(RESULT_FEE), containsText(fee)),
                seeThat(the(RESULT_EXPENSES), isPresent()),
                seeThat(the(RESULT_EXPENSES), containsText(expenses)),
                seeThat(the(RESULT_RATE), isPresent()),
                seeThat(the(RESULT_RATE), containsText(rate))
        );


    }


}