package com.sofkianos.questions;

import com.sofkianos.tasks.ConsultarUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public final class ElUsuarioNoExiste implements Question<Boolean> {

    private final String username;

    private ElUsuarioNoExiste(String username) {
        this.username = username;
    }

    public static ElUsuarioNoExiste conNombre(String username) {
        return new ElUsuarioNoExiste(username);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(ConsultarUsuario.conNombre(username));
        return LastResponse.received().answeredBy(actor).statusCode() == 404;
    }
}