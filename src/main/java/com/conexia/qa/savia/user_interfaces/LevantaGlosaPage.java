package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LevantaGlosaPage {

	public static final Target PESTAÑA_LEVANTAR_GLOSA = Target.the("Pestaña Levantar glosa").locatedBy("//div[contains(@id,'tabGestionMasivas')]//a[@tabindex='-1' and .='Levantar glosa']");
	public static final Target MOTIVO_LEVANTAMIENTO = Target.the("Motivo Levantamietno").locatedBy("(//label[contains(@id,'motivosLevantamiento_label')])[1]");
	public static final Target MOTIVO_LEVANTAMIENTO_SELECCION = Target.the("Motivo Levantamietno {0}").locatedBy("(//li[contains(@id,'motivosLevantamiento_') and .='{0}'])");
	public static final Target JUSTIFICACION = Target.the("Justificacion").locatedBy("//div[contains(@style,'display: block;')]//textarea[contains(@id,'observacionGlosa')]");
	public static final Target JUSTIFICACION_MASIVO = Target.the("Justificacion").locatedBy("//textarea[contains(@id,'observacionGlosa')]");
	public static final Target LEVANTAR_GLOSA = Target.the("Levantar Glosa").locatedBy("//button[@type='submit']/span[.='Levantar glosa']");

}
