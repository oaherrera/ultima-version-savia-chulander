package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PortafolioSedesDelPrestadorPage {
    public static final Target TAB_SEDES_DEL_PRESTADOR = Target.the("Sedes del prestador").locatedBy("//a[@data-toggle='tab' and .='Sedes del prestador']");
    public static final Target EDITAR_SERVICIOS_SEDE = Target.the("Editar servicios sedes {0}").locatedBy("//table[@id='tablaSedes']//tr/td[.='{0}']/following::a[@title='Editar Servicios Sede']");

}
