package com.asignarEquipo.asignarEquipo.service;

import java.util.List;
import com.asignarEquipo.asignarEquipo.model.Persona;

public interface PersonaService {

    public Persona buscarId(Long id);

    public List<Persona> listar();

    public List<Persona> buscar(String filtro);

    public Persona crear(Persona persona);

    public Persona actualizar(Long id, Persona persona);

    public Boolean eliminar(Long id);
}
