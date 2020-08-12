package com.conexia.qa.excel.tasks;

import com.conexia.qa.excel.modelos.DatosExcel;
import com.conexia.qa.excel.utilitario.Excel_xlsx;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class LeeExcel implements Task {

	private String rutaArchivo;

	public LeeExcel(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		DatosExcel.Registros = Excel_xlsx.traerExcel().leerExcel(rutaArchivo);
	}

	public static LeeExcel delArchivo(String rutaArchivo) {
		return Tasks.instrumented(LeeExcel.class, rutaArchivo);
	}

}
