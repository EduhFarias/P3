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

    public void resulVenda(){}

    public void taxaServ(){}

    public void changeDate(){}

    public void pay(){}

    public void undo_redo(){}

    public void agenda(){}

    public void createAgenda(){}
}
