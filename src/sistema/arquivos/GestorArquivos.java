/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.arquivos;
import atracao.Filme;
import atracao.Serie;
import cliente.Cliente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import servicos.Locacao;

/**
 *
 * @author jardel
 */
public abstract class GestorArquivos {
    private static final String CAMINHO_RAIZ = "./Arquivos";
    private static final String CAMINHO_CLIENTES = CAMINHO_RAIZ + "/Clientes";
    private static final String CAMINHO_FILMES = CAMINHO_RAIZ + "/Filmes";
    private static final String CAMINHO_SERIES = CAMINHO_RAIZ + "/Series";
    private static final String CAMINHO_LOCACOES = CAMINHO_RAIZ + "/Locacoes";
    
    public static void inicia(){
        diretorio(CAMINHO_CLIENTES);
        diretorio(CAMINHO_FILMES);
        diretorio(CAMINHO_SERIES);
        diretorio(CAMINHO_LOCACOES);
    }
    
    private static void print(){
        System.out.println("DEBUG");
    }
    
    private static boolean existe(String caminho, String arquivo){
        File f = new File(caminho + "/" + arquivo);
        return f.exists();
    }
    
    private static boolean arquivo(String caminho, String arquivo){
        File f = new File(caminho + "/" + arquivo);
        try{
            f.createNewFile();
        }catch(IOException | SecurityException e){
            return true;
        }
        return true;
    }
    
    private static void diretorio(String caminho){
        File f = new File(caminho);
        if(!f.isDirectory()){
            f.mkdirs();
        }
    }
    
    private static Object lerObjeto(String caminho, String nome){
        String txt = nome + ".txt";
        if(!existe(caminho, txt))
            return null;
        try{
            FileInputStream i = new FileInputStream(caminho + "/" + txt);
            ObjectInputStream in = new ObjectInputStream(i);
            Object x = in.readObject();
            i.close();
            in.close();
            return x;
        }catch(FileNotFoundException e){
            System.out.println("Arquivo não existe");
        }catch(IOException e){
            //Se não houver objetos no arquivo
            System.out.println("Erro ao ler o arquivo");
        }catch(ClassNotFoundException e){
            //Se quando for feito o cast não houver compatibilidade com o objeto lido
            System.out.println("Não há nenhum objeto no arquivo");
        }
        return null;
    }
    
    private static boolean escreverObjeto(Object objeto, String caminho, String txt){
        String dir = caminho + "/" + txt;
        if(!existe(caminho, txt)){
            if(arquivo(caminho, txt)){
                try{
                    FileOutputStream o = new FileOutputStream(dir);
                    ObjectOutputStream out = new ObjectOutputStream(o);
                    out.writeObject(objeto);
                    o.close();
                    out.close();
                    return true;
                }catch(IOException e){
                    return false;
                }
            }
        }
        return false;
    }
    
    private static void deletarObjeto(String caminho, String nome){
        String txt = nome + ".txt";
        File f = new File(caminho + "/" + txt);
        if(f.exists())
            f.delete();
    }
    
    
    
    public static boolean cadastrarCliente(Cliente c){
        return escreverObjeto(c, CAMINHO_CLIENTES, c.formatoArquivo());
    }
    
    public static Cliente consultarCliente(Integer id){
        return (Cliente) lerObjeto(CAMINHO_CLIENTES, id.toString());
    }
    
    public static void deletarCliente(Integer id){
        deletarObjeto(CAMINHO_CLIENTES, id.toString());
    }
    
    
    
    public static boolean cadastrarFilme(Filme f){
        return escreverObjeto(f, CAMINHO_FILMES, f.formatoArquivo());
    }
    
    public static Filme consultarFilme(String nome){
        return (Filme) lerObjeto(CAMINHO_FILMES, nome);
    }
    
    public static void deletarFilme(String nome){
        deletarObjeto(CAMINHO_FILMES, nome);
    }
    
    
    
    public static boolean cadastrarSerie(Serie s){
        return escreverObjeto(s, CAMINHO_SERIES, s.formatoArquivo());
    }
    
    public static Serie consultarSerie(String nome){
        return (Serie) lerObjeto(CAMINHO_SERIES, nome);
    }
    
    public static void deletarSerie(String nome){
        deletarObjeto(CAMINHO_SERIES, nome);
    }
    
    
    
    public static boolean cadastrarLocacao(Locacao l){
        return escreverObjeto(l, CAMINHO_LOCACOES, l.formatoArquivo());
    }
    
    public static Locacao consultarLocacao(Integer id){
        return (Locacao) lerObjeto(CAMINHO_LOCACOES, id.toString());
    }
    
    public static void deletarLocacao(Integer id){
        deletarObjeto(CAMINHO_LOCACOES, id.toString());
    }
    
    
}
   