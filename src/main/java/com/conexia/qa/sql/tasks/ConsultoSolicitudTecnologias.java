package com.conexia.qa.sql.tasks;

import com.conexia.qa.savia.interactions.TomarEvidencia;
import com.conexia.qa.savia.modelos.SolicitudAuditorBandeja;
import com.conexia.qa.sql.colecciones.SolicitudAuditorBandejaTecnologiasBD;
import com.conexia.qa.sql.utilitario.ConexionBD;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultoSolicitudTecnologias implements Task {

    private ConexionBD conexion;
    private String consulta = "" +
            "select concat(\n" +
            " case when i.codigo is not null then concat(i.codigo,' - ',i.descripcion)end ,\n" +
            " case when m.codigo is not null then concat(m.codigo,' - ',m.descripcion)end ,\n" +
            " case when p.codigo is not null then concat(p.codigo,' - ',p.descripcion)end ,\n" +
            " case when pr.codigo is not null then concat(pr.codigo,' - ',pr.descripcion) end\n" +
            " ),\n" +
            "  esi.descripcion ,etisp.cantidad cantidad_solicitada,mo.codigo motivo, um.username\n" +
            "from transaccion.solicitud_autorizacion sa \n" +
            "inner join transaccion.evento_transaccion et on sa.id = et.id \n" +
            "inner join transaccion.evento_transaccion_item eti on  eti.evento_transaccion_id  = et.id\n" +
            "inner join transaccion.evento_transaccion_item_estado_parcial  etisp on etisp.evento_transaccion_item_id = eti.id\n" +
            "inner join parametro.estado_solicitud_item esi on esi.id  = etisp.estado_solicitud_item_id \n" +
            "inner join parametro.tipo_tecnologia tt on tt.id = eti.tipo_tecnologia_id \n" +
            "left  join transaccion.evento_transaccion_item_insumo insumo on eti.id= insumo.evento_transaccion_item_id \n" +
            "left  join maestro.insumo i on i.id = insumo.insumo_id \n" +
            "left  join transaccion.evento_transaccion_item_medicamento medicamento on eti.id  = medicamento.evento_transaccion_item_id \n" +
            "left  join maestro.medicamento m on m.id  = medicamento.medicamento_generico_id \n" +
            "left  join transaccion.evento_transaccion_item_paquete paquete on eti.id=paquete.evento_transaccion_item_id \n" +
            "left  join maestro.paquete_pmi p on p.id = paquete.paquete_pmi_id \n" +
            "left  join transaccion.evento_transaccion_item_procedimiento procedimiento on eti.id = procedimiento.evento_transaccion_item_id \n" +
            "left  join maestro.procedimiento pr on procedimiento.procedimiento_id = pr.id \n" +
            "left join transaccion.bandeja_entrada_auditor ba on et.id = ba.evento_transaccion_id and eti.id = ba.evento_transaccion_item_id \n" +
            "left join maestro.auditor au on au.id  = ba.auditor_direccionado_id \n" +
            "left join  seguridad.usuario_aplicacion  ua on au.numero_documento = ua.numero_documento and au.tipo_documento_id  = ua.tipo_documento_id \n" +
            "left join seguridad.usuario_modelo um on um.id = ua.id \n" +
            "inner join parametro.motivo_auditoria mo on mo.id = ba.motivo_auditoria_id \n" +
            "where sa.numero_solicitud = ? \n" +
            "order by eti.id asc\n";
    private String respuesta;
    private SolicitudAuditorBandeja tecnologiaBandejaAuditor;
    private SolicitudAuditorBandejaTecnologiasBD tecnologiasBandejaAuditor;

    private String nroSolicitud;

    public ConsultoSolicitudTecnologias(String nroSolicitud) {
        this.nroSolicitud = nroSolicitud;
        this.respuesta = "Descripcion|Estado|CantidadSolicitada|AuditorResponsable|AuditorLogin|Motivo" + "\n\n ";
        this.tecnologiaBandejaAuditor = SolicitudAuditorBandeja.nuevo();
        this.tecnologiasBandejaAuditor = SolicitudAuditorBandejaTecnologiasBD.traerSolicitudAuditorBandejaTecnologias();
        this.conexion = ConexionBD.getConexion();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            tecnologiasBandejaAuditor.borrarSolicitudAuditorBandeja();
            PreparedStatement prepararSentencia = conexion.metPrepararSentcia(consulta);
            prepararSentencia.setInt(1, Integer.parseInt(nroSolicitud));

            ResultSet datos = prepararSentencia.executeQuery();

            while (datos.next()) {
                tecnologiaBandejaAuditor = SolicitudAuditorBandeja.nuevo();
                tecnologiaBandejaAuditor.setDescripcionTecnologia(datos.getString(1));
                tecnologiaBandejaAuditor.setEstado(datos.getString(2));
                tecnologiaBandejaAuditor.setCantidadSolicitada(datos.getString(3));
                tecnologiaBandejaAuditor.setMotivo(datos.getString(4));
                tecnologiaBandejaAuditor.setAuditorResponsable(datos.getString(5));

                tecnologiasBandejaAuditor.agregarSolicitudAuditorBandeja(tecnologiaBandejaAuditor);
                respuesta = respuesta + "|" + tecnologiaBandejaAuditor.getDescripcionTecnologia() + "|" + tecnologiaBandejaAuditor.getEstado() + "|" + tecnologiaBandejaAuditor.getCantidadSolicitada() + "|" + tecnologiaBandejaAuditor.getMotivo() + "|" + tecnologiaBandejaAuditor.getAuditorResponsable() + "\n\n ";
            }

            prepararSentencia.clearParameters();
            prepararSentencia.close();
            conexion.metDesconectarBd();

            actor.attemptsTo(TomarEvidencia.delQuery(consulta, respuesta, tecnologiasBandejaAuditor.cantidadSolicitudAuditorBandeja()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConsultoSolicitudTecnologias porNumeroSolicitud(String nroSolicitud) {
        return Tasks.instrumented(ConsultoSolicitudTecnologias.class, nroSolicitud);
    }
}
