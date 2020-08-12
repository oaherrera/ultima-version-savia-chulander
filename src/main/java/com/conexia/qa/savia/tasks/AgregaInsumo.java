package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.InsumoPage.AGREGAR_INSUMO;
import static com.conexia.qa.savia.user_interfaces.InsumoPage.DIAGNOSTICO;
import static com.conexia.qa.savia.user_interfaces.InsumoPage.DIAGNOSTICO_SELECT;
import static com.conexia.qa.savia.user_interfaces.InsumoPage.DURACION_TRATAMIENTO;
import static com.conexia.qa.savia.user_interfaces.InsumoPage.GUARDAR;
import static com.conexia.qa.savia.user_interfaces.InsumoPage.ID_DESCRIPCION_UNSUMO;
import static com.conexia.qa.savia.user_interfaces.InsumoPage.ID_DESCRIPCION_UNSUMO_SELECT;
import static com.conexia.qa.savia.user_interfaces.InsumoPage.TAB_INSUMOS;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.Esperar;

import com.conexia.qa.savia.interactions.EsperarCargando;
import com.conexia.qa.sql.tasks.ConsultoInsumo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class AgregaInsumo implements Task {

    private String tipologia;
    private String codigo;
    private String descripcionInsumo;
    private String diagnostico;
    private String duracionTratamientoEnDias;

    public AgregaInsumo(String tipologia, String codigo, String descripcionInsumo, String diagnostico, String duracionTratamientoEnDias) {
        this.tipologia = tipologia;
        this.codigo = codigo;
        this.descripcionInsumo = descripcionInsumo;
        this.diagnostico = diagnostico;
        this.duracionTratamientoEnDias = duracionTratamientoEnDias;
    }

    @Override
    @Step("{0} agrega un insumo a la autorizacion #idDescripcionInsumo,#diagnostico, ")
    public <T extends Actor> void performAs(T actor) {
        takeScreenshot();
        actor.attemptsTo(EsperarCargando.pagina(), Esperar.por(1000));
        actor.attemptsTo(Click.on(TAB_INSUMOS));
        actor.attemptsTo(Enter.theValue(codigo + " - " + descripcionInsumo).into(ID_DESCRIPCION_UNSUMO));
        actor.attemptsTo(Click.on(ID_DESCRIPCION_UNSUMO_SELECT.of(codigo + " - " + descripcionInsumo)));
        actor.attemptsTo(Click.on(DIAGNOSTICO));
        actor.attemptsTo(Click.on(DIAGNOSTICO_SELECT.of(diagnostico)));
        takeScreenshot();
        if (tipologia.equalsIgnoreCase("PBS")||tipologia.equalsIgnoreCase("Condicionado")) {
            actor.attemptsTo(Click.on(AGREGAR_INSUMO));
            actor.attemptsTo(Enter.theValue(duracionTratamientoEnDias).into(DURACION_TRATAMIENTO));
            takeScreenshot();
            actor.attemptsTo(Click.on(GUARDAR));
            actor.attemptsTo(Esperar.por(300));
            takeScreenshot();
        }

    }

    public static AgregaInsumo conLosDatos(String tipologia, String codigo, String descripcionInsumo, String diagnostico,
                                           String duracionTratamientoEnDias) {

        return Tasks.instrumented(AgregaInsumo.class, tipologia, codigo, descripcionInsumo, diagnostico, duracionTratamientoEnDias);
    }

}
