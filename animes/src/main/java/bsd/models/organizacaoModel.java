package bsd.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "organizacoes",
        uniqueConstraints = { @UniqueConstraint(columnNames = "sigla")})
@Data
public class organizacaoModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String sigla;
    private String chefe;
    private int membros;

}