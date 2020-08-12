package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class GeneraGlosaFacturaPage {

	public static final Target MOTIVO_GLOSA = Target.the("Motivo Glosa").locatedBy("//label[contains(@id,'motivoGlosa_label')]");
	public static final Target MOTIVO_GLOSA_SELECCION = Target.the("Motivo Glosa {0}").locatedBy("//li[contains(@id,'motivoGlosa_') and @data-label='{0}']");
	public static final Target MOTIVO_CODIGO_GLOSA = Target.the("Motivo o código glosa").locatedBy("//input[contains(@id,'seleccionGlosa_input')]");
	public static final Target MOTIVO_CODIGO_GLOSA_SELECCION = Target.the("Motivo o código glosa {0}").locatedBy("//li[@role='option' and @data-item-label='{0}']");
	public static final Target TIPO_GLOSA_TOTAL = Target.the("Tipo glosa total").locatedBy("//input[contains(@id,'tipoGlosa')]/following::span[.='Total']");
	public static final Target TIPO_GLOSA_TOTAL_ACTIVO = Target.the("Tipo glosa total").locatedBy("//input[contains(@id,'tipoGlosa')]/following::span[.='Total']/ancestor::div[1]");
	public static final Target TIPO_GLOSA_PARCIAL = Target.the("Tipo glosa parcial").locatedBy("//input[contains(@id,'tipoGlosa')]/following::span[.='Parcial']");
	public static final Target TIPO_GLOSA_PARCIAL_ACTIVO = Target.the("Tipo glosa parcial").locatedBy("//input[contains(@id,'tipoGlosa')]/following::span[.='Parcial']/ancestor::div[1]");
	public static final Target VALOR_GLOSA = Target.the("Valor glosa").locatedBy("//input[contains(@id,'valorGlosa_input')]");
	public static final Target JUSTIFICACION = Target.the("Justificacion").locatedBy("//textarea[contains(@id,'observacionGlosa')]");
	public static final Target ADICIONAR_MOTIVO = Target.the("Adicionar Motivo").locatedBy("//button[@type='submit' and .='Adicionar motivo']");
	public static final Target GENERAR_GLOSA = Target.the("Generar glosa").locatedBy("//button[@type='submit']/span[.='Generar glosa factura']");
	public static final Target GENERAR_GLOSA_DEL_ITEM = Target.the("Generar glosa").locatedBy("//button[@type='submit']/span[.='Generar glosa del item']");

	// tabla con los motivos de glosa agregados
	public static final Target DESCRIPCION = Target.the("Tabla Descripcion registro {0}").locatedBy("//tbody[contains(@id,'motivosGlosa_data')]/tr[{0}]/td[2]");

}
