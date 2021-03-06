package com.conexia.qa.savia.runner_personalizado;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Rips/cargue_y_validacion_rips_capita.feature",
		snippets = SnippetType.CAMELCASE,
//		monochrome = true,
		glue = "com.conexia.qa.savia.step_definitions"
		, tags = "@GestionarCuentaEnviarAVerificarEPS,@RevisarFacturasCuentaEps,@RegistroCuentaEps"
		//, tags = "@CargarRipsDeCapita,@GestionarCuentaEnviarAVerificarEPS,@RevisarFacturasCuentaEps,@RegistroCuentaEps "
)

public class RipsCapitaRunner {

}
