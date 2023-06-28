package com.alvaro.spring.msvc.usuarios.msvcusuarios.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ISSUE")
public class IssueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private int codigo;
    private boolean resuelta;
    private double gravedad;
    private String responsable;
    private Date fechaCreacion;
    private String observaciones;

    // Constructores, getters y setters

    public IssueEntity() {
    }

    public IssueEntity(String nombre, String descripcion, int codigo, boolean resuelta, double gravedad, String responsable, Date fechaCreacion, String observaciones) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.resuelta = resuelta;
        this.gravedad = gravedad;
        this.responsable = responsable;
        this.fechaCreacion = fechaCreacion;
        this.observaciones = observaciones;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isResuelta() {
        return resuelta;
    }

    public void setResuelta(boolean resuelta) {
        this.resuelta = resuelta;
    }

    public double getGravedad() {
        return gravedad;
    }

    public void setGravedad(double gravedad) {
        this.gravedad = gravedad;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
