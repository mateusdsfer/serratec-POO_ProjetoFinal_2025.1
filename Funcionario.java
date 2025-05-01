package br.org.serratec.projeto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Funcionario extends Pessoa{
    double salarioBruto;
    double descontoINSS;
    double descontoIR;
    List<Dependentes> dependentes;

    public Funcionario(String nome, int cpf, LocalDate dataNascimento, double salarioBruto) {
        super(nome, cpf, dataNascimento);
        this.salarioBruto = salarioBruto;
        this.dependentes = new ArrayList<Dependentes>();
    }


    public double getSalarioBruto() {
        return salarioBruto;
    }

    public double getDescontoINSS() {
        return descontoINSS;
    }

    public double getDescontoIR() {
        return descontoIR;
    }

    public void adicionarDependentes(Dependentes dependente){
        dependentes.add(dependente);
    }

    public void calcularDescontoInss() {
        if (salarioBruto <= 1518.00) {
            descontoINSS = salarioBruto * 0.075;
        } else if (salarioBruto <= 2793.88) {
            descontoINSS = salarioBruto * 0.09 - 19.80;
        } else if (salarioBruto <= 4190.83) {
            descontoINSS = salarioBruto * 0.12 - 96.94;
        } else if (salarioBruto <= 8157.41) {
            descontoINSS = salarioBruto * 0.14 - 173.80;
        } else {
            descontoINSS = 8157.41 * 0.14 - 173.80;
        }
    }

    public void calcularDescontoIR() {
        double valorPorDependentes = dependentes.size() * 189.59;
        double baseCalculo = salarioBruto - descontoINSS - valorPorDependentes;

        if (baseCalculo <= 2259.00) {
            descontoIR = 0.0;
        } else if (baseCalculo <= 2826.65) {
            descontoIR = baseCalculo * 0.075 - 169.44;
        } else if (baseCalculo <= 3751.05) {
            descontoIR = baseCalculo * 0.15 - 381.44;
        } else if (baseCalculo <= 4664.68) {
            descontoIR = baseCalculo * 0.225 - 662.77;
        } else {
            descontoIR = baseCalculo * 0.275 - 896.00;
        }
    }
    
    public Double calcularSalarioLiquido() {
        return salarioBruto - descontoINSS - descontoIR;
    }
}
