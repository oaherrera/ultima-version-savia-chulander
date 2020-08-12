package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RadicadoItemDeServicioFacturadosPage {

	public static final Target MARCAR_ITEM = Target.the("Marcar Item {0}").locatedBy("//tbody[contains(@id,'consumoItemProcedimientos_data')]/tr[{0}]/td/div[contains(@class,'ui-chkbox')]");
}
