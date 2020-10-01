/*
 * Copyright 2018 CNE
 * Todos los derechos reservados
 */
package ec.gob.cne.ws.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ezamora
 */
@Entity
@Table(name = "usuario", catalog = "wanqara", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Usuario.OBTENER_USUARIO, query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario")
    , @NamedQuery(name = Usuario.OBTENER_USUARIO_POR_USR, query = "SELECT u FROM Usuario u WHERE u.usrUsuario = :usuario")
    , @NamedQuery(name = "Usuario.findByUsrPassword", query = "SELECT u FROM Usuario u WHERE u.usrPassword = :usrPassword")
    , @NamedQuery(name = "Usuario.findByUsrFecha", query = "SELECT u FROM Usuario u WHERE u.usrFecha = :usrFecha")
    , @NamedQuery(name = "Usuario.findByUsrEstado", query = "SELECT u FROM Usuario u WHERE u.usrEstado = :usrEstado")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String OBTENER_USUARIO="Usuario.OBTENER_USUARIO";
    public static final String OBTENER_USUARIO_POR_USR="Usuario.OBTENER_USUARIO_USR";
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuario")
    private Integer idusuario;
    @Size(max = 45)
    @Column(name = "usr_usuario")
    private String usrUsuario;
    @Size(max = 45)
    @Column(name = "usr_password")
    private String usrPassword;
    @Size(max = 45)
    @Column(name = "usr_fecha")
    private String usrFecha;
    @Column(name = "usr_estado")
    private Integer usrEstado;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsrUsuario() {
        return usrUsuario;
    }

    public void setUsrUsuario(String usrUsuario) {
        this.usrUsuario = usrUsuario;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public String getUsrFecha() {
        return usrFecha;
    }

    public void setUsrFecha(String usrFecha) {
        this.usrFecha = usrFecha;
    }

    public Integer getUsrEstado() {
        return usrEstado;
    }

    public void setUsrEstado(Integer usrEstado) {
        this.usrEstado = usrEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wanqara.wanqara.ws.modelo.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}
