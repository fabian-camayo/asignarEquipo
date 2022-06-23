package com.asignarEquipo.asignarEquipo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.asignarEquipo.asignarEquipo.service.PersonaService;
import com.asignarEquipo.asignarEquipo.model.Persona;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PersonaController {

    @Autowired
    protected PersonaService personaService;

    @GetMapping("/persona/listar")
    public String listar(Model model) {
        try {
            model.addAttribute("personas", personaService.listar());
            return "persona/listar_persona";
        } catch (Exception e) {
            return "persona/listar_persona";
        }
    }

    @GetMapping("/persona/buscar")
    public String buscar(String filtro, Model model) {
        try {
            model.addAttribute("personas", personaService.buscar(filtro));
            return "persona/listar_persona";
        } catch (Exception e) {
            return "persona/listar_persona";
        }
    }

    @GetMapping("/persona/nuevo")
    public String crearPersonaForm(Model model) {

        Persona persona = new Persona();
        model.addAttribute("persona", persona);
        return "persona/crear_persona";
    }

    @PostMapping("/persona/crear")
    public String crear(@ModelAttribute("persona") Persona persona) {

        try {
            persona = personaService.crear(persona);
            return "redirect:/persona/listar";
        } catch (Exception e) {
            return "redirect:/persona/nuevo";

        }

    }

    @GetMapping("/persona/editar/{id}")
    public String editarPersonaForm(@PathVariable Long id, Model model) {
        Persona persona = personaService.buscarId(id);

        model.addAttribute("persona", persona);

        return "persona/editar_persona";
    }

    @PostMapping("/persona/actualizar/{id}")
    public String actualizar(@PathVariable Long id,
            @ModelAttribute("persona") Persona persona,
            Model model) {

        try {
            personaService.actualizar(id, persona);
            return "redirect:/persona/listar";
        } catch (Exception e) {
            return "redirect:/persona/listar";

        }

    }

    @GetMapping("/persona/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {

        try {
            personaService.eliminar(id);
            return "redirect:/persona/listar";
        } catch (Exception e) {
            return "redirect:/persona/listar";
        }

    }
}
