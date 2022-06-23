package com.asignarEquipo.asignarEquipo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipos")
public class Equipo implements Serializable {

    private Long id;
    private String codigo;
    private String marca;
    private String ram;
    private String disco;
    private String tipo;
    private String procesador;
    private String fechaCompra;

    public Equipo() {
    }

    public Equipo(Long id, String codigo, String marca, String ram, String disco, String tipo, String procesador, String  fechaCompra) {
        this.id = id;
        this.codigo = codigo;
        this.marca = marca;
        this.ram = ram;
        this.disco = disco;
        this.tipo = tipo;
        this.procesador = procesador;
        this.fechaCompra = fechaCompra;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name = "codigo", nullable = false)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    @Column(name = "marca", nullable = false)
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Column(name = "ram", nullable = false)
    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    @Column(name = "disco", nullable = false)
    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    @Column(name = "tipo", nullable = false)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Column(name = "procesador", nullable = false)
    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }
    
    @Column(name = "fecha_compra", nullable = false, length = 100)
    public String  getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String  fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public String toString() {
        return "Equipo{" + "id=" + id + ", codigo=" + codigo + ", marca=" + marca + ", ram=" + ram + ", disco=" + disco + ", tipo=" + tipo + ", procesador=" + procesador + ", fechaCompra=" + fechaCompra + '}';
    }
    
}
