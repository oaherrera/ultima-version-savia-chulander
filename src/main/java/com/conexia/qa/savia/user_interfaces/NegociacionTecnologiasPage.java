package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class NegociacionTecnologiasPage {

    public static final Target TAB_MEDICAMENTOS = Target.the("Tab Medicamentos").locatedBy("//div[contains(@id,'tabsTecnologias')]//following::a[contains(@href,'tabsTecnologias:tabMedicamentos')]");
    public static final Target IMPORTAR_MEDICAMENTOS = Target.the("Importar Medicamentos").locatedBy("//input[@type='file' and contains(@id,'btnImportarMedicamentos_input')]");
    public static final Target GESTIONAR_MEDICAMENTOS = Target.the("Gestionar Servicios").locatedBy("//label[contains(@id,'gestionMedicamentos_label')]");
    public static final Target SELECCIONAR_TODOS_MEDICAMENTOS = Target.the("Seleccionar Todos").locatedBy("//div[contains(@id,'gestionMedicamentos_panel')]//li[contains(@class,'ui-selectonemenu-item') and .='Seleccionar todos']");
    public static final Target BORRAR_TODOS_MEDICAMETOS = Target.the("Borrar Todos").locatedBy("//div[contains(@id,'gestionMedicamentos_panel')]//li[contains(@class,'ui-selectonemenu-item') and .='Borrar seleccionados']");
    public static final Target CONFIRMAR_ACEPTAR_ELIMINAR_MEDICAMENTOS = Target.the("Aceptar").locatedBy("//span[contains(text(),'Medicamentos')]/ancestor::div[contains(@class,'ui-confirm-dialog')]//span[.='Aceptar']");

    public static final Target TAB_PROCEDMIENTOS = Target.the("Tab Procedimientos").locatedBy("//div[contains(@id,'tabsTecnologias')]//following::a[contains(@href,'tabsTecnologias:tabServicios')]");
    public static final Target GESTIONAR_SERVICIOS = Target.the("Gestionar Servicios").locatedBy("//label[contains(@id,'gestionServicios_label')]");
    public static final Target SELECCIONAR_TODOS_PROCEDIMIENTOS = Target.the("Seleccionar Todos").locatedBy("//div[contains(@id,'gestionServicios_panel')]//li[contains(@class,'ui-selectonemenu-item') and .='Seleccionar todos']");
    public static final Target BORRAR_TODOS_PROCEDIMIENTOS = Target.the("Borrar Todos").locatedBy("//div[contains(@id,'gestionServicios_panel')]//li[contains(@class,'ui-selectonemenu-item') and .='Borrar seleccionados']");
    public static final Target CONFIRMAR_ACEPTAR = Target.the("Aceptar").locatedBy("(//div[contains(@style,'display: block')]//button[contains(@class,'btn-info')]/span[.='Aceptar'])[2]");

}
