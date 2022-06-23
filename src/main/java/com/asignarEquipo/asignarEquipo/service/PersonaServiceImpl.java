package com.asignarEquipo.asignarEquipo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.asignarEquipo.asignarEquipo.model.Persona;
import com.asignarEquipo.asignarEquipo.repositories.PersonaRepository;

@Service("personaService")
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    protected PersonaRepository personaRepository;

    @Override
    public Persona buscarId(Long id) {
        Persona personaData = personaRepository.buscarId(id);

        return personaData;

    }

    @Override
    public List<Persona> listar() {
        return personaRepository.findAll();
    }

    @Override
    public List<Persona> buscar(String filtro) {
        return personaRepository.findAllFiltro(filtro);
    }

    @Override
    public Persona crear(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona actualizar(Long id, Persona persona) {
        Persona personaData = personaRepository.buscarId(id);
        Persona _persona = personaData;
        _persona.setNombre(persona.getNombre());
        _persona.setCargo(persona.getCargo());
        _persona.setCelular(persona.getCelular());
        _persona.setCorreo(persona.getCorreo());
        _persona.setDireccion(persona.getDireccion());
        return personaRepository.save(_persona);

    }

    @Override
    public Boolean eliminar(Long id) {
        try {
            Persona personaData = personaRepository.buscarId(id);
            personaRepository.delete(personaData);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
