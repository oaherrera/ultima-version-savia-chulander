package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CargueMasivoSolicitudPage {
    public static final Target ESTADO_CARGUE = Target.the("EstadoC Cargue {0}").locatedBy("(//tbody[contains(@id,'dtCargue_data')]/tr/td[text()='{0}'])/following::td[2]");
    public static final Target PROCESAR = Target.the("Procesar {0}").locatedBy("(//tbody[contains(@id,'dtCargue_data')]/tr/td[text()='{0}'])//preceding::td[1]/a[1]");
    public static final Target CONFIRMAR_SI = Target.the("Confirmar Si").locatedBy("//div[contains(@style,'display: block')]//button[contains(@class,'button')]/span[text()='Sí']");    
}
