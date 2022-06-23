package com.asignarEquipo.asignarEquipo.controller;

import com.asignarEquipo.asignarEquipo.model.Equipo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.asignarEquipo.asignarEquipo.service.AsignarService;
import com.asignarEquipo.asignarEquipo.service.PersonaService;
import com.asignarEquipo.asignarEquipo.service.EquipoService;
import com.asignarEquipo.asignarEquipo.model.dto.AsignarDto;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AsignarController {

    @Autowired
    protected AsignarService asignarService;
    @Autowired
    protected PersonaService personaService;
    @Autowired
    protected EquipoService equipoService;

    @GetMapping("/")
    public String listar(Model model) {
        try {
            model.addAttribute("asignacion", asignarService.listar());
            return "asignar/listar_asignar";
        } catch (Exception e) {
            return "asignar/listar_asignar";
        }
    }

    @GetMapping("/asignar/buscar")
    public String buscar(String filtro, Model model) {
        try {
            model.addAttribute("asignacion", asignarService.buscar(filtro));
            return "asignar/listar_asignar";
        } catch (Exception e) {
            return "asignar/listar_asignar";
        }
    }

    @GetMapping("/asignar/buscar/persona")
    public String buscarPersona(
            @ModelAttribute("asignarDto") AsignarDto asignarDto,
            @ModelAttribute("asignacionEquipo") ArrayList<Equipo> asignacionEquipo,
            String filtro, Model model) {
        try {
            model.addAttribute("asignacionPersona", personaService.buscar(filtro));
            model.addAttribute("asignacionEquipo", asignacionEquipo);
            model.addAttribute("asignarDtoTemp", asignarDto);
            return "asignar/crear_asignar";
        } catch (Exception e) {
            return "asignar/crear_asignar";
        }
    }

    @GetMapping("/asignar/buscar/equipo")
    public String buscarEquipo(
            @ModelAttribute("asignarDto") AsignarDto asignarDto,
            String filtro, Model model) {
        try {
            model.addAttribute("asignacionEquipo", equipoService.buscar(filtro));
            model.addAttribute("asignarDto", asignarDto);
            return "asignar/crear_asignar";
        } catch (Exception e) {
            return "asignar/crear_asignar";
        }
    }

    @GetMapping("/asignar/nuevo")
    public String crearAsignarForm(Model model) {

        AsignarDto asignarDto = new AsignarDto();
        model.addAttribute("asignarDto", asignarDto);
        return "asignar/crear_asignar";
    }

    @PostMapping("/asignar/crear")
    public String crear(@ModelAttribute("asignarDto") AsignarDto asignarDto) {

        try {
            if (asignarDto.getIdEquipo() == null || asignarDto.getIdPersona() == null) {
                return "redirect:/asignar/nuevo";
            }
            asignarService.crear(asignarDto);
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/asignar/nuevo";

        }

    }

    @GetMapping("/asignar/editar/{id}")
    public String editarAsignarForm(@PathVariable Long id, Model model) {
        AsignarDto asignarDto = asignarService.buscarId(id);

        model.addAttribute("asignarDto", asignarDto);

        return "asignar/editar_asignar";
    }

    @PostMapping("/asignar/actualizar/{id}")
    public String actualizar(@PathVariable Long id,
            @ModelAttribute("asignarDto") AsignarDto asignarDto,
            Model model) {

        try {
            if (asignarDto.getIdEquipo() == null || asignarDto.getIdPersona() == null) {
                return "redirect:/";
            }
            asignarService.actualizar(id, asignarDto);
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/";

        }

    }

    @GetMapping("/asignar/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {

        try {
            asignarService.eliminar(id);
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/";
        }

    }
}
