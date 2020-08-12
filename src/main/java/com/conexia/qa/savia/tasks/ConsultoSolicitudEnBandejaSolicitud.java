package com.conexia.qa.savia.tasks;

import com.conexia.qa.savia.colecciones.SolicitudAuditorBandejaTecnologias;
import com.conexia.qa.savia.interactions.EsperarCargando;
import com.conexia.qa.savia.interactions.MueveScroll;
import com.conexia.qa.savia.modelos.SolicitudAuditorBandeja;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static com.conexia.qa.savia.colecciones.SolicitudAuditorBandejaTecnologias.traerSolicitudAuditorBandejaTecnologias;
import static com.conexia.qa.savia.interactions.AtributosElemento.setiarAtributo;
import static com.conexia.qa.savia.modelos.SolicitudAuditorBandeja.nuevo;
import static com.conexia.qa.savia.user_interfaces.BandejaSolicitud.*;
import static com.conexia.qa.savia.user_interfaces.CommonPage.BUSCAR;

public class ConsultoSolicitudEnBandejaSolicitud implements Task {

    private String nroSolicitud;
    private SolicitudAuditorBandeja tecnologia;
    private SolicitudAuditorBandejaTecnologias tecnologias;
    private int cantidadDeTecnologias;

    public ConsultoSolicitudEnBandejaSolicitud(String nroSolicitud) {
        this.nroSolicitud = nroSolicitud;
        this.tecnologia = nuevo();
        this.tecnologias = traerSolicitudAuditorBandejaTecnologias();
        this.cantidadDeTecnologias = 0;
    }

    @Override
    @Step("{0} Consulta la solicitud #nroSolicitud, para ver las tecnologias, los auditores y las bandejas donde se pueden auditar")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(nroSolicitud).into(NUMERO_SOLICITUD), EsperarCargando.pagina());
        Serenity.takeScreenshot();;
        actor.attemptsTo(Click.on(BUSCAR), EsperarCargando.pagina());
        actor.attemptsTo(MueveScroll.vertical(400));
        Serenity.takeScreenshot();;
        actor.attemptsTo(Click.on(EXPANDIR_REGISTRO), EsperarCargando.pagina());
        actor.attemptsTo(setiarAtributo(TABLA, "style", "width:40%;font-size:8px"));
        Serenity.takeScreenshot();;
        cantidadDeTecnologias = Integer.parseInt(CANTIDAD_TECNOLOGIAS.resolveFor(actor).getText());
        actor.attemptsTo(MueveScroll.vertical(400));
        Serenity.takeScreenshot();;
        tecnologias.borrarSolicitudAuditorBandeja();
        for (int indice = 0; indice < cantidadDeTecnologias; indice++) {
            tecnologia = SolicitudAuditorBandeja.nuevo();
            tecnologia.setDescripcionTecnologia(DESCRIPCION_TECNOLOGIA.of("" + indice).resolveFor(actor).getText());
            tecnologia.setEstado(ESTADO_TECNOLOGIA.of("" + indice).resolveFor(actor).getText());
            tecnologia.setCantidadSolicitada(CANTIDAD_SOLICITADA_TECNOLOGIA.of("" + indice).resolveFor(actor).getText());
            tecnologia.setBandejaSolicitud(BANDEJA_AUDITORIA_TECNOLOGIA.of("" + indice).resolveFor(actor).getText());
            tecnologia.setMotivo(MOTIVO_TECNOLOGIA.of("" + indice).resolveFor(actor).getText());
            tecnologias.agregarSolicitudAuditorBandeja(tecnologia);
        }
    }

    public static ConsultoSolicitudEnBandejaSolicitud porNumeroSolicitud(String nroSolicitud) {
        return Tasks.instrumented(ConsultoSolicitudEnBandejaSolicitud.class, nroSolicitud);
    }

}
