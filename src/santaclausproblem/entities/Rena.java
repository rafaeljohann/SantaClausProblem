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
public class Rena extends Thread {
    private boolean ferias;
    int idRena;
    private ElfosRenas renas;
    private PapaiNoel papaiNoel;
    Random gerador = new Random();
    
    public Rena(int idRena, ElfosRenas renas, PapaiNoel papaiNoel){
        this.idRena = idRena;
        this.renas = renas;
        this.papaiNoel = papaiNoel;
    }

    public int getIdRena() {
        return idRena;
    }

    public void setIdRena(int idRena) {
        this.idRena = idRena;
    }
    
    public void entregarPresentes(){
        System.out.println("RENA " + this.getIdRena() + ": Entregando presentes...");
    }
    
    public void tirarFerias(){
        System.out.println("RENA " + this.getIdRena() + ": Tirando férias...");
    }
    
    public void acordarPapaiNoel(){
        System.out.println("RENA " + this.getIdRena()+ ": Acordar o Papai Noel...");
    }
    
    public void viver(){
        synchronized (renas) {
            if(renas.renasVoltaramFeriasTropicos.size() == 9){ //Se as 9 renas voltaram de férias
                System.out.println("RENA " + this.getIdRena()+ ": Voltamos de férias!");
                renas.removeRenasFerias();
                
                this.acordarPapaiNoel();
                
                //notifica papai noel
                synchronized(papaiNoel){
                    //papaiNoel.wait();
                    
                    papaiNoel.acordar(); 
                    papaiNoel.amarrarRenaTreno();
                    papaiNoel.distribuirBrinquedos();
                    papaiNoel.desamarrarRenaTreno();
                    papaiNoel.dormir();
                    //papaiNoel.notify();
                }
            }else{
                
                if(renas.getVoltouFeriasRenas(this.getIdRena())){
                    System.out.println("RENA " + this.getIdRena()+ ": Continuo aguardando para acordar Papai Noel...");
                }else{
                    int numero = gerador.nextInt((11));
                    if(numero == 10){
                        System.out.println("RENA " + this.getIdRena()+ ": Voltei de férias..." );
                        renas.addRenasVoltouFerias(this.idRena);  
                    }else{
                        this.tirarFerias();
                    }                
                renas.notifyAll();
                }
            }
        }
    }
    
    @Override
    public void run(){
        while (true) {
            this.viver();
            try{
                Thread.sleep((int)(Math.random() * 500));
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        //this.tirarFerias();
        
        
        
      //  System.out.println("RENA " + this.getIdRena() + ": Voltou de férias");
        //this.ferias = false;
        //this.entregarPresentes();
        }
    }

    public boolean isFerias() {
        return ferias;
    }

    public void setFerias(boolean ferias) {
        this.ferias = ferias;
    }
}
