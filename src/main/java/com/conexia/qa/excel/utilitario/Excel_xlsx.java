package com.conexia.qa.excel.utilitario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Excel_xlsx {

	private static Excel_xlsx excel;
	private List<ExcelModel> valoresExcel;

	public static Excel_xlsx traerExcel() {
		if (excel == null) {
			excel = new Excel_xlsx();

		}
		return excel;
	}

	public List<ExcelModel> leerExcel(String rutaArchivo) {
		valoresExcel = new ArrayList<ExcelModel>();

		File ExcelArchivo = new File(rutaArchivo);
		InputStream excelStream = null;
		try {
			excelStream = new FileInputStream(ExcelArchivo);
			XSSFWorkbook Libro = new XSSFWorkbook(excelStream);
			XSSFSheet Hoja = Libro.getSheetAt(0);
			XSSFRow Registro;

			int RegistroSiguiente = Hoja.getLastRowNum();
			int CantidadFilas = 0;
			for (int r = 0; r <= RegistroSiguiente; r++) {
				Registro = Hoja.getRow(r);
				if (Registro == null) {
					break;
				} else {
					ExcelModel CeldasRegistro = new ExcelModel();
					CeldasRegistro.getInstance();
					for (int c = 0; c < (CantidadFilas = Registro.getLastCellNum()); c++) {
						CeldasRegistro.celdas.add(this.getValueCell(Registro.getCell(c)));
						CeldasRegistro.numeroCelda = CantidadFilas;
					}
					valoresExcel.add(CeldasRegistro);
				}
			}
			Libro.close();
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println("No se encontró el Archivo: " + rutaArchivo + fileNotFoundException);
		} catch (IOException ex) {
			System.out.println("Error al procesar el fichero" + rutaArchivo + ex);
		} finally {
			try {
				excelStream.close();
			} catch (IOException ex) {
				System.out.println("Error al procesar el fichero " + rutaArchivo + ", después de cerrarlo " + ex);
			}
		}
		return valoresExcel;
	}

	public String getValueCell(XSSFCell celda){
		switch (celda.getCellType().toString()){
			case  "STRING":
				return celda.getStringCellValue();
			case "NUMERIC":
				return ""+celda.getNumericCellValue();
			default:
				return ""+celda.getRichStringCellValue();
		}
	}

}
