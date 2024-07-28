package bsd.repositories;

import bsd.models.organizacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface organizacaoRepository extends JpaRepository<organizacaoModel, Long> {

}