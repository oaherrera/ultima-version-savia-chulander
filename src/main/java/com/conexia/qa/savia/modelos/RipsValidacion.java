package com.conexia.qa.savia.modelos;

public class RipsValidacion {
	
	private String ips;
	private String nroCuenta;
	private String estadoCuenta;
	private String estadoCuentaEsperado;

	private RipsValidacion ripsValidacion;

	public RipsValidacion traerRipsValidacion() {
		if (ripsValidacion != null) {
			ripsValidacion = new RipsValidacion();
		}
		return ripsValidacion;
	}

	public String getIps() {
		return ips;
	}

	public void setIps(String ips) {
		this.ips = ips;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public String getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(String estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public String getEstadoCuentaEsperado() {
		return estadoCuentaEsperado;
	}

	public void setEstadoCuentaEsperado(String estadoCuentaEsperado) {
		this.estadoCuentaEsperado = estadoCuentaEsperado;
	}

}
