package br.edu.ifms.crudspring.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.crudspring.model.Turma;
import br.edu.ifms.crudspring.services.TurmaService;

@Controller
@RequestMapping("/turmas")    
public class TurmaController {
    
  @Autowired
   TurmaService service;

  @PostMapping("/")
  public String saveTurma(@ModelAttribute("turma") Turma turma ){
          service.saveTurma(turma);
          return "redirect:/turmas/";  
       
  }
  @GetMapping("/")
    public String locAll(Model model) { 
        List<Turma> turmas = service.getTurma();
        model.addAttribute("turmas", turmas); 
        return "indexTurma"; 
    } 

  @GetMapping("/cadastrarTurmas") // get que popula a tela de Cadastrar Turmas
  public String newTurma(Model model) {
      model.addAttribute("turma", new Turma());
      return "cadastrarTurmas";
  }

  @GetMapping("/edit/{id}")
  public String editTurma(@PathVariable("id") UUID id, Model model){
         
    //  log.info("id = editado", id);

      Turma turmas = service.findById(id); 
      model.addAttribute("turmas", turmas);   
  
      return "editTurma";
  }

  @GetMapping("/remove/{id}")
  public String removerStudent(@PathVariable("id") UUID id){
     
    
      service.deleteTurma(id);
      return "redirect:/turmas/"; 
  }

  @PostMapping("/update/{id}")
  public String updateStudent(@PathVariable("id") UUID id, @ModelAttribute Turma turmas){
      service.saveTurma(turmas);

      return "redirect:/turmas/";
  }

  
}
