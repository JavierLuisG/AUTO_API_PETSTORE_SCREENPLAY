package com.sofkianos.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public final class EliminarUsuario implements Task {

    private final String username;

    private EliminarUsuario(String username) {
        this.username = username;
    }

    public static EliminarUsuario conNombre(String username) {
        return new EliminarUsuario(username);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // DELETE explícito sobre el actor
        actor.attemptsTo(
                Delete.from("/user/" + username)
        );

        // Verificar que el DELETE fue aceptado (200)
        int status = LastResponse.received().answeredBy(actor).statusCode();
        if (status != 200) {
            throw new IllegalStateException(
                    "DELETE fallido para '" + username + "'. Status: " + status
            );
        }

        // Espera: la API pública de PetStore procesa eliminaciones con delay
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}