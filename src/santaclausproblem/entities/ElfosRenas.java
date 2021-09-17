/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santaclausproblem.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class ElfosRenas {
    int qtdElfos=10;
    int elfosQtdProblemasBrinquedos;
    List<Integer> elfosProblemasBrinquedos = new ArrayList<Integer>();
    List<Integer> renasVoltaramFeriasTropicos = new ArrayList<Integer>();

    public int getElfosQtdProblemasBrinquedos() {
        return elfosQtdProblemasBrinquedos;
    }

    public void setElfosQtdProblemasBrinquedos(int elfosQtdProblemasBrinquedos) {
        this.elfosQtdProblemasBrinquedos = this.elfosQtdProblemasBrinquedos - elfosQtdProblemasBrinquedos;
    }
    
    private int[] elfos = new int[qtdElfos];
    
    
    public ElfosRenas() {
        for (int i = 0; i < qtdElfos; i++) {
            elfos[i]=0;
        }
        
        elfosProblemasBrinquedos = new ArrayList<Integer>();
    }
    
    public boolean getProblemasElfos(int idElfo) {
        if(this.elfosProblemasBrinquedos.contains(idElfo) == true){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean getVoltouFeriasRenas(int idRena) {
        if(this.renasVoltaramFeriasTropicos.contains(idRena) == true){
            return true;
        }else{
            return false;
        }
    }
    
    public void addElfosProblemasBrinquedos(int idElfo){
        this.elfosProblemasBrinquedos.add(idElfo);
    }
    
    public void addRenasVoltouFerias(int idRena){
        this.renasVoltaramFeriasTropicos.add(idRena);
    }
    
    public void removeElfosProblemasBrinquedos(){
        this.elfosProblemasBrinquedos.clear();
    }
    
    public void removeRenasFerias(){
        this.renasVoltaramFeriasTropicos.clear();
    }
    
    /*public int setAddEstoque(int arg) {
        int produto=arg;
        for (int i = 0; i < qtdProdutos; i++) {
            if(produtos[i]==0){
                produtos[i]=produto;
                break;
            }
        }
        return produto;
    }*/
    
}
