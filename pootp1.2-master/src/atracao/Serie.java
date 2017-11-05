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
public class Serie extends Atracao implements Formato{
    
    private int numEp;/*número de episódios*/
    private int numTemp;/*número de temporadas*/
    
    public Serie(String titulo, String genero, int classIndicativa, int quantidade, int numEp, int numTemp){
    
        super(titulo, genero, classIndicativa, quantidade);
        this.numEp = numEp;
        this.numTemp = numTemp;
        
    }
    
    public int getNumEp(){
    
        return numEp;
        
    }
    
    public int getNumTemp(){
    
        return numTemp;
    
    }
    
    @Override
    public String toString(){
    
        return super.toString() + "\nNúmero de Episódios: " + numEp + "\nNúmero de Temporadas: " + numTemp;
        
    }
    
    @Override
    public void info(){
    
        System.out.println(toString());
        
    }
    
    @Override 
    public String formatoArquivo(){
        return super.formatoArquivo() + '.' + numEp + '.' + numTemp;
    }
    
}
