package br.com.usuario.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ApiModel(value = "Dados referente ao usuário")
public class UsuarioRequest {

    @NotBlank(message = "Nome deve estar preechido")
    @ApiModelProperty(value = "Nome", required = true, dataType = "String")
    private String nome;

    @NotBlank(message = "Email deve estar preechido")
    @Email(message = "Email informado é inválido")
    @ApiModelProperty(value = "Email", required = true, dataType = "Email")
    private String email;

    @NotNull(message = "Data de nascimento deve estar preechida")
    @ApiModelProperty(value = "Data de nascimento", required = true, dataType = "Date", example = "12/12/2017")
    private LocalDate dataDeNascimento;

    @NotNull(message = "Id do time do coração deve estar preechido")
    @ApiModelProperty(value = "Data de nascimento", required = true, dataType = "String")
    private Long idTimeDoCoracao;

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

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Long getIdTimeDoCoracao() {
        return idTimeDoCoracao;
    }

    public void setIdTimeDoCoracao(Long idTimeDoCoracao) {
        this.idTimeDoCoracao = idTimeDoCoracao;
    }
}
