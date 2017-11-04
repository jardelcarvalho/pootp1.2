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
    private int quantidade;
    
    public Atracao(String titulo, String genero, int classIndicativa, int quantidade){
    
        this.titulo = titulo;
        this.genero = genero;
        this.classIndicativa = classIndicativa;
        this.quantidade = quantidade;
        
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
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public void incrementaQuantidade(int i){
        quantidade+=i;
    }
    
    public void decrementaQuantidade(int i){
        if(quantidade == 0)
            return;
        quantidade-=i;
    } 
    
    @Override
    public String toString(){
    
        return "Título: " + titulo + "\nGênero: " + genero + "\nClassificação Indicativa: " + classIndicativa + "\nQuantidade: " + quantidade;
        
    }
    
    public void info(){
    
        System.out.println(toString());
        
    }
    
    @Override
    public String formatoArquivo(){
        return titulo + '.' + genero + '.' + classIndicativa + '.' + quantidade;
    }
    
}
