/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;
import cliente.Cliente;
import atracao.Filme;
import atracao.Serie;
import servicos.Locacao;
import sistema.arquivos.GestorArquivos;
/**
 *
 * @author jardel
 */
public abstract class Sistema {
    public static void main(String[] args){
        int opt, id, classIndicativa, duracao, episodios;
        boolean ok;
        String servico, nome, genero;
        Cliente c;
        Filme f;
        Serie s;
        Locacao l;
        GestorArquivos.inicia(); //Configurações iniciais do gerenciador de arquivos #MUITO IMPORTANTE#
        
        
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
                            ok = false;
                            while(!ok){
                                nome = Interface.getString();
                                id = Interface.getId();
                                ok = GestorArquivos.cadastrarCliente(new Cliente(nome, id));
                                if(!ok){ 
                                    Interface.show("Este id já existe, deseja digitar outro?");
                                    opt = Interface.showMenu(Interface.OPT_BINARIA);
                                    if(opt == 2) break;
                                    continue;
                                }
                                ok = true;
                            }
                            //cadastrar cliente
                            break;
                        case 3:
                            id = Interface.getId();
                            GestorArquivos.deletarCliente(id);
                            //Remover cliente
                            break;
                        case 4:
                            ok = false;
                            while(!ok){
                                id = Interface.getId();
                                c = GestorArquivos.consultarCliente(id);
                                if(c == null){
                                    Interface.show("Cliente não encontrado, deseja procurar outro?");
                                    opt = Interface.showMenu(Interface.OPT_BINARIA);
                                    if(opt == 2) break;
                                    continue;
                                }
                                c.info();
                                l = GestorArquivos.consultarLocacao(c.getCodigo());
                                if(l != null)
                                    l.info();
                                ok = true;      
                            }
                            //Buscar cliente
                            break;
                        case 5:
                            switch(Interface.showMenu(Interface.OPT_T_SERVICO)){
                                case 1:
                                    break;
                                case 2:
                                    id = Interface.getId();
                                    c = GestorArquivos.consultarCliente(id);
                                    if(c == null){
                                        Interface.show("Este cliente não existe deseja cadastra-lo?");
                                        opt = Interface.showMenu(Interface.OPT_BINARIA);
                                        if(opt == 1){
                                            ok = false;
                                            while(!ok){
                                                nome = Interface.getString();
                                                id = Interface.getId();
                                                ok = GestorArquivos.cadastrarCliente(new Cliente(nome, id));
                                                if(!ok){ 
                                                    Interface.show("Este id já existe, deseja digitar outro?");
                                                    opt = Interface.showMenu(Interface.OPT_BINARIA);
                                                    if(opt == 2) break;
                                                    continue;
                                                }
                                                ok = true;
                                            }
                                        }
                                        if(opt == 2) break;
                                    }
                                    l = new Locacao(c);
                                    Interface.show("Adicione filmes ao pedido");
                                    ok = false;
                                    while(true){
                                        nome = Interface.getString();
                                        f = GestorArquivos.consultarFilme(nome);
                                        if(f == null){
                                           Interface.show("Filme não encontrado, deseja procurar outro?");
                                           opt = Interface.showMenu(Interface.OPT_BINARIA);
                                           if(opt == 2) break;
                                           continue; 
                                        }
                                        l.adicionarAtracao(f);
                                        Interface.show("Deseja procurar outro?");
                                        opt = Interface.showMenu(Interface.OPT_BINARIA);
                                        if(opt == 2) break;
                                    }
                                    if(l.getLocacoes().size() > 0)
                                        GestorArquivos.cadastrarLocacao(l);
                                    break;
                                case 3:
                                    id = Interface.getId();
                                    c = GestorArquivos.consultarCliente(id);
                                    if(c == null){
                                        Interface.show("Este cliente não existe deseja cadastra-lo?");
                                        opt = Interface.showMenu(Interface.OPT_BINARIA);
                                        if(opt == 1){
                                            ok = false;
                                            while(!ok){
                                                nome = Interface.getString();
                                                id = Interface.getId();
                                                ok = GestorArquivos.cadastrarCliente(new Cliente(nome, id));
                                                if(!ok){ 
                                                    Interface.show("Este id já existe, deseja digitar outro?");
                                                    opt = Interface.showMenu(Interface.OPT_BINARIA);
                                                    if(opt == 2) break;
                                                    continue;
                                                }
                                                ok = true;
                                            }
                                        }
                                        if(opt == 2) break;
                                    }
                                    l = new Locacao(GestorArquivos.consultarCliente(id));
                                    Interface.show("Adicione series ao pedido");
                                    ok = false;
                                    while(true){
                                        nome = Interface.getString();
                                        s = GestorArquivos.consultarSerie(nome);
                                        if(s == null){
                                           Interface.show("Serie não encontrada, deseja procurar outra?");
                                           opt = Interface.showMenu(Interface.OPT_BINARIA);
                                           if(opt == 2) break;
                                           continue; 
                                        }
                                        l.adicionarAtracao(s);
                                        Interface.show("Deseja procurar outra?");
                                        opt = Interface.showMenu(Interface.OPT_BINARIA);
                                        if(opt == 2) break;
                                    }
                                    if(l.getLocacoes().size() > 0)
                                        GestorArquivos.cadastrarLocacao(l);
                                    break;
                            }
                            //Alugar serviço
                            break;
                        case 6:
                            id = Interface.getId(); //Recebe id do cliente
                            ok = false;
                            GestorArquivos.deletarLocacao(id);
                            Interface.show("Devolução efetuada!");
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
                            //cadastrar serviço
                            opt = Interface.showMenu(Interface.OPT_T_SERVICO);
                            switch(opt){
                                case 1:
                                    break;
                                case 2:
                                    nome = Interface.getString();
                                    genero = Interface.getString("Gênero");
                                    System.out.print("Classificação inidicativa: ");
                                    classIndicativa = Interface.getInt();
                                    System.out.print("Duracao:");
                                    f = new Filme(nome, genero, classIndicativa, Interface.getInt());
                                    Interface.show("Deseja efetivar o cadastro?");
                                    opt = Interface.showMenu(Interface.OPT_BINARIA);
                                    if(opt == 1)
                                        GestorArquivos.cadastrarFilme(f);
                                    GestorArquivos.cadastrarFilme(f);
                                    break;
                                case 3:
                                    nome = Interface.getString();
                                    genero = Interface.getString("Gênero");
                                    System.out.print("Classificação inidicativa: ");
                                    classIndicativa = Interface.getInt();
                                    System.out.print("Duracao:");
                                    duracao = Interface.getInt();
                                    System.out.print("Episodios:");
                                    episodios = Interface.getInt();
                                    System.out.print("Temporadas:");
                                    s = new Serie(nome, genero, classIndicativa, episodios, Interface.getInt());
                                    Interface.show("Deseja efetivar o cadastro?");
                                    opt = Interface.showMenu(Interface.OPT_BINARIA);
                                    if(opt == 1)
                                        GestorArquivos.cadastrarSerie(s);
                                    break;
                            }
                            
                            break;
                        case 3:
                            //Deletar serviço
                            opt = Interface.showMenu(Interface.OPT_T_SERVICO);
                            switch(opt){
                                case 1:
                                    break;
                                case 2:
                                    servico = Interface.getString();
                                    GestorArquivos.deletarFilme(servico);
                                    break;
                                case 3:
                                    servico = Interface.getString();
                                    GestorArquivos.deletarSerie(servico);
                                    break;
                            }
                            break;
                        case 4:
                            //Consultar serviço
                            opt = Interface.showMenu(Interface.OPT_T_SERVICO);
                            switch(opt){
                                case 1:
                                    break;
                                case 2:
                                    while(true){
                                        servico = Interface.getString();
                                        f = GestorArquivos.consultarFilme(servico);
                                        if(f == null){
                                            Interface.show("Filme não encontrado, deseja pesquisar outro?");
                                            opt = Interface.showMenu(Interface.OPT_BINARIA);
                                            if(opt == 2) break;
                                            continue;
                                        }
                                        f.info();
                                        break;
                                    }
                                    break;
                                case 3:
                                    while(true){
                                        servico = Interface.getString();
                                        s = GestorArquivos.consultarSerie(servico);
                                        if(s == null){
                                            Interface.show("Série não encontrada, deseja pesquisar outra?");
                                            opt = Interface.showMenu(Interface.OPT_BINARIA);
                                            if(opt == 2) break;
                                            continue;
                                        }
                                        s.info();
                                        break;
                                    }
                                    break;
                            }
                            break;
                    }
                break;
            }
        }
    }
}
