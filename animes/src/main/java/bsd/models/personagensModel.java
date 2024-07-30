package bsd.models;

import lombok.Data;
import java.time.LocalDate;
import jakarta.persistence.*;
import bsd.models.organizacaoModel;

@Entity
@Table (name = "personagens")
@Data
public class personagensModel {

   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)

   private Long id;


   @ManyToOne
   @JoinColumn(name = "organizacao", referencedColumnName = "sigla")
   private organizacaoModel organizacao;

   private String nome;
   private int idade;
   private String nacionalidade;
   private String sexo;
   private LocalDate nascimento;

}