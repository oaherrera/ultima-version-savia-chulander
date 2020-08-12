package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.TAB_DE_MEDICAMENTOS;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.TIPO_CATASTROFICO;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.TIPO_CATASTROFICO_SELECCION;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.VIA_DE_ADMINISTRACION;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.VIA_DE_ADMINISTRACION_SELECCION;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.savia.interactions.Esperar;

import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.ADVERTENCIA_NO_ELIMINAR_MEDICAMENTO;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.AGREGAR_PRESCRIPCION_MEDICAMENTO;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.CAUSA_EXTERNA;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.CAUSA_EXTERNA_SELECCION;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.CODIGO_DESCRIPCION;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.CODIGO_DESCRIPCION_SELECCION;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.DOSIS;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.DURACION_TRATAMIENTO_DIAS;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.FINALIDAD;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.FINALIDAD_SELECCION;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.FRECUENCIA;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.FRECUENCIA_TIPO;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.FRECUENCIA_TIPO_SELECCION;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.GUARDAR;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.POSOLOGIA;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.SERVICIO;
import static com.conexia.qa.savia.user_interfaces.MedicamentoPage.SERVICIO_SELECCION;

import com.conexia.qa.savia.interactions.EsperarCargando;
import com.conexia.qa.sql.colecciones.MedicamentosBD;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class AgregaMedicamento implements Task {

    private String tipologia;
    private String codigoMedicamento;
    private String descripcionMedicamento;
    private String servicio;
    private String causaExterna;
    private String finalidad;
    private String tipoCatastrofico;
    private String dosis;
    private String frecuencia;
    private String frecuenciaTipo;
    private String viaDeAdministracion;
    private String DuracionTratamientoEnDias;
    private String Posologia;


    public AgregaMedicamento(String tipologia, String codigoMedicamento, String descripcionMedicamento, String servicio, String causaExterna, String finalidad,
                             String tipoCatastrofico, String dosis, String frecuencia, String frecuenciaTipo, String viaDeAdministracion,
                             String duracionTratamientoEnDias, String posologia) {
        this.tipologia = tipologia;
        this.codigoMedicamento = codigoMedicamento;
        this.descripcionMedicamento = descripcionMedicamento;
        this.servicio = servicio;
        this.causaExterna = causaExterna;
        this.finalidad = finalidad;
        this.tipoCatastrofico = tipoCatastrofico;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
        this.frecuenciaTipo = frecuenciaTipo;
        this.viaDeAdministracion = viaDeAdministracion;
        this.DuracionTratamientoEnDias = duracionTratamientoEnDias;
        this.Posologia = posologia;
    }

    @Step("{0} agrega un medicamento a la autorizacion #descripcionMedicamento ")
    @Override
    public <T extends Actor> void performAs(T actor) {
        takeScreenshot();
        actor.attemptsTo(Click.on(TAB_DE_MEDICAMENTOS));
        actor.attemptsTo(Enter.theValue(codigoMedicamento + " " + descripcionMedicamento).into(CODIGO_DESCRIPCION));
        actor.attemptsTo(Click.on(CODIGO_DESCRIPCION_SELECCION.of(descripcionMedicamento)));
        actor.attemptsTo(Click.on(SERVICIO));
        actor.attemptsTo(Click.on(SERVICIO_SELECCION.of(servicio)));
        actor.attemptsTo(Esperar.por(2000));
        takeScreenshot();
        if (MedicamentosBD.traerMedicamentos().traerMedicamento(0).getCodigoDiagnostico() == null) {
            actor.attemptsTo(Click.on(ADVERTENCIA_NO_ELIMINAR_MEDICAMENTO),EsperarCargando.pagina());
        }
        if(ADVERTENCIA_NO_ELIMINAR_MEDICAMENTO.resolveFor(actor).isVisible()){
            actor.attemptsTo(Click.on(ADVERTENCIA_NO_ELIMINAR_MEDICAMENTO));
        }
        takeScreenshot();
        if (tipologia.equalsIgnoreCase("PBS") || tipologia.equalsIgnoreCase("Condicionado")) {
            actor.attemptsTo(EsperarCargando.pagina(), Click.on(AGREGAR_PRESCRIPCION_MEDICAMENTO));
            takeScreenshot();
            actor.attemptsTo(Click.on(CAUSA_EXTERNA));
            actor.attemptsTo(Click.on(CAUSA_EXTERNA_SELECCION.of(causaExterna)));
            actor.attemptsTo(Click.on(FINALIDAD));
            actor.attemptsTo(Click.on(FINALIDAD_SELECCION.of(finalidad)));
            actor.attemptsTo(Click.on(TIPO_CATASTROFICO));
            actor.attemptsTo(Click.on(TIPO_CATASTROFICO_SELECCION.of(tipoCatastrofico)));
            actor.attemptsTo(Enter.theValue(dosis).into(DOSIS));
            actor.attemptsTo(Enter.theValue(frecuencia).into(FRECUENCIA));
            actor.attemptsTo(Click.on(FRECUENCIA_TIPO));
            actor.attemptsTo(Click.on(FRECUENCIA_TIPO_SELECCION.of(frecuenciaTipo)));
            actor.attemptsTo(Click.on(VIA_DE_ADMINISTRACION));
            actor.attemptsTo(Click.on(VIA_DE_ADMINISTRACION_SELECCION.of(viaDeAdministracion)));
            actor.attemptsTo(Enter.theValue(DuracionTratamientoEnDias).into(DURACION_TRATAMIENTO_DIAS));
            actor.attemptsTo(Enter.theValue(Posologia).into(POSOLOGIA));
            takeScreenshot();
            actor.attemptsTo(Click.on(GUARDAR), EsperarCargando.pagina());
        }
    }

    public static AgregaMedicamento conLosDatos(String tipologia, String codigoMedicamento, String descripcionMedicamento, String servicio, String causaExterna,
                                                String finalidad, String tipoCatastrofico, String dosis, String frecuencia, String frecuenciaTipo,
                                                String viaDeAdministracion, String DuracionTratamientoEnDias, String Posologia) {

        return Tasks.instrumented(AgregaMedicamento.class, tipologia, codigoMedicamento, descripcionMedicamento, servicio, causaExterna, finalidad,
                tipoCatastrofico, dosis, frecuencia, frecuenciaTipo, viaDeAdministracion, DuracionTratamientoEnDias,
                Posologia);
    }

}
