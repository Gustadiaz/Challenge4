package br.com.fiap.raposymapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_CLINICAS")
public class ClinicasPublicas {
    

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 15)
    private String localizacao;

    @NotBlank
    @Size(min = 20)
    private String descricao;

    @NotBlank
    private String telefone;


    public ClinicasPublicas() {}


    public ClinicasPublicas(String name,String localizacao, String descricao, String telefone) {
        this.name = name;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.telefone = telefone;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    


}
