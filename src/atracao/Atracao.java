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
public class Atracao implements Formato{
    
    private String titulo;
    private String genero;
    private int classIndicativa;
    
    public Atracao(String titulo, String genero, int classIndicativa){
    
        this.titulo = titulo;
        this.genero = genero;
        this.classIndicativa = classIndicativa;
        
    }
    
    public String getTitulo(){
        
        return titulo;
    
    }
    
    public String getGenero(){
    
        return genero;
        
    }
    
    public int getClassIndicativa(){
    
        return classIndicativa;
        
    }
    
    @Override
    public String toString(){
    
        return "Título: " + titulo + "\nGênero: " + genero + "\nClassificação Indicativa: " + classIndicativa;
        
    }
    
    public void info(){
    
        System.out.println(toString());
        
    }
    
    @Override
    public String formatoArquivo(){
        return titulo + '.' + genero + ',' + classIndicativa;
    }
    
}
