package br.edu.ifms.crudspring.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.crudspring.model.Turma;
import br.edu.ifms.crudspring.repositories.TurmaRepository;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository repository;

    public List<Turma> getTurma() {
        return repository.findAll();
    }

    public void saveTurma(Turma turminha) {
        this.repository.save(turminha);
    }

    public void deleteTurma(UUID  id){
        this.repository.deleteById(id);
    }

    public Turma findById(UUID id){  
        return repository.findById(id).get(); 
    }

    public void updateStudent(Turma turmas){ 
         repository.save(turmas);     
    }
}
