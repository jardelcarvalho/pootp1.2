/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;
import sistema.arquivos.Formato;

/**
 *
 * @author jardel
 */
public class Cliente implements Formato{
    private String nome;
    private int codigo;
    
    public Cliente(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public boolean identificacao(int codigo){
        return codigo == this.codigo;
    }
    
    @Override
    public String toString(){
        return "Nome: " + nome + "\nId. Local: " + codigo;
    }
    
    @Override
    public String formatoArquivo(){
        return nome + '.' + codigo;
    }
}
