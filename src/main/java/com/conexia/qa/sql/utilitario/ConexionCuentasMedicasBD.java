package com.conexia.qa.sql.utilitario;

import com.conexia.qa.savia.modelos.Selenium;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ChristianCamiloSchottlaender
 */
public class ConexionCuentasMedicasBD {

	public static ConexionCuentasMedicasBD objClaConxion;
	private Connection conexion;

	public static ConexionCuentasMedicasBD getConexion() {
		if (objClaConxion == null) {
			objClaConxion = new ConexionCuentasMedicasBD();
		}
		return objClaConxion;
	}

	public Connection Conexion() {
		return this.conexion;
	}

	private Connection metGetConexionDrive() {
		try {
			Class.forName("org.postgresql.Driver");
			return this.conexion = DriverManager.getConnection(
					Selenium.parameters().getProperty("ConexionDataCM"),
					Selenium.parameters().getProperty("UsuarioBDCM"),
					Selenium.parameters().getProperty("ContrasenhaBDCM"));
		} catch (SQLException ex) {
			Logger.getLogger(ConexionCuentasMedicasBD.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error Metodo metGetConexionDrive: " + ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println("Error Metodo metGetConexionDrive: " + ex.getMessage());
			Logger.getLogger(ConexionCuentasMedicasBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public void metDesconectarBd() {
		try {
			this.conexion.close();
			System.out.println("Desconectado? " + this.conexion.isClosed());
		} catch (SQLException ex) {
			System.out.println("Error Metodo metDesconectarBd: " + ex.getMessage());
			Logger.getLogger(ConexionCuentasMedicasBD.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public PreparedStatement metPrepararSentcia(String parSentencia) {
		try {
			PreparedStatement preparedStatement = metGetConexionDrive().prepareStatement(parSentencia);
			System.out.println("" + parSentencia);
			return preparedStatement;
		} catch (SQLException ex) {
			System.out.println("Error Metodo metPrepararSentcia: " + ex.getMessage());
			Logger.getLogger(ConexionCuentasMedicasBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public CallableStatement metPrepararSentciaSP(String parSentencia) {
		try {
			CallableStatement preparedStatement = metGetConexionDrive().prepareCall(parSentencia);
			System.out.println("" + parSentencia);
			return preparedStatement;
		} catch (SQLException ex) {
			System.out.println("Error Metodo metPrepararSentcia: " + ex.getMessage());
			Logger.getLogger(ConexionCuentasMedicasBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}