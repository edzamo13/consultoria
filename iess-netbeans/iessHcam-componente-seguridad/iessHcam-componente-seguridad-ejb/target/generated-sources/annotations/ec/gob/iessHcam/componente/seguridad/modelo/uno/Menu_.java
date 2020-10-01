package ec.gob.iessHcam.componente.seguridad.modelo.uno;

import ec.gob.iessHcam.componente.seguridad.modelo.Aplicacion;
import ec.gob.iessHcam.componente.seguridad.modelo.Menu;
import ec.gob.iessHcam.componente.seguridad.modelo.Rolxmenu;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-04T13:02:26")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, String> meEstado;
    public static volatile SingularAttribute<Menu, Integer> meIdOpcion;
    public static volatile SingularAttribute<Menu, String> meEtiqueta;
    public static volatile SingularAttribute<Menu, String> meUrl;
    public static volatile SingularAttribute<Menu, Integer> meNodoFinal;
    public static volatile SingularAttribute<Menu, Integer> meAuditoria;
    public static volatile SingularAttribute<Menu, Aplicacion> apIdAplicacion;
    public static volatile ListAttribute<Menu, Rolxmenu> segRolxmenuTblList;
    public static volatile SingularAttribute<Menu, Integer> meOrden;
    public static volatile SingularAttribute<Menu, String> meAccion;
    public static volatile SingularAttribute<Menu, Integer> meIdOpcionPadre;

}