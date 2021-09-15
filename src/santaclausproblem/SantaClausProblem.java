/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santaclausproblem;

import java.util.ArrayList;
import java.util.List;
import santaclausproblem.entities.Elfo;
import santaclausproblem.entities.ElfosRenas;
import santaclausproblem.entities.PapaiNoel;
import santaclausproblem.entities.Rena;

/**
 *
 * @author Rafael
 */
public class SantaClausProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PapaiNoel papaiNoel = new PapaiNoel();
        List<Elfo> elfos = new ArrayList();
        List<Rena> renas = new ArrayList(); 
        ElfosRenas listaElfosRenas = new ElfosRenas();
        int qtdRenas = 0;
        
        papaiNoel.start();
        
        for(int i = 0; i < 3; i++){ // modificar contador depois
            Elfo elfo = new Elfo(listaElfosRenas, papaiNoel);
            elfos.add(elfo);
        }
        
        elfos.forEach((elfo) -> {
            elfo.start();
        });
        
        for(int i = 0; i < 1; i++){ // modificar contador depois
            Rena rena = new Rena();
            renas.add(rena);
        }
        
        renas.forEach((rena) -> {
            rena.start();
        });
        
        /*for(Rena rena : renas){
            qtdRenas++;
        }
        
        if(qtdRenas == renas.size()){
            papaiNoel.acordar();
        }*/
        
        
    }
    
}
