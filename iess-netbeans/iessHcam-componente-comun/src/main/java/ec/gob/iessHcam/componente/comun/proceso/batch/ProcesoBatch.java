package ec.gob.iessHcam.componente.comun.proceso.batch;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import lombok.Getter;
import lombok.Setter;
import ec.gob.iessHcam.componente.comun.excepciones.ServicioExcepcion;
import ec.gob.iessHcam.componente.comun.logs.Log;

public class ProcesoBatch implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 211220932285612330L;
    @Getter
    @Setter
    private DataSource base;

    public ProcesoBatch() {
        super();
    }

    public ProcesoBatch(DataSource baseDatos) {
        this.base = baseDatos;
    }

    public void guardarListaBatch(List<String> consultas) throws ServicioExcepcion {

        Statement ps = null;

        try (Connection conn = getBase().getConnection()) {
            Log.info(getClass().getName(), "Se obtuvo la conexión de la base");
            ps = conn.createStatement();
            for (String consulta : consultas) {
                ps.addBatch(consulta);
            }
            int[] registrosActualizados = ps.executeBatch();
            Log.info(getClass().getName(), "Se actualizaron: " + registrosActualizados.length);
            ps.close();
        } catch (SQLException | RuntimeException e) {
            Log.error(getClass().getName(), "Ocurrio un problema al ejecutar el proceso batch.", e);
            new ServicioExcepcion("Ocurrio un error al momento de ejecutar la actualización batch. ", e);
        }

    }
}
