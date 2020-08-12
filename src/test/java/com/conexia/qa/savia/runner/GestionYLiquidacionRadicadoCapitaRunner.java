package com.conexia.qa.savia.runner;

import static cucumber.api.SnippetType.CAMELCASE;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/GestionLiquidacion/Gestion_Y_Liquidacion_Radicado.feature", snippets = CAMELCASE,
		glue = "com.conexia.qa.savia.step_definitions"
//		 ,tags = "@LegalizarCuenta,@LevantoGlosaRadicadoTodasLasFacturas,@GeneroGlosaTotalRadicadoTodasLasFacturas,@MarcarCuentasRevisadas,@AsignoAusitoryLiquidador,@FinalizarAuditoriaAuditorMedico,@CierreDeCuentaLiquidador"
		, tags = "@LegalizarCuenta"

)

public class GestionYLiquidacionRadicadoCapitaRunner {

}
