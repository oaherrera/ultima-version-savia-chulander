package com.conexia.qa.savia.tasks;

import com.conexia.qa.savia.interactions.Esperar;
import com.conexia.qa.savia.interactions.EsperarCargando;
import com.conexia.qa.savia.interactions.MueveScroll;
import com.conexia.qa.savia.user_interfaces.CommonPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

import static com.conexia.qa.savia.user_interfaces.BandejaAuditoriaAutorizacionPage.*;


public class ConsultoSolicitudAuditar implements Task {

    private String nroSolicitud;
    private String descripcionTecnologia;
    private String accion;


    public ConsultoSolicitudAuditar(String nroSolicitud, String descripcionTecnologia, String accion) {
        this.nroSolicitud = nroSolicitud;
        this.descripcionTecnologia = descripcionTecnologia;
        this.accion = accion;
    }
    @Step("{0} Consulta la solicitud #nroSolicitud, para Auditar la tecnologia #descripcionTecnologia")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(nroSolicitud).into(NUMERO_SOLICITUD), EsperarCargando.pagina());
        actor.attemptsTo(Click.on(CommonPage.BUSCAR), EsperarCargando.pagina());
        Serenity.takeScreenshot();
        actor.attemptsTo(MueveScroll.vertical(600));
        Serenity.takeScreenshot();
        actor.attemptsTo(Scroll.to(AMBITO), Esperar.por(1000));
        Serenity.takeScreenshot();
        actor.attemptsTo(Scroll.to(ACCIONES), Esperar.por(1000));
        switch (accion){
            case "Auditar":
                actor.attemptsTo(Click.on(AUDITAR.of(descripcionTecnologia)), EsperarCargando.pagina());
                break;
            case "Ver":
                actor.attemptsTo(Click.on(VER.of(descripcionTecnologia)), EsperarCargando.pagina());
                break;
        }
    }

    public static ConsultoSolicitudAuditar paraAuditarLaTecnologia(String nroSolicitud, String descripcionTecnologia) {
        return Tasks.instrumented(ConsultoSolicitudAuditar.class, nroSolicitud, descripcionTecnologia,"Auditar");
    }

    public static ConsultoSolicitudAuditar paraVerLaTecnologia(String nroSolicitud, String descripcionTecnologia) {
        return Tasks.instrumented(ConsultoSolicitudAuditar.class, nroSolicitud, descripcionTecnologia,"Ver");
    }
}
