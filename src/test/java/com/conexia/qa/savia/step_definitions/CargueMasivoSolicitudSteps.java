package com.conexia.qa.savia.step_definitions;

import com.conexia.qa.savia.interactions.AbrirOpcion;
import com.conexia.qa.savia.interactions.Esperar;
import com.conexia.qa.savia.questions.ElEstadoDeCargueSolicitud;
import com.conexia.qa.savia.questions.ElMensaje;
import com.conexia.qa.savia.questions.MensajeTemporal;
import com.conexia.qa.savia.tasks.*;
import com.conexia.qa.savia.utilitarios.ExtraerExprexion;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static com.conexia.qa.savia.modelos.MensajeTemporal.traerMensajeTexto;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.containsString;


public class CargueMasivoSolicitudSteps {

    private String idCargueSolicitudes;

    @When("^Cargo archivo masivo de solicitud.$")
    public void cargoArchivoMasivoDeSolicitud(DataTable rutaArchivo) {
        theActorInTheSpotlight().attemptsTo(AbrirOpcion.delMenu("Solicitud autorización", "Carga masiva solicitud"));
        List<Map<String, String>> Ruta = rutaArchivo.asMaps(String.class, String.class);
        theActorInTheSpotlight().attemptsTo(CargoArchivoSolicitud.conLaRuta(Ruta.get(0).get("rutaArchivo").toString()));
        theActorInTheSpotlight().should(seeThat(MensajeTemporal.es(), containsString("La operación se ejecutó exitosamente.")));
        theActorInTheSpotlight().should(seeThat(ElMensaje.contiene(traerMensajeTexto(), "se almaceno correctamente e iniciara el proceso de validación, por favor este pendiente del estado")));
        idCargueSolicitudes = ExtraerExprexion.deUnTexto(traerMensajeTexto(), "El cargue N° (.*) se almaceno .*", 1);
        theActorInTheSpotlight().attemptsTo(AbrirOpcion.delMenuDesplegado("Solicitud autorización", "Carga masiva solicitud"));
        theActorInTheSpotlight().should(seeThat(ElEstadoDeCargueSolicitud.es(idCargueSolicitudes,"Validado")));
    }

    @And("^Proceso el cargue de archivo solicitud.$")
    public void procesoElCargueDeArchivoSolicitud() {
        theActorInTheSpotlight().attemptsTo(AbrirOpcion.delMenuDesplegado("Solicitud autorización", "Carga masiva solicitud"));
        theActorInTheSpotlight().attemptsTo(ProcesoCargaAutorizacion.validada(idCargueSolicitudes));
        theActorInTheSpotlight().should(seeThat(MensajeTemporal.es(), containsString("La operación se ejecutó exitosamente.")));
        theActorInTheSpotlight().should(seeThat(ElMensaje.contiene(traerMensajeTexto(), "Inicio correctamente el procesamiento del cargue N° "+idCargueSolicitudes+", por favor este pendiente del estado")));
        theActorInTheSpotlight().should(seeThat(ElEstadoDeCargueSolicitud.es(idCargueSolicitudes,"En Proceso")));
    }

    @Then("^Proceso de cargue de archivo solicitud en estado Procesado.$")
    public void procesoDeCargueDeArchivoSolicitudEnEstadoProcesado() {
        theActorInTheSpotlight().attemptsTo(Esperar.por(10000));
        theActorInTheSpotlight().attemptsTo(AbrirOpcion.delMenuDesplegado("Solicitud autorización", "Carga masiva solicitud"));
        theActorInTheSpotlight().should(seeThat(ElEstadoDeCargueSolicitud.es(idCargueSolicitudes,"Procesado")));
    }
}
