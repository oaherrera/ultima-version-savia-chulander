package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FiltroGlosaPage {
	public static final Target TIPO_TECNOLOGIA = Target.the("Filtro Tecnologia").locatedBy("//label[contains(@id,'tipoTecnologia_label')]");
	public static final Target TIPO_TECNOLOGIA_SELECCION = Target.the("Filtro Tecnologia {0}").locatedBy("//li[contains(@id,'tipoTecnologia_') and contains(@data-label,'{0}')]");
	public static final Target CODIGO = Target.the("Codigo Tecnologia").locatedBy("//input[contains(@id,'compositeFiltroTipoTecnologiaGlosa:codigo')]");
	public static final Target DESCIPCION = Target.the("Descripción Tecnologia").locatedBy("//input[contains(@id,'compositeFiltroTipoTecnologiaGlosa:descripcion')]");
	public static final Target REGISTRO_SELECCIONAR = Target.the("Seleccionar Registro nro {0}").locatedBy("//tbody[contains(@id,'dtTecnologiaGlosa_data')]/tr[{0}]/td//span[contains(@class,'chkbox')]");
}
