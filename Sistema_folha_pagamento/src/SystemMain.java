import java.util.*;

public class SystemMain {

    public static void main(String[] args){
        ArrayList<Empregado> empregados = new ArrayList<Empregado>();
        System.out.println("1. Adicionar empregado.\n2. Remover empregado.\n3. Lançar um cartão de ponto.\n" +
                "4. Larçar um resultado de venda.\n5. Lançar uma taxa de serviço.\n6. Alterar informações de empregado.\n" +
                "7. Rodar folha de pagamento para hoje.\n8. Agenda de pagamento.\n9. Criar nova agenda de pagamento.\n" +
                "10. Desfazer/Refazer\n0. Sair");
    }

    public void addE(ArrayList<Empregado> empregados, int ident, int identSind){

        Scanner input = new Scanner(System.in);
        String name, address, status, pagamento, sind;

        System.out.println("Digite o nome do novo empregado: ");
        name = input.nextLine();
        System.out.println("Digite o endereço: ");
        address = input.nextLine();
        System.out.println("Digite o tipo de empregado: ");
        status = input.nextLine();
        System.out.println("O empregado pertence ao sindicato ?");
        sind = input.nextLine();
        if(sind.equals("Pertence")){
            identSind++;
        } else ident++;
        System.out.println("Qual a forma de pagamento desejada ?");
        pagamento = input.nextLine();

        CartaoPonto ponto = new CartaoPonto(null,null,null,null);
        empregados.add(new Empregado(name, address, status, sind, ident, identSind, pagamento, ponto));
    }

    public void removeE(ArrayList<Empregado> empregados){
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome do empregado a ser removido:");
        String name = input.nextLine();

        for(int i = 0; i < empregados.size(); i++){
            Empregado emp = empregados.get(i);
            if(emp.getName().equals(name)){
                empregados.remove(emp);
                System.out.println("Empregado removido com sucesso!");
                break;
            }
        }
        System.out.println("Empregado não encontrado!");
    }

    public void baterP(ArrayList<Empregado> empregados){
        Scanner input = new Scanner(System.in);
        int day, month, year, hr, min, seg;
        Date data;
        Hour horario;
        System.out.println("Número de identificação do empregado: ");
        int ident = input.nextInt();

        for(int i = 0; i < empregados.size(); i++){
            Empregado emp = empregados.get(i);

            if(emp.getIdent() == ident){
                System.out.println("Entrada ou saída ?");
                String aux = input.nextLine();
                if(aux.equals("Entrada")){
                    System.out.println("Data de entrada: ");
                    day = input.nextInt();
                    month = input.nextInt();
                    year = input.nextInt();
                    data = new Date(day, month, year);

                    System.out.println("Horário de entrada:");
                    hr = input.nextInt();
                    min = input.nextInt();
                    seg = input.nextInt();
                    horario = new Hour(hr, min, seg);

                    CartaoPonto newP = new CartaoPonto(data, horario, null, null);
                    break;
                } else{
                    System.out.println("Data de saída: ");
                    day = input.nextInt();
                    month = input.nextInt();
                    year = input.nextInt();
                    data = new Date(day, month, year);

                    System.out.println("Horário de saída:");
                    hr = input.nextInt();
                    min = input.nextInt();
                    seg = input.nextInt();
                    horario = new Hour(hr, min, seg);

                    CartaoPonto newP = new CartaoPonto(emp.getPonto().getdInicio(), emp.getPonto().gethInicio(),
                            data, horario);
                    break;
                }
            }
        }
        System.out.println("Empregado não encontrado!");
    }

    public void resulVenda(){
        /*
        * Recebe determinada quantidade de venda, o empregado é o assalariado com comissao
        * podemos colocar o bonus por horas aqui tbm
        * */
    }

    public void taxaServ(){
        /*
        * Cobrança de taxas, a taxa sindical é algo fixo para cara empregado, já a taxa de serviços extra é pra quem tem
        * plano de saude, seguro, colegio pago, tudo pela empresa*/
    }

    public void changeDate(ArrayList<Empregado> empregados){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do usuário que deseja alterar os dados:");
        String name = input.nextLine();
        Empregado aux;
        boolean flag = false;
        int escolha = 1;

        for(int i = 0; i < empregados.size(); i++){
            aux = empregados.get(i);
            if(aux.getName().equals(name)){
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println("Empregado não encontrado!");
        } else {
            while (escolha != 0) {
                System.out.println("1. Alterar nome\n2. Alterar endereço\n3. Alterar tipo de empregado\n" +
                        "4. Alterar método de pagamento\n5. Alterar vínculo com sinditaco\n" +
                        "6. Alterar identificação do sindicato\n7. Alterar taxa sindical\n0. Sair");
                escolha = input.nextInt();
                String lixo = input.nextLine();
                if(escolha == 1){
                    System.out.println("Digite o novo nome:");
                    name = input.nextLine();
                    aux.setName(name);
                } else if(escolha == 2){
                    System.out.println("Digite o novo endereço:");
                    name = input.nextLine();
                    aux.setAddress(name);
                } else if(escolha == 3){
                    System.out.println("Digite o novo tipo de empregado:");
                    name = input.nextLine();
                    aux.setStatus(name);
                } else if(escolha == 4){
                    System.out.println("Digite o novo método de pagamento");
                } else if(escolha == 5){
                    System.out.println("Pertence ou não ao sindicato ?");
                } else if(escolha == 6){
                    System.out.println("Digite nova identificação do sindicato:");
                } else if(escolha == 7){
                    System.out.println("Digite a nova taxa sindical:");
                }
            }
        }
    }

    public void pay(){}

    public void undo_redo(){}

    public void agenda(){}

    public void createAgenda(){}
}
