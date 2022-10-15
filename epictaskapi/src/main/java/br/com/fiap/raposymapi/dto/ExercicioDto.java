package br.com.fiap.raposymapi.dto;

public record ExercicioDto (
     String nmExercicio,
     String dsExercicio,
     int score,
     int status

) {

     
     public ExercicioDto(String nmExercicio, String dsExercicio){
          this(nmExercicio, dsExercicio, 100, 0);
     }
     

}

