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
                            GestorArquivos.deletarCliente(Interface.getId());
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
                            opt = Interface.showMenu(Interface.OPT_T_SERVICO);
                            switch(opt){
                                case 1:
                                    break;
                                case 2:
                                    GestorArquivos.registrarFilme(new Filme(Interface.getString(), Interface.getString(), Interface.getClassInd(), Interface.getQtd(), Interface.getTempDura()));
                                    break;
                                case 3:
                                    GestorArquivos.registrarSerie(new Serie(Interface.getString(), Interface.getString(), Interface.getClassInd(), Interface.getQtd(), Interface.getNumEp(), Interface.getNumTemp()));
                                    break;
                            }
                            break;
                        case 3:
                            opt = Interface.showMenu(Interface.OPT_T_SERVICO);
                            switch(opt){
                                case 1:
                                    break;
                                case 2:
                                    GestorArquivos.deletarFilme(Interface.getString());
                                    break;
                                case 3:
                                    GestorArquivos.deletarSerie(Interface.getString());
                                    break;
                            }
                            break;
                        case 4:
                            /*altera serviço*/
                            break;
                        case 5:
                            GestorArquivos.filmeDisponivel(Interface.getString(), Interface.getQtd());
                            break;
                    }
                    break;
            }
        }
    }
}
