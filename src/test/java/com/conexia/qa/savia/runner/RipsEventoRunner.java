package com.conexia.qa.savia.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Rips/cargue_y_validacion_rips_evento.feature",
        snippets = SnippetType.CAMELCASE,
        glue = "com.conexia.qa.savia.step_definitions",
		tags = "@RevisarFacturasCuentaEps,@RegistroCuentaEps")
        //tags = "@CargarRipsDeEvento,@CambioDeEstadoValidadoAPendienteHomologacion,@GestionarCuentaEnviarHomologar,@GestionarCuentaFinalizarHomologacion,@GestionarCuentaEnviarAVerificarEPS,@RevisarFacturasCuentaEps,@RegistroCuentaEps")
//		tags = "@RevisarFacturasCuentaEps,@RegistroCuentaEps")

public class RipsEventoRunner {

}
