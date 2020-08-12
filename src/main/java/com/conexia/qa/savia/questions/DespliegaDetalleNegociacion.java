package com.conexia.qa.savia.questions;

import static com.conexia.qa.savia.modelos.NegociacionPrestador.traerNegociacionPrestador;
import static com.conexia.qa.savia.user_interfaces.DetalleNegociacionPage.DATOS_GENERALES_PRESTADO;
import static com.conexia.qa.savia.user_interfaces.DetalleNegociacionPage.DETALLE_NEGOCIACION;
import static com.conexia.qa.savia.user_interfaces.DetalleNegociacionPage.TITULO_DETALLE_NEGOCIACION;

import org.hamcrest.Matchers;
import org.junit.Assert;

import com.conexia.qa.savia.user_interfaces.DetalleNegociacionPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class DespliegaDetalleNegociacion implements Question<Boolean>{

	@Override
	public Boolean answeredBy(Actor actor) {
		Serenity.takeScreenshot();
		String Titulo = Text.of(TITULO_DETALLE_NEGOCIACION).viewedBy(actor).asString();
		String DatosPrestador = Text.of(DATOS_GENERALES_PRESTADO).viewedBy(actor).asString();
		String DetalleNegociacion = Text.of(DETALLE_NEGOCIACION).viewedBy(actor).asString();
		String ModalidadNegociacion = Text.of(DetalleNegociacionPage.MODALIDAD_NEGOCIACION).viewedBy(actor).asString();
		
		Assert.assertThat("Titulo erroneo", Titulo, Matchers.containsString(traerNegociacionPrestador().getNumeroNegociacion()));
		Assert.assertThat("Datos prestador erroneo", DatosPrestador, Matchers.containsString(traerNegociacionPrestador().getPrestador()));
		Assert.assertThat("Detalle Negociacion erroneo", DetalleNegociacion, Matchers.containsString(traerNegociacionPrestador().getNumeroNegociacion()));
		Assert.assertThat("Modalidad Negociacion erroneo", ModalidadNegociacion, Matchers.containsString(traerNegociacionPrestador().getModalidad()));
		return true;
	}

	public static DespliegaDetalleNegociacion enLaPantalla() {
		return new DespliegaDetalleNegociacion();
	}

}
