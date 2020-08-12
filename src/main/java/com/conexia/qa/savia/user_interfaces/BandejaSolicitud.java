package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class BandejaSolicitud {
    public static final Target NUMERO_SOLICITUD = Target.the("Filtro nro solicitud").locatedBy("//input[@id='form:filters:numeroComprobante_input']");
    //Resultados
    public static final Target EXPANDIR_REGISTRO = Target.the("Expandir el Registro").locatedBy("//div[contains(@class,'ui-icon-circle-triangle')]");
    public static final Target CANTIDAD_TECNOLOGIAS = Target.the("Cantidad Tecnologias").locatedBy("//tbody[contains(@id,'dtSolicitud_data')]/tr[1]/td[7]");
    public static final Target DESCRIPCION_TECNOLOGIA = Target.the("Descripción tecnologia {0}").locatedBy("//tbody[contains(@id,'dtItem_data')]/tr[@data-ri='{0}']/td[2]");
    public static final Target ESTADO_TECNOLOGIA = Target.the("Estado tecnologia {0}").locatedBy("//tbody[contains(@id,'dtItem_data')]/tr[@data-ri='{0}']/td[3]");
    public static final Target CANTIDAD_SOLICITADA_TECNOLOGIA = Target.the("Cantidad solicitada tecnologia {0}").locatedBy("//tbody[contains(@id,'dtItem_data')]/tr[@data-ri='{0}']/td[4]");
    public static final Target MOTIVO_TECNOLOGIA = Target.the("Motivo tecnologia {0}").locatedBy("//tbody[contains(@id,'dtItem_data')]/tr[@data-ri='{0}']/td[13]");
    public static final Target BANDEJA_AUDITORIA_TECNOLOGIA = Target.the("Bandeja Auditoria tecnologia {0}").locatedBy("//tbody[contains(@id,'dtItem_data')]/tr[@data-ri='{0}']/td[10]");
    public static final Target TABLA = Target.the("tabla").locatedBy("//div[contains(@id,'dtItem')]//table[@role='grid']");

}
