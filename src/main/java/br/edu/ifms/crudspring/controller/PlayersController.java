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

import br.edu.ifms.crudspring.model.Players;
import br.edu.ifms.crudspring.services.PlayersService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/rPlayers") 
@Slf4j
public class PlayersController {
    

    @Autowired
    PlayersService service;

    @PostMapping("/")
    public String save(@ModelAttribute("player") Players player) {
        service.save(player);
        return "redirect:/rPlayers/"; 
    }

  
    @GetMapping("/")
    public String locAll(Model model) {
        List<Players> players = service.getPlayers();
        model.addAttribute("players", players); 
        return "indexPlayers";
    } 


    @GetMapping("/cadastrarPlayers")
    public String newStudent(Model model) {
        model.addAttribute("player", new Players());
        return "cadastrarPlayers";
    } 
  
    @GetMapping("/remove/{id}")
    public String removerPlayer(@PathVariable("id") UUID id){
       
        log.info("id = " + id); 
        service.delete(id);
        return "redirect:/rPlayers/"; 
    }

    @GetMapping("/edit/{id}")
    public String editPlayer(@PathVariable("id") UUID id, Model model){
           
        log.info("id = editado", id);

        Players players = service.findById(id);
        model.addAttribute("player", players);
    
        return "editPlayers";
    }

    @PostMapping("/update/{id}")
    public String updatePlayer(@PathVariable("id") UUID id, @ModelAttribute Players players){
        service.save(players);

        return "redirect:/rPlayers/";
    }

}
