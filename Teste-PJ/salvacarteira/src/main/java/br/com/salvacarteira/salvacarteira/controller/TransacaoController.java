package br.com.salvacarteira.salvacarteira.controller;


import br.com.salvacarteira.salvacarteira.model.Transacao;
import br.com.salvacarteira.salvacarteira.repository.CategoriaRepository;
import br.com.salvacarteira.salvacarteira.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository; // Precisamos disso para preencher o <select>

    // Listar Transações
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaTransacoes", transacaoRepository.findAll());
        return "transacao/lista"; // Vamos criar esse HTML abaixo
    }

    // Abrir formulário de Nova Transação
    @GetMapping("/nova")
    public String formulario(Model model) {
        model.addAttribute("transacao", new Transacao());
        // Envia a lista de categorias para o dropdown
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "transacao/formulario"; // Vamos criar esse HTML abaixo
    }

    // Salvar Transação
    @PostMapping
    public String salvar(@ModelAttribute Transacao transacao) {
        transacaoRepository.save(transacao);
        return "redirect:/transacoes";
    }

    // Excluir Transação
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        transacaoRepository.deleteById(id);
        return "redirect:/transacoes";
    }
}