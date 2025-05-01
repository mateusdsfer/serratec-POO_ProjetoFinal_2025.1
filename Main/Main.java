package Main;

import Banco.ConnectionFactory;
import inserirDados.DependenteDao;
import inserirDados.FolhaDePagamentoDao;
import inserirDados.FuncionarioDao;
import util.GravacaoArquivo;
import util.LeituraCSV;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection conn = new ConnectionFactory().getConnection();
        Scanner sc = new Scanner(System.in);
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        DependenteDao dependenteDao = new DependenteDao();
        FolhaDePagamentoDao folhaDePagamentoDao = new FolhaDePagamentoDao();

        System.out.println("Insira o caminho do diretório ou seu arquivo: ");
        String diretorio = sc.nextLine();

        GravacaoArquivo.gerarArquivo(LeituraCSV.leituraCSV(diretorio));
        funcionarioDao.inserirFuncionarios(LeituraCSV.leituraCSV(diretorio), conn);
        dependenteDao.inserirDependente(LeituraCSV.leituraCSV(diretorio), conn);
        folhaDePagamentoDao.inserirPagamento(LeituraCSV.leituraCSV(diretorio), conn);
    }
}