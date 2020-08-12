package com.conexia.qa.savia.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Portafolio/PortafolioEvento.feature"
        , snippets = SnippetType.CAMELCASE
        , glue = "com.conexia.qa.savia.step_definitions"
        , tags = "@AgregoProcedimientoAlPortafolio")
public class PortafolioEventoRunner {
}
