package com.conexia.qa.savia.modelos;

import java.util.ArrayList;
import java.util.List;

public class SedePrestador {

	private String areaCobertura;
	private String nombreSede;
	private String sedePrincipal;

	private static SedePrestador sedePrestador;
	private static List<SedePrestador> sedesPrestador;

	public static SedePrestador traerSedePrestador() {
		if (sedePrestador == null) {
			sedePrestador = new SedePrestador();
			sedesPrestador = new ArrayList<SedePrestador>();
		}
		return sedePrestador;
	}

	public String getAreaCobertura() {
		return areaCobertura;
	}

	public void setAreaCobertura(String areaCobertura) {
		this.areaCobertura = areaCobertura;
	}

	public String getNombreSede() {
		return nombreSede;
	}

	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}

	public String getSedePrincipal() {
		return sedePrincipal;
	}

	public void setSedePrincipal(String sedePrincipal) {
		this.sedePrincipal = sedePrincipal;
	}

	public SedePrestador traerSedePrestador(int indice) {
		return sedesPrestador.get(indice);
	}
	
	public List<SedePrestador> traerSedesPrestador() {
		return sedesPrestador;
	}

	public void guardarSedePrestador(SedePrestador datosSedePrestaodr) {
		sedesPrestador.add(datosSedePrestaodr);
	}

	public void guardarSedePrestador(List<SedePrestador> datosSedePrestaodr) {
		int indice = 0;
		while (indice < datosSedePrestaodr.size()) {
			sedesPrestador.add(datosSedePrestaodr.get(indice));
			indice++;
		}
	}
	public void limpiarDatosSedesPrestador() {
		sedesPrestador = new ArrayList<SedePrestador>();
	}

	

}
