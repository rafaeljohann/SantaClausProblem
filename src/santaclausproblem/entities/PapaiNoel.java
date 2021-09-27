/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santaclausproblem.entities;

import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class PapaiNoel extends Thread {
    
    public PapaiNoel(){
        
    }
    
    public void dormir(){
        System.out.println("PAPAI NOEL: Dormindo...");
    }
    
    public void acordar(){
        System.out.println("PAPAI NOEL: Acordou...");
    }
    
    public void amarrarRenaTreno(){
        System.out.println("PAPAI NOEL: Amarrando as renas ao trenó...");
    }
    
    public void desamarrarRenaTreno(){
        System.out.println("PAPAI NOEL: Desamarrando as renas do trenó...");
    }
    
    public void distribuirBrinquedos(){
        System.out.println("PAPAI NOEL: Distribuindo brinquedos...");
    }
    
    public void discutirProjetos(ArrayList elfos){
        for(int i = 0; i < elfos.size(); i++){
            System.out.println("PAPAI NOEL: Discutindo projetos de brinquedo com elfo " + elfos.get(i) + "...");
        }
    }
    
    @Override
    public void run(){
        while (true) {
            this.dormir();
            try{
                Thread.sleep((int)(Math.random() * 50));
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
