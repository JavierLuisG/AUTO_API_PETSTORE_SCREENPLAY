package com.sofkianos.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public final class ElUsuarioFueEliminado implements Question<Boolean> {

    private final String username;

    private ElUsuarioFueEliminado(String username) {
        this.username = username;
    }

    public static ElUsuarioFueEliminado conNombre(String username) {
        return new ElUsuarioFueEliminado(username);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LastResponse.received().answeredBy(actor).statusCode() == 200;
    }

    @Override
    public String toString() {
        return "confirmacion de eliminacion del usuario " + username;
    }
}