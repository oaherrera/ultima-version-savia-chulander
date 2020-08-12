package com.conexia.qa.savia.modelos;

import java.util.ArrayList;
import java.util.List;

public class Glosas {

	private String motivoGlosa;
	private String motivoCodigo;
	private String totalOParcial;
	private String justificacion;
	private String parcialValorGlosa;
	private String exitoso;
	private String mensajeEsperado;
	private static List<Glosas> Glosas;
	private static List<Glosas> GlosasAgrupadas;

	private static Glosas glosas;

	private static Glosas traerGlosas() {
		if (glosas == null) {
			glosas = new Glosas();
			Glosas = new ArrayList<Glosas>();
			GlosasAgrupadas= new ArrayList<Glosas>();
		}
		return glosas;
	}

	public String getMotivoGlosa() {
		return motivoGlosa;
	}

	public void setMotivoGlosa(String motivoGlosa) {
		this.motivoGlosa = motivoGlosa;
	}

	public String getMotivoCodigo() {
		return motivoCodigo;
	}

	public void setMotivoCodigo(String motivoCodigo) {
		this.motivoCodigo = motivoCodigo;
	}

	public String getTotalOParcial() {
		return totalOParcial;
	}

	public void setTotalOParcial(String totalOParcial) {
		this.totalOParcial = totalOParcial;
	}

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	public String getParcialValorGlosa() {
		return parcialValorGlosa;
	}

	public void setParcialValorGlosa(String parcialValorGlosa) {
		this.parcialValorGlosa = parcialValorGlosa;
	}

	public String getExitoso() {
		return exitoso;
	}

	public void setExitoso(String exitoso) {
		this.exitoso = exitoso;
	}

	public String getMensajeEsperado() {
		return mensajeEsperado;
	}

	public void setMensajeEsperado(String mensajeEsperado) {
		this.mensajeEsperado = mensajeEsperado;
	}

	public static void guardarGlosa(Glosas glosa) {
		traerGlosas();
		Glosas.add(glosa);
		GlosasAgrupadas.add(glosa);
	}

	public static void guardarGlosa(List<Glosas> glosa) {
		traerGlosas();
		int indice = 0;
		while (indice < glosa.size()) {
			Glosas.add(glosa.get(indice));
			GlosasAgrupadas.add(glosa.get(indice));
			indice++;
		}
	}

	public static Glosas traerGlosa(int indice) {
		return Glosas.get(indice);
	}

	public static List<Glosas> traerGlosa() {
		return Glosas;
	}

	public static void limpiarGlosas() {
		Glosas = null;
	}

	public static List<Glosas> traerGlosaAgrupadas() {
		return GlosasAgrupadas;
	}
}
