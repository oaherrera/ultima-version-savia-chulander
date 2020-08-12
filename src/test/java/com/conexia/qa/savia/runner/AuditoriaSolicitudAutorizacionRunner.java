package com.conexia.qa.savia.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/SolicitudAutorizacion/auditoria_solicitud_autorizacion.feature",
        snippets = SnippetType.CAMELCASE,
        monochrome = true,
        glue = "com.conexia.qa.savia.step_definitions",
        tags = "@TranscripcionDerivarLasTecnologiasEnLaSolicitud"
)


public class AuditoriaSolicitudAutorizacionRunner {


}
