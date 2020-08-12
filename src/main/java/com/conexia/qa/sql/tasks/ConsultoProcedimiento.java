package com.conexia.qa.sql.tasks;

import com.conexia.qa.savia.interactions.TomarEvidencia;
import com.conexia.qa.sql.colecciones.ProcedimientosBD;
import com.conexia.qa.savia.modelos.Procedimiento;
import com.conexia.qa.sql.utilitario.ConexionBD;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultoProcedimiento implements Task {

    private ConexionBD conexion;
    private String consulta = "select  \n" +
            "tppm.descripcion tipologia,  p.codigo ,p.descripcion procedimiento , nv.descripcion complejidad, g.descripcion genero,p.edad_desde  desde_edad , p.edad_hasta hasta_edad,\n" +
            "ut.descripcion medida_Edad\n" +
            "from maestro.procedimiento p \n" +
            "inner join parametro.tipo_ppm tppm on tppm.id  = p.tipo_ppm_id \n" +
            "inner join parametro.nivel_complejidad  nv on nv.id  = p.nivel_complejidad_id \n" +
            "inner join parametro.genero g on g.id  = p.genero_id \n" +
            "inner join parametro.unidad_tiempo  ut on ut.id  = p.unidad_tiempo_edad_id \n" +
            "where p.deleted is false\n" +
            "and tppm.descripcion  = ? \n" +
            "and p.codigo  = ?  \n" +
            "and p.descripcion = ? \n" +
            "limit 1";
    private String respuesta;
    private Procedimiento procedimiento;
    private ProcedimientosBD procedimientos;

    private String codigo;
    private String descripcion;
    private String tipo;

    public ConsultoProcedimiento(String codigo, String descripcion, String tipo) {
        this.conexion = ConexionBD.getConexion();
        this.respuesta = "Tipologia|Codigo|Descripcion|Complejidad|Genero|DesdeEdad|HastaEdad|MedidaEdad"+"\n\n ";
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.procedimiento = Procedimiento.nuevoProcedimiento();
        this.procedimientos = ProcedimientosBD.traerProcedimientos();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            this.procedimientos.limpiarProcedimientos();
            PreparedStatement prepararSentencia = conexion.metPrepararSentcia(consulta);
            prepararSentencia.setString(1, tipo);
            prepararSentencia.setString(2, codigo);
            prepararSentencia.setString(3, descripcion);

            ResultSet datosConsulta= prepararSentencia.executeQuery();

            while (datosConsulta.next()){
                procedimiento= Procedimiento.nuevoProcedimiento();
                procedimiento.setTipologiaProcedimiento(datosConsulta.getString(1));
                procedimiento.setCodigoProcedimiento(datosConsulta.getString(2));
                procedimiento.setDescripcionProcedimiento(datosConsulta.getString(3));
                procedimiento.setComplejidadProcedimiento(datosConsulta.getString(4));
                procedimiento.setGeneroProcedimiento(datosConsulta.getString(5));
                procedimiento.setDesdeEdadProcedimiento(datosConsulta.getString(6));
                procedimiento.setHastaEdadProcedimiento(datosConsulta.getString(7));
                procedimiento.setMedidaEdadProcedimiento(datosConsulta.getString(8));

                procedimientos.guardarProcedimiento(procedimiento);
                respuesta = respuesta + procedimiento.getTipologiaProcedimiento()+" | "+procedimiento.getCodigoProcedimiento()+" | "+" | "+procedimiento.getDescripcionProcedimiento()+" | "+" | "+procedimiento.getComplejidadProcedimiento()+" | "+" | "+procedimiento.getGeneroProcedimiento()+" | "+" | "+procedimiento.getDesdeEdadProcedimiento()+" | "+" | "+procedimiento.getHastaEdadProcedimiento()+" | "+" | "+procedimiento.getMedidaEdadProcedimiento()+"\n\n ";
            }

            prepararSentencia.clearParameters();
            prepararSentencia.close();
            conexion.metDesconectarBd();

            actor.attemptsTo(TomarEvidencia.delQuery(consulta,respuesta,procedimientos.cantidadProcedimientos()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConsultoProcedimiento porCodigoYDescripcio(String codigo, String descripcion, String tipo) {
        return Tasks.instrumented(ConsultoProcedimiento.class, codigo, descripcion, tipo);
    }
}
