package com.conexia.qa.savia.modelos;

import java.util.ArrayList;
import java.util.List;

public class Tecnologias {
	private String tipo;
	private String codigo;
	private String descripcion;

	private static Tecnologias tecnologia;
	private static List<Tecnologias> tecnologias;

	public static Tecnologias traerTecnologia() {
		if (tecnologia == null) {
			tecnologia = new Tecnologias();
			tecnologias = new ArrayList<Tecnologias>();
		}
		return tecnologia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static Tecnologias traerTecnologia(int indice) {
		return tecnologias.get(indice);
	}
	
	public static List<Tecnologias> traerTecnologias(){
		return tecnologias;
	}

	public static void guardarTecnologia(Tecnologias tecnologia) {
		traerTecnologia();
		tecnologias.add(tecnologia);
	}

	public static void guardarTecnologias(List<Tecnologias> Datatecnologias) {
		traerTecnologia();
		int indice = 0;
		while (indice < Datatecnologias.size()) {
			tecnologias.add(Datatecnologias.get(indice));
			indice++;
		}
	}
	
	public static void LimpiarTecnologias() {
		tecnologias = null;
	}
}
