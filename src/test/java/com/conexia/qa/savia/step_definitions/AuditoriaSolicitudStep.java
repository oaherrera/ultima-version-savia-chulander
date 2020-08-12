package com.conexia.qa.savia.step_definitions;

import com.conexia.qa.savia.interactions.AbrirOpcion;
import com.conexia.qa.savia.interactions.SalgoDelSistema;
import com.conexia.qa.savia.modelos.Selenium;
import com.conexia.qa.savia.questions.LosResultadosDeLaTablaSolicitud;
import com.conexia.qa.savia.tasks.ConsultoSolicitudAuditar;
import com.conexia.qa.savia.tasks.ConsultoSolicitudEnBandejaSolicitud;
import com.conexia.qa.savia.tasks.Loguearse;
import com.conexia.qa.sql.tasks.ConsultoSolicitudTecnologias;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import org.junit.Assert;

import static com.conexia.qa.sql.colecciones.SolicitudAuditorBandejaTecnologiasBD.traerSolicitudAuditorBandejaTecnologias;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class AuditoriaSolicitudStep {

    private String nroSolicitud;

    @When("^Consulto las tecnologias para la solicitud Nro: (.+)$")
    public void consultoLasTecnologiasParaLaSolicitudId(String nroSolicitud) {
        this.nroSolicitud = nroSolicitud;
        theActorInTheSpotlight().attemptsTo(AbrirOpcion.delMenu("Solicitud autorización", "Bandeja solicitud"));
        theActorInTheSpotlight().attemptsTo(ConsultoSolicitudTecnologias.porNumeroSolicitud(nroSolicitud));
        theActorInTheSpotlight().attemptsTo(ConsultoSolicitudEnBandejaSolicitud.porNumeroSolicitud(nroSolicitud));
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(LosResultadosDeLaTablaSolicitud.esIgualAlosDeLABD()));
    }

    @And("^Ingreso con el Auditor para Aprobar las tecnologias\\.$")
    public void ingresoConElAuditorParaAprobarLasTecnologias() {
        theActorInTheSpotlight().attemptsTo(SalgoDelSistema.correctamente());
        for (int indice = 0; indice < traerSolicitudAuditorBandejaTecnologias().cantidadSolicitudAuditorBandeja(); indice++) {
            String usuarioo = traerSolicitudAuditorBandejaTecnologias().traerSolicitudAuditorBandeja(indice).getAuditorResponsable();
            String contrasenha = Selenium.parameters().getProperty("contrasenha");
            String bandeja = traerSolicitudAuditorBandejaTecnologias().traerSolicitudAuditorBandeja(indice).getBandejaSolicitud();
            String estado = traerSolicitudAuditorBandejaTecnologias().traerSolicitudAuditorBandeja(indice).getEstado();
            String descripcionTecnologia = traerSolicitudAuditorBandejaTecnologias().traerSolicitudAuditorBandeja(indice).getDescripcionTecnologia();
            if (estado.equals("Pendiente de Auditoria")) {
                theActorInTheSpotlight().attemptsTo(Loguearse.enElPortal(usuarioo, contrasenha));
                theActorInTheSpotlight().attemptsTo(AbrirOpcion.delMenu("Auditoría", bandeja));
                theActorInTheSpotlight().attemptsTo(ConsultoSolicitudAuditar.paraAuditarLaTecnologia(nroSolicitud, descripcionTecnologia));
                theActorInTheSpotlight().attemptsTo(AuditoLaTecnologiaSolicitud.paraAprobar("Aprobar", descripcionTecnologia));
                theActorInTheSpotlight().attemptsTo(SalgoDelSistema.correctamente());
            }
        }
    }

    @And("^Ingreso con el Auditor para Rechazar las tecnologias por motivo: (.+)$")
    public void ingresoConElAuditorParaRechazarLasTecnologias(String motivoRechazo) {
        theActorInTheSpotlight().attemptsTo(SalgoDelSistema.correctamente());
        for (int indice = 0; indice < traerSolicitudAuditorBandejaTecnologias().cantidadSolicitudAuditorBandeja(); indice++) {
            String usuarioo = traerSolicitudAuditorBandejaTecnologias().traerSolicitudAuditorBandeja(indice).getAuditorResponsable();
            String contrasenha = Selenium.parameters().getProperty("contrasenha");
            String bandeja = traerSolicitudAuditorBandejaTecnologias().traerSolicitudAuditorBandeja(indice).getBandejaSolicitud();
            String estado = traerSolicitudAuditorBandejaTecnologias().traerSolicitudAuditorBandeja(indice).getEstado();
            String descripcionTecnologia = traerSolicitudAuditorBandejaTecnologias().traerSolicitudAuditorBandeja(indice).getDescripcionTecnologia();
            if (estado.equals("Pendiente de Auditoria")) {
                theActorInTheSpotlight().attemptsTo(Loguearse.enElPortal(usuarioo, contrasenha));
                theActorInTheSpotlight().attemptsTo(AbrirOpcion.delMenu("Auditoría", bandeja));
                theActorInTheSpotlight().attemptsTo(ConsultoSolicitudAuditar.paraAuditarLaTecnologia(nroSolicitud, descripcionTecnologia));
                theActorInTheSpotlight().attemptsTo(AuditoLaTecnologiaSolicitud.paraRechazar("Rechazar", descripcionTecnologia, motivoRechazo));
                theActorInTheSpotlight().attemptsTo(SalgoDelSistema.correctamente());
            }
        }
    }

    @And("^Ingreso con el Auditor para transcribir Devolver las tecnologias por motivo: (.+)$")
    public void ingresoConElAuditorParaTranscribirDevolverLasTecnologias(String motivo) {
        theActorInTheSpotlight().attemptsTo(SalgoDelSistema.correctamente());
        for (int indice = 0; indice < traerSolicitudAuditorBandejaTecnologias().cantidadSolicitudAuditorBandeja(); indice++) {
            String usuarioo = traerSolicitudAuditorBandejaTecnologias().traerSolicitudAuditorBandeja(indice).getAuditorResponsable();
            String contrasenha = Selenium.parameters().getProperty("contrasenha");
            String bandeja = traerSolicitudAuditorBandejaTecnologias().traerSolicitudAuditorBandeja(indice).getBandejaSolicitud();
            String estado = traerSolicitudAuditorBandejaTecnologias().traerSolicitudAuditorBandeja(indice).getEstado();
            System.out.println(estado);
            String descripcionTecnologia = traerSolicitudAuditorBandejaTecnologias().traerSolicitudAuditorBandeja(indice).getDescripcionTecnologia();
            if (estado.equals("Pendiente de transcripcion")) {
                theActorInTheSpotlight().attemptsTo(Loguearse.enElPortal(usuarioo, contrasenha));
                theActorInTheSpotlight().attemptsTo(AbrirOpcion.delMenu("Auditoría", bandeja));
                theActorInTheSpotlight().attemptsTo(ConsultoSolicitudAuditar.paraVerLaTecnologia(nroSolicitud, descripcionTecnologia));
                theActorInTheSpotlight().attemptsTo(AuditoLaTecnologiaSolicitud.paraTranscribirDevolver("TranscribirDevolver", descripcionTecnologia, motivo));
                theActorInTheSpotlight().attemptsTo(SalgoDelSistema.correctamente());
            }
        }
    }

    @And("^Ingreso con el Auditor para transcribir Derivar las tecnologias a tipo auditor: (.+)$")
    public void ingresoConElAuditorParaTranscribirDerivarLasTecnologias(String tipoAuditor) {
        theActorInTheSpotlight().attemptsTo(SalgoDelSistema.correctamente());
        for (int indice = 0; indice < traerSolicitudAuditorBandejaTecnologias().cantidadSolicitudAuditorBandeja(); indice++) {
            String usuarioo = traerSolicitudAuditorBandejaTecnologias().traerSolicitudAuditorBandeja(indice).getAuditorResponsable();
            String contrasenha = Selenium.parameters().getProperty("contrasenha");
            String bandeja = traerSolicitudAuditorBandejaTecnologias().traerSolicitudAuditorBandeja(indice).getBandejaSolicitud();
            String estado = traerSolicitudAuditorBandejaTecnologias().traerSolicitudAuditorBandeja(indice).getEstado();
            System.out.println(estado);
            String descripcionTecnologia = traerSolicitudAuditorBandejaTecnologias().traerSolicitudAuditorBandeja(indice).getDescripcionTecnologia();
            if (estado.equals("Pendiente de transcripcion")) {
                theActorInTheSpotlight().attemptsTo(Loguearse.enElPortal(usuarioo, contrasenha));
                theActorInTheSpotlight().attemptsTo(AbrirOpcion.delMenu("Auditoría", bandeja));
                theActorInTheSpotlight().attemptsTo(ConsultoSolicitudAuditar.paraVerLaTecnologia(nroSolicitud, descripcionTecnologia));
                theActorInTheSpotlight().attemptsTo(AuditoLaTecnologiaSolicitud.paraTranscribirDerivar("TranscribirDerivar", descripcionTecnologia, tipoAuditor));
                theActorInTheSpotlight().attemptsTo(SalgoDelSistema.correctamente());
            }
        }
    }


    @Then("^Tecnologias de la solicitud en estado (.+) consultadas por el usuario (.+) y contraseña (.+)$")
    public void tecnologiasDeLaSolicitudEnEstado(String estadoEsperado, String usuarioo, String contrasenha) {
        //TODO actualizar esta porque no esta adejacuada a los posibles assert de cada una
        theActorInTheSpotlight().attemptsTo(Loguearse.enElPortal(usuarioo, contrasenha));
        theActorInTheSpotlight().attemptsTo(AbrirOpcion.delMenu("Solicitud autorización", "Bandeja solicitud"));
        theActorInTheSpotlight().attemptsTo(ConsultoSolicitudTecnologias.porNumeroSolicitud(nroSolicitud));
        theActorInTheSpotlight().attemptsTo(ConsultoSolicitudEnBandejaSolicitud.porNumeroSolicitud(nroSolicitud));
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(LosResultadosDeLaTablaSolicitud.esIgualAlosDeLABD()));

        for (int indice = 0; indice < traerSolicitudAuditorBandejaTecnologias().cantidadSolicitudAuditorBandeja(); indice++) {
            String estado = traerSolicitudAuditorBandejaTecnologias().traerSolicitudAuditorBandeja(indice).getEstado();
            Assert.assertFalse("Hay Tecnologias pendientes de auditar a lo cual es incorrecto", estado.equals("Pendiente de Auditoria"));
        }
        theActorInTheSpotlight().attemptsTo(SalgoDelSistema.correctamente());
    }

}
