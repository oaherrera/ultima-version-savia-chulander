package com.conexia.qa.savia.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class TomarEvidencia implements Interaction{

	private static String evidencia ;
	
	@Step("#evidencia")
	@Override
	public <T extends Actor> void performAs(T actor) {
//		Shutterbug.shootPage(OwnWebDriver.getDriver()).save();
//		Serenity.takeScreenshot();;
	}

	public static TomarEvidencia delTexto(String texto) {
		evidencia= texto;
		return Tasks.instrumented(TomarEvidencia.class, evidencia);
	}
	
	public static TomarEvidencia delQuery(String query,String respuesta, int registros) {
		evidencia= "Query:\n\n"+query+"\n\n Respuesta: \n\n"+respuesta+"\n\n Registros:"+registros;
		return Tasks.instrumented(TomarEvidencia.class, evidencia);
	}
	
}
