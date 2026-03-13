package com.sofkianos.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.Map;

public final class ActualizarDatosDeContacto {

    private ActualizarDatosDeContacto() {
    }

    public static Task delUsuario(String username, String firstName, String lastName, String email, String password,
                                  String phone) {
        return Task.where("{0} actualiza los datos de contacto del usuario",
                Put.to("/user/" + username).with(request -> request.body(Map.of(
                        "username", username,
                        "firstName", firstName,
                        "lastName", lastName,
                        "email", email,
                        "password", password,
                        "phone", phone
                )))
        );
    }
}