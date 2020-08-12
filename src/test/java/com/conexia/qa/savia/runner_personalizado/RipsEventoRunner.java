package com.conexia.qa.savia.runner_personalizado;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/Rips/cargue_y_validacion_rips_capita.feature",
		snippets = SnippetType.CAMELCASE, 
		glue = "com.conexia.qa.savia.step_definitions", 
///		tags = "@CargarRipsDeEvento,@CambioDeEstadoValidadoAPendienteHomologacion,@GestionarCuentaEnviarHomologar,@GestionarCuentaFinalizarHomologacion,@GestionarCuentaEnviarAVerificarEPS,@RevisarFacturasCuentaEps,@RegistroCuentaEps")
		tags = "@RevisarFacturasCuentaEps,@RegistroCuentaEps")

public class RipsEventoRunner {

}
