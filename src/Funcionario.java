import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Funcionario extends Pessoa implements Usuario{
    private double salario;
    List<Cargo> cargosList = new ArrayList<Cargo>();

    Funcionario(String nome, String cpf, String telefone) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setTelefone(telefone);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void nomeCargo(String nome){
        Cargo cargo = new Cargo();
        cargo.setNome(nome);
        this.cargosList.add(cargo);
    }
    
    public void listCargos() {
        System.out.printf("Cargo.......: ");
        for (Cargo cargo : this.cargosList) {
            System.out.println(cargo.getNome());
        }
    }

    @Override
    public boolean autenticar() {
        return true;
    }
}

