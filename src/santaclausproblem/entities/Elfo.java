/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santaclausproblem.entities;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class Elfo extends Thread {
    
    private ElfosRenas elfos;
    boolean problemaBrinquedos;
    private PapaiNoel papaiNoel;
    private ElfosRenas renas;
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
    
    public void reunirPapaiNoel(){
        System.out.println("ELFO " + this.getIdElfo() + ": Se reunindo com o Papai Noel...");
    }
    
    public void viver() throws InterruptedException{
        synchronized (elfos) {
            if(elfos.elfosProblemasBrinquedos.size() == 3 && renas.renasVoltaramFeriasTropicos.size() < 9){ //Se tem no mínimo 3 elfos com problemas
                System.out.println("ELFO " + this.getIdElfo() + ": Estamos com problemas!");
                elfos.removeElfosProblemasBrinquedos();
                
                this.reunirPapaiNoel();
                
                //notifica papai noel
                synchronized(papaiNoel){
                    //papaiNoel.wait();
                    
                    papaiNoel.acordar(); 
                    papaiNoel.discutirProjetos();
                    papaiNoel.dormir();
                    //papaiNoel.notify();
                }
                
                //Acordar papai noel.
            }else{
                /*if(papaiNoel.isAcordado()){
                    
                }*/
                
                if(elfos.getProblemasElfos(this.getIdElfo())){
                    System.out.println("ELFO " + this.getIdElfo() + ": Continuo com o problema...");
                    
                }else{
                    // Gera número randômico de 0 a 5 para definir problemas na fabricação de brinquedos
                    int numero = gerador.nextInt((6));
                    if(numero == 5){
                        System.out.println("ELFO " + this.getIdElfo() + ": Ops, tive um problema aqui!" );
                        elfos.addElfosProblemasBrinquedos(this.idElfo); 
                    }else{
                        this.fabricarBrinquedos();
                    }
                }
                
                elfos.notifyAll();
                /*this.produtos.setAddEstoque(valor);
                System.out.println("|Produtor|- " + this.getName() + "\t - Novo produto adicionado" + valor);
                produtos.notifyAll();*/
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
