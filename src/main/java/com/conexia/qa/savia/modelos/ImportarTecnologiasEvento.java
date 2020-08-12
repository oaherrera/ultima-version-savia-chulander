package com.conexia.qa.savia.modelos;

import java.util.ArrayList;
import java.util.List;

public class ImportarTecnologiasEvento {
	private String tecnologia;
	private String archovACargar;

	private static ImportarTecnologiasEvento importarTecnologiasEvento;
	private static List<ImportarTecnologiasEvento> ImportarTecnologias;

	public static ImportarTecnologiasEvento traerImportarTecnologiasEvento() {
		if (importarTecnologiasEvento == null) {
			importarTecnologiasEvento = new ImportarTecnologiasEvento();
			ImportarTecnologias = new ArrayList<ImportarTecnologiasEvento>();
		}
		return importarTecnologiasEvento;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getArchovACargar() {
		return archovACargar;
	}

	public void setArchovACargar(String archovACargar) {
		this.archovACargar = archovACargar;
	}

	public static void agregarTecnologias(List<ImportarTecnologiasEvento> importTecnologias) {
		traerImportarTecnologiasEvento();
		int indice = 0;
		while (indice < importTecnologias.size()) {
			ImportarTecnologias.add(importTecnologias.get(indice));
			indice++;
		}
	}

	public static ImportarTecnologiasEvento traerImportTecnologia(int indice) {
		traerImportarTecnologiasEvento();
		return ImportarTecnologias.get(indice);
	}

	public static int cantidadTecnologias() {
		traerImportarTecnologiasEvento();
		return ImportarTecnologias.size();
	}

	public static void limpiarTecnologias() {
		importarTecnologiasEvento = null;
	}
	public static void agregoTecnologia(ImportarTecnologiasEvento importarTecnologias) {
		ImportarTecnologias.add(importarTecnologias);
		
	}
}
