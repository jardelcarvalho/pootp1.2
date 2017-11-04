/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atracao;
import sistema.arquivos.Formato;

/**
 *
 * @author davi
 */
public class Filme extends Atracao implements Formato{
    
    private int tempDura;/*tempo de duração*/
    
    public Filme(String titulo, String genero, int classIndicativa, int tempDura, int quantidade){
    
        super(titulo, genero, classIndicativa, quantidade);
        this.tempDura = tempDura;
        
    }
    
    public int getTempDura(){
    
        return tempDura;
    
    }
    
    @Override
    public String toString(){
    
        return super.toString() + "\nTempo de Duração: " + tempDura;
        
    }
    
    @Override
    public void info(){
    
        System.out.println(toString());
        
    }
    
    @Override
    public String formatoArquivo(){
        return super.formatoArquivo() + '.' + tempDura;
    }
    
}
