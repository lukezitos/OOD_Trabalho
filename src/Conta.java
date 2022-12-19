import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    String numero;
    List<Credito> creditosList = new ArrayList<Credito>();;
    List<Debito> debitosList = new ArrayList<Debito>();;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void depositar(Double valor){
        Debito toAdd = new Debito();
        toAdd.setValor(valor);
        this.debitosList.add(toAdd);

    }
    public void sacar(Double valor){
        Credito toSubtract = new Credito();
        toSubtract.setValor(valor);
        this.creditosList.add(toSubtract);
    }
}
