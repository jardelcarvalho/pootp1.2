/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;
import java.io.Serializable;
import sistema.arquivos.Formato;

/**
 *
 * @author jardel
 */
public class Cliente implements Formato, Comparable<Cliente>, Serializable{
    private String nome;
    private Integer codigo;
    
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
    
    public void info(){
        System.out.println(toString());
    }
    
    @Override
    public String toString(){
        return "        Nome: " + nome + "\n        Id. Local: " + codigo;
    }
    
    @Override
    public String formatoArquivo(){
        return codigo + ".txt";
    }
    
    @Override
    public int compareTo(Cliente cliente){
        System.out.print("Veio aqui");
        if(codigo == cliente.getCodigo())
            return 0;
        return -1;
    }
}
