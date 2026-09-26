public class Assalariado extends Funcionario {
    private double salarioMensal;

    public Assalariado(String nome, String cpf, String endereco, String telefone, String setor, double salarioMensal) {
        super(nome, cpf, endereco, telefone, setor);
        this.salarioMensal = salarioMensal;
    }

    public double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    @Override
    public double calcularPagamento() {
        return salarioMensal;
    }

    @Override
    public void aplicarAumento(double percentual) {
        this.salarioMensal = this.salarioMensal * (1 + percentual / 100);
    }
}