package com.conexia.qa.sql.modelos;

import java.util.ArrayList;
import java.util.List;

public class NegociacionProcedimiento {
	private String habilitacionGrupo;
	private String habilitacionServicio;
	private String contratoAntTarifario;

	private static NegociacionProcedimiento negociacionProcedimiento;
	private static List<NegociacionProcedimiento> negociacionProcedimientos;

	public static NegociacionProcedimiento traerNegociacionProcedimiento() {
		if (negociacionProcedimiento == null) {
			negociacionProcedimiento = new NegociacionProcedimiento();
			negociacionProcedimientos = new ArrayList<NegociacionProcedimiento>();
		}
		return negociacionProcedimiento;
	}

	public String getHabilitacionGrupo() {
		return habilitacionGrupo;
	}

	public void setHabilitacionGrupo(String habilitacionGrupo) {
		this.habilitacionGrupo = habilitacionGrupo;
	}

	public String getHabilitacionServicio() {
		return habilitacionServicio;
	}

	public void setHabilitacionServicio(String habilitacionServicio) {
		this.habilitacionServicio = habilitacionServicio;
	}

	public String getContratoAntTarifario() {
		return contratoAntTarifario;
	}

	public void setContratoAntTarifario(String contratoAntTarifario) {
		this.contratoAntTarifario = contratoAntTarifario;
	}

	public void agregarProcedimiento(NegociacionProcedimiento procedimiento) {
		traerNegociacionProcedimiento();
		negociacionProcedimientos.add(procedimiento);
	}

	public NegociacionProcedimiento traerProcedimiento(int indice) {
		traerNegociacionProcedimiento();
		return negociacionProcedimientos.get(indice);
	}

	public int cantidadProcedimientos() {
		traerNegociacionProcedimiento();
		return negociacionProcedimientos.size();
	}
	
	public List<NegociacionProcedimiento> Procedimientos() {
		traerNegociacionProcedimiento();
		return negociacionProcedimientos;
	}
	
	public void limpiarNegociacionProcedimiento() {
		negociacionProcedimiento = null;
		negociacionProcedimientos = null;
	}
}
