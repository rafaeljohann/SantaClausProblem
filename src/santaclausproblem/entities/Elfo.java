/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santaclausproblem.entities;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class Elfo extends Thread {
    
    private final ElfosRenas elfos;
    private final PapaiNoel papaiNoel;
    private final ElfosRenas renas;
    Random gerador = new Random();
    
    int idElfo;
    
    public Elfo(int idElfo, ElfosRenas elfos, PapaiNoel papaiNoel, ElfosRenas renas){
        super();
        this.idElfo = idElfo;
        this.elfos = elfos;
        this.papaiNoel = papaiNoel;
        this.renas = renas;
    }

    public int getIdElfo() {
        return idElfo;
    }

    public void setIdElfo(int idElfo) {
        this.idElfo = idElfo;
    }
    
    public void fabricarBrinquedos(){
        System.out.println("ELFO " + this.getIdElfo() + ": Fabricando brinquedos...");
    }
    
    public void validaElfosProblemas(){
        //System.out.println("Elfos com Problemas: " + elfos.elfosProblemasBrinquedos.size());
        //System.out.println("Renas com problemas: " + renas.renasVoltaramFeriasTropicos.size());
        
        if(elfos.elfosProblemasBrinquedos.size() == 3 && renas.renasVoltaramFeriasTropicos.size() < 9){ //Se tem no mínimo 3 elfos com problemas, mas as renas não voltaram totalmente
            this.reunirPapaiNoel();
            elfos.removeElfosProblemasBrinquedos();
        }
    }
    
    public void reunirPapaiNoel(){
        System.out.println("ELFOS: Estamos com problemas!");
        System.out.println("ELFOS: Se reunindo com o Papai Noel...");
        
        synchronized(papaiNoel){
            papaiNoel.acordar(); 
            papaiNoel.discutirProjetos((ArrayList) elfos.elfosProblemasBrinquedos);
            papaiNoel.dormir();
        }
    }
    
    public void viver() throws InterruptedException{
        boolean problemas = false;
        
        synchronized (elfos) {
            if(elfos.getProblemasElfos(this.getIdElfo())){
                System.out.println("ELFO " + this.getIdElfo() + ": Continuo com o problema..."); 
                problemas = true;
            }
            
            // Validação caso a última rena voltou dos trópicos na iteração anterior.
            validaElfosProblemas();
        }
        
        if(!problemas){
            this.fabricarBrinquedos();
        }
        
        int numero = gerador.nextInt((6));
        if(numero == 5 && !problemas){
            System.out.println("ELFO " + this.getIdElfo() + ": Ops, tive um problema aqui!" );
            
            synchronized(elfos){
                elfos.addElfosProblemasBrinquedos(this.idElfo);
                validaElfosProblemas();
            }
        }
    }
    
    @Override
    public void run(){
        while (true) {
            try {
                this.viver();
            } catch (InterruptedException ex) {
                Logger.getLogger(Elfo.class.getName()).log(Level.SEVERE, null, ex);
            }
            try{
                Thread.sleep((int)(Math.random() * 500));
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
