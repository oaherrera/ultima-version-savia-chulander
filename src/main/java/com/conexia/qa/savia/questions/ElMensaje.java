package com.conexia.qa.savia.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matchers;
import org.junit.Assert;

public class ElMensaje implements Question<Boolean> {

    private String mensajeArcual;
    private String mesajeEsperado;
    private String match;

    public ElMensaje(String mensajeArcual, String mesajeEsperado, String match) {
        this.mensajeArcual = mensajeArcual;
        this.mesajeEsperado = mesajeEsperado;
        this.match = match;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        switch (match) {
            case "Contiene":
                Assert.assertTrue("El mensaje '" + mensajeArcual + "' no contiene '" + mesajeEsperado + "'", mensajeArcual.contains(mesajeEsperado));
        }
        return true;
    }

    public static ElMensaje contiene(String mensajeActual, String mensajeEsperado) {
        return new ElMensaje(mensajeActual, mensajeEsperado, "Contiene");
    }
}
