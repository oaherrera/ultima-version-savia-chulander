package com.conexia.qa.savia.runner;

import com.conexia.qa.excel.modelos.DatosExcel;
import com.conexia.qa.excel.utilitario.Excel_xlsx;


public class Test {

     public static void main(String[] args) {

         DatosExcel.Registros = Excel_xlsx.traerExcel().leerExcel("C:/Proyectos/Savia-Serenity/Cargas/importacion_servicios.xlsx");
         System.out.println(DatosExcel.Registros.size());
         int indice =0 ;
         while(indice<DatosExcel.Registros.size()){
             System.out.println(DatosExcel.Registros.get(indice).celdas.get(1));
             indice = indice+1;
         }
    }


}
