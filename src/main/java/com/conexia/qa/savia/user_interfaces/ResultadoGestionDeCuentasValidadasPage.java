package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ResultadoGestionDeCuentasValidadasPage {
	public static final Target NUMERO_CUENTA = Target.the("Resultado Numero de Cuenta").locatedBy("//tbody[contains(@id,'tablaCuentas_data')]/tr/td[1][.='{0}']");
	public static final Target ESTADO = Target.the("Resultado Estado de Cuenta").locatedBy("//tbody[contains(@id,'tablaCuentas_data')]/tr/td[7][.='{0}']");
	public static final Target ESTADO_ACTUAL = Target.the("Resultado Estado de Cuenta").locatedBy("//tbody[contains(@id,'tablaCuentas_data')]/tr/td[7]");
}
