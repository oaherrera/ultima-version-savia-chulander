package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class BandejaAuditoriaAutorizacionPage {
    public static final Target NUMERO_SOLICITUD = Target.the("Numero de Solicitud").locatedBy("//input[contains(@id,'inputTextNumeroSolicitudId_input')]");
    public static final Target AMBITO = Target.the("Ambito").locatedBy("//tbody/tr[1]/td[14]");
    public static final Target ACCIONES = Target.the("").locatedBy("//tbody/tr[1]/td[1]");
    public static final Target AUDITAR = Target.the("Auditar {0}").locatedBy("//tbody[contains(@id,'bandeja:auditorias_data')]/tr/td[.='{0}']//preceding::a[@title='Auditar'][1]");
    public static final Target VER = Target.the("Ver {0}").locatedBy("//tbody[contains(@id,'bandeja:auditorias_data')]/tr/td[.='{0}']//preceding::a[@title='Ver'][1]");


}
