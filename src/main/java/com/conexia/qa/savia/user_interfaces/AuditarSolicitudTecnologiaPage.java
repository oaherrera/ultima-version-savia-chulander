package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class AuditarSolicitudTecnologiaPage {
    public static Target ACCION = Target.the("Accion tecnologia {0}").locatedBy("(//span[.='{0}']/following::label[contains(@id,'respuestaAuditor:selectEnum_label')])[1]");
    public static Target ACCION_SELECCION = Target.the("Selecciona accion {0}").locatedBy("//div[contains(@id,'respuestaAuditor:selectEnum_panel') and contains(@style,'display: block')]//li[.='{0}']");
    public static Target DIRECCIONAMIENTO_NOMBRE_IPS = Target.the("Direccionamiento ips nombre").locatedBy("//a[contains(@id,'cambiarIpsDireccionamiento')]");
    public static Target REGISTRO_DIRECCIONAMIENTO_IPS = Target.the("Registro numero 1").locatedBy("//tbody[contains(@id,'dataTableBuscarIpsDireccionamientobuscarIpsDireccionamientoComposite')]/tr[@data-ri='0']");
    public static Target COMMENTARIOS = Target.the("Comentarios para {0}").locatedBy("(//span[.='{0}']/following::textarea[contains(@id,'comentarios')])[1]");
    public static Target MOTIVO = Target.the("Motivo para {0}").locatedBy("(//span[.='{0}']/following::label[contains(@id,'motivo:selectEnum_label')])[1]");
    public static Target MOTIVO_SELECCION = Target.the("Motivo seleccionado {0}").locatedBy("//li[.='{0}' and @role='option']");
    public static Target TIPO_AUDITOR = Target.the( "Tipo Auditor para {0}").locatedBy("(//span[.='{0}']/following::label[contains(@id,'tiposAuditor:selectEnum_label')])[1]");
    public static Target TIPO_AUDITOR_SELECCION = Target.the("Tipo auditor seleccionado {0}").locatedBy("(//div[contains(@id,'tiposAuditor:selectEnum_panel') and contains(@style,'display: block')]//following::li[.='{0}' and @role='option'])[1]");
}
