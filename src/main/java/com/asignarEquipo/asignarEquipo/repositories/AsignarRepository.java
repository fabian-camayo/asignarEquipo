package com.asignarEquipo.asignarEquipo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asignarEquipo.asignarEquipo.model.Asignar;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AsignarRepository extends JpaRepository<Asignar, Integer> {
    
    //Consulta utilizada para asignacion por nombre-persona, correo-persona, codigo-equipo, marca-equipo, fecha-inicio o fecha-fin
    @Query(value = "SELECT a FROM Asignar a WHERE a.persona.nombre like %:filtro% or a.persona.correo like %:filtro% or a.equipo.codigo like %:filtro% or a.equipo.marca like %:filtro% or a.fechaInicio like %:filtro% or a.fechaFin like %:filtro%")
    public List<Asignar> findAllFiltro(@Param("filtro") String filtro);

    //Consulta utilizada para buscar un Asignar por id
    @Query(value = "SELECT a FROM Asignar a WHERE a.id = :id")
    public Asignar buscarId(@Param("id") Long id);
}
