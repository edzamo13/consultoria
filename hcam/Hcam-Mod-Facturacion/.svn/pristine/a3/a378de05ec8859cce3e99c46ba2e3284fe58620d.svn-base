/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.hcam.executor;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.sql.DataSource;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.QuirksMode;
import org.sql2o.Sql2o;
import java.lang.InterruptedException;
import java.sql.SQLException;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class QueryExecutor implements IQueryExecutor {

    
    @Resource(lookup = "jdbc/hcam", type = DataSource.class)
    DataSource dataSource;
   
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List executeQuery(String queryString, Map<String, Object> params, Class returnType) {
        //Modifico el metodo para manejar exepciones
        //List resulset = null;
        //try {
        Sql2o slSql2o = new Sql2o(dataSource, QuirksMode.DB2);
        List resulset;
        try (Query query = slSql2o.createQuery(queryString)) {
            if (params != null) {
                for (String key : params.keySet()) {
                    query.addParameter(key, params.get(key));
                }
            }   //List
            resulset = query.executeAndFetch(returnType);
        }
        return resulset;
        
        }
  /*      
        } catch(java.sql.SQLException jlie){
            //System.err.println("An InterruptedException was caught: " + jlie.getMessage());
            //System.out.println(jlie.getMessage());
            throw new InterruptedException("error when executing query", jlie);
        }finally{
            try{
        if(stmt != null) {
            stmt.close();
        }
    } catch(SQLException se) {
        se.printStackTrace();
    }
    try {
        if (conn != null) {
            conn.close();
        }
    } catch(SQLException se) {
        se.printStackTrace();
    }
        return resulset;
        }
    }
          */

    @Override
    public void executeQueryInsert(String query, Map<String, Object> params) {

        Sql2o slSql2o = new Sql2o(dataSource, QuirksMode.DB2);
        try (Connection con = slSql2o.beginTransaction()) {
            Query queryInsert = slSql2o.createQuery(query);

            if (params != null) {
                for (String key : params.keySet()) {
                    queryInsert.addParameter(key, params.get(key));
                }
            }
            queryInsert.executeUpdate();
            con.commit();
        }

    }

}
