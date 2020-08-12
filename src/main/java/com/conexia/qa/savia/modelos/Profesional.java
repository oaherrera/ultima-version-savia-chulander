package com.conexia.qa.savia.modelos;

public class Profesional {

	private String tipoDocumentoProfesional;
	private String primerNombreProfesional;
	private String segundoNombreProfesional;
	private String primerApellidoProfesional;
	private String segundoApellidoProfesional;
	private String numeroDocumentoProfesional;
	private String especialidadProfesional;
	private String cargoProfesional;

	public static Profesional nuevoProfesional() {
			return  new Profesional();
	}

	public String getTipoDocumentoProfesional() {
		return tipoDocumentoProfesional;
	}

	public void setTipoDocumentoProfesional(String tipoDocumentoProfesional) {
		this.tipoDocumentoProfesional = tipoDocumentoProfesional;
	}

	public String getPrimerNombreProfesional() {
		return primerNombreProfesional;
	}

	public void setPrimerNombreProfesional(String primerNombreProfesional) {
		this.primerNombreProfesional = primerNombreProfesional;
	}

	public String getSegundoNombreProfesional() {
		return segundoNombreProfesional;
	}

	public void setSegundoNombreProfesional(String segundoNombreProfesional) {
		this.segundoNombreProfesional = segundoNombreProfesional;
	}

	public String getPrimerApellidoProfesional() {
		return primerApellidoProfesional;
	}

	public void setPrimerApellidoProfesional(String primerApellidoProfesional) {
		this.primerApellidoProfesional = primerApellidoProfesional;
	}

	public String getSegundoApellidoProfesional() {
		return segundoApellidoProfesional;
	}

	public void setSegundoApellidoProfesional(String segundoApellidoProfesional) {
		this.segundoApellidoProfesional = segundoApellidoProfesional;
	}

	public String getNumeroDocumentoProfesional() {
		return numeroDocumentoProfesional;
	}

	public void setNumeroDocumentoProfesional(String numeroDocumentoProfesional) {
		this.numeroDocumentoProfesional = numeroDocumentoProfesional;
	}

	public String getEspecialidadProfesional() {
		return especialidadProfesional;
	}

	public void setEspecialidadProfesional(String especialidadProfesional) {
		this.especialidadProfesional = especialidadProfesional;
	}

	public String getCargoProfesional() {
		return cargoProfesional;
	}

	public void setCargoProfesional(String cargoProfesional) {
		this.cargoProfesional = cargoProfesional;
	}
}
