package com.sofkianos.tasks;

import com.sofkianos.models.User;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

public final class ActualizarDatosDeContacto {

    private ActualizarDatosDeContacto() {
    }

        public static Task delUsuario(User user) {
        return Task.where("{0} actualiza los datos de contacto del usuario",
                                Put.to("/user/" + user.username()).with(request -> request.body(user))
        );
    }
}