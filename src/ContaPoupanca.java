import javax.crypto.SealedObject;

public class ContaPoupanca extends Conta{
    private Double rentalidadeMensal;

    ContaPoupanca(String contaNumero){
        this.setNumero(contaNumero);
    }

    public Double calcularSaldo(){
        double somaDeposito,somaSaque, saldo;
        somaDeposito = 0.0;
        somaSaque = 0.0;

        for (Debito deb : this.debitosList){
            somaDeposito += deb.getValor();
        }

        // Pois esta conta também pode sacar
        for (Credito cred : creditosList) {
            somaSaque += cred.getValor();
        }

        saldo = (somaDeposito - somaSaque);
        return saldo;
    }

    @Override
    public void depositar(Double valor) {
        System.out.println("TRANSFÊRENCIA RECEBIDA NA CONTA POUPANÇA");
        System.out.printf("Valor da transferência: %.2f\n", valor);
        System.out.printf("Saldo anterior        : %.2f\n", this.calcularSaldo());
        super.depositar(valor);
    }
}
