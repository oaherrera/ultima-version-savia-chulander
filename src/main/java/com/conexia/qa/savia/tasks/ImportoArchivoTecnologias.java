package com.conexia.qa.savia.tasks;

import static com.conexia.qa.savia.modelos.ImportarTecnologiasEvento.cantidadTecnologias;
import static com.conexia.qa.savia.modelos.ImportarTecnologiasEvento.traerImportTecnologia;
import static com.conexia.qa.savia.user_interfaces.NegociacionTecnologiasPage.IMPORTAR_MEDICAMENTOS;
import static com.conexia.qa.savia.user_interfaces.NegociacionTecnologiasPage.TAB_MEDICAMENTOS;

import com.conexia.qa.excel.tasks.LeeExcel;
import com.conexia.qa.savia.interactions.AdjuntoArchivo;
import com.conexia.qa.savia.interactions.Esperar;
import com.conexia.qa.savia.interactions.TomarEvidencia;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class ImportoArchivoTecnologias implements Task {

	public ImportoArchivoTecnologias() {
	}

	@Step("{0} Carga los archivos de las tecnologias a la negociación")
	@Override
	public <T extends Actor> void performAs(T actor) {
		int indice = 0;
		actor.attemptsTo(TomarEvidencia.delTexto("Importo las tecnologias "));
		while (indice < cantidadTecnologias()) {
			switch (traerImportTecnologia(indice).getTecnologia()) {
			case "Medicamentos":
				actor.attemptsTo(Click.on(TAB_MEDICAMENTOS),Esperar.por(2000));
				actor.attemptsTo(AdjuntoArchivo.con(traerImportTecnologia(indice).getArchovACargar(), IMPORTAR_MEDICAMENTOS));
				actor.attemptsTo(LeeExcel.delArchivo(traerImportTecnologia(indice).getArchovACargar()));
				break;
			case "Insumos":
				break;
			}
			actor.attemptsTo(TomarEvidencia.delTexto("Tecnologia Cargada"));
			indice++;
		}

	}

	public static ImportoArchivoTecnologias conLosDatosDelModelo() {
		return Tasks.instrumented(ImportoArchivoTecnologias.class);
	}

}
