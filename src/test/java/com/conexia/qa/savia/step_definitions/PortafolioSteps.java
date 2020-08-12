package com.conexia.qa.savia.step_definitions;

import com.conexia.qa.savia.modelos.PortafolioProcedimiento;
import com.conexia.qa.savia.questions.EstaAgregadoElProcedimiento;
import com.conexia.qa.savia.questions.EstaAgregadoElServicio;
import com.conexia.qa.savia.tasks.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class PortafolioSteps {

    @When("Selecciono sedes del prestador para (.+), de la sede: (.+)")
    public void seleccionoSedesDelPrestadorParaAccionarDeLaSede(String accion, String sede) {
        theActorInTheSpotlight().attemptsTo(SeleccionaSedesDelPrestador.para(accion, sede));
    }

    @And("^Agrego un nuevo servicio con procedimiento$")
    public void agregoUnNuevoServicioEnProcedimientos(List<PortafolioProcedimiento> procedimientosPortafolio) {
        PortafolioProcedimiento DatosProcedimiento = procedimientosPortafolio.get(0);
        theActorInTheSpotlight().attemptsTo(FiltroServicioProcedimiento.enPortafolio(DatosProcedimiento.getDescripcionGrupoServicio(), DatosProcedimiento.getCodigoServicio(), DatosProcedimiento.getDescripcionServicio()));
        Boolean servicioYaExiste = theActorInTheSpotlight().asksFor(EstaAgregadoElServicio.alPortafoliio(DatosProcedimiento.getDescripcionGrupoServicio()));
        if (!servicioYaExiste) {
            theActorInTheSpotlight().attemptsTo(AgregoGrupoDeHabilitacion.conLosDatos(DatosProcedimiento.getDescripcionGrupoServicio(), DatosProcedimiento.getCodigoServicio(), DatosProcedimiento.getDescripcionServicio(), DatosProcedimiento.getTarifario(), DatosProcedimiento.getPorcentajeNegociado(), DatosProcedimiento.getComplejidad()));
            theActorInTheSpotlight().attemptsTo(FiltroServicioProcedimiento.enPortafolio(DatosProcedimiento.getDescripcionGrupoServicio(), DatosProcedimiento.getCodigoServicio(), DatosProcedimiento.getDescripcionServicio()));
            servicioYaExiste = theActorInTheSpotlight().asksFor(EstaAgregadoElServicio.alPortafoliio(DatosProcedimiento.getDescripcionGrupoServicio()));
            if (!servicioYaExiste) {
                Assert.assertFalse("No se logro registrar el servicio", true);
            }
        }
        theActorInTheSpotlight().attemptsTo(EnServicioSede.EditaServicio(DatosProcedimiento.getCodigoServicio(), DatosProcedimiento.getDescripcionServicio()));
        Boolean procedimientoYaExistente = theActorInTheSpotlight().asksFor(EstaAgregadoElProcedimiento.alPortafolio(DatosProcedimiento.getCodigoProcedimiento(), DatosProcedimiento.getDescripcionProcedimiento()));
        if (!procedimientoYaExistente) {
            theActorInTheSpotlight().attemptsTo(BuscaProcedimientoExistentes.paraAgregarlosAlPortafolio(DatosProcedimiento.getDescripcionProcedimiento(), DatosProcedimiento.getCodigoProcedimiento(), DatosProcedimiento.getTarifario(), DatosProcedimiento.getValorProcedimiento()));
            procedimientoYaExistente = theActorInTheSpotlight().asksFor(EstaAgregadoElProcedimiento.alPortafolio(DatosProcedimiento.getCodigoProcedimiento(), DatosProcedimiento.getDescripcionProcedimiento()));
            if (!procedimientoYaExistente) {
                Assert.assertFalse("No se logro registrar el procedimiento", true);
            }
        }
    }

    @Then("^Se agrega el servicio de procedimiento al portafolio evento$")
    public void seAgregaElServicioDeProcedimientoAlPortafolioEvento() {
        //TODO: HACE FALTA IMPLEMENTAR
    }
}
