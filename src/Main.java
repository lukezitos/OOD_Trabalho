public class Main {
    public static void main(String[] args) {
        gerarFuncionarios();
        separadorPrint("/", 60, 1);
        gerarClientes();
    }

    //Exercício 1 - Gerar dois funcionários

    public static void gerarFuncionarios(){
        
        // Exercício 1 - Criação funcionário 1
        Funcionario funcionario1 = new Funcionario("Lucas Moreno Faria", "56743738720", "11956783325");
        
        funcionario1.setSalario(10000);        
        funcionario1.nomeCargo("CTO");
        
        // Exercício 1 - Criação funcionário 2
        Funcionario funcionario2 = new Funcionario("Pedro Paulo de Araújo Euphrasino", "92341287733", "11977894532");

        funcionario2.setSalario(10000);
        funcionario2.nomeCargo("Data Engineer");

        mostra(funcionario1);
        funcionario1.listCargos();
        mostra(funcionario2);
        funcionario2.listCargos();
    }



    public static void gerarClientes(){

        //Exercício 2 - Criação do cliente 1 - Gerando endereços para o cliente
        Cliente cliente1 =  new Cliente("Joaquim Passos Quintela", "17749571400", "11923445612");
        cliente1.Endereco("59078080", "Rua dos Miosótis", "655", "Natal", "RN");
        cliente1.Endereco("55014512", "Avenida Joaquim de Jesus Dourado", "332", "Natal", "RN");
        cliente1.Endereco("68049550", "Estrada da Embratel", "128","Natal", "RN");

        printCliente(cliente1);

        separadorPrint("/", 60, 1);
        
        //Criando número da conta corrente e poupança
        cliente1.gerarContaCorrente("0024-56691");
        cliente1.gerarContaPoupanca("0223-67859");


        //Exercício 3 - Criando depósitos e saques para um cliente
        cliente1.contaCorrenteList.get(0).depositar(100.00);
        cliente1.contaCorrenteList.get(0).depositar(100.00);
        cliente1.contaCorrenteList.get(0).depositar(100.00);
        cliente1.contaCorrenteList.get(0).sacar(50.00);

        //Exercício 4 - 
        cliente1.contaCorrenteList.get(0).depositar(1000.00);

        separadorPrint("/", 60, 2);
        
        cliente1.contaPoupancaList.get(0).depositar(1000.00);

        separadorPrint("/", 60, 2);

        cliente1.contaCorrenteList.get(0).transferir(cliente1.contaPoupancaList.get(0),500.00);
        separadorPrint("/", 60);

    }

    public static void mostra(Funcionario func){
        separadorPrint("/", 60);
        System.out.print("Nome........: ");
        System.out.println(func.getNome());
        System.out.print("CPF.........: ");
        System.out.println(func.getCpf());
        System.out.print("Telefone....: ");
        System.out.println(func.getTelefone());
        System.out.print("Salário.....: ");
        System.out.println(func.getSalario());

    }
    public static void printCliente(Cliente cliente){
        System.out.println("       Aguarde... Carregando endereços do cliente");
        separadorPrint("/", 60);
        System.out.println("Cliente 1");
        System.out.print("Nome........: ");
        System.out.println(cliente.getNome());
        System.out.print("CPF.........: ");
        System.out.println(cliente.getCpf());
        System.out.print("Telefone....: ");
        System.out.println(cliente.getTelefone());
        System.out.println("Endereços encontrados: ");
        cliente.listarEnderecos();
    }

    private static void separadorPrint(String sep, int qtd, int repeat) {
        String repeated = new String(new char[qtd]).replace("\0", sep);
        for (int i = 0; i<repeat; i++)
        {
            System.out.println(repeated);
        }
    }
    private static void separadorPrint(String sep, int qtd) {
        String repeated = new String(new char[qtd]).replace("\0", sep);
        System.out.println(repeated);
    }

}