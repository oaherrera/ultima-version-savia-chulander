package com.conexia.qa.savia.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Rips/cargue_y_validacion_rips_capita.feature",
		snippets = SnippetType.CAMELCASE,
//		monochrome = true,
		glue = "com.conexia.qa.savia.step_definitions"
		//, tags = "@GestionarCuentaEnviarAVerificarEPS,@RevisarFacturasCuentaEps,@RegistroCuentaEps"
		, tags = "@CargarRipsDeCapita,@@CambioDeEstadoValidadoAPendienteHomologacion,@GestionarCuentaEnviarAVerificarEPS,@RevisarFacturasCuentaEps,@RegistroCuentaEps "
)

public class RipsCapitaRunner {

}
