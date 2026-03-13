package com.sofkianos.stepdefinitions;

import com.sofkianos.questions.ElUsuarioNoExiste;
import com.sofkianos.tasks.ActualizarDatosDeContacto;
import com.sofkianos.tasks.ConsultarUsuario;
import com.sofkianos.tasks.EliminarUsuario;
import com.sofkianos.tasks.RegistrarUsuario;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.model.environment.ConfiguredEnvironment;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class UserStepDefinitions {

    private static final String NOMBRE_ACTOR = "Administrador de usuarios";

    private Actor actor;
    private UserData userData;

    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled(NOMBRE_ACTOR);
        actor.can(CallAnApi.at(obtenerBaseUrl()));
    }

    @Given("que el area administrativa requiere registrar un usuario {string}, nombres {string}, apellidos {string}, correo {string}, clave {string} y telefono {string}")
    public void definirInformacionDelUsuario(String username, String firstName, String lastName, String email, String password,
                                             String phone) {
        userData = new UserData(username, firstName, lastName, email, password, phone);
    }

    @When("el usuario queda registrado en el sistema con su perfil")
    public void registrarUsuarioConSuPerfil() {
        actor.attemptsTo(
                RegistrarUsuario.conDatos(
                        userData.username(),
                        userData.firstName(),
                        userData.lastName(),
                        userData.email(),
                        userData.password(),
                        userData.phone()
                )
        );
    }

    @And("se verifica la informacion del usuario registrado mediante su nombre {string}")
    public void verificarInformacionDelUsuarioRegistrado(String username) {
        actor.attemptsTo(ConsultarUsuario.conNombre(username));
    }

    @And("se actualizan sus datos de contacto a correo {string} y telefono {string}")
    public void actualizarDatosDeContactoDelUsuario(String updatedEmail, String updatedPhone) {
        actor.attemptsTo(
                ActualizarDatosDeContacto.delUsuario(
                        userData.username(),
                        userData.firstName(),
                        userData.lastName(),
                        updatedEmail,
                        userData.password(),
                        updatedPhone
                )
        );
    }

    @And("se elimina definitivamente el registro del usuario {string}")
    public void eliminarDefinitivamenteElRegistroDelUsuario(String username) {
        actor.attemptsTo(EliminarUsuario.conNombre(username));
    }

    @Then("el usuario {string} ya no se encuentra disponible para su gestion en el sistema")
    public void validarQueElUsuarioYaNoExiste(String username) {
        actor.should(GivenWhenThen.seeThat(ElUsuarioNoExiste.conNombre(username)));
    }

    private String obtenerBaseUrl() {
        String baseUrl = EnvironmentSpecificConfiguration
                .from(ConfiguredEnvironment.getEnvironmentVariables())
                .getProperty("restapi.baseurl");

        if (baseUrl == null || baseUrl.isBlank()) {
            throw new IllegalStateException("No se encontro la propiedad restapi.baseurl en la configuracion de Serenity");
        }

        return baseUrl;
    }

    private record UserData(String username, String firstName, String lastName, String email, String password,
                            String phone) {
    }
}