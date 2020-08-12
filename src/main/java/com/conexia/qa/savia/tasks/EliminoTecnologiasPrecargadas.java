package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.NegociacionTecnologiasPage.BORRAR_TODOS_MEDICAMETOS;
import static com.conexia.qa.savia.user_interfaces.NegociacionTecnologiasPage.BORRAR_TODOS_PROCEDIMIENTOS;
import static com.conexia.qa.savia.user_interfaces.NegociacionTecnologiasPage.CONFIRMAR_ACEPTAR;
import static com.conexia.qa.savia.user_interfaces.NegociacionTecnologiasPage.CONFIRMAR_ACEPTAR_ELIMINAR_MEDICAMENTOS;
import static com.conexia.qa.savia.user_interfaces.NegociacionTecnologiasPage.GESTIONAR_MEDICAMENTOS;
import static com.conexia.qa.savia.user_interfaces.NegociacionTecnologiasPage.GESTIONAR_SERVICIOS;
import static com.conexia.qa.savia.user_interfaces.NegociacionTecnologiasPage.SELECCIONAR_TODOS_MEDICAMENTOS;
import static com.conexia.qa.savia.user_interfaces.NegociacionTecnologiasPage.SELECCIONAR_TODOS_PROCEDIMIENTOS;
import static com.conexia.qa.savia.user_interfaces.NegociacionTecnologiasPage.TAB_MEDICAMENTOS;
import static com.conexia.qa.savia.user_interfaces.NegociacionTecnologiasPage.TAB_PROCEDMIENTOS;
import static com.conexia.qa.sql.modelos.NegociacionMedicamento.traerNegociacionMedicamento;
import static com.conexia.qa.sql.modelos.NegociacionProcedimiento.traerNegociacionProcedimiento;
import static net.serenitybdd.core.Serenity.takeScreenshot;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

import com.conexia.qa.savia.interactions.EsperarCargando;
import com.conexia.qa.savia.interactions.MueveScroll;
import com.conexia.qa.savia.questions.MensajeTemporal;
import com.conexia.qa.sql.tasks.ConsultoEnNegociacion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class EliminoTecnologiasPrecargadas implements Task {

	private String numeroNegociacion;

	public EliminoTecnologiasPrecargadas(String numeroNegociacion) {
		this.numeroNegociacion = numeroNegociacion;
	}

	@Override
	@Step("{0} Elimina todas las tecnologias precargadas de la negociación #numeroNegociacion")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(MueveScroll.vertical(200));

		// eliminar procedimientos
		takeScreenshot();
		actor.attemptsTo(ConsultoEnNegociacion.procedimientos(numeroNegociacion));
		actor.attemptsTo(Click.on(TAB_PROCEDMIENTOS));
		takeScreenshot();
		while (traerNegociacionProcedimiento().cantidadProcedimientos() > 0) {
			actor.attemptsTo(Click.on(GESTIONAR_SERVICIOS));
			actor.attemptsTo(Click.on(SELECCIONAR_TODOS_PROCEDIMIENTOS), EsperarCargando.pagina());
			actor.attemptsTo(Click.on(GESTIONAR_SERVICIOS));
			actor.attemptsTo(Click.on(BORRAR_TODOS_PROCEDIMIENTOS));
			actor.attemptsTo(Click.on(CONFIRMAR_ACEPTAR), EsperarCargando.pagina());
			actor.should(seeThat(MensajeTemporal.es(), containsString("Servicio(s) eliminado(s) correctamente.")));
			actor.attemptsTo(ConsultoEnNegociacion.procedimientos(numeroNegociacion));
			
		}
		takeScreenshot();
		
		// eliminar medicamenos
		actor.attemptsTo(ConsultoEnNegociacion.medicamentos(numeroNegociacion));
		actor.attemptsTo(Click.on(TAB_MEDICAMENTOS));
		takeScreenshot();
		while (traerNegociacionMedicamento().cantidadMedicamentos() > 0) {
			actor.attemptsTo(Click.on(GESTIONAR_MEDICAMENTOS));
			actor.attemptsTo(Click.on(SELECCIONAR_TODOS_MEDICAMENTOS), EsperarCargando.pagina());
			actor.attemptsTo(Click.on(GESTIONAR_MEDICAMENTOS));
			actor.attemptsTo(Click.on(BORRAR_TODOS_MEDICAMETOS));
			actor.attemptsTo(Click.on(CONFIRMAR_ACEPTAR_ELIMINAR_MEDICAMENTOS), EsperarCargando.pagina());
			actor.should(seeThat(MensajeTemporal.es(), containsString("Medicamento(s) eliminado(s) correctamente.")));
			actor.attemptsTo(ConsultoEnNegociacion.medicamentos(numeroNegociacion));
			
		}
		takeScreenshot();

		
	}

	public static EliminoTecnologiasPrecargadas paraLaNegociacion(String numeroNegociacion) {
		return Tasks.instrumented(EliminoTecnologiasPrecargadas.class, numeroNegociacion);
	}

}
