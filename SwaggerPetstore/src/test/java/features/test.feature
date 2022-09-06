Feature: Swagger Petstore con Rest Assured API
  Como QA quiero testear la API para despues validarla

  Scenario: Agregar una mascota realizando un POST al path /v2/pet
    When Realizo el request POST de una nueva mascota
    Then Valido el response body del POST
    And Valido el Status code esperado del POST
    And Valido el Schema del response del POST

  Scenario: Realizar un GET /v2/pet/{petId} para obtener una mascota existente.
    When Realizo el request GET de una mascota existente
    Then Valido el response body del GET
    And Valido el Status code esperado del GET
    And Valido el Schema del response del GET

  Scenario: Modificar una mascota existente mediante PUT al path /v2/pet.
    When Realizo el request PUT para modificar una mascota existente
    Then Valido el response body del PUT
    And Valido el Status code esperado del PUT
    And Valido el Schema del response del PUT
