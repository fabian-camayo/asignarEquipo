package com.asignarEquipo.asignarEquipo.service;

import java.util.List;
import com.asignarEquipo.asignarEquipo.model.Equipo;


public interface EquipoService {

    public Equipo buscarId(Long id);

    public List<Equipo> listar();

    public List<Equipo> buscar(String filtro);

    public Equipo crear(Equipo equipo);

    public Equipo actualizar(Long id, Equipo equipo);

    public Boolean eliminar(Long id);
}
