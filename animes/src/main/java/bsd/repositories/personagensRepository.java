package bsd.repositories;

import bsd.models.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface personagensRepository extends JpaRepository<personagensModel, Long> {
}
