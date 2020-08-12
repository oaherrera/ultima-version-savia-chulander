package com.conexia.qa.savia.step_definitions;


import com.conexia.qa.savia.interactions.DobleClic;
import com.conexia.qa.savia.interactions.EsperarCargando;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static com.conexia.qa.savia.user_interfaces.AuditarSolicitudTecnologiaPage.*;
import static com.conexia.qa.savia.user_interfaces.CommonPage.ACEPTAR;

public class AuditoLaTecnologiaSolicitud implements Task {

    private String accionTecnologia;
    private String descripcionTecnologia;
    private String motivo;
    private String tipoAuditor;

    public AuditoLaTecnologiaSolicitud(String accionTecnologia, String descripcionTecnologia, String motivo, String tipoAuditor) {
        this.accionTecnologia = accionTecnologia;
        this.descripcionTecnologia = descripcionTecnologia;
        this.motivo = motivo;
        this.tipoAuditor = tipoAuditor;
    }

    @Step("{0} Realiza la accion #accionTecnologia, sobre la tecnologia #descripcionTecnologia")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ACCION.of(descripcionTecnologia)), EsperarCargando.pagina());
        Serenity.takeScreenshot();
        switch (accionTecnologia) {
            case "Aprobar":
                actor.attemptsTo(Click.on(ACCION_SELECCION.of("Aprobar")), EsperarCargando.pagina());
                actor.attemptsTo(Click.on(DIRECCIONAMIENTO_NOMBRE_IPS), EsperarCargando.pagina());
                Serenity.takeScreenshot();
                actor.attemptsTo(DobleClic.En(REGISTRO_DIRECCIONAMIENTO_IPS), EsperarCargando.pagina());
                Serenity.takeScreenshot();
                break;
            case "Rechazar":
                actor.attemptsTo(Click.on(ACCION_SELECCION.of("Rechazar")), EsperarCargando.pagina());
                actor.attemptsTo(Click.on(MOTIVO.of(descripcionTecnologia)), EsperarCargando.pagina());
                actor.attemptsTo(Click.on(MOTIVO_SELECCION.of(motivo)), EsperarCargando.pagina());
                break;
            case "TranscribirDevolver":
                actor.attemptsTo(Click.on(ACCION_SELECCION.of("Devolver")), EsperarCargando.pagina());
                actor.attemptsTo(Click.on(MOTIVO.of(descripcionTecnologia)), EsperarCargando.pagina());
                actor.attemptsTo(Click.on(MOTIVO_SELECCION.of(motivo)), EsperarCargando.pagina());
                break;
            case "TranscribirDerivar":
                actor.attemptsTo(Click.on(ACCION_SELECCION.of("Derivar")), EsperarCargando.pagina());
                actor.attemptsTo(Click.on(TIPO_AUDITOR.of(descripcionTecnologia)), EsperarCargando.pagina());
                actor.attemptsTo(Click.on(TIPO_AUDITOR_SELECCION.of(tipoAuditor)), EsperarCargando.pagina());
                break;
        }
        actor.attemptsTo(Enter.theValue("Comentarios tecnologia +" + descripcionTecnologia).into(COMMENTARIOS.of(descripcionTecnologia)), EsperarCargando.pagina());
        actor.attemptsTo(Click.on(ACEPTAR), EsperarCargando.pagina());
        Serenity.takeScreenshot();

    }

    public static AuditoLaTecnologiaSolicitud paraAprobar(String accionTecnologia, String descripcionTecnologia) {
        return Tasks.instrumented(AuditoLaTecnologiaSolicitud.class, accionTecnologia, descripcionTecnologia, null, null);
    }

    public static AuditoLaTecnologiaSolicitud paraRechazar(String accionTecnologia, String descripcionTecnologia, String motivo) {
        return Tasks.instrumented(AuditoLaTecnologiaSolicitud.class, accionTecnologia, descripcionTecnologia, motivo, null);
    }

    public static AuditoLaTecnologiaSolicitud paraTranscribirDevolver(String accionTecnologia, String descripcionTecnologia, String motivo) {
        return Tasks.instrumented(AuditoLaTecnologiaSolicitud.class, accionTecnologia, descripcionTecnologia, motivo, null);
    }

    public static AuditoLaTecnologiaSolicitud paraTranscribirDerivar(String accionTecnologia, String descripcionTecnologia, String tipoAuditor) {
        return Tasks.instrumented(AuditoLaTecnologiaSolicitud.class, accionTecnologia, descripcionTecnologia, null, tipoAuditor);
    }


}
