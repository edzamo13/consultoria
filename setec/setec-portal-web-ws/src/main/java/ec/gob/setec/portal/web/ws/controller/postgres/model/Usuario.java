package ec.gob.setec.portal.web.ws.controller.postgres.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name = "Usuario", schema = "carrocompras")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USUARIO_IDUSUARIO_GENERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_IDUSUARIO_GENERATOR")
	@Column(name = "id_usuario")
	private Integer idUsuario;

	private String apellidos;

	private String avatar;

	private String email;

	@Temporal(TemporalType.DATE)
	private Date fechaalta;

	private String nombre;

	private String password;

	// bi-directional many-to-one association to Compra
	@OneToMany(mappedBy = "usuario" , fetch = FetchType.EAGER )
	private List<Compra> compras;

	// bi-directional many-to-one association to Producto
	@OneToMany(mappedBy = "usuario")
	private List<Producto> productos;

	public Usuario() {
	}

	public Usuario(Integer idUsuario, String apellidos, String avatar, String email, Date fechaalta, String nombre,
			String password) {
		super();
		this.idUsuario = idUsuario;
		this.apellidos = apellidos;
		this.avatar = avatar;
		this.email = email;
		this.fechaalta = fechaalta;
		this.nombre = nombre;
		this.password = password;
	}

	public Usuario(String apellidos, String avatar, String email, Date fechaalta, String nombre, String password) {
		super();
		this.apellidos = apellidos;
		this.avatar = avatar;
		this.email = email;
		this.fechaalta = fechaalta;
		this.nombre = nombre;
		this.password = password;

	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaalta() {
		return this.fechaalta;
	}

	public void setFechaalta(Date fechaalta) {
		this.fechaalta = fechaalta;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setUsuario(this);

		return compra;
	}

	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setUsuario(null);

		return compra;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setUsuario(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setUsuario(null);

		return producto;
	}

}