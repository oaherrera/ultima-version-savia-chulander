package com.conexia.qa.sql.tasks;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conexia.qa.savia.modelos.Profesional;
import com.conexia.qa.sql.colecciones.ProfesionalesBD;
import com.conexia.qa.sql.utilitario.ConexionBD;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsultoProfesional implements Task {
	private ConexionBD conexion;
	private String sentencia = "" + "select\r\n"
			+ "	p.nombre1, p.nombre2,p.apellido1,p.apellido2,td.descripcion,p.numero_documento,\r\n"
			+ "	e.descripcion , cp.descripcion\r\n" + " from maestro.profesional p \r\n"
			+ " inner join parametro.tipo_documento td on p.tipo_documento_id = td.id\r\n"
			+ " inner join parametro.cargo_profesional_ips cp on p.cargo_profesional_ips_id = cp.id\r\n"
			+ " inner join maestro.profesional_especialidad_medica pe on p.id = pe.profesional_id\r\n"
			+ " inner join maestro.especialidad_medica e on pe.especialidad_medica_id = e.id\r\n" + " where  1 = 1\r\n"
			+ " and p.deleted = 'false'\r\n" + " and pe.deleted = 'false'\r\n" + " and e.deleted = 'false'\r\n"
			+ " and td.deleted = 'false'\r\n" + " and cp.deleted = 'false'\r\n" + " ";
	private String sentenciaOrdenamiento;
	private PreparedStatement psentencia;
	
	private String buscarPor;
	private String tipoDocumento;
	private String numeroDocumento;
	private Profesional profesional;
	private ProfesionalesBD profesionalesBD;

	public ConsultoProfesional(String buscarPor, String tipoDocumnento, String numeroDocumento) {
		this.buscarPor = buscarPor;
		this.tipoDocumento = tipoDocumento(tipoDocumnento);
		this.numeroDocumento = numeroDocumento;
		this.conexion = ConexionBD.getConexion();
		this.profesional = Profesional.nuevoProfesional();
		this.sentenciaOrdenamiento = "";
		this.profesionalesBD = ProfesionalesBD.traerProfesionales();
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		try {
			switch (buscarPor) {
			case "Documento":
				sentencia = sentencia + " and p.numero_documento = ? \r\n" + " and td.descripcion = ? \r\n";
				sentenciaOrdenamiento = "order by e.id";
				psentencia = conexion.metPrepararSentcia(sentencia + sentenciaOrdenamiento);
				psentencia.setString(1, numeroDocumento);
				psentencia.setString(2, tipoDocumento);
			}
			
			ResultSet datos = psentencia.executeQuery();
			profesionalesBD.borrarProfesionales();
			while(datos.next()) {
				profesional.setPrimerNombreProfesional(datos.getString(1));
				profesional.setSegundoNombreProfesional(datos.getString(2));
				profesional.setPrimerApellidoProfesional(datos.getString(3));
				profesional.setSegundoApellidoProfesional(datos.getString(4));
				profesional.setTipoDocumentoProfesional(datos.getString(5));
				profesional.setNumeroDocumentoProfesional(datos.getString(6));
				profesional.setEspecialidadProfesional(datos.getString(7));
				profesional.setCargoProfesional(datos.getString(8));
				profesionalesBD.guardarProfesionale(profesional);
			}
			
			psentencia.clearParameters();
			psentencia.close();
			conexion.metDesconectarBd();
			
		} catch (SQLException e) {
			conexion.metDesconectarBd();
			e.printStackTrace();
		}

	}

	public static ConsultoProfesional porTipoDocumento(String tipoDocumento, String numeroDocumento) {
		return Tasks.instrumented(ConsultoProfesional.class, "Documento", tipoDocumento, numeroDocumento);
	}
	
	private String tipoDocumento(String tipoDocumento) {
		if(tipoDocumento.equals("Cédula de ciudadanía")) {
			return "Cedula ciudadania";
		}
		return tipoDocumento;
	} 

}
