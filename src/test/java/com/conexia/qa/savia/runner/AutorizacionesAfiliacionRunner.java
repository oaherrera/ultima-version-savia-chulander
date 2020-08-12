package com.conexia.qa.savia.runner;

import com.conexia.qa.savia.runner_personalizado.RunnerPersonalizado;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
        features = "src/test/resources/features/SolicitudAutorizacion/autorizaciones_afiliacion.feature",
        snippets = SnippetType.CAMELCASE,
        monochrome = true,
        glue = "com.conexia.qa.savia.step_definitions",
        //tags = "@autorizacionPBS"
        //tags = "@autorizacionNoPBS"
//        tags = "@autorizacionCondicionada"
        tags = "@autorizacionNoPBS"



)


public class AutorizacionesAfiliacionRunner {


}
