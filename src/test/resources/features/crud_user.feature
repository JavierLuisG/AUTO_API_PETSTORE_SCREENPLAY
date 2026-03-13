Feature: Gestion administrativa del ciclo de vida de usuarios en PetStore

  Scenario Outline: Administrar de principio a fin el registro de un usuario
    Given que el area administrativa requiere registrar un usuario "<username>", nombres "<firstName>", apellidos "<lastName>", correo "<email>", clave "<password>" y telefono "<phone>"
    When el usuario queda registrado en el sistema con su perfil
    And se verifica la informacion del usuario registrado mediante su nombre "<username>"
    And se actualizan sus datos de contacto a correo "<updatedEmail>" y telefono "<updatedPhone>"
    When se elimina definitivamente el registro del usuario "<username>"
    Then el sistema confirma que el usuario "<username>" fue eliminado exitosamente

    Examples:
      | username   | firstName | lastName | email                  | password   | phone      | updatedEmail                 | updatedPhone |
      | userpet001 | Ana       | Gomez    | ana.gomez@petstore.com | PetStore01 | 3001234567 | ana.actualizada@petstore.com | 3007654321   |