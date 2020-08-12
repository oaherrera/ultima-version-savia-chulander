package com.conexia.qa.savia.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.conexia.qa.savia.user_interfaces.PortafolioProcedimientoPage.*;

public class EstaAgregadoElServicio implements Question<Boolean> {

    private String descripcionGrupoServicio;

    public EstaAgregadoElServicio(String descripcionGrupoServicio) {
        this.descripcionGrupoServicio = descripcionGrupoServicio;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return REGISTRO_BUSQUEDA_CON_FILTRO.of(descripcionGrupoServicio).resolveFor(actor).isVisible();
    }

    public static EstaAgregadoElServicio alPortafoliio(String descripcionGrupoServicio) {
        return new EstaAgregadoElServicio(descripcionGrupoServicio);
    }
}

