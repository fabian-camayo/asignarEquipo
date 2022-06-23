package com.asignarEquipo.asignarEquipo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import com.asignarEquipo.asignarEquipo.model.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Integer> {

    //Consulta utilizada para buscar un Equipo por codigo, nombre, cargo o correo
    @Query(value = "SELECT e FROM Equipo e WHERE e.codigo like %:filtro% or e.marca like %:filtro% or e.tipo like %:filtro% or e.fechaCompra like %:filtro%")
    public List<Equipo> findAllFiltro(@Param("filtro") String filtro);

    //Consulta utilizada para buscar un Equipo por id
    @Query(value = "SELECT e FROM Equipo e WHERE e.id = :id")
    public Equipo buscarId(@Param("id") Long id);
}
