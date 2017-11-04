/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;
import cliente.Cliente;
import atracao.Filme;
import atracao.Serie;
import sistema.arquivos.GestorArquivos;
/**
 *
 * @author jardel
 */
public class Sistema {
    public static void main(String[] args){
        int opt, id;
        String servico, nome;
        Cliente c;
        Filme f;
        Serie s;
        
        GestorArquivos.registrarFilme(new Filme("O filme", "Guerra", 18, 124, 1));
        
        while(true){
            opt = Interface.showMenu(Interface.opt_MenuRaiz);
            switch(opt){


                case 1:
                    return;


                case 2:
                    
                    opt = Interface.showMenu(Interface.opt_Cliente);
                    switch(opt){
                        case 1:
                            break;
                        case 2:
                            nome = Interface.getString();
                            id = Interface.getId();
                            GestorArquivos.registrarCliente(new Cliente(nome, id));
                            //cadastrar cliente
                            break;
                        case 3:
                            id = Interface.getId();
                            //Remover cliente
                            break;
                        case 4:
                            id = Interface.getId();
                            //Alterar cliente
                            break;
                        case 5:
                            id = Interface.getId();
                            c = GestorArquivos.buscarCliente(Integer.toString(id));
                            if(c != null){
                                //encontrou
                            }    
                            //Consultar cliente
                            break;
                        case 6:
                            switch(Interface.showMenu(Interface.OPT_T_SERVICO)){
                                case 1:
                                    nome = Interface.getString(); 
                                    f = GestorArquivos.buscarFilme(nome);
                                    if(f != null){
                                        //encontrou
                                    }
                                    break;
                                case 2:
                                    nome = Interface.getString();
                                    s = GestorArquivos.buscarSerie(nome);
                                    if(s != null){
                                        //encontrou
                                    }
                                    break;
                            }
                            //Alugar serviço
                            break;
                        case 7:
                            id = Interface.getId(); //Recebe id do cliente
                            //Devolver serviço
                            break;
                    }
                    break;

                case 3:
                    opt = Interface.showMenu(Interface.opt_Servico);
                    switch(opt){
                        case 1:
                            break;
                        case 2:
                            servico = Interface.getString();
                            //cadastrar serviço
                            break;
                        case 3:
                            servico = Interface.getString();
                            //Remover serviço
                            break;
                        case 4:
                            servico = Interface.getString();
                            //Alterar serviço
                            break;
                        case 5:
                            servico = Interface.getString();
                            //Consultar serviço
                            break;
                    }
                break;
            }
        }
    }
}
