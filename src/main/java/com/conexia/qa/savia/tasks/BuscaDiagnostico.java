package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.DiagnosticoPage.DIAGNOSTICO;
import static com.conexia.qa.savia.user_interfaces.DiagnosticoPage.DIAGNOSTICO_SELECCION;
import static com.conexia.qa.savia.user_interfaces.DiagnosticoPage.TIPO;
import static com.conexia.qa.savia.user_interfaces.DiagnosticoPage.TIPO_SELECCION;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.Esperar;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class BuscaDiagnostico implements Task {

    private String codigo;
    private String descripcion;
    private String tipo;

    public BuscaDiagnostico(String codigo, String descripcion, String tipo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    @Step("{0} busca el diagnostico #codigo de #tipo ")
    @Override
    public <T extends Actor> void performAs(T actor) {
        takeScreenshot();
        actor.attemptsTo(Esperar.por(2000));
        actor.attemptsTo(Enter.theValue(codigo).into(DIAGNOSTICO));
        actor.attemptsTo(Esperar.por(2000));
        actor.attemptsTo(Click.on(DIAGNOSTICO_SELECCION.of(descripcion)));
        takeScreenshot();
        actor.attemptsTo(Click.on(TIPO));
        actor.attemptsTo(Click.on(TIPO_SELECCION.of(tipo)));
        takeScreenshot();
    }

    public static BuscaDiagnostico porCodigoDescripcion(String codigo, String descripcion, String tipo) {
        return Tasks.instrumented(BuscaDiagnostico.class, codigo, descripcion, tipo);
    }

}
