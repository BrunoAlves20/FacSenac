package br.com.salvacarteira.salvacarteira.controller;

import br.com.salvacarteira.salvacarteira.model.Categoria; // Importe o model
import br.com.salvacarteira.salvacarteira.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute; // Importe
import org.springframework.web.bind.annotation.PostMapping; // Importe
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping 
    public String listarCategorias(Model model) {
        
        // 1. Busca todas as categorias (para a tabela)
        model.addAttribute("listaCategorias", categoriaRepository.findAll());
        
        // 2. Envia um objeto VAZIO para o formulário (para o 'th:object')
        model.addAttribute("novaCategoria", new Categoria());
        
        return "categoria/lista"; // Renderiza o lista.html
    }

    // Este método é NOVO: Ele recebe os dados do formulário via POST
    @PostMapping
    public String salvarCategoria(@ModelAttribute Categoria novaCategoria) {
        
        // 1. Salva a nova categoria no banco de dados
        categoriaRepository.save(novaCategoria);
        
        // 2. Redireciona de volta para a página de listagem
        return "redirect:/categorias";
    }
}