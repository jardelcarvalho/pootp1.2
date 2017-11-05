/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.arquivos;
import cliente.Cliente;
import atracao.Filme;
import atracao.Serie;
import servicos.Locacao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import sistema.Interface;
/**
 *
 * @author jardel
 */
public class GestorArquivos {
    private static final String CAMINHO_RAIZ = "./Arquivos";
    private static final String CAMINHO_CLIENTES = CAMINHO_RAIZ + "/clientes.txt";
    private static final String CAMINHO_FILMES = CAMINHO_RAIZ + "/filmes.txt";
    private static final String CAMINHO_SERIES = CAMINHO_RAIZ + "/series.txt";
    private static final String CAMINHO_LOCACOES = CAMINHO_RAIZ + "/locacoes.txt";
    
    private static void print(){
        System.out.println("DEBUG");
    }
    
    public static boolean deletarLinha(String identificador, String path, String regex){
        File file = new File(path);
        String[] splited = null;
        ArrayList<String> novo = new ArrayList<>();
        boolean deletou = false;
        if(!file.exists()){
            System.out.println(path + " não existe");
            return false;
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
                            splited = null;
                            deletou = true;
                            break;
                        }
                    }
                    if(splited != null)
                        novo.add(linha);
                }
            }
            if(!deletou){
                System.out.println("Cliente " + identificador + " não existe");
                return false;
            }
            try(FileWriter w = new FileWriter(path)){
                for(String s : novo)
                    w.write(s + '\n');
                w.close();
            }catch(IOException e){
                System.out.println("Erro ao modificar " + path);
                f.close();
                h.close();
                return false;
            }
            f.close();
            h.close();
            return true;
        }catch(IOException e){
            System.out.println("Erro ao ler " + path);
            return false;
        }
    }
    
    public static String[] buscarLinha(String identificador, String path, String regex){
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
    
    public static void escrever(String dado, String path){
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
                        System.out.println("Ocorreu algum problema ao criar " + path);
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
    
    public static boolean jaExiste(String item, String path){
        boolean existe = false;
        try{
            FileReader f = new FileReader(path);
            BufferedReader h = new BufferedReader(f);
            String linha = h.readLine();
            String[] splited = null;
            while(linha != null){
                splited = linha.split("\\.");
                for(String s : splited){
                    if(s.compareTo(item) == 0){
                        existe = true;
                        break;
                    }
                }
                linha = h.readLine();
            }
            f.close();
            h.close();
        }catch(IOException e){
            //System.out.println("Erro ao ler " + path);
        }
        return existe;
    }
    
    
    
    public static Cliente buscarCliente(String identificador){
        String[] dados = buscarLinha(identificador, CAMINHO_CLIENTES, "\\.");
        return dados != null ? new Cliente(dados[0], Integer.parseInt(dados[1])) : null;
    }
    
    public static Filme buscarFilme(String nome){
        String[] dados = buscarLinha(nome, CAMINHO_FILMES, "\\.");
        if(dados != null){
            return new Filme(dados[0], dados[1], Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), Integer.parseInt(dados[4]));
        }
        return null;
    }
    
    public static Serie buscarSerie(String nome){
        String[] dados = buscarLinha(nome, CAMINHO_SERIES, "\\.");
        if(dados != null){
            return new Serie(dados[0], dados[1], Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), Integer.parseInt(dados[4]), Integer.parseInt(dados[5]));
        }
        return null;
    }

    
    
    //Funções administrativas
    public static void registrarCliente(Cliente c){
        if(!jaExiste(Integer.toString(c.getCodigo()), CAMINHO_CLIENTES)){
            escrever(c.formatoArquivo(), CAMINHO_CLIENTES);
            return;
        }
        System.out.println("Este cliente já existe");
    }
    
    public static void registrarFilme(Filme f){
        if(!jaExiste(f.getTitulo(), CAMINHO_FILMES)){
            escrever(f.formatoArquivo(), CAMINHO_FILMES);
            return;
        }
        Filme b = buscarFilme(f.getTitulo());
        b.incrementaQuantidade(f.getQuantidade());
        deletarFilme(f.getTitulo());
        escrever(b.formatoArquivo(), CAMINHO_FILMES);
    }
    
    public static void registrarSerie(Serie s){
        if(!jaExiste(s.getTitulo(), CAMINHO_SERIES)){
            escrever(s.formatoArquivo(), CAMINHO_SERIES);
            return;
        }
        Serie b = buscarSerie(s.getTitulo());
        b.incrementaQuantidade(s.getQuantidade());
        deletarSerie(s.getTitulo());
        escrever(b.formatoArquivo(), CAMINHO_SERIES);
    }
    
    public static void deletarCliente(Integer identificador){
        deletarLinha(identificador.toString(), CAMINHO_CLIENTES, "\\.");
    }
    
    public static void deletarFilme(String nome){
        Filme b = buscarFilme(nome);
        if(b == null) return;
        b.decrementaQuantidade();
        deletarLinha(nome, CAMINHO_FILMES, "\\.");
        escrever(b.formatoArquivo(), CAMINHO_FILMES);
    }
    
    public static void deletarSerie(String nome){
        Serie b = buscarSerie(nome);
        if(b == null) return;
        b.decrementaQuantidade();
        deletarLinha(nome, CAMINHO_SERIES, "\\.");
        escrever(b.formatoArquivo(), CAMINHO_SERIES);
    }
    
    
    //Funções para os serviços
    public static boolean filmeDisponivel(String nome, int qtd){
        Filme f = buscarFilme(nome);
        if(f != null && f.getQuantidade() >= qtd && qtd != 0)
            return true;
        return false;
    }
    
    public static boolean serieDisponivel(String nome, int qtd){
        Serie s = buscarSerie(nome);
        if(s != null && s.getQuantidade() >= qtd && qtd != 0)
            return true;
        return false;
    }
    
}
