/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santaclausproblem.entities;

/**
 *
 * @author Rafael
 */
public class PapaiNoel extends Thread {
    
    private boolean acordado;
    
    public PapaiNoel(){
        
    }
    
    public void dormir(){
        System.out.println("PAPAI NOEL: Dormindo...");
    }
    
    public void acordar(){
        System.out.println("PAPAI NOEL: Acordou...");
        this.acordado = true;
    }
    
    public void amarrarRenaTreno(){
        System.out.println("PAPAI NOEL: Amarrando a rena...");
    }
    
    public void desamarrarRenaTreno(){
        System.out.println("PAPAI NOEL: Desamarrando a rena...");
    }
    
    public void distribuirBrinquedos(){
        System.out.println("PAPAI NOEL: Distribuindo brinquedos...");
    }
    
    public void discutirProjetos(){
        System.out.println("PAPAI NOEL: Discutindo projetos de brinquedo...");
    }
    
    @Override
    public void run(){
        while (true) {
            this.dormir();
            this.acordado = false;
            try{
                Thread.sleep((int)(Math.random() * 500));
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public boolean isAcordado() {
        return acordado;
    }

    public void setAcordado(boolean acordado) {
        this.acordado = acordado;
    }
    

}
