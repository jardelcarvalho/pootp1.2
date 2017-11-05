/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;
import atracao.Filme;
import atracao.Serie;
import cliente.Cliente;
import sistema.arquivos.GestorArquivos;

/**
 *
 * @author jardel
 */
public class Locacao{
    
    
    
    public void locacaoFilme(Cliente c, Filme f){
        if(GestorArquivos.filmeDisponivel(f.getTitulo(), f.getQuantidade()) == true){//caso filme disponível na quantidade desejada
            /*função aqui*/
            Filme cl;
            if(GestorArquivos.jaExiste(f.getTitulo(), path)){//caso cliente já possua uma cópia alugada
                cl = GestorArquivos.buscarFilme(f.getTitulo());
                cl.incrementaQuantidade(f.getQuantidade());//incrementa quantidade ao contador do cliente
                GestorArquivos.deletarFilme(f.getTitulo());//diminui do catálogo
                escrever(cl.formatoArquivo(), path);
            }else{
                GestorArquivos.escrever(f.getTitulo(), path);
            }
        }else{
            System.out.println("Não disponível\n");
        }
    }
    
    public void locacaoFilme(Cliente c, Serie f){
        if(GestorArquivos.filmeDisponivel(f.getTitulo(), f.getQuantidade()) == true){//caso filme disponível na quantidade desejada
            /*função aqui*/
            Filme cl;
            if(GestorArquivos.jaExiste(f.getTitulo(), path)){//caso cliente já possua uma cópia alugada
                cl = GestorArquivos.buscarFilme(f.getTitulo());
                cl.incrementaQuantidade(f.getQuantidade());//incrementa quantidade ao contador do cliente
                GestorArquivos.deletarFilme(f.getTitulo());//diminui do catálogo
                escrever(cl.formatoArquivo(), path);
            }else{
                GestorArquivos.escrever(f.getTitulo(), path);
            }
        }else{
            System.out.println("Não disponível\n");
        }
    }
    
}
