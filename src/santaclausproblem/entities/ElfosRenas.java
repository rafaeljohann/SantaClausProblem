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
public class ElfosRenas {
    int qtdElfos=10;
    int elfosQtdProblemasBrinquedos;

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
    }
    
    public int getProblemasElfos() {
        return this.elfosQtdProblemasBrinquedos;
    }
    
    public void addElfosQtdProblemasBrinquedos(int qtd){
        this.elfosQtdProblemasBrinquedos += qtd;
    }
    
    public void removeElfosQtdProblemasBrinquedos(int qtd){
        this.elfosQtdProblemasBrinquedos -= qtd;
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
