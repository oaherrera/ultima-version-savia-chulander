package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CommonPage {
	public static final Target CARGANDO = Target.the("Cargando Pagina").locatedBy("//img[contains(@src,'ajaxloadingbar.gif')]");
	public static final Target CARGANDO_PROCESANDO = Target.the("Cargando Pagina").locatedBy("//div[@class='blockUI blockMsg blockPage']");
	public static final Target ADJUNTAR_ARCHIVO = Target.the("Adjuntar Archivo").locatedBy("//input[@type='file']");
	public static final Target BARRA_DE_CARGANDO_ARCHIVO = Target.the("Barra de Cargando Archivo").locatedBy("//div[@role='progressbar']/div[contains(@style,'display')]");
	public static final Target VOLVER = Target.the("Volver").locatedBy("//button[@role='button']/span[.='Volver']");
	public static final Target CONFIRMAR_ACEPTAR = Target.the("Confirmar Aceptar").locatedBy("//div[contains(@style,'display: block')]//button[contains(@class,'ui-confirmdialog')]/span[.='Aceptar']");
	public static final Target CONFIRMAR_SI = Target.the("Confirmar Si").locatedBy("//div[contains(@style,'display: block')]//button[contains(@class,'ui-confirmdialog')]/span[.='Si']");
	public static final Target BUSCAR = Target.the("Buscar").locatedBy("//button[@type='submit']/span[.='Buscar']");
	public static final Target GUARDAR = Target.the("Guardar").locatedBy("//button[@type='submit']/span[.='Guardar']");
	public static final Target AGREGAR = Target.the("Agregar").locatedBy("//button[@type='submit']/span[.='Agregar']");
	public static final Target ASIGNAR = Target.the("Asignar").locatedBy("//button[@type='submit']/span[.='Asignar']");
	public static final Target ACEPTAR = Target.the("Aceotar").locatedBy("//button[@type='submit']/span[.='Aceptar']");
	public static final Target SIGUIENTE = Target.the("Siguiente").locatedBy("//button[@type='submit']/span[.='Siguiente']");
	public static final Target TERMINAR = Target.the("Terminar").locatedBy("//button[@type='submit']/span[.='Terminar']");
	public static final Target MENSAJE_TEMPORAL = Target.the("Mensaje Temporal").locatedBy("//div[@class='ui-growl-message']/span");
	public static final Target MENSAJE_TEMPORAL_TEXTO = Target.the("Mensaje Temporal").locatedBy("(//div[@class='ui-growl-message']/span/following::p)[1]");
	public static final Target MENSAJE_CONFIRMACION = Target.the("Mensaje Confirmación").locatedBy("//div[contains(@style,'display: block')]//span[@class='ui-confirm-dialog-message']");
	public static final Target CERRAR_VENTANA_DIALOGO = Target.the("Cerrar Ventana").locatedBy("//div[@role='dialog' and contains(@style,'display: block')]//span[contains(@class,'ui-icon-closethick')]");
    public static final Target SALIR_DEL_SISTEMA = Target.the("Salir del sistema").locatedBy("//a[contains(@href,'logout.do')]");

}
