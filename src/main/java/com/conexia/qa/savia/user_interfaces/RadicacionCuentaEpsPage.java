package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RadicacionCuentaEpsPage {

	public static final Target REGIONAL = Target.the("Regional").locatedBy("(//table[contains(@id,'GridDatosCuenta')]//label[contains(@class,'selectonemenu')])[1]");
	public static final Target REGIONAL_SELECCION = Target.the("Regional").locatedBy("//div[contains(@style,'display: block')]//li[.='{0}']");
	public static final Target RESPONSABLE_DE_PAGO = Target.the("Responsable de pago").locatedBy("(//table[contains(@id,'GridDatosCuenta')]//label[contains(@class,'selectonemenu')])[2]");
	public static final Target RESPONSABLE_DE_PAGO_SELECCION = Target.the("Responsable de pago").locatedBy("//div[contains(@style,'display: block')]//li[.='{0}']");
	public static final Target OBSERVACION = Target.the("Observaciones").locatedBy("//td[.='Observación:']/following::textarea[contains(@id,'formTablaCuentas:')]");
	public static final Target REGISTRAR = Target.the("Registrar").locatedBy("//button[@title='Registrar']/span[.='Registrar']");
}
