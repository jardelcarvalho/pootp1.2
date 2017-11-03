/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.arquivos;
import cliente.Cliente;
import atracao.Filme;
import atracao.Serie;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author jardel
 */
public class GestorArquivos {
    private static final String CAMINHO_RAIZ = "./Arquivos";
    private static final String CAMINHO_CLIENTES = CAMINHO_RAIZ + "/clientes.txt";
    private static final String CAMINHO_FILMES = CAMINHO_RAIZ + "/filmes.txt";
    private static final String CAMINHO_SERIES = CAMINHO_RAIZ + "/series.txt";
    
    private static String[] buscarLinha(String identificador, String path, String regex){
        File file = new File(path);
        String[] splited = null;
        if(!file.exists()){
            System.out.println(path + " não existe");
            return null;
        }
        try{
            FileReader f = new FileReader(path);
            BufferedReader h = new BufferedReader(f);
            String linha = "";
            while(linha != null){
                linha = h.readLine();
                if(linha != null){
                    splited = linha.split(regex);
                    for(String s : splited){
                        if(s.compareTo(identificador) == 0){
                            linha = null;
                        }
                    }
                    if(linha == null)
                        continue;
                    splited = null;
                }
            }
            f.close();
            h.close();
        }catch(IOException e){
            System.out.println("Erro ao ler " + path);
        }
        return splited;
    }
    
    private static void escrever(String dado, String path){
        File file = new File(path);
        if(!file.exists()){
            try{
                if(!file.createNewFile())
                    throw new IOException();
            }catch(IOException e){
                if(!file.isDirectory()){
                    try{
                        new File(CAMINHO_RAIZ).mkdir();
                    }finally{
                        System.out.println("Erro ao criar diretório " + path);
                    }
                }
            }
        }
        try(FileWriter h = new FileWriter(path, true)){
            h.write(dado + "\n");
            h.close();
        }catch(IOException e){
            System.out.println("Erro ao escrever em " + path);
        }
    }
    
    public static void registrarCliente(Cliente c){
        escrever(c.formatoArquivo(), CAMINHO_CLIENTES);
    }
    
    public static Cliente buscarCliente(String identificador){
        String[] dados = buscarLinha(identificador, CAMINHO_CLIENTES, "\\.");
        return dados != null ? new Cliente(dados[0], Integer.parseInt(dados[1])) : null;
    }
    
    public static void registrarFilme(Filme f){
        escrever(f.formatoArquivo(), CAMINHO_FILMES);
    }
    
    public static Filme buscarFilme(String nome){
        String[] dados = buscarLinha(nome, CAMINHO_FILMES, "\\.");
        if(dados != null){
            String[] splited = dados[1].split("\\,");
            if(splited.length != 3) return null;
            return new Filme(dados[0], splited[0], Integer.parseInt(splited[1]), Integer.parseInt(splited[2]));
        }
        return null;
    }
    
    public static void registrarSerie(Serie s){
        escrever(s.formatoArquivo(), CAMINHO_SERIES);
    }
    
    public static Serie buscarSerie(String nome){
        String[] dados = buscarLinha(nome, CAMINHO_SERIES, "\\.");
        if(dados != null){
            String[] splited = dados[1].split("\\,");
            if(splited.length != 4) return null;
            return new Serie(dados[0], splited[0], Integer.parseInt(splited[1]), Integer.parseInt(splited[2]), Integer.parseInt(splited[3]));
        }
        return null;
    }
}
