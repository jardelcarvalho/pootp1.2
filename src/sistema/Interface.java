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
    public static final String[] opt_Cliente = {"Sair", "Cadastrar", "Remover", "Alterar", "Consultar", "Alugar ", "Devolver"};
    public static final String[] opt_Servico = {"Sair", "Cadastrar", "Remover", "Alterar", "Consultar"};
    private static final Scanner sc = new Scanner(System.in);
    
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
    
    public static String getString(){
        System.out.print("Nome: ");
        //
        while(sc.hasNextDouble() || sc.hasNextFloat() || sc.hasNextInt())
            sc.next();
        return sc.next().toUpperCase();
    }
    
    public static int getId(){
        String getId = "";
        System.out.print("Id. Local: ");
        while(!getId.matches("\\d\\d\\d")){
            getId = sc.next();
        }
        return Integer.parseInt(getId);
    }
    
}
