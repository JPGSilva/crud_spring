package br.edu.ifms.crudspring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.crudspring.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, UUID>{
    

    
}
