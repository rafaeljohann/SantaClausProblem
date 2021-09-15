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
public class Rena extends Thread {
    private boolean ferias;
    
    public Rena(){
        
    }
    
    public void entregarPresentes(){
        System.out.println("Entregando presentes...");
    }
    
    public void tirarFerias(){
        System.out.println("Tirando férias. Até o ano que vem!");
    }
    
    public void viver(){
        this.tirarFerias();
    }
    
    @Override
    public void run(){
        this.tirarFerias();
        
        System.out.println("RENA: Voltou de férias");
        this.ferias = false;
        //this.entregarPresentes();
    }

    public boolean isFerias() {
        return ferias;
    }

    public void setFerias(boolean ferias) {
        this.ferias = ferias;
    }
}
