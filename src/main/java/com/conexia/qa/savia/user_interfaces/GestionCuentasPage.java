package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class GestionCuentasPage {

	public static final Target ENVIAR_A_HOMOLOGAR = Target.the("Enviar cuenta a homologar").locatedBy("//button[@title='Enviar homologar']/span[1]");
	public static final Target CONFIRMAR_SI = Target.the("Si confirmo").locatedBy("//div[contains(@style,'display: block')]/div//span[.='Si']");
	public static final Target FINALIZAR_HOLOGACION = Target.the("Finalizar la homologación").locatedBy("//button[@title='Finalizar homologación']/span[1]");
	public static final Target ACEPTAR = Target.the("Aceptar").locatedBy("//div[contains(@style,'display: block')]/div//span[.='Aceptar']");
	public static final Target ENVIAR_A_VERIFICACION_EPS = Target.the("Enviar a verificación eps").locatedBy("//button[@title='Enviar a Verificación EPS']/span[1]");
}
