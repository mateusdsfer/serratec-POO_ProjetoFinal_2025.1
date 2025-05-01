package br.org.serratec.projeto;

import java.time.LocalDate;
import java.time.Period;

public class Dependentes extends Pessoa{
    private ParentescoEmun parentesco;

    public Dependentes(String nome, int cpf, LocalDate dataNascimento, double salarioBruto, ParentescoEmun parentesco) throws ExceptionDependentes {
        super(nome, cpf, dataNascimento);
        if (Period.between(dataNascimento, LocalDate.now()).getYears() >= 18){
            throw new ExceptionDependentes("dependente deve ser menos que 18 anos");
        }
     this.parentesco = parentesco;
    }

    public ParentescoEmun getParentesco() {
        return parentesco;
    }
}
