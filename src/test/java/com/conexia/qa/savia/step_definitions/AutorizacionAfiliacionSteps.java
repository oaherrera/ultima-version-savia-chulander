package com.conexia.qa.savia.step_definitions;

import static com.conexia.qa.savia.colecciones.Diagnosticos.traerDiagnosticos;
import static com.conexia.qa.savia.colecciones.Insumos.traerInsumos;
import static com.conexia.qa.savia.colecciones.Medicamentos.traerMedicamentos;
import static com.conexia.qa.savia.colecciones.Paquetes.traerPaquetes;
import static com.conexia.qa.savia.colecciones.Procedimientos.traerProcedimientos;
import static com.conexia.qa.savia.colecciones.Profesionales.traerProfesionales;
import static com.conexia.qa.savia.colecciones.ServiciosSolicitados.traerServiciosSolicitados;
import static com.conexia.qa.savia.modelos.DatosAcompanhante.trearDatosAcompanhante;
import static com.conexia.qa.savia.modelos.SedeIPS.trearSedeIPS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.conexia.qa.savia.colecciones.SoporteFisico;
import com.conexia.qa.savia.drivers.OwnWebDriver;
import com.conexia.qa.savia.interactions.AbrirOpcion;
import com.conexia.qa.savia.modelos.*;
import com.conexia.qa.savia.questions.CreoAnexo3;
import com.conexia.qa.savia.tasks.*;

import com.conexia.qa.sql.tasks.ConsultoInsumo;
import com.conexia.qa.sql.tasks.ConsultoMedicamento;
import com.conexia.qa.sql.tasks.ConsultoProcedimiento;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;

import java.util.List;

public class AutorizacionAfiliacionSteps {

    private String idCargueSolicitudes;

    @Given("^me autentico con (.+) y contraseña (.+)$")
    public void meAutenticoConUsuarioYContraseña(String usuario, String contrasena) {
        setTheStage(Cast.ofStandardActors());
        theActorCalled(usuario);
        theActorInTheSpotlight().can(BrowseTheWeb.with(OwnWebDriver.withChrome().setURL(Selenium.parameters().getProperty("url"))));
        theActorInTheSpotlight().attemptsTo(Loguearse.enElPortal(usuario, contrasena));
    }

    @Given("^Consulto afiliado con (.+) Nro (.+) en Autorizaciones$")
    public void consultoAfiliadoConTipoDocumentoNro(String tipoDocumento, String numeroDocumento) {
        theActorInTheSpotlight().attemptsTo(AbrirOpcion.delMenu("Solicitud autorización", "Solicitud"));
        theActorInTheSpotlight().attemptsTo(BuscarAfiliado.porTipoidentificacion(tipoDocumento, numeroDocumento));
    }

    @When("^Diligencio el formulario de autorizaciones con los datos:$")
    public void diligencioElFormularioDeAutorizacionesConLosDatos(List<DatosAcompanhante> pdatosAcompanhante) {
        trearDatosAcompanhante().guardarDatosAcompanhante(pdatosAcompanhante.get(0));
        theActorInTheSpotlight().attemptsTo(DiligenciarDatosAcompañanate.enElFormulario(trearDatosAcompanhante().getNombreAcompanhante(), trearDatosAcompanhante().getTelefonoFijoAcompanhante(), trearDatosAcompanhante().getCelularAcompanhante()));
        theActorInTheSpotlight().attemptsTo(DiligenciaTipoDeSolicitud.enElFormulario(trearDatosAcompanhante().getServicio(), trearDatosAcompanhante().getPrograma()));
        theActorInTheSpotlight().attemptsTo(DiligenciarDatosSolicitud.enElFomularioSolicitud(trearDatosAcompanhante().getNroSolicitud()));
    }

    @And("^Asocio la sede de la ips con razon social$")
    public void asocioLaSedeCon(List<SedeIPS> sedeIPS) {
        trearSedeIPS().guardarSedeIPS(sedeIPS.get(0));
        theActorInTheSpotlight().attemptsTo(BuscarSedeIPS.porRazonSocial(trearSedeIPS().getIpsRazonSocial(), trearSedeIPS().getSede()));
    }


    @And("^Asigno el profesional identificado con:$")
    public void asignoElProfesionalIdentificadoCon(List<Profesional> profesionalData) {
        traerProfesionales().guardarProfesionales(profesionalData.get(0));
        Profesional profesional = traerProfesionales().traerProfesional(0);
        theActorInTheSpotlight().attemptsTo(BuscarProfesional.porTipoDocumento(profesional.getTipoDocumentoProfesional(), profesional.getNumeroDocumentoProfesional()));

    }

    @And("^Selecciono servicios solicitados.$")
    public void seleccionoServiciosSolicitados(List<ServiciosSolicitado> serviciosSolicitadosData) {
        traerServiciosSolicitados().guardarServiciosSolicitados(serviciosSolicitadosData.get(0));
        ServiciosSolicitado servicioSolicitado = traerServiciosSolicitados().traerServiciosSolicitado();
        theActorInTheSpotlight().attemptsTo(DiligenciarServiciosSolicitados.enElFormulario(servicioSolicitado.getOrigenDeLaAtencion(), servicioSolicitado.getPrioridadDeLaAntencion(), servicioSolicitado.getTipoDeServicioSolicitado(), servicioSolicitado.getUbicacionDelPaciente()));
    }

    @And("^Asocio Diagnostico.$")
    public void asocioDiagnostricoConElCodigo(List<Diagnostico> diagnosticoData) {
        traerDiagnosticos().agregarDiagnostico(diagnosticoData.get(0));
        Diagnostico diagnostico = traerDiagnosticos().traerDiagnostico(0);
        theActorInTheSpotlight().attemptsTo(BuscaDiagnostico.porCodigoDescripcion(diagnostico.getCodigoDiagnostico(), diagnostico.getDescripcionDiagnostico(), diagnostico.getTipoDiagnostico()));
    }

    @And("^Agrego procedimiento.$")
    public void agregoProcedimientoConElId(List<Procedimiento> procedimientosData) {
        traerProcedimientos().guardarProcedimientos(procedimientosData);
        for (int indice = 0; indice < traerProcedimientos().cantidadProcedimientos(); indice++) {
            Procedimiento procedimiento = traerProcedimientos().traerProcedimiento(indice);
            theActorInTheSpotlight().attemptsTo(ConsultoProcedimiento.porCodigoYDescripcio(procedimiento.getCodigoProcedimiento(), procedimiento.getDescripcionProcedimiento(), procedimiento.getTipologiaProcedimiento()));
            theActorInTheSpotlight().attemptsTo(AgregaProcedimiento.conLosDatos(procedimiento.getTipologiaProcedimiento(), procedimiento.getCodigoProcedimiento(), procedimiento.getDescripcionProcedimiento(), procedimiento.getDuracionTratamientoProcedimiento(), procedimiento.getIndicacionesProcedimiento()));
        }
    }

    @And("^Agrego medicamento.$")
    public void agregoMedicamentoConElId(List<Medicamento> medicamentosData) {
        traerMedicamentos().agregarMedicamentos(medicamentosData);
        for (int indice = 0; indice < traerMedicamentos().cantidadMedicamentos(); indice++) {
            Medicamento medicamento = traerMedicamentos().traerMedicamento(indice);
            theActorInTheSpotlight().attemptsTo(ConsultoMedicamento.porCodigoYDescipcion(medicamento.getCodigoMedicamento(), medicamento.getDescripcionMedicamento(), medicamento.getTipologiaMedicamento()));
            theActorInTheSpotlight().attemptsTo(AgregaMedicamento.conLosDatos(medicamento.getTipologiaMedicamento(), medicamento.getCodigoMedicamento(), medicamento.getDescripcionMedicamento(), medicamento.getCodigoDiagnostico(), medicamento.getCausaExternaMedicamento(), medicamento.getFinalidadMedicamento(), medicamento.getTipoCatastroficoMedicamento(), medicamento.getDosisMedicamento(), medicamento.getFrecuenciaMedicamento(), medicamento.getFrecuenciaTipoMedicamento(), medicamento.getViaDeAdministracionMedicamento(), medicamento.getDuracionTratamientoMedicamento(), medicamento.getPosologiaMedicamento()));
        }
    }

    @And("^Agrego insumo.$")
    public void agregoInsumoConElId(List<Insumo> insumoData) {
        traerInsumos().agregarInsumos(insumoData);
        for (int indice = 0; indice < traerInsumos().cantidadInsumos(); indice = indice + 1) {
            Insumo insumo = traerInsumos().traerInsumo(indice);
            theActorInTheSpotlight().attemptsTo(ConsultoInsumo.porCodigoYDescipcion(insumo.getCodigoDiagnostico(), insumo.getDescripcionInsumo(), insumo.getTipologiaInsumo()));
            theActorInTheSpotlight().attemptsTo(AgregaInsumo.conLosDatos(insumo.getTipologiaInsumo(), insumo.getCodigoInsumo(), insumo.getDescripcionInsumo(), insumo.getCodigoDiagnostico(), insumo.getDuracionTratamientoInsumo()));
        }
    }

    @And("^Agrego paquete.$")
    public void agregoPaqueteConEld(List<Paquete> paqueteData) {
        traerPaquetes().agregarPaquetes(paqueteData);
        for (int indice = 0; indice < traerInsumos().cantidadInsumos(); indice = indice + 1) {
            Paquete paquete = traerPaquetes().traerPaquete(indice);
            theActorInTheSpotlight().attemptsTo(AgregoPaquete.conLosDatos(paquete.getTipologiaPaquete(), paquete.getCodigoPaquete(), paquete.getDescripcionPaquete(), paquete.getCodigoDiagnostico(), paquete.getDuracionTratamientoPaquete(), paquete.getIndicacionesPaquete()));
        }
    }

    @And("Diligencio campos complementarios de la autorizacion")
    public void diligencioCamposComplementariosDeLaSolicitud(List<AutorizacionComplementarios> AutorizacionComplementariosDatos) {
        AutorizacionComplementarios DatosComplementarios = AutorizacionComplementariosDatos.get(0);
        theActorInTheSpotlight().attemptsTo(IngresaJustificacionClinica.conElValor(DatosComplementarios.getJustificacionClinica()));
        theActorInTheSpotlight().attemptsTo(IngresarHistoriaClinica.con(DatosComplementarios.getHistoriaClinica()));
    }

    @And("^Ajunto soporte fisico formato PDF.$")
    public void adjuntoSoporteFisicoFormatoPDFUbicado(List<SoporteFisico> soporteFisicoData) {
        SoporteFisico soporteFisico = soporteFisicoData.get(0);
        String[] rutasSoporte = soporteFisico.getRutaArchivo().split(";");
        String[] tiposSoportes = soporteFisico.getTipoArchivo().split(";");
        for (int indice = 0; indice < rutasSoporte.length; indice = indice + 1) {
            theActorInTheSpotlight().attemptsTo(AdjuntoSoportesFisicos.enLaSolicitud(indice, rutasSoporte[indice], tiposSoportes[indice]));
        }
        theActorInTheSpotlight().attemptsTo(AdjuntoSoportesFisicos.diligencioObservaciones());
    }

    @And("Envio la solicitud a Validar")
    public void envioSolicitudAValidar() {
        theActorInTheSpotlight().attemptsTo(ValidoSolicitud.enviandola());
    }

    @Then("^Se debe generar una solicitud de afiliacion anexo4$")
    public void seDebeGenerarUnaSolicitudDeAfiliacionAnexo4() {
        theActorInTheSpotlight().should(seeThat(CreoAnexo3.Correctamente()));
    }
}
