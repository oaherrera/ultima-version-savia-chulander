package com.conexia.qa.savia.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/SolicitudAutorizacion/carga_masiva_solicitud.feature",
        snippets = SnippetType.CAMELCASE,
        monochrome = true,
        glue = "com.conexia.qa.savia.step_definitions",
        //tags = "@autorizacionPBS"
        //tags = "@autorizacionNoPBS"
//        tags = "@autorizacionCondicionada"
        tags = "@cargueArchivoCorrecto"



)


public class CargueMasivoSolicitudAutorizacion {


}
