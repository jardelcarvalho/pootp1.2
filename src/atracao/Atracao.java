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
public class Atracao implements Formato, Comparable<Atracao>, Serializable{
    
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
    
        return "Título: " + titulo + "\n        Gênero: " + genero + "\n        Classificação Indicativa: " + classIndicativa;
        
    }
    
    public void info(){
    
        System.out.println(toString());
        
    }
    
    @Override
    public String formatoArquivo(){
        return titulo + ".txt";
    }
    
    @Override
    public int compareTo(Atracao atracao){
        if(titulo.compareTo(atracao.titulo) == 0)
            return 0;
        return -1;
    }
    
}
