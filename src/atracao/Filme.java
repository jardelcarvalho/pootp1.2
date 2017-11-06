/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atracao;
import java.io.Serializable;
import sistema.arquivos.Formato;

/**
 *
 * @author davi
 */
public class Filme extends Atracao implements Serializable{
    
    private int tempDura;/*tempo de duração*/
    
    public Filme(String titulo, String genero, int classIndicativa, int tempDura){
    
        super(titulo, genero, classIndicativa);
        this.tempDura = tempDura;
        
    }
    
    public int getTempDura(){
    
        return tempDura;
    
    }
    
    @Override
    public String toString(){
    
        return super.toString() + "\n       Tempo de Duração: " + tempDura;
                
        
    }
    
    @Override
    public void info(){
    
        System.out.println(toString());
        
    }
    
}
