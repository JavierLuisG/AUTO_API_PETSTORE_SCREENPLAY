package com.sofkianos.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

public final class RegistrarUsuario {

    private RegistrarUsuario() {
    }

    public static Task conDatos(String username, String firstName, String lastName, String email, String password,
                                String phone) {
        return Task.where("{0} registra un nuevo usuario",
                Post.to("/user").with(request -> request.body(Map.of(
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