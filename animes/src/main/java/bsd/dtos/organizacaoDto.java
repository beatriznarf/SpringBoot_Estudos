package bsd.dtos;

import lombok.Data;

@Data
public class organizacaoDto {

        private Long id;
        private String nome;
        private String sigla;
        private String chefe;
        private int membros;

}