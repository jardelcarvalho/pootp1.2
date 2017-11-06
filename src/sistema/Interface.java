/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;
import java.util.Scanner;

/**
 *
 * @author jardel
 */

class Interface {
    public static final String[] opt_MenuRaiz = {"Sair", "Cliente", "Serviço"};
    public static final String[] opt_Cliente = {"Sair", "Cadastrar", "Remover", "Consultar", "Alugar ", "Devolver"};
    public static final String[] opt_Servico = {"Sair", "Cadastrar", "Remover", "Consultar"};
    public static final String[] OPT_T_SERVICO = {"Sair", "Filme", "Serie"};
    public static final String[] OPT_BINARIA = {"Sim", "Não"};
    public static final String[] OPT_CONSULTA = {"Sair", "Cliente", "Servico", "Locação"};
    private static final Scanner sc = new Scanner(System.in);
    
    
    public static void show(String s){
        System.out.println(s);
    }
    
    public static int showMenu(String[] menu){
        int opt = -1;
        for(int i = 0; i < menu.length; i++)
            System.out.println("[" + (i + 1) + "]" + menu[i]);
        while(opt < 1 || opt > menu.length){
            while(!sc.hasNextInt())
                sc.next();
            opt = sc.nextInt();
        }
        return opt;
    }
    
    public static int getInt(){
        while(!sc.hasNextInt()){
            show("Valor inteiro inválido!");
            sc.next();
        }
        return sc.nextInt();
    }
    
    public static String getString(String s){
        System.out.print(s + ": ");
        //
        while(sc.hasNextDouble() || sc.hasNextFloat() || sc.hasNextInt())
            sc.next();
        return sc.next().toUpperCase();
    }
    
    public static String getString(){
        System.out.print("Nome: ");
        //
        while(sc.hasNextDouble() || sc.hasNextFloat() || sc.hasNextInt())
            sc.next();
        return sc.next().toUpperCase();
    }
    
    public static int getId(){
        String getId = "";
        System.out.print("Id. Local do cliente: ");
        while(!getId.matches("\\d\\d\\d")){
            getId = sc.next();
        }
        return Integer.parseInt(getId);
    }
    
}
