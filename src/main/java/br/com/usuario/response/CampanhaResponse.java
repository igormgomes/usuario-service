package br.com.usuario.response;

import java.time.LocalDate;

public class CampanhaResponse {

    private Long id;
    private Long idTimeDoCoracao;
    private LocalDate dataInicioVigencia;
    private LocalDate dataFimVigencia;
    private String nome;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getIdTimeDoCoracao() {
        return idTimeDoCoracao;
    }

    public void setIdTimeDoCoracao(Long idTimeDoCoracao) {
        this.idTimeDoCoracao = idTimeDoCoracao;
    }

    public LocalDate getDataInicioVigencia() {
        return dataInicioVigencia;
    }

    public void setDataInicioVigencia(LocalDate dataInicioVigencia) {
        this.dataInicioVigencia = dataInicioVigencia;
    }

    public LocalDate getDataFimVigencia() {
        return dataFimVigencia;
    }

    public void setDataFimVigencia(LocalDate dataFimVigencia) {
        this.dataFimVigencia = dataFimVigencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
