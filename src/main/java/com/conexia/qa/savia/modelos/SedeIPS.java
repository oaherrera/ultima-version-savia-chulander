package com.conexia.qa.savia.modelos;

public class SedeIPS {
    private String sede;
    private String ipsRazonSocial;

    private static SedeIPS sedeIPS;

    public static SedeIPS trearSedeIPS(){
        if(sedeIPS==null){
            sedeIPS = new SedeIPS();
        }
        return sedeIPS;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getIpsRazonSocial() {
        return ipsRazonSocial;
    }

    public void setIpsRazonSocial(String ipsRazonSocial) {
        this.ipsRazonSocial = ipsRazonSocial;
    }

    public void guardarSedeIPS(SedeIPS psedeIPS){
        sedeIPS = psedeIPS;
    }
}
