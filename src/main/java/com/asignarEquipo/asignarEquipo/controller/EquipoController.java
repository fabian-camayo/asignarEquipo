package com.asignarEquipo.asignarEquipo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.asignarEquipo.asignarEquipo.service.EquipoService;
import com.asignarEquipo.asignarEquipo.model.Equipo;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class EquipoController {

    @Autowired
    protected EquipoService equipoService;

    @GetMapping("/equipo/listar")
    public String listar(Model model) {
        try {
            model.addAttribute("equipos", equipoService.listar());
            return "equipo/listar_equipo";
        } catch (Exception e) {
            return "equipo/listar_equipo";
        }
    }

    @GetMapping("/equipo/buscar")
    public String buscar(String filtro, Model model) {
        try {
            model.addAttribute("equipos", equipoService.buscar(filtro));
            return "equipo/listar_equipo";
        } catch (Exception e) {
            return "equipo/listar_equipo";
        }
    }

    @GetMapping("/equipo/nuevo")
    public String crearEquipoForm(Model model) {

        Equipo equipo = new Equipo();
        model.addAttribute("equipo", equipo);
        return "equipo/crear_equipo";
    }

    @PostMapping("/equipo/crear")
    public String crear(@ModelAttribute("equipo") Equipo equipo) {

        try {
            equipoService.crear(equipo);
            return "redirect:/equipo/listar";
        } catch (Exception e) {
            return "redirect:/equipo/nuevo";

        }

    }

    @GetMapping("/equipo/editar/{id}")
    public String editarEquipoForm(@PathVariable Long id, Model model) {
        Equipo equipo = equipoService.buscarId(id);

        model.addAttribute("equipo", equipo);

        return "equipo/editar_equipo";
    }

    @PostMapping("/equipo/actualizar/{id}")
    public String actualizar(@PathVariable Long id,
            @ModelAttribute("equipo") Equipo equipo,
            Model model) {

        try {
            equipoService.actualizar(id, equipo);
            return "redirect:/equipo/listar";
        } catch (Exception e) {
            return "redirect:/equipo/listar";

        }

    }

    @GetMapping("/equipo/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {

        try {
            equipoService.eliminar(id);
            return "redirect:/equipo/listar";
        } catch (Exception e) {
            return "redirect:/equipo/listar";
        }

    }
}
