package com.conexia.qa.savia.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PortafolioProcedimientoPage {
    public static final Target FILTRO_GRUPO_HABILITACION = Target.the("Filtro Grupo habilitacion").locatedBy("//table[@id='tablaServicios']/tfoot//th/input[@placeholder='Grupo de habilitación']");
    public static final Target FILTRO_SERVICIO_HABILITACION = Target.the("Filtro Servicio habilitacion").locatedBy("//table[@id='tablaServicios']/tfoot//th/input[@placeholder='Servicio de habilitación']");
    public static final Target REGISTRO_BUSQUEDA_CON_FILTRO = Target.the("Resultado Filtro {0}").locatedBy("(//table[@id='tablaServicios']/tbody//td[text()='{0}'])[1]");
    public static final Target NUEVO_SERVICIO = Target.the("Agregar nuevo Servicio").locatedBy("//button[@id='botonNuevoServicio']");
    //Nuevo Servicio
    public static final Target GRUPO_HABILITACION = Target.the("Grupo Habilitación").locatedBy("//select[@id='selectGrupoServicio']");
    public static final Target GRUPO_HABILITACION_SELECCION = Target.the("Grupo Habilitación {0}").locatedBy("//select[@id='selectGrupoServicio']/option[.='{0}']");
    public static final Target SERVICIO_DE_HABILITACION = Target.the("Servicio de Habilitación").locatedBy("//select[@id='selectServicio']");
    public static final Target SERVICIO_DE_HABILITACION_SELECCION = Target.the("Servicio de Habilitación {0}").locatedBy("//select[@id='selectServicio']/option[.='{0}']");
    public static final Target TARIFARIO = Target.the("Tarifario").locatedBy("//select[@id='selectTarifario']");
    public static final Target TARIFARIO_SELECCION = Target.the("Tarifario {0}").locatedBy("//select[@id='selectTarifario']/option[.='{0}']");
    public static final Target PORCENTAJE_NEGOCIACION = Target.the("Porcentaje Negociacion").locatedBy("//input[@id='inputPorcentNegociacion']");
    public static final Target COMPLEJIDAD = Target.the("complejidad").locatedBy("//select[@id='complejidadServicio']");
    public static final Target COMPLEJIDAD_SELECCION = Target.the("Complejidad {0}").locatedBy("//select[@id='complejidadServicio']/option[.='{0}']");
    public static final Target AGREGAR = Target.the("Agregar Servicios").locatedBy("//form[@id='formNuevoServicio']//button[@data-original-title='Guardar servicio']");
    //ProcedimientoEdiciónIndividual
    public static final Target EDITAR_SERVICIO = Target.the("Editar Serivio {0}").locatedBy("//table[@id='tablaServicios']/tbody//td[.='{0}']//following::a[@title='Editar Servicio'][1]");
    public static final Target FILTRO_DESCRIPCION_PROCEDIMIENTO = Target.the("Filtro Descripcion procedimiento").locatedBy("//table[@id='tablaProcedimientosPortafolio']/tfoot//th/input[@placeholder='Descripción']");
    public static final Target FILTRO_CUPS = Target.the("Filtro Cups").locatedBy("//table[@id='tablaProcedimientosPortafolio']/tfoot//th/input[@placeholder='CUPS']");
    public static final Target REGISTRO_PROCEDIMIENTO_FILTRADO = Target.the("Procedimiento Filtrado {0}").locatedBy("//table[@id='tablaProcedimientosPortafolio']/tbody//td[.='{0}']");
    public static final Target BUSCAR_PROCEDIMIENTO = Target.the("Buscar procedimiento").locatedBy("//button[@data-original-title='Buscar procedimiento(s) existente(s) para agregarlo(s) al portafolio']");
    //Buscar Procedimiento
    public static final Target DESCRIPCION_PROCEDIMIENTO = Target.the("Descripciono procedimiento").locatedBy("//div[@id='buscarProcedimientosForm']//input[@id='descripcionServicioBusqueda']");
    public static final Target CUPS = Target.the("Cups").locatedBy("//div[@id='buscarProcedimientosForm']//input[@id='cupsBusqueda']");
    public static final Target BUSCAR = Target.the("Buscar").locatedBy("//div[@id='buscarProcedimientosForm']//button[@data-original-title='Buscar procedimientos']");
    public static final Target TARIFARIO_DIFERENCIAL = Target.the("Chekear Tarifario para {0}").locatedBy("//table[@id='tablaBusquedaProcedimientos' and @style='display: table;']/tbody/tr/td[.='{0}']/following::input[@id='tarifarioDiferencial'][1]");
    public static final Target TARIFARIO_PROCEDIMIENTO = Target.the("Tarifario para {0}").locatedBy("//table[@id='tablaBusquedaProcedimientos' and @style='display: table;']/tbody/tr/td[.='{0}']/following::select[@id='tarifario'][1]");
    public static final Target TARIFARIO_PROCEDIMIENTO_SELECCION = Target.the("Tarifario {1}").locatedBy("//table[@id='tablaBusquedaProcedimientos' and @style='display: table;']/tbody/tr/td[.='{0}']/following::select[@id='tarifario']/option[.='{1}'][1]");
    public static final Target VALOR = Target.the("Valor para {0}").locatedBy("//table[@id='tablaBusquedaProcedimientos' and @style='display: table;']/tbody/tr/td[.='{0}']/following::input[@id='valorOfertado'][1]");
    public static final Target SELLECCION_REGISTRO = Target.the("Seleccion registro").locatedBy("//table[@id='tablaBusquedaProcedimientos' and @style='display: table;']/tbody/tr/td[.='{0}']/following::input[@id='seleccionado'][1]");
    public static final Target AGREGAR_AL_PORTAFOLIO = Target.the("Agregar al portafolio").locatedBy("//button[@id='btnAgregarServiciosPortafolio']");

}
