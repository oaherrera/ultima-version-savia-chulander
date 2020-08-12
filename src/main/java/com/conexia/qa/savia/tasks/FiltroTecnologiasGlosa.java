package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.modelos.Tecnologias.traerTecnologias;
import static com.conexia.qa.savia.user_interfaces.CommonPage.BUSCAR;
import static com.conexia.qa.savia.user_interfaces.FiltroGlosaPage.CODIGO;
import static com.conexia.qa.savia.user_interfaces.FiltroGlosaPage.DESCIPCION;
import static com.conexia.qa.savia.user_interfaces.FiltroGlosaPage.REGISTRO_SELECCIONAR;
import static com.conexia.qa.savia.user_interfaces.FiltroGlosaPage.TIPO_TECNOLOGIA;
import static com.conexia.qa.savia.user_interfaces.FiltroGlosaPage.TIPO_TECNOLOGIA_SELECCION;
import static com.conexia.qa.savia.user_interfaces.RadicadoGestionRadicadoPage.GLOSA_MASIVA_POR_RADICADO;
import static com.conexia.qa.savia.user_interfaces.RadicadoGestionRadicadoPage.LEVANTAMIENTO_GLOSA_MASIVA;

import java.util.List;

import com.conexia.qa.savia.interactions.Esperar;
import com.conexia.qa.savia.interactions.EsperarCargando;
import com.conexia.qa.savia.modelos.Tecnologias;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class FiltroTecnologiasGlosa implements Task {

	private int indice;
	private List<Tecnologias> tecnologias;
	private String LevantarOCrear;

	private String tipo;
	private String codigo;
	private String descripcion;

	public FiltroTecnologiasGlosa(String LevantarOCrear) {
		this.tecnologias = traerTecnologias();
		this.indice = 0;
		this.LevantarOCrear = LevantarOCrear;
	}

	@Step("{0} filtra las tecnologias para #LevantarOCrear ")
	@Override
	public <T extends Actor> void performAs(T actor) {
		
		switch (LevantarOCrear) {
		case "Crear":
			actor.attemptsTo(Click.on(GLOSA_MASIVA_POR_RADICADO));
			break;
		case "Levantar":
			actor.attemptsTo(Click.on(LEVANTAMIENTO_GLOSA_MASIVA));
			break;
		}

		while (indice < tecnologias.size()) {
			darValores(tecnologias.get(indice));
			
			actor.attemptsTo(EsperarCargando.pagina());
			actor.attemptsTo(Click.on(TIPO_TECNOLOGIA),Esperar.por(200));
			actor.attemptsTo(Click.on(TIPO_TECNOLOGIA_SELECCION.of(tipo)),Esperar.por(500));
			actor.attemptsTo(Enter.theValue(codigo).into(CODIGO),Esperar.por(500));
			actor.attemptsTo(Enter.theValue(descripcion).into(DESCIPCION));
			actor.attemptsTo(Click.on(BUSCAR),EsperarCargando.pagina());
			actor.attemptsTo(Click.on(REGISTRO_SELECCIONAR.of("1")));
			
			indice++;
		}

	}

	public static FiltroTecnologiasGlosa paraCrearGlosa() {
		return Tasks.instrumented(FiltroTecnologiasGlosa.class,"Crear");
	}
	
	public static FiltroTecnologiasGlosa paraLevantarGlosa() {
		return Tasks.instrumented(FiltroTecnologiasGlosa.class,"Levantar");
	}

	public void darValores(Tecnologias tecnologia) {
		this.codigo = tecnologia.getCodigo();
		this.descripcion = tecnologia.getDescripcion();
		this.tipo = tecnologia.getTipo();
	}



}
