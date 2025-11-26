package br.com.salvacarteira.salvacarteira.controller;


import br.com.salvacarteira.salvacarteira.model.TipoTransacao;
import br.com.salvacarteira.salvacarteira.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@Controller
public class DashboardController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping("/")
    public String dashboard(Model model) {
        // Busca totais no banco
        BigDecimal totalReceitas = transacaoRepository.calcularTotalPorTipo(TipoTransacao.RECEITA);
        BigDecimal totalDespesas = transacaoRepository.calcularTotalPorTipo(TipoTransacao.DESPESA);
        
        // Calcula saldo
        BigDecimal saldo = totalReceitas.subtract(totalDespesas);

        // Envia para a tela
        model.addAttribute("totalReceitas", totalReceitas);
        model.addAttribute("totalDespesas", totalDespesas);
        model.addAttribute("saldo", saldo);

        return "dashboard"; // Vamos criar o dashboard.html
    }
}