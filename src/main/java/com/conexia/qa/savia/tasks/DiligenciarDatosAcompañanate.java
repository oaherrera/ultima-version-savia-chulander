package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.AcompañantePage.CELULAR;
import static com.conexia.qa.savia.user_interfaces.AcompañantePage.NOMBRE;
import static com.conexia.qa.savia.user_interfaces.AcompañantePage.TELEFONO_FIJO;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.EsperarCargando;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class DiligenciarDatosAcompañanate implements Task {

    private String nombre;
    private String telefonoFijo;
    private String celular;

    public DiligenciarDatosAcompañanate(String nombre, String telefonoFijo, String celular) {
        this.nombre = nombre;
        this.telefonoFijo = telefonoFijo;
        this.celular = celular;
    }

    @Step("{0} Llena los datos del acompañante.")
    @Override
    public <T extends Actor> void performAs(T actor) {
        takeScreenshot();
        actor.attemptsTo(
                EsperarCargando.pagina(),
                Enter.theValue(nombre).into(NOMBRE),
                Enter.theValue(telefonoFijo).into(TELEFONO_FIJO),
                Enter.theValue(celular).into(CELULAR));
        takeScreenshot();
    }

    public static DiligenciarDatosAcompañanate enElFormulario(String nombre, String telefonoFijo, String celular) {

        return Tasks.instrumented(DiligenciarDatosAcompañanate.class, nombre, telefonoFijo, celular);
    }

}
