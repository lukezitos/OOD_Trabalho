public class ContaCorrente extends Conta{
    // Conta não pode ser instanciada

    private Double limite;
    ContaCorrente(String contaNumero){
        this.setNumero(contaNumero);
        this.setLimite(0.00);
    }

    private void setLimite(Double limite) {
        this.limite = limite;
    }

    @Override
    public void depositar(Double valor) {
        System.out.println("DEPÓSITO RECEBIDO NA CONTA CORRENTE!");
        System.out.printf("Valor         : %.2f\n", valor);
        System.out.printf("Saldo anterior: %.2f\n", this.calcularSaldo());
        super.depositar(valor);
        System.out.printf("Saldo atual   : %.2f\n\n", this.calcularSaldo());
    }

    @Override
    public void sacar(Double valor) {
        System.out.println("SOLICITAÇÃO DE SAQUE!");
        Double saldo = this.calcularSaldo();
        System.out.printf("Valor do saque: %.2f\n", valor);
        System.out.printf("Saldo anterior: %.2f\n", this.calcularSaldo());
        super.sacar(valor);
        System.out.printf("Saldo atual   : %.2f\n\n", this.calcularSaldo());
    }

    public Double calcularSaldo(){
//        return limite + debito + credito
        double somaFaturaCreditos, somaDepositoDebitos, saldo;

        somaDepositoDebitos = 0.0;
        somaFaturaCreditos = 0.0;


        for (Debito deb : this.debitosList){
            somaDepositoDebitos += deb.getValor();
        }


        for (Credito cred : creditosList) {
            somaFaturaCreditos += cred.getValor();
        }
        somaFaturaCreditos = somaFaturaCreditos - limite;


        saldo = somaDepositoDebitos - somaFaturaCreditos;

        return saldo;
//        return limite;
    }

    public void transferir(Conta contaDestino, Double valor){
        System.out.println("TRANSFERÊNCIA ENTRE CONTAS CC E CP");
        System.out.printf("DE  : %s\n", this.getNumero());
        System.out.printf("PARA: %s\n", contaDestino.getNumero());
        System.out.printf("Valor enviado: %.2f\n\n", valor);
        contaDestino.depositar(valor);
    }


}