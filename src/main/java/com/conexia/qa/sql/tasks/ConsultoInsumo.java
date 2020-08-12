package com.conexia.qa.sql.tasks;


import com.conexia.qa.savia.interactions.TomarEvidencia;
import com.conexia.qa.sql.colecciones.InsumosBD;
import com.conexia.qa.savia.modelos.Insumo;
import com.conexia.qa.sql.utilitario.ConexionBD;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultoInsumo implements Task {

    private ConexionBD conexion;
    private String consulta = "" +
            "select \n" +
            "tppm.descripcion tipificacion, i.codigo ,i.descripcion insumo\n" +
            "from maestro.insumo i \n" +
            "inner join parametro.tipo_ppm tppm on i.tipo_ppm_id  = tppm.id \n" +
            "where i.deleted is false\n" +
            "and tppm.descripcion  = ? \n" +
            "and i.codigo  = ?\n" +
            "and i.descripcion  = ?\n" +
            "limit 1";
    private String respuesta;

    private String codigo;
    private String descipcion;
    private String tipo;
    private Insumo insumo;
    private InsumosBD insumos;

    public ConsultoInsumo(String codigo, String descipcion, String tipo) {
        this.codigo = codigo;
        this.descipcion = descipcion;
        this.tipo = tipo;
        this.conexion = ConexionBD.getConexion();
        this.insumo = Insumo.nuevoInsumo();
        this.insumos = InsumosBD.traerInsumos();
        this.respuesta = "Tipologia|Codigo|Descripcion"+"\n\n ";
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            insumos.borrarInsumos();
            PreparedStatement prepararConsulta = conexion.metPrepararSentcia(consulta);
            prepararConsulta.setString(1, tipo);
            prepararConsulta.setString(2, codigo);
            prepararConsulta.setString(3, descipcion);

            ResultSet dattosConsulta = prepararConsulta.executeQuery();

            while (dattosConsulta.next()) {
                insumo = Insumo.nuevoInsumo();
                insumo.setTipologiaInsumo(dattosConsulta.getString(1));
                insumo.setCodigoInsumo(dattosConsulta.getString(2));
                insumo.setDescripcionInsumo(dattosConsulta.getString(3));
                insumos.agregarInsumo(insumo);

                respuesta = respuesta+insumo.getTipologiaInsumo()+" | "+insumo.getCodigoInsumo()+" | "+insumo.getDescripcionInsumo()+"\n\n ";
            }

            prepararConsulta.clearParameters();
            prepararConsulta.close();
            conexion.metDesconectarBd();

            actor.attemptsTo(TomarEvidencia.delQuery(consulta,respuesta,insumos.cantidadInsumos()));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ConsultoInsumo porCodigoYDescipcion(String codigo, String descipcion, String tipo) {
        return Tasks.instrumented(ConsultoInsumo.class, codigo, descipcion, tipo);
    }
}
