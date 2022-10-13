package br.com.fiap.raposymapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_PSICOLOGO")
public class Psicologo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "titulo é obrigatório")
    private String name;

    @Size(min = 10, max = 250)
    private String description;

    @Min(1)
    private int idade;

    private int documento;

    private String setor;

    public Psicologo() {}

    public Psicologo(String name, String description, int idade, int documento, String setor) {
        this.name = name;
        this.description = description;
        this.idade = idade;
        this.documento = documento;
        this.setor = setor;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getSetor(){
        return setor;
    }

    public void setSetor(String setor){
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Psicologo [nome=" + name + ", description=" + description + ", id=" + id + ", idade=" + idade + ", documento=" + documento + ", setor=" + setor + "]";
    }

}
