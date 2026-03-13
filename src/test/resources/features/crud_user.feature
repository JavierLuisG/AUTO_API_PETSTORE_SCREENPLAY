Feature: Gestion del ciclo de vida de usuarios en PetStore

  Scenario: Administrar un usuario durante todo su ciclo de vida
    Given que se requiere gestionar la informacion de un usuario en la tienda
    When se registra un nuevo usuario
    And se consulta la informacion del usuario creado
    And se actualizan los datos del usuario
    And se elimina definitivamente el usuario
    Then el usuario completa su ciclo de vida correctamente en el sistema