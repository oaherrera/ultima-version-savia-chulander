package com.conexia.qa.savia.tasks;

import com.conexia.qa.savia.interactions.AdjuntoArchivo;
import com.conexia.qa.savia.interactions.EsperarCargando;
import com.conexia.qa.savia.questions.MensajeTemporal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.conexia.qa.savia.user_interfaces.CommonPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class CargoArchivoSolicitud implements Task {

    private String rutaArchivo;

    public CargoArchivoSolicitud(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(AGREGAR),EsperarCargando.pagina());
        actor.attemptsTo(AdjuntoArchivo.con(rutaArchivo,ADJUNTAR_ARCHIVO));
        actor.attemptsTo(Click.on(GUARDAR), EsperarCargando.pagina());
    }

    public static CargoArchivoSolicitud conLaRuta(String rutaArchivo) {
        return Tasks.instrumented(CargoArchivoSolicitud.class, rutaArchivo);
    }
}
