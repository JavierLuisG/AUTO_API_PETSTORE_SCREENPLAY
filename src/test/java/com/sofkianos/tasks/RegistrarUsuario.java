package com.sofkianos.tasks;

import com.sofkianos.models.User;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public final class RegistrarUsuario {

    private RegistrarUsuario() {
    }

        public static Task conDatos(User user) {
        return Task.where("{0} registra un nuevo usuario",
                                Post.to("/user").with(request -> request.body(user))
        );
    }
}