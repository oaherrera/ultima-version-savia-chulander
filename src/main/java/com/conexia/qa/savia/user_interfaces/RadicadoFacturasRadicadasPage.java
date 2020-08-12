package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RadicadoFacturasRadicadasPage {

	public static final Target MARCAR_TODOS = Target.the("Marcar todos").locatedBy("(//span[.='Marcar todos']/following::div/span)[1]");
	public static final Target MARCAR_COMO_REVISADO = Target.the("Marca como Revisado").locatedBy("//Button[@type='submit']/span[.='Marcar como revisado']");
	public static final Target TABLA_ENCABEZADO = Target.the("Tabla").locatedBy("//div[@class='ui-datatable-scrollable-header-box']");
	public static final Target VER_FACTURA = Target.the("Factura {0}").locatedBy("//tbody[contains(@id,'dtCargarRadicado_data')]/tr[{0}]/td[1]/button/span[contains(@class,'pencil')]");
}
