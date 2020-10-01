package ec.gob.iessHcam.componente.seguridad.modelo.uno;

import ec.gob.iessHcam.componente.seguridad.modelo.Aplicacion;
import ec.gob.iessHcam.componente.seguridad.modelo.Dependencias;
import ec.gob.iessHcam.componente.seguridad.modelo.Menu;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-04T13:02:26")
@StaticMetamodel(Aplicacion.class)
public class Aplicacion_ { 

    public static volatile SingularAttribute<Aplicacion, String> apEstado;
    public static volatile SingularAttribute<Aplicacion, Dependencias> deIdDependencia;
    public static volatile SingularAttribute<Aplicacion, byte[]> apImagen;
    public static volatile SingularAttribute<Aplicacion, Integer> apIdAplicacion;
    public static volatile SingularAttribute<Aplicacion, String> apExtImg;
    public static volatile SingularAttribute<Aplicacion, String> apDescripcion;
    public static volatile SingularAttribute<Aplicacion, String> apUrl;
    public static volatile SingularAttribute<Aplicacion, String> apNombre;
    public static volatile SingularAttribute<Aplicacion, String> apNomImg;
    public static volatile SingularAttribute<Aplicacion, String> apDesCont;
    public static volatile SingularAttribute<Aplicacion, Integer> caIdCategoria;
    public static volatile SingularAttribute<Aplicacion, String> apCodAplicacion;
    public static volatile ListAttribute<Aplicacion, Menu> segMenuTblList;
    public static volatile SingularAttribute<Aplicacion, String> apTipo;
    public static volatile SingularAttribute<Aplicacion, Integer> apVisible;

}