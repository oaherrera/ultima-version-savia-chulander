package com.conexia.qa.excel.utilitario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel_xls {

	private static Excel_xls excel;
	private List<ExcelModel> valoresExcel;

	public static Excel_xls traerExcel() {
		if (excel == null) {
			excel = new Excel_xls();

		}
		return excel;
	}

	public List<ExcelModel> leerExcel(String rutaArchivo) {
		valoresExcel = new ArrayList<ExcelModel>();

		File ExcelArchivo = new File(rutaArchivo);
		InputStream excelStream = null;
		try {
			excelStream = new FileInputStream(ExcelArchivo);
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(excelStream);
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
			HSSFRow hssfRow;

			int rows = hssfSheet.getLastRowNum();
			int cols = 0;
			for (int r = 0; r < rows; r++) {
				hssfRow = hssfSheet.getRow(r);
				if (hssfRow == null) {
					break;
				} else {
					ExcelModel CeldasRegistro = new ExcelModel();
					for (int c = 0; c < (cols = hssfRow.getLastCellNum()); c++) {
						CeldasRegistro.celdas.add(hssfRow.getCell(c).getStringCellValue());
						CeldasRegistro.numeroCelda = cols;
					}
					valoresExcel.add(CeldasRegistro);
				}
			}
			hssfWorkbook.close();
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
}
