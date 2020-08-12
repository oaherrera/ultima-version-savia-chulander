package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RadicadoGestionRadicadoPage {

	public static final Target CERRAR_CUENTA = Target.the("Cerrar Cuenta").locatedBy("//button[@type='submit' ]/span[.='Cerrar cuenta']");
	public static final Target CONFIRMAR_CIERRE_CUENTA = Target.the("Confirmar Cierre de Cuenta").locatedBy("//button[@type='submit' ]/span[.='Confirmar cerrar cuenta']");
	public static final Target CANTIDAD_FACTURAS_RADICADO = Target.the("Cantidad Cuentas Radicado").locatedBy("//input[contains(@id,'acturasRadicadas')]");
	public static final Target GLOSA_MASIVA_POR_RADICADO = Target.the("Glosa Masiva por radicado").locatedBy("//button[@type='submit' ]/span[.='Glosa masiva por radicado']");
	public static final Target LEVANTAMIENTO_GLOSA_MASIVA = Target.the("Levantamiento glosa masiva").locatedBy("//button[@type='submit' ]/span[.='Levantamiento glosa masiva']");
}
