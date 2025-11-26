package br.com.salvacarteira.salvacarteira.model;

import jakarta.persistence.*;

@Entity // Diz ao JPA que esta classe é uma tabela
@Table(name = "categoria") // O nome exato da tabela no MySQL
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    // --- Getters e Setters ---
    // (O VS Code pode gerar para você: clique com o botão direito > Source Action... > Generate Getters and Setters)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}