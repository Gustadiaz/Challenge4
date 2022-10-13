package br.com.fiap.raposymapi.dto;

public record PsicologoDto (
     String name,
     String description,
     int idade,
     int documento,
     String setor


) {

     
     public PsicologoDto(String name, String description, String setor){
          this(name, description, 25, 235, setor);
     }
     

}
