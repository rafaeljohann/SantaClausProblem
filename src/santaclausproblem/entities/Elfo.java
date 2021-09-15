/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santaclausproblem.entities;

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
    
    public Elfo(ElfosRenas elfos, PapaiNoel papaiNoel){
        super();
        this.elfos = elfos;
        this.papaiNoel = papaiNoel;
    }
    
    public void fabricarBrinquedos(){
        System.out.println("ELFOS: Fabricando brinquedos...");
    }
    
    public void reunirPapaiNoel(){
        System.out.println("ELFOS: Se reunindo com o Papai Noel...");
    }
    
    public void viver() throws InterruptedException{
        synchronized (elfos) {
            if(elfos.getProblemasElfos() == 3){ //Se tem no mínimo 3 elfos com problemas
                System.out.println("ELFOS: Estamos com problemas!");
                elfos.removeElfosQtdProblemasBrinquedos(3);
                
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
                this.fabricarBrinquedos();
                
                elfos.addElfosQtdProblemasBrinquedos(1); // verificar como disparar essa ação.
                
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
