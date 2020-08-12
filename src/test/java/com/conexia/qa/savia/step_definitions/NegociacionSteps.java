package com.conexia.qa.savia.step_definitions;

import static com.conexia.qa.savia.modelos.ImportarTecnologiasEvento.agregarTecnologias;
import static com.conexia.qa.savia.modelos.ImportarTecnologiasEvento.limpiarTecnologias;
import static com.conexia.qa.savia.modelos.MensajeTemporal.traerMensaje;
import static com.conexia.qa.savia.modelos.NegociacionPrestador.guardarNegociacionPrestador;
import static com.conexia.qa.savia.modelos.NegociacionPrestador.limpioDatosNegociacionPrestador;
import static com.conexia.qa.savia.modelos.NegociacionPrestador.traerNegociacionPrestador;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;

import com.conexia.qa.savia.modelos.ImportarTecnologiasEvento;
import com.conexia.qa.savia.modelos.NegociacionPrestador;
import com.conexia.qa.savia.modelos.SedePrestador;
import com.conexia.qa.savia.questions.DespliegaDetalleNegociacion;
import com.conexia.qa.savia.questions.MensajeTemporal;
import com.conexia.qa.savia.tasks.BuscoAlPrestadorNegociacion;
import com.conexia.qa.savia.tasks.ConsultoNegociacion;
import com.conexia.qa.savia.tasks.CreaLaBaseDeNegociacion;
import com.conexia.qa.savia.tasks.ImportoArchivoTecnologias;
import com.conexia.qa.savia.tasks.SeleccionaAreaDeCobertura;
import com.conexia.qa.savia.tasks.SeleccionoTipoNegociacion;
import com.conexia.qa.savia.utilitarios.ExtraerExprexion;

import static org.hamcrest.Matchers.containsString;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NegociacionSteps {

	@When("^Busco al prestador (.+) para (.+).$")
	public void buscoAlPrestadorPara(String nombreprestador, String realizarAccionAlBuscar) {
		if (NegociacionPrestador.traerNegociacionPrestador() != null) {
			NegociacionPrestador.traerNegociacionPrestador().setPrestador(nombreprestador);
		}
		theActorInTheSpotlight().attemptsTo(BuscoAlPrestadorNegociacion.porNombre(nombreprestador));
		theActorInTheSpotlight().attemptsTo(BuscoAlPrestadorNegociacion.para(realizarAccionAlBuscar));
	}

	@When("^Creo la base negociacion$")
	public void creoLaBaseNegociacion(List<NegociacionPrestador> datosNegociacionPrestador) {
		limpioDatosNegociacionPrestador();
		guardarNegociacionPrestador(datosNegociacionPrestador.get(0));
		theActorInTheSpotlight().attemptsTo(CreaLaBaseDeNegociacion.conLosDatos());
		theActorInTheSpotlight()
				.should(seeThat(MensajeTemporal.es(), containsString("Negociación creada correctamente")));
		traerNegociacionPrestador()
				.setNumeroNegociacion(ExtraerExprexion.deUnTexto(traerMensaje(), ".*, No (.*)", 1).trim());
	}

	@And("^Consulto la negociacion nro (.+), para (.+)$")
	public void consultoLaNegociacionNumeroParaVerNegociacion(String nroNegociacion, String accionAlBuscar) {
		int numeroNegociacion = 0;
		if (traerNegociacionPrestador() == null) {
			numeroNegociacion = Integer.parseInt(nroNegociacion);
			NegociacionPrestador.guardarNegociacionPrestador(new NegociacionPrestador());
			traerNegociacionPrestador().setNumeroNegociacion(nroNegociacion );
		} else {
			numeroNegociacion = Integer.parseInt(traerNegociacionPrestador().getNumeroNegociacion());
		}
		theActorInTheSpotlight().attemptsTo(ConsultoNegociacion.porNumeroDeNegocacion("" + numeroNegociacion));
		theActorInTheSpotlight().attemptsTo(ConsultoNegociacion.para(accionAlBuscar));
	}

	@And("^Asigno area de cobertura$")
	public void asignoAreaDeCobertura(List<SedePrestador> datosSedePrestador) {
		SedePrestador dataSedePrestador = SedePrestador.traerSedePrestador();
		dataSedePrestador.guardarSedePrestador(datosSedePrestador);
		theActorInTheSpotlight().attemptsTo(SeleccionaAreaDeCobertura.asociandoSedes());
	}

	@And("^Selecciono un tipo de negociación: (.+)$")
	public void seleccionountipoDeNegociacion(String tipoNegociacion) {
		theActorInTheSpotlight().attemptsTo(SeleccionoTipoNegociacion.paraTerminarNegociacion(tipoNegociacion));
	}

	@Then("Se despliegua el detalle de la negociación.")
	public void seDesplieguaElDetalleDeLaNegociacion() {
		theActorInTheSpotlight().should(seeThat(DespliegaDetalleNegociacion.enLaPantalla()));
	}

	@And("^Importo las tecnologias$")
	public void importoLasTecnologias(List<ImportarTecnologiasEvento> importarTecnologias) {
//		theActorInTheSpotlight().attemptsTo(EliminoTecnologiasPrecargadas.paraLaNegociacion(traerNegociacionPrestador().getNumeroNegociacion()));
		limpiarTecnologias();
		agregarTecnologias(importarTecnologias);
		theActorInTheSpotlight().attemptsTo(ImportoArchivoTecnologias.conLosDatosDelModelo());
	}
}
