package com.conexia.qa.sql.modelos;

import java.util.ArrayList;
import java.util.List;

public class NegociacionMedicamento {
	private String grupoFarmacologico;
	private String codigoCum;
	private String descripcion;
	private String valorNegociado;
	private String valorImportado;

	private static NegociacionMedicamento negociacionMedicamento;
	private static List<NegociacionMedicamento> negociacionMedicamentos;

	public static NegociacionMedicamento traerNegociacionMedicamento() {
		if (negociacionMedicamento == null) {
			negociacionMedicamento = new NegociacionMedicamento();
			negociacionMedicamentos = new ArrayList<NegociacionMedicamento>();
		}
		return negociacionMedicamento;
	}

	public String getGrupoFarmacologico() {
		return grupoFarmacologico;
	}

	public void setGrupoFarmacologico(String grupoFarmacologico) {
		this.grupoFarmacologico = grupoFarmacologico;
	}

	public String getCodigoCum() {
		return codigoCum;
	}

	public void setCodigoCum(String codigoCum) {
		this.codigoCum = codigoCum;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValorNegociado() {
		return valorNegociado;
	}

	public void setValorNegociado(String valorNegociado) {
		this.valorNegociado = valorNegociado;
	}

	public String getValorImportado() {
		return valorImportado;
	}

	public void setValorImportado(String valorImportado) {
		this.valorImportado = valorImportado;
	}

	public static NegociacionMedicamento getNegociacionMedicamento() {
		return negociacionMedicamento;
	}

	public static void setNegociacionMedicamento(NegociacionMedicamento negociacionMedicamento) {
		NegociacionMedicamento.negociacionMedicamento = negociacionMedicamento;
	}

	public static List<NegociacionMedicamento> getNegociacionMedicamentos() {
		return negociacionMedicamentos;
	}

	public static void setNegociacionMedicamentos(List<NegociacionMedicamento> negociacionMedicamentos) {
		NegociacionMedicamento.negociacionMedicamentos = negociacionMedicamentos;
	}
	
	
	public void agregarMedicamento(NegociacionMedicamento medicamento) {
		traerNegociacionMedicamento();
		negociacionMedicamentos.add(medicamento);
	}

	public NegociacionMedicamento traerMedicamento(int indice) {
		traerNegociacionMedicamento();
		return negociacionMedicamentos.get(indice);
	}

	public int cantidadMedicamentos() {
		traerNegociacionMedicamento();
		return negociacionMedicamentos.size();
	}
	
	public List<NegociacionMedicamento> medicamentos() {
		traerNegociacionMedicamento();
		return negociacionMedicamentos;
	}
	
	public void limpiarNegociacionMedicamento() {
		negociacionMedicamento= null;
		negociacionMedicamentos = null;
	}

}
