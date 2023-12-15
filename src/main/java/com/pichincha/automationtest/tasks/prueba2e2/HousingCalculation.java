package com.pichincha.automationtest.tasks.prueba2e2;

import com.pichincha.automationtest.model.pruebae2e.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static com.pichincha.automationtest.ui.pruebae2e.PageCalculate.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class HousingCalculation  implements Task {

    private final User user;

    public HousingCalculation(User user){
        this.user = user;
    }

    public static HousingCalculation withInformation(User user){
        return instrumented(HousingCalculation.class, user);
    }

    @Step("{0} completa datos de consulta")
    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Click.on(PUBLIC_HOUSING),
                Enter.theValue(user.getCost()).into(COST),
                Enter.theValue(user.getTerm()).into(TERM),
                Enter.theValue(user.getYear()).into(YEAR),
                Click.on(ARMOTIZATION),
                Click.on(CALCULATE)
        );
    }

}
