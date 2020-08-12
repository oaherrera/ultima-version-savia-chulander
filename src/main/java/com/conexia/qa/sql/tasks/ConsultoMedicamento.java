package com.conexia.qa.sql.tasks;

import com.conexia.qa.savia.interactions.TomarEvidencia;
import com.conexia.qa.sql.colecciones.MedicamentosBD;
import com.conexia.qa.savia.modelos.Medicamento;
import com.conexia.qa.sql.utilitario.ConexionBD;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultoMedicamento implements Task {
    private ConexionBD conexion;
    private String consulta = "select \n" +
            "tppm.descripcion tipologia, m.codigo , m.descripcion medicamento,pa.descripcion principio_activo, c.descripcion concentracion ,ff.descripcion forma_farmaceutica,d.descripcion diagnostico\n" +
            "from maestro.medicamento m\n" +
            "inner join parametro.tipo_ppm tppm on m.tipo_ppm_id  = tppm.id\n" +
            "inner join maestro.principio_activo  pa on m.principio_activo_id  = pa.id \n" +
            "inner join parametro.concentracion  c on m.concentracion_id  = c.id \n" +
            "inner join maestro.forma_farmaceutica ff on ff.id  = m.forma_farmaceutica_id \n" +
            "left outer join maestro.diagnostico_medicamento  dm on dm.medicamento_id  = m.id and dm.deleted is false\n" +
            "left outer join maestro.diagnostico d on dm.diagnostico_id = d.id and d.deleted is false\n" +
            "where \n" +
            "m.deleted is false \n" +
            "and tppm.descripcion  = ?\n" +
            "and m.codigo  = ? \n" +
            "and m.descripcion = ?\n" +
            " order by M.codigo \n" +
            "limit 1";
    private String respuesta;

    private String codigo;
    private String descripcion;
    private String tipo;
    private Medicamento medicamento;
    private MedicamentosBD medicamentos;

    public ConsultoMedicamento(String codigo, String descripcion, String tipo) {
        this.conexion = ConexionBD.getConexion();
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.medicamento = Medicamento.nuevoMedicamento();
        this.medicamentos = MedicamentosBD.traerMedicamentos();
        this.respuesta = "Tipologia|Codigo|Descripcion|PrincipoActivo|Concentracion|FormaFarmaceutica|CodigoDiagnostico" + "\n\n ";
        this.tipo = tipo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            medicamentos.borrarMedicamentos();
            PreparedStatement prepararConsulta = conexion.metPrepararSentcia(consulta);
            prepararConsulta.setString(1, this.tipo);
            prepararConsulta.setString(2, this.codigo);
            prepararConsulta.setString(3, this.descripcion);
            ResultSet datosConsulta = prepararConsulta.executeQuery();

            while (datosConsulta.next()) {
                this.medicamento = Medicamento.nuevoMedicamento();
                this.medicamento.setTipologiaMedicamento(datosConsulta.getString(1));
                this.medicamento.setCodigoMedicamento(datosConsulta.getString(2));
                this.medicamento.setDescripcionMedicamento(datosConsulta.getString(3));
                this.medicamento.setPrincipoActivo(datosConsulta.getString(4));
                this.medicamento.setConcentracion(datosConsulta.getString(5));
                this.medicamento.setFormaFarmaceutica(datosConsulta.getString(6));
                this.medicamento.setCodigoDiagnostico(datosConsulta.getString(7));
                this.medicamentos.agregarMedicamento(medicamento);

                respuesta = respuesta + medicamento.getTipologiaMedicamento() + " | " + medicamento.getCodigoMedicamento() + " | " + medicamento.getDescripcionMedicamento() + " | " + medicamento.getPrincipoActivo() + " | " + medicamento.getConcentracion() + " | " + medicamento.getFormaFarmaceutica() + " | " + medicamento.getCodigoDiagnostico() + "\n\n ";
            }

            prepararConsulta.clearParameters();
            prepararConsulta.close();
            conexion.metDesconectarBd();

            actor.attemptsTo(TomarEvidencia.delQuery(this.consulta, this.respuesta, this.medicamentos.cantidadMedicamentos()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConsultoMedicamento porCodigoYDescipcion(String codigo, String descripcion, String tipo) {
        return Tasks.instrumented(ConsultoMedicamento.class, codigo, descripcion, tipo);
    }


}
