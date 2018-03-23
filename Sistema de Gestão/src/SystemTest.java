import Resource.Atividade;
import Resource.Recurso;
import User.User;
import Util.Date;
import Util.Hour;

import java.util.*;

public class SystemTest {

    public static void main(String[] args){
        int escolha = 1, count = 0, labs = 7, auds = 2, projs = 10, salas = 15;
        String lixo;
        Recurso Lab[] = new Recurso[7], Aud[] = new Recurso[2], Proj[] = new Recurso[10], Sala[] = new Recurso[15];
        User UserList[] = new User[100];
        Scanner input = new Scanner(System.in);

        while (escolha != 0){
            System.out.println("1. Cadastrar usuário.");
            System.out.println("2. Consultar usuário.");
            System.out.println("3. Alocar recurso.");
            System.out.println("4. Consultar recurso.");
            System.out.println("0. Sair.");

            escolha = input.nextInt();

            if (escolha == 1){
                System.out.println("\n");
                lixo = input.nextLine();
                RegisterUser(UserList, count);
                count++;
                System.out.println();

            } else if (escolha == 2) {
                System.out.println();
                System.out.println("Digite nome do usuário a ser consultado:");
                lixo = input.nextLine();
                String name = input.nextLine();;
                CheckUser(UserList, name);
                System.out.println();

            } else if (escolha == 3){
                System.out.println("1. Laboratório\n2. Auditório\n3. Resource.Projetor\n4. Sala de aula");
                lixo = input.nextLine();
                escolha = input.nextInt();
                if(escolha == 1){
                    if(labs == 0) {
                        System.out.println("Todos os laboratórios já foram alocados");
                    } else{
                        allocResource(Lab, UserList, (7 - labs), "Laboratório");
                        labs--;
                    }
                } else if(escolha == 2){
                    if(auds == 0) {
                        System.out.println("Todos os auditórios já foram alocados");
                    } else{
                        allocResource(Aud, UserList, (2 - auds), "Auditório");
                        auds--;
                    }
                } else if(escolha == 3){
                    if(projs == 0) {
                        System.out.println("Todos os projetores já foram alocados");
                    } else{
                        allocResource(Proj, UserList, (10 - projs), "Resource.Projetor");
                        projs--;
                    }
                } else {
                    if(salas == 0) {
                        System.out.println("Todos as salas de aula já foram alocados");
                    } else{
                        allocResource(Sala, UserList, (15 - salas), "Sala de aula");
                        salas--;
                    }
                }

            } else if (escolha == 4){
                    System.out.println("\n");
                //2 Auditórios, 7 laboratórios, 15 salas, 10 projetores;
                System.out.println("Digite o recurso desejado:");
                String recurso = input.nextLine();

            }

        }
    }

    public static void RegisterUser(User[] UserList, int count){
        Scanner input = new Scanner(System.in);
        int month, day, year, nRefer;
        Util.Date birthday;

        System.out.println("Digite o nome do usuário:");
        String name = input.nextLine();
        System.out.println("Digite o endereço de email do usuário: ");
        String address = input.nextLine();
        System.out.println("Digite o status do usuário: ");
        String status = input.nextLine();
        System.out.println("Digite o mês, dia e ano de nascimento do usuário:");
        month = input.nextInt();
        day = input.nextInt();
        year = input.nextInt();
        System.out.println("Digite o número de matrícula/identificação do usuário:");
        nRefer = input.nextInt();
        birthday = new Util.Date(month, day, year);

        User newUser = new User(name, address, birthday, status, nRefer);
        UserList[count] = newUser;
    }

    public static void CheckUser(User[] UserList, String name){
        System.out.println();
        boolean flag = false;
        for(User user : UserList){
            if(user.getName().equals(name)){
                System.out.println("Nome: "+user.getName()+"\n"+"Endereço de email:"+user.getAddress()+"\n"+
                        "Status: "+user.getStatus()+"\n"+"Número de matrícula/identificação: "+
                        user.getnRefer()+"\n"+"Ano de nascimento: "+user.getBirthday());
                flag = true;
                break;
            }
        }
        if(!flag)
            System.out.println("Usuário não cadastrado!");
    }

    public static void allocResource(Recurso[] resource, User[] userList, int count, String ident){
        Scanner input = new Scanner(System.in);
        boolean perm = true, exist = false;
        System.out.println("Digite seu nome:");
        String name = input.nextLine();
        User user;

        for(User aux : userList) {
            if (aux.getName().equals(name)) {
                user = aux;
                exist = true;
            }
        }
        if(!exist){
            System.out.println("Usuário não cadastrado");
        } else{
            for(User aux : userList) {
                if (aux.getName().equals(name)) {
                    user = aux;
                }


                System.out.println("Para qual fim será usado o recurso ?");
                String event = input.nextLine();

                if ((event == "Aula tradicional" || event == "Laboratório") && !(aux.getStatus().equals("Professor"))) {
                    System.out.println("Somente professores podem alocar este tipo de recurso para tais fins.");
                    perm = false;
                }

                if (!(aux.getStatus().equals("Professor")) || !(aux.getStatus().equals("Pesquisador")) || !(aux.getStatus().equals("Administrador"))) {
                    System.out.println("Recursos não podem ser alocados por alunos.");
                    perm = false;
                }

                if (perm) {
                    Util.Date dInicio, dFim;
                    Hour hInicio, hFim;
                    int month, day, year, hr, min;
                    Atividade atividade = new Atividade("Lab", "Aula", "qqcoisa", 32, "apagador e pincel");

                    System.out.println("Digite o mês, dia e ano do início da atividade:");
                    month = input.nextInt();
                    day = input.nextInt();
                    year = input.nextInt();
                    dInicio = new Util.Date(month, day, year);

                    System.out.println("Digite o mês, dia e ano do término da atividade:");
                    month = input.nextInt();
                    day = input.nextInt();
                    year = input.nextInt();
                    dFim = new Date(month, day, year);

                    System.out.println("Digite as horas e minutos do início da atividade:");
                    hr = input.nextInt();
                    min = input.nextInt();
                    hInicio = new Hour(hr, min);

                    System.out.println("Digite as horas e minutos do término da atividade:");
                    hr = input.nextInt();
                    min = input.nextInt();
                    hFim = new Hour(hr, min);

                    ident += count;
                    Recurso newR = new Recurso(ident, dInicio, hInicio, dFim, hFim, aux, atividade);
                    resource[count] = newR;
                }
            }
        }
    }

    public static void CheckResource(Recurso[] resource){
        System.out.println("Digite o recurso que deseja consultar:");

        Scanner input = new Scanner(System.in);
        String recurso = input.nextLine();

        for(Recurso aux : resource){
            if(aux.getIdent().equals(recurso)){
                System.out.println("Identificação: "+aux.getIdent()+"\n"+"Data de início: "+aux.getdInicio()+"\n"+"Horário de início: "+aux.gethInicio()+"\n"+
                "Data de término: "+aux.getdTermino()+"\n"+"Horário de término: "+aux.getHtermino()+"\n"+"Responsável: "+aux.getUser()+"\n"+
                "Status: "+aux.getStatus());
                System.out.println("Identificação da atividade: "+aux.getEvent().getTipo()+"\n"+"Título da ativadade: "+aux.getEvent().getTitulo()+"\n"+
                "Descrição: "+aux.getEvent().getDescricao()+"\n"+"Número de participantes: "+aux.getEvent().getParticipante()+"\n"+
                "Materiais de apoio usados: "+aux.getEvent().getmApoio());
            }
        }
    }
}
