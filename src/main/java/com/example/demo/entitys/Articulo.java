package com.example.demo.entitys;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

@Entity

@NamedStoredProcedureQuery(
        name = "BuscarArticulo",
        procedureName = "buscarPorSku",
        parameters = {
          @StoredProcedureParameter(mode=ParameterMode.IN, name="skuIn", type=Integer.class)
})

/*@NamedStoredProcedureQuery(
        name = "CrearArticulo",
        procedureName = "createArticulo",
        parameters = {
          @StoredProcedureParameter(mode=ParameterMode.IN, name="skuIn", type=Integer.class),
          @StoredProcedureParameter(mode=ParameterMode.IN, name="articuloIn", type=String.class),
          @StoredProcedureParameter(mode=ParameterMode.IN, name="marcaIn", type=String.class),
          @StoredProcedureParameter(mode=ParameterMode.IN, name="modeloIn", type=String.class),
          @StoredProcedureParameter(mode=ParameterMode.IN, name="id_departamentoIn", type=Integer.class),
          @StoredProcedureParameter(mode=ParameterMode.IN, name="id_claseIn", type=Integer.class),
          @StoredProcedureParameter(mode=ParameterMode.IN, name="id_familiaIn", type=Integer.class),
          @StoredProcedureParameter(mode=ParameterMode.IN, name="fecha_altaIn", type=Date.class),
          @StoredProcedureParameter(mode=ParameterMode.IN, name="stockIn", type=Integer.class),
          @StoredProcedureParameter(mode=ParameterMode.IN, name="cantidadIn", type=Integer.class),
          @StoredProcedureParameter(mode=ParameterMode.IN, name="descontinuadoIn", type=Integer.class),
          @StoredProcedureParameter(mode=ParameterMode.IN, name="fecha_bajaIn", type=Date.class)
})*/
@Table(name="articulos")
public class Articulo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="sku", nullable=false, length=6)
	private Integer sku;
	
	@Column(name="articulo", nullable=false, length=15)
	private String articulo;
	
	@Column(name="marca", nullable=false, length=15)
	private String marca;
	
	@Column(name="modelo", nullable=false, length=20)
	private String modelo;
	
	@Column(name="fecha_alta", nullable=false)
	private Date fechaAlta;
	
	@Column(name="stock", nullable=false)
	private Integer stock;
	
	@Column(name="cantidad", nullable=false)
	private Integer cantidad;
	
	@Column(name="descontinuado", nullable=false)
	private Integer descontinuado;
	
	@Column(name="fecha_baja", nullable=false)
	private Date fechaBaja;

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="id_departamento")
	private Departamento departamento;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="id_clase")
	private Clase clase;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="id_familia")
	private Familia familia;

	public Integer getSku() {
		return sku;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public void setSku(Integer sku) {
		this.sku = sku;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getDescontinuado() {
		return descontinuado;
	}

	public void setDescontinuado(Integer descontinuado) {
		this.descontinuado = descontinuado;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	
}
