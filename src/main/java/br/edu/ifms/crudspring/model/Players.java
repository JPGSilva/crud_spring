package br.edu.ifms.crudspring.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Players {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     UUID idPlayer;

     String namePlayer;
     String age;
     String  game;
     String  exp;  
}
