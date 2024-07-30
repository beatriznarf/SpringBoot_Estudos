package bsd.dtos;

import lombok.Data;
import java.time.LocalDate;

@Data
public class personagensCreateRequest {

    private Long id;
    private String organizacao;
    private String nome;
    private int idade;
    private String nacionalidade;
    private String sexo;
    private LocalDate nascimento;

}
