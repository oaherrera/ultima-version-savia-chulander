package com.conexia.qa.sql.tasks;

import static com.conexia.qa.sql.modelos.NegociacionMedicamento.traerNegociacionMedicamento;
import static com.conexia.qa.sql.modelos.NegociacionProcedimiento.traerNegociacionProcedimiento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conexia.qa.savia.interactions.TomarEvidencia;
import com.conexia.qa.sql.modelos.NegociacionMedicamento;
import com.conexia.qa.sql.modelos.NegociacionProcedimiento;
import com.conexia.qa.sql.utilitario.ConexionBD;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsultoEnNegociacion implements Task {

	private String consulta;
	private String porNroNegociacion;
	private String tecnologia;
	private String respuesta;
	private int registros;

	private ConexionBD conexion;
	private NegociacionProcedimiento procedimiento;
	private NegociacionMedicamento medicamento;

	public ConsultoEnNegociacion(String consulta, String porNroNegociacion, String tecnologia) {
		this.consulta = consulta;
		this.porNroNegociacion = porNroNegociacion;
		this.conexion = ConexionBD.getConexion();
		this.tecnologia = tecnologia;
		this.procedimiento = traerNegociacionProcedimiento();
		this.medicamento = traerNegociacionMedicamento();
		this.respuesta = "";
		this.registros = 0;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		try {
			PreparedStatement sentencia = conexion.metPrepararSentcia(consulta);
			sentencia.setInt(1, Integer.parseInt(porNroNegociacion));
			ResultSet datos = sentencia.executeQuery();

			switch (tecnologia) {
			case "Procedimientos":
				while (datos.next()) {
					procedimiento.setHabilitacionGrupo(datos.getString(1));
					procedimiento.setHabilitacionServicio(datos.getString(2) + "-" + datos.getString(3));
					procedimiento.setContratoAntTarifario(datos.getString(4));
					procedimiento.agregarProcedimiento(procedimiento);

					respuesta = respuesta + procedimiento.getHabilitacionGrupo() + " | "+ procedimiento.getHabilitacionServicio() + "\n\n ";
					registros++;
				}
				break;
			case "Medicamentos":
				while (datos.next()) {
					medicamento.setGrupoFarmacologico(datos.getString(1));
					medicamento.setCodigoCum(datos.getString(2));
					medicamento.setDescripcion(datos.getString(3));
					medicamento.agregarMedicamento(medicamento);

					respuesta = respuesta + medicamento.getGrupoFarmacologico() + " | "+ medicamento.getCodigoCum() + " | "+ medicamento.getDescripcion() +"\n\n ";
					registros++;
				}
				break;
			}

			sentencia.close();
			conexion.metDesconectarBd();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		actor.attemptsTo(TomarEvidencia.delQuery(consulta, respuesta, registros));

	}

	public static ConsultoEnNegociacion procedimientos(String porNroNegociacion) {
		traerNegociacionProcedimiento().limpiarNegociacionProcedimiento();
		String consultaProcedimientos = ""
				+ "select distinct gs.descripcion, s.codigo, s.descripcion,tca.descripcion,nsr.porcentaje_tarifario_contrato_anterior, nsr.tarifario_negociado_id  "
				+ "from contratacion_n2.negociacion n \r\n"
				+ "inner join contratacion_n2.negociacion_sede ns on n.id = ns.negociacion_id\r\n"
				+ "inner join contratacion_n2.sede_prestador sp on ns.sede_prestador_id = sp.id\r\n"
				+ "inner join contratacion_n2.negociacion_servicio nsr  on nsr.negociacion_sede_id = ns.id\r\n"
				+ "inner join maestro.servicio s on s.id = nsr.servicio_id\r\n"
				+ "inner join maestro.grupo_servicio gs on gs.id= s.grupo_servicio_id\r\n"
				+ "left outer join parametro.tarifario_contratacion tca on tca.id = nsr.tarifario_contrato_anterior_id\r\n"
				+ "where n.id = ?";
		return Tasks.instrumented(ConsultoEnNegociacion.class, consultaProcedimientos, porNroNegociacion,
				"Procedimientos");
	}

	public static ConsultoEnNegociacion medicamentos(String porNroNegociacion) {
		traerNegociacionMedicamento().limpiarNegociacionMedicamento();
		String consultaMedicamentos = ""
				+ "select \r\n"
				+ "	distinct cm.codigo||'-'||cm.nombre grupo_farmacologico,m.cum_ajustado codigo_cum, me.descripcion ,nm.valor_negociado,nm.valor_importado\r\n"
				+ "from contratacion_n2.negociacion n \r\n"
				+ "inner join contratacion_n2.negociacion_sede ns on n.id = ns.negociacion_id\r\n"
				+ "inner join contratacion_n2.sede_prestador sp on ns.sede_prestador_id = sp.id\r\n"
				+ "inner join contratacion_n2.negociacion_medicamento nm  on nm.negociacion_sede_id = ns.id\r\n"
				+ "inner join maestro.medicamento_cum m on nm.medicamento_id = m.id\r\n"
				+ "inner join maestro.medicamento me on me.id = m.medicamento_id\r\n"
				+ "inner join parametro.categoria_medicamento cm on m.categoria_medicamento_id = cm.id\r\n"
				+ "where n.id = ?";
		return Tasks.instrumented(ConsultoEnNegociacion.class, consultaMedicamentos, porNroNegociacion,
				"Medicamentos");
	}

}
