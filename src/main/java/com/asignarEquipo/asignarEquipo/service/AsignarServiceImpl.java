package com.asignarEquipo.asignarEquipo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.asignarEquipo.asignarEquipo.model.Asignar;
import com.asignarEquipo.asignarEquipo.model.Persona;
import com.asignarEquipo.asignarEquipo.model.Equipo;
import com.asignarEquipo.asignarEquipo.model.dto.AsignarDto;
import com.asignarEquipo.asignarEquipo.repositories.AsignarRepository;
import com.asignarEquipo.asignarEquipo.repositories.PersonaRepository;
import com.asignarEquipo.asignarEquipo.repositories.EquipoRepository;
import java.util.ArrayList;

@Service("asignarService")
public class AsignarServiceImpl implements AsignarService {

    @Autowired
    protected AsignarRepository asignarRepository;
    @Autowired
    protected PersonaRepository personaRepository;
    @Autowired
    protected EquipoRepository equipoRepository;

    @Override
    public AsignarDto buscarId(Long id) {
        Asignar asignarData = asignarRepository.buscarId(id);
        AsignarDto asignarDto = new AsignarDto();
        asignarDto.setId(asignarData.getId());
        asignarDto.setIdPersona(asignarData.getPersona().getId());
        asignarDto.setNombrePersona(asignarData.getPersona().getNombre());
        asignarDto.setCorreoPersona(asignarData.getPersona().getCorreo());
        asignarDto.setIdEquipo(asignarData.getEquipo().getId());
        asignarDto.setCodigoEquipo(asignarData.getEquipo().getCodigo());
        asignarDto.setMarcaEquipo(asignarData.getEquipo().getMarca());
        asignarDto.setFechaInicio(asignarData.getFechaInicio());
        asignarDto.setFechaFin(asignarData.getFechaFin());
        asignarDto.setDescripcion(asignarData.getDescripcion());

        return asignarDto;

    }

    @Override
    public List<AsignarDto> listar() {
        List<Asignar> asignarDataList = asignarRepository.findAll();
        List<AsignarDto> AsignarDtoList = new ArrayList<AsignarDto>();
        for (Asignar asignar : asignarDataList) {
            AsignarDto asignarDtoTemp = new AsignarDto();
            asignarDtoTemp.setId(asignar.getId());
            asignarDtoTemp.setIdPersona(asignar.getPersona().getId());
            asignarDtoTemp.setNombrePersona(asignar.getPersona().getNombre());
            asignarDtoTemp.setCorreoPersona(asignar.getPersona().getCorreo());
            asignarDtoTemp.setIdEquipo(asignar.getEquipo().getId());
            asignarDtoTemp.setCodigoEquipo(asignar.getEquipo().getCodigo());
            asignarDtoTemp.setMarcaEquipo(asignar.getEquipo().getMarca());
            asignarDtoTemp.setFechaInicio(asignar.getFechaInicio());
            asignarDtoTemp.setFechaFin(asignar.getFechaFin());
            asignarDtoTemp.setDescripcion(asignar.getDescripcion());
            AsignarDtoList.add(asignarDtoTemp);
        }
        return AsignarDtoList;
    }

    @Override
    public List<AsignarDto> buscar(String filtro) {
        List<Asignar> asignarDataList = asignarRepository.findAllFiltro(filtro);
        List<AsignarDto> AsignarDtoList = new ArrayList<AsignarDto>();
        for (Asignar asignar : asignarDataList) {
            AsignarDto asignarDtoTemp = new AsignarDto();
            asignarDtoTemp.setId(asignar.getId());
            asignarDtoTemp.setIdPersona(asignar.getPersona().getId());
            asignarDtoTemp.setNombrePersona(asignar.getPersona().getNombre());
            asignarDtoTemp.setCorreoPersona(asignar.getPersona().getCorreo());
            asignarDtoTemp.setIdEquipo(asignar.getEquipo().getId());
            asignarDtoTemp.setCodigoEquipo(asignar.getEquipo().getCodigo());
            asignarDtoTemp.setMarcaEquipo(asignar.getEquipo().getMarca());
            asignarDtoTemp.setFechaInicio(asignar.getFechaInicio());
            asignarDtoTemp.setFechaFin(asignar.getFechaFin());
            asignarDtoTemp.setDescripcion(asignar.getDescripcion());
            AsignarDtoList.add(asignarDtoTemp);
        }
        return AsignarDtoList;
    }

    @Override
    public AsignarDto crear(AsignarDto asignarDto) {
        Persona persona = personaRepository.buscarId(asignarDto.getIdPersona());
        Equipo equipo = equipoRepository.buscarId(asignarDto.getIdEquipo());
        Asignar asignar = new Asignar();
        asignar.setPersona(persona);
        asignar.setEquipo(equipo);
        asignar.setFechaInicio(asignarDto.getFechaInicio());
        asignar.setFechaFin(asignarDto.getFechaFin());
        asignar.setDescripcion(asignarDto.getDescripcion());
        asignarRepository.save(asignar);
        return asignarDto;
    }

    @Override
    public AsignarDto actualizar(Long id, AsignarDto asignarDto) {
        Asignar asignar = asignarRepository.buscarId(id);
        Persona persona = personaRepository.buscarId(asignarDto.getIdPersona());
        Equipo equipo = equipoRepository.buscarId(asignarDto.getIdEquipo());
        asignar.setPersona(persona);
        asignar.setEquipo(equipo);
        asignar.setFechaInicio(asignarDto.getFechaInicio());
        asignar.setFechaFin(asignarDto.getFechaFin());
        asignar.setDescripcion(asignarDto.getDescripcion());
        asignarRepository.save(asignar);
        return asignarDto;

    }

    @Override
    public Boolean eliminar(Long id) {
        try {
            Asignar asignarData = asignarRepository.buscarId(id);
            asignarRepository.delete(asignarData);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
