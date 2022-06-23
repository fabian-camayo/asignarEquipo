package com.asignarEquipo.asignarEquipo.service;

import com.asignarEquipo.asignarEquipo.model.dto.AsignarDto;
import java.util.List;

public interface AsignarService {

    public AsignarDto buscarId(Long id);

    public List<AsignarDto> listar();

    public List<AsignarDto> buscar(String filtro);

    public AsignarDto crear(AsignarDto asignarDto);

    public AsignarDto actualizar(Long id, AsignarDto asignarDto);

    public Boolean eliminar(Long id);
}
