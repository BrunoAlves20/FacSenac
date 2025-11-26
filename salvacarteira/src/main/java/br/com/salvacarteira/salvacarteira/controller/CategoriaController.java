package br.com.salvacarteira.salvacarteira.controller;

import br.com.salvacarteira.salvacarteira.model.Categoria;
import br.com.salvacarteira.salvacarteira.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Listar (GET)
    @GetMapping 
    public String listarCategorias(Model model) {
        model.addAttribute("listaCategorias", categoriaRepository.findAll());
        model.addAttribute("novaCategoria", new Categoria());
        return "categoria/lista";
    }

    // Salvar (POST)
    @PostMapping
    public String salvarCategoria(@ModelAttribute Categoria novaCategoria) {
        categoriaRepository.save(novaCategoria);
        return "redirect:/categorias";
    }

    // --- CORREÇÃO: Função Excluir que estava faltando ---
    @GetMapping("/deletar/{id}")
    public String deletarCategoria(@PathVariable Long id) {
        try {
            categoriaRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
        return "redirect:/categorias";
    }
}