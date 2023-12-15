package com.pichincha.automationtest.ui.pruebae2e;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:webdriver.base.url.calculadora")
public class PageCalculate extends PageObject {

    public static final Target PUBLIC_HOUSING = Target.the("'Vivienda de interés público y social'").located(By.id("setVipVisProduct"));

    public static final Target COST = Target.the("'¿Cuánto cuesta la vivienda que deseas comprar?'").located(By.id("home-price-calculator"));

    public static final Target TERM = Target.the("'¿Cuánto dinero necesitas que te prestemos?'").located(By.id("requested-amount-calculator"));

    public static final Target YEAR = Target.the("'¿En cuánto tiempo deseas pagar el préstamo?'").located(By.id("loan-term-years-calculator"));

    public static final Target ARMOTIZATION = Target.the("'Alemán'").located(By.xpath("//*[@id=\"setGermanAmortization\"]/div/div[1]/div[1]"));

    public static final Target CALCULATE = Target.the("'Calcular'").located(By.id("calculateButton"));

    public static final Target RESULT_FEE = Target.the("'Cuota mensual aproximada'").locatedBy("//*[@id=\"results\"]/div[2]/pichincha-grid/div/pichincha-grid[1]/div/div/div/div[3]/pichincha-grid/div/pichincha-grid[2]/div/pichincha-typography");

    public static final Target RESULT_EXPENSES = Target.the("'Tasa de interés'").locatedBy("/html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/pichincha-grid/div/pichincha-grid[2]/div/pichincha-grid/div/pichincha-grid[1]/div/div[2]/div/div/div[5]/div[2]/pichincha-typography");

    public static final Target RESULT_RATE = Target.the("'Gastos de avalúo'").locatedBy("/html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/pichincha-grid/div/pichincha-grid[2]/div/pichincha-grid/div/pichincha-grid[2]/div/div[2]/div/div/pichincha-grid[2]/div/pichincha-grid[3]/div/div/pichincha-typography");




    //public static final Target RESULTS = Target.the("Cuota mensual aproximada").


}
