package com.conexia.qa.savia.modelos;

public class PortafolioProcedimiento extends Procedimiento {
    private String tarifario;
    private String porcentajeNegociado;
    private String complejidad;

    public static PortafolioProcedimiento nuevoPortafolioProcedimiento(){
        return new PortafolioProcedimiento();
    }

    public String getTarifario() {return tarifario;}

    public void setTarifario(String tarifario) {this.tarifario = tarifario;}

    public String getPorcentajeNegociado() {return porcentajeNegociado;}

    public void setPorcentajeNegociado(String porcentajeNegociado) {this.porcentajeNegociado = porcentajeNegociado;}

    public String getComplejidad() {return complejidad;}

    public void setComplejidad(String complejidad) {this.complejidad = complejidad;}
}
