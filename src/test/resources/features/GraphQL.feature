@REQ_PQBP-1706 @GraphQL @karate @Agente1
Feature: GraphQl Test
  @id:1 @ConsultaValidaKarate @embebida
  Scenario: Solicitud GraphQL con query embedida
    * header content-type = 'application/json'
    * json queryEmbebido = { "query": "{ allFilms { totalCount films { title director releaseDate created episodeID }}}"}
    * print queryEmbebido
    Given url 'https://swapi-graphql.netlify.app/.netlify/functions/index'
    And request queryEmbebido
    When method POST
    Then status 200
    And print response

  @id:2 @ConsultaValidaKarate @json
  Scenario: Solicitud GraphQL con query en archivo JSON
    * header content-type = 'application/json'
    * def queryJSON = read('classpath:../data/GraphQL/QueryGraphQL.json')
    * print queryJSON
    Given url 'https://swapi-graphql.netlify.app/.netlify/functions/index'
    And request queryJSON
    When method POST
    Then status 200
    And print response

  @id:3 @ConsultaValidaKarate @jsData
  Scenario: Solicitud GraphQL con query en archivo JS
    * header content-type = 'application/json'
    * json queryJS = call read('classpath:../data/GraphQL/QueryGraphQL.js')
    * print queryJS
    Given url 'https://swapi-graphql.netlify.app/.netlify/functions/index'
    And request queryJS
    When method POST
    Then status 200
    And print response
