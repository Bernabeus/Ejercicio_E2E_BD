@REQ_PQBP-511 @SerenityBDDWeb
Feature:  Ejercicio de prueba practico E2E

  @id:1 @PruebaE2E
  Scenario Outline: T-E2E-PQBP-551-CA01 - Calculo para compra  de vivienda
    Given que el usuario juan ingresa a la calculadora online
    When el selecciona el producto "<product>" e ingresa sus datos para el calculo "<cost>", "<term>", "<year>" y "<amortization>"
    Then se deberia mostrar los resultados del calculo "<fee>", "<expenses>", "<rate>"
    Examples:
      | @externaldata@pruebae2e/DataCalculoVivienda.xlsx..calculo |