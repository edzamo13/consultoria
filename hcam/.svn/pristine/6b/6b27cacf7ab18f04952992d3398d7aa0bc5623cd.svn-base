package hcam.web;

import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import ec.hcam.entities1.InformacionB;
import ec.hcam.entities1.InformacionC;

/**
 * Clase: LectorInformacionController Controla la logica de la ejecucion de las
 * reglas en los metodos que tiene implementados.
 *
 * @author Programacion
 * @version 1.0.0
 */
@ViewScoped
@ManagedBean(name = "lectorInformacionServicioDependencia")
public class LectorInformacionServicioDependencia {

//	private Connection conn;	
    InitialContext cxt;

    @Resource(name = "jdbc/hcam")
    private DataSource ds;

    public void recuperaInfo() {
        try {
            cxt = new InitialContext();
            Context initContext = new InitialContext();
			//Context envContext = (Context) initContext.lookup("java:/comp/env");
            //Context envContext = (Context) initContext.lookup("java:comp/env/jdbc/hcamDS");

			//opcion dos tampoco funciono
            //ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/hcamDS");
			//estos si valen pero sale error.....
            Context envContext = (Context) initContext.lookup("java:comp/env");
            ds = (DataSource) envContext.lookup("jdbc/hcam");

			//System.out.println("conexion con la base EXITOSA "
            //		+ conn.hashCode());
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Sql2o sql2o = new Sql2o("jdbc:as400://172.16.4.10;prompt=false", "conexFact", "webFactura");
        Sql2o sql2o = new Sql2o(ds);

		//String sql = "SELECT ir2his as IR2HIS,i.ir2ite as IR2ITE,t.tavalor as TAVALOR,ir2hop as IR2HOP FROM CEDDTA.IRSI02 i join facweb.tarifaftbl t on i.ir2ite=t.tacodigo and t.ctidpk=1 WHERE IR2UNM='1110100000' AND IR2DEP=1142 AND IR2CIT=20150421 order by ir2hop fetch first 1 rows only";
        //String sql = "SELECT ir2his as IR2HIS, i.ir2ite as IR2ITE, t.tavalor as TAVALOR, ir2hop as IR2HOP FROM produio.CEDDTA.IRSI02 i join facweb.tarifaftbl t on i.ir2ite=t.tacodigo and t.ctidpk=1 WHERE IR2UNM='1110100000' AND IR2DEP=1142 AND IR2CIT=20150421 order by ir2hop";
        String sql = "SELECT count(*) as valor FROM produio.facweb.tarifaftbl t;";
        try (Connection con = sql2o.open()) {
            List<InformacionC> tasks = con.createQuery(sql)
                    // .addParameter("category", "foo")
                    .executeAndFetch(InformacionC.class);

            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("IR2HIS :" + tasks.get(i).getValor());
                /*
                System.out.println("IR2ITE :" + tasks.get(i).getIR2ITE());
                System.out.println("TAVALOR :" + tasks.get(i).getTAVALOR());
                System.out.println("IR2HOP :" + tasks.get(i).getIR2HOP());
                        */
            }

        }
        
    }

}
