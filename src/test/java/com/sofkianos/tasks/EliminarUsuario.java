package com.sofkianos.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public final class EliminarUsuario {

    private EliminarUsuario() {
    }

    public static Task conNombre(String username) {
        return Task.where("{0} elimina definitivamente el registro del usuario",
                Delete.from("/user/" + username)
        );
    }
}