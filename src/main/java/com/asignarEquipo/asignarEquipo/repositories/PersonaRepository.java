package com.asignarEquipo.asignarEquipo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import com.asignarEquipo.asignarEquipo.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    //Consulta utilizada para buscar un persona por nombre, cargo o correo
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre like %:filtro% or p.cargo like %:filtro% or p.correo like %:filtro%")
    public List<Persona> findAllFiltro(@Param("filtro") String filtro);
        
    //Consulta utilizada para buscar un persona por id
    @Query(value = "SELECT p FROM Persona p WHERE p.id = :id")
    public Persona buscarId(@Param("id") Long id);
       
}
