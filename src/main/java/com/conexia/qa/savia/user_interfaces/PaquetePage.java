package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.apache.poi.ss.formula.functions.T;

public class PaquetePage {

    public static final Target TAB_PAQUETE = Target.the("Tab de paquetes").locatedBy("(//a[contains(@href,'prescripciones:tabs:')][.='Paquetes'])[1]");
    public static final Target CODIGO_DESCRIPCION = Target.the("Codigo o Descripcion").locatedBy("//input[contains(@id,'campoAutocomplete4_input')]");
    public static final Target CODIGO_DESCRIPCION_SELECCION = Target.the("Codigo o Descripcion {0}").locatedBy("//li[@role='option' and contains(@class,'autocomplete-item') and @data-item-label='{0}']");
    public static final Target DIAGNOSTICO = Target.the("Diagnostico").locatedBy("(//select[contains(@id,'listaPaquetes:paquetesTable')])[2]");
    public static final Target DIAGNOSTICO_SELECCION = Target.the("Selección Diagnostico").locatedBy("(//select[contains(@id,'listaPaquetes:paquetesTable')])[2]/option[contains(text(),'{0}')]");
    public static final Target AGREGAR_PAQUETE = Target.the("Agregar paquete").locatedBy("//a[contains(@id,'paquete') and @title= 'Agregar prescripción paquete']");
    public static final Target ES_POSFECHADO = Target.the("Es posfechado").locatedBy("//label[text()='¿Es posfechado?']//ancestor::div[1]/div/div[2]/span");
    public static final Target DURACION_DEL_TRATAMIENTO = Target.the("Duracion del tratamiento").locatedBy("//input[contains(@id,'duracionTratamientoId_input')]");
    public static final Target INDICACIONES = Target.the("Indicaciones").locatedBy("//label[text()='Indicaciones']//following::textarea[1]");
    public static final Target GUARDAR = Target.the("Guardar").locatedBy("//Button[contains(@id,'btnAceptarPrescripcion')]");

}