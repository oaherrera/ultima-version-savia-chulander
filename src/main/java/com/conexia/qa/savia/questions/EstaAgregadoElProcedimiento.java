package com.conexia.qa.savia.questions;

import com.conexia.qa.savia.tasks.FiltroProcedimiento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.conexia.qa.savia.user_interfaces.PortafolioProcedimientoPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EstaAgregadoElProcedimiento implements Question<Boolean> {
    private String codigoProcedimiento;
    private String descripcionProcedimiento;

    public EstaAgregadoElProcedimiento(String codigoProcedimiento, String descripcionProcedimiento) {
        this.codigoProcedimiento = codigoProcedimiento;
        this.descripcionProcedimiento = descripcionProcedimiento;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        if (!FILTRO_DESCRIPCION_PROCEDIMIENTO.resolveFor(actor).isVisible()) {
            System.out.println("novisible");
            return false;
        }
        theActorInTheSpotlight().attemptsTo(FiltroProcedimiento.enPortafolio(codigoProcedimiento,  descripcionProcedimiento));
        return REGISTRO_PROCEDIMIENTO_FILTRADO.of(descripcionProcedimiento).resolveFor(actor).isVisible();

    }

    public static EstaAgregadoElProcedimiento alPortafolio(String codigoProcedimiento, String descripcionProcedimiento) {
        return new EstaAgregadoElProcedimiento(codigoProcedimiento, descripcionProcedimiento);
    }


}
