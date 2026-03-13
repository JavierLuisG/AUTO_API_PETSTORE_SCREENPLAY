package com.sofkianos.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public final class ConsultarUsuario {

    private ConsultarUsuario() {
    }

    public static Task conNombre(String username) {
        return Task.where("{0} consulta la informacion del usuario registrado",
                Get.resource("/user/" + username)
        );
    }
}