/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;
import atracao.Atracao;
import cliente.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import sistema.arquivos.Formato;

/**
 *
 * @author jardel
 */
public class Locacao implements Formato, Serializable{
    private ArrayList<Atracao> pedidos;
    private Cliente cliente;
    private float valor;
    
    public Locacao(Cliente cliente){
        pedidos = new ArrayList<>();
        this.cliente = cliente;
        valor = 0F;
    }
    
    public ArrayList<Atracao> getLocacoes(){
        return pedidos;
    }
    
    public void adicionarAtracao(Atracao pedido){
        pedidos.add(pedido);
        valor += 3F;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public int getCodigoCliente(){
        return cliente.getCodigo();
    }
    
    private String pedidosStr(){
        String retorno = "";
        for(Atracao a : pedidos)
            retorno += "-------\n        " + a.toString() + "\n";
        return retorno;
    }
    
    public void info(){
        System.out.println("        ###Locações###\n" + toString());
    }
    
    @Override
    public String toString(){
        return pedidosStr() + "        R$" + valor + "\n";
    }
    
    @Override
    public String formatoArquivo(){
        return cliente.formatoArquivo();
    }
}