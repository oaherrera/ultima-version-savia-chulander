package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class NegociacionAreaDeCoberturaPage {

	public static final Target TITULO_AREA_DE_COBERTURA = Target.the("Titulo Area de cobertura").locatedBy("//span[.='Área de cobertura - Asignar municipios de acuerdo a tabla de general: ']");
	public static final Target SELECCIONAR_AREA_DE_COBSERTURA = Target.the("Seleccionar area").locatedBy("//tbody[contains(@id,'deptoMunicipioCobertura_data')]/tr[1]/td/div/div[contains(@class,'chkbox-box')]");
	public static final Target REPLICAR_AREA = Target.the("Replicar Area").locatedBy("//button[@type='submit']/span[.='Replicar área']");
	
}
