package com.asignarEquipo.asignarEquipo.model.dto;

public class AsignarDto {

    private Long id;
    private Long idPersona;
    private String nombrePersona;
    private String correoPersona;
    private Long idEquipo;
    private String codigoEquipo;
    private String marcaEquipo;
    private String fechaInicio;
    private String fechaFin;
    private String descripcion;

    public AsignarDto() {
    }

    public AsignarDto(Long id, Long idPersona, String nombrePersona, String correoPersona, Long idEquipo, String codigoEquipo, String marcaEquipo, String fechaInicio, String fechaFin, String descripcion) {
        this.id = id;
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.correoPersona = correoPersona;
        this.idEquipo = idEquipo;
        this.codigoEquipo = codigoEquipo;
        this.marcaEquipo = marcaEquipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getCorreoPersona() {
        return correoPersona;
    }

    public void setCorreoPersona(String correoPersona) {
        this.correoPersona = correoPersona;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setCodigoEquipo(String codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    public String getMarcaEquipo() {
        return marcaEquipo;
    }

    public void setMarcaEquipo(String marcaEquipo) {
        this.marcaEquipo = marcaEquipo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
