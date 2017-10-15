package br.com.usuario.domain.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(name = "data_de_nascimento", nullable = false)
    private LocalDate dataDeNascimento;

    @Column(name = "id_time_do_coracao")
    private Long idTimeDoCoracao;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public Long getIdTimeDoCoracao() {
        return idTimeDoCoracao;
    }

    public void setIdTimeDoCoracao(Long idTimeDoCoracao) {
        this.idTimeDoCoracao = idTimeDoCoracao;
    }
}
