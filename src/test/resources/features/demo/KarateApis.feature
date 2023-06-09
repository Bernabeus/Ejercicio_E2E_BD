@REQ_PQBP-556 @karate @Agente2
Feature: Pruebas usando Karate Framework para llar a APIs

  @id:1 @TCS @ConsulContacto
  Scenario: T-API-PQBP-556-CA04 - Consulta contacto transaccional WSClientes0007
    * header authorization = 'Basic YmpqYXJhOnBpY2hpbmNoYTE='
    * header content-type = 'application/json'
    Given url 'https://api-test.pichincha.com/tcs/WSClientes0007'
    And def user = read('classpath:../data/demo/consultaContactoTransaccionalData.json')
    And request user
    When method POST
    Then status 200
    And print response
    And match response.ConsultarContactoTransaccional01Response.error.mensajeNegocio contains 'Transaccion exitosa.'

  @id:2 @ConsultaIntentos
  Scenario: T-API-PQBP-556-CA05 - Consulta Intentos
    * header content-type = 'application/json'
    Given url 'https://app-security-username-attempts-dot-pmovil-app-test.ue.r.appspot.com/app/security/biometric/identification/attempts/v1'
    And def user = read('classpath:../data/demo/BMconsultaIntentosUsuarioData.json')
    And request user
    When method POST
    Then status 201
    And print response