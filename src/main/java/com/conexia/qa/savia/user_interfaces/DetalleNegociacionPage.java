package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DetalleNegociacionPage {

	public static final Target TITULO_DETALLE_NEGOCIACION = Target.the("Titulo detalle de la negociacion").locatedBy("//div[@class='header-title']/h1");
	public static final Target DATOS_GENERALES_PRESTADO = Target.the("Datos generales pestador").locatedBy("//strong[contains(text(),'Datos generales prestador')]");
	public static final Target MODALIDAD_NEGOCIACION = Target.the("Modalidad negociación").locatedBy("//strong[contains(text(),'Modalidad negociacion:')]");
	public static final Target DETALLE_NEGOCIACION = Target.the("Detalle Negociación").locatedBy("//strong[contains(text(),'Detalle negociación:')]");

}
