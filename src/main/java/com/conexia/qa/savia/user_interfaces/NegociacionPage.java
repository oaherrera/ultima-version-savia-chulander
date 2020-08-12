package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class NegociacionPage {

	public static final Target CREAR_NEGOCIACION = Target.the("Crear Negociacion").locatedBy("//button[@type='submit']/span[.='Crear negociación']");
	public static final Target NUMERO_NEGOCIACION_FILTRO = Target.the("N° Negociacion tabla filtro").locatedBy("//thead[contains(@id,'negociacionesPrestador_head')]/tr/th[.='No. Negociación']/child::input");
	public static final Target VER_NEGOCIACION = Target.the("Ver negociacion").locatedBy("//button[contains(@id,'btnVerNegociacion')]");
	public static final Target TABLA_ENCABEZADO = Target.the("Tabla Encabezado").locatedBy("//div[@class='ui-scrollpanel ui-scrollpanel-native ui-widget ui-widget-content ui-corner-all']");

	// Crear Negociación
	public static final Target MODALIDAD_NEGOCIACION = Target.the("Modalidad Negociacion").locatedBy("//label[contains(@id,'modalidadNegociacion_label')]");
	public static final Target MODALIDAD_NEGOCIACION_SELECCION = Target.the("Modalidad Negociacion {0}").locatedBy("//div[contains(@id,'modalidadNegociacion_panel')]//li[@data-label='{0}']");
	public static final Target REGIMEN_NEGOCIACION = Target.the("Regimen Negociacion").locatedBy("//label[contains(@id,'regimenNegociacion_label')]");
	public static final Target MODALIDAD_REGIMEN_SELECCION = Target.the("Regimen Negociacion {0}").locatedBy("//div[contains(@id,'regimenNegociacion_panel')]//li[@data-label='{0}']");
	public static final Target POBLACION = Target.the("Poblacion").locatedBy("//input[contains(@id,'poblacionNegociacion')]");
	public static final Target COMPLEJIDAD = Target.the("Complejidad").locatedBy("//label[contains(@id,'complejidadNegociacion_label')]");
	public static final Target COMPLEJIDAD_SELECCION = Target.the("Complejidad {0}").locatedBy("//div[contains(@id,'complejidadNegociacion_panel')]//li[@data-label='{0}']");
	public static final Target AREA_DE_COBERTURA = Target.the("Area de cobertura").locatedBy("//label[contains(@id,'listOpcionesArea_label')]");
	public static final Target AREA_DE_COBERTURA_SELECCION = Target.the("Area de cobertura {0}").locatedBy("//div[contains(@id,'listOpcionesArea_panel')]//li[@data-label='{0}']");

	// Sedes Prestador
	public static final Target NOMBRE_SEDE = Target.the("Nombre de la sede").locatedBy("//thead[contains(@id,'sedesNegociacion')]/tr/th[.='Nombre sede']/child::input");
	public static final Target SELECCIONAR_SEDE = Target.the("Seleccionar sede {0}").locatedBy("//tbody[contains(@id,'sedesNegociacion_data')]/tr/td[.='{0}']/following::span[contains(@class,'ui-chkbox-icon') ][1]");
	public static final Target ASIGNAR_AREA_DE_COBERTURA = Target.the("Asignar Area de Cobertura a {0}").locatedBy("//tbody[contains(@id,'sedesNegociacion_data')]/tr/td[.='{0}']/following::button[contains(@id,'btnInvitar') ][1]/span[1]");

	// Sede principal
	public static final Target SEDE_PRINCIPAL = Target.the("Sede principal").locatedBy("//label[contains(@id,'sedePrincipal_label')]");
	public static final Target SEDE_PRINCIPAL_SELECCION = Target.the("Sede principal {0}").locatedBy("//div[contains(@id,'sedePrincipal_panel')]//li[contains(@data-label,'-{0}')]");
	public static final Target NEGOCIAR_TODAS_LAS_SEDES = Target.the("Negociar todas las sedes").locatedBy("//label[contains(@for,'tipoModalidadNegociacion') and .='{0}']");

}
