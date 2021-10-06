/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santaclausproblem.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class ElfosRenas {
    List<Integer> elfosProblemasBrinquedos = new ArrayList<>();
    List<Integer> renasVoltaramFeriasTropicos = new ArrayList<>();
    
    public ElfosRenas() {
        
    }
    
    public boolean getProblemasElfos(int idElfo) {
        return this.elfosProblemasBrinquedos.contains(idElfo) == true;
    }
    
    public void addElfosProblemasBrinquedos(int idElfo){
        this.elfosProblemasBrinquedos.add(idElfo);
    }
    
    public void removeElfosProblemasBrinquedos(){
        this.elfosProblemasBrinquedos.clear();
    }
    
    public boolean getVoltouFeriasRenas(int idRena) {
        return this.renasVoltaramFeriasTropicos.contains(idRena) == true;
    }
    
    public void addRenasVoltouFerias(int idRena){
        this.renasVoltaramFeriasTropicos.add(idRena);
    }
  
    public void removeRenasFerias(){
        this.renasVoltaramFeriasTropicos.clear();
    }
}