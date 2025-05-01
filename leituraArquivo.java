package arquivo;
import models.Dependente;
import models.Funcionario;
import models.parentesco;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class leituraArquivo {


        public static List<Funcionario> leituraCSV(String caminhoArquivo) {
            List<Funcionario> funcionarios = new ArrayList<>();
            Scanner scannerEntrada = new Scanner(System.in);

            try {

                try (Scanner leitor = new Scanner(new FileReader(caminhoArquivo))) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

                    List<String> bloco = new ArrayList<>();
                    while (leitor.hasNextLine()) {
                        String linha = leitor.nextLine().trim();

                        if (linha.isEmpty() && !bloco.isEmpty()) {
                            Funcionario funcionario = processarBloco(bloco, formatter);
                            if (funcionario != null) {
                                funcionarios.add(funcionario);
                            }
                            bloco.clear();
                        } else if (!linha.isEmpty()) {
                            bloco.add(linha);
                        }
                    }

                    if (!bloco.isEmpty()) {
                        Funcionario funcionario = processarBloco(bloco, formatter);
                        if (funcionario != null) {
                            funcionarios.add(funcionario);
                        }
                    }
                }

                for (Funcionario funcionario : funcionarios) {
                    System.out.println(funcionario);
                }

            } catch (FileNotFoundException e) {
                System.err.println("Erro: Arquivo não encontrado! Verifique o caminho especificado.");
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Erro ao ler o arquivo: " + e.getMessage());
                e.printStackTrace();
            }

            return funcionarios;
        }

        private static Funcionario processarBloco(List<String> bloco, DateTimeFormatter formatter) {
            if (bloco.isEmpty()) return null;

            try {
                String[] dadosFuncionario = bloco.get(0).split(";");
                String nomeFuncionario = dadosFuncionario[0];
                String cpfFuncionario = dadosFuncionario[1];
                LocalDate dataNascimentoFuncionario = LocalDate.parse(dadosFuncionario[2], formatter);
                double salarioBruto = Double.parseDouble(dadosFuncionario[3]);

                Funcionario funcionario = new Funcionario(nomeFuncionario, cpfFuncionario, dataNascimentoFuncionario, salarioBruto);

                for (int i = 1; i < bloco.size(); i++) {
                    String[] dadosDependente = bloco.get(i).split(";");
                    String nomeDependente = dadosDependente[0];
                    String cpfDependente = dadosDependente[1];
                    LocalDate dataNascimentoDependente = LocalDate.parse(dadosDependente[2], formatter);
                    parentesco parentesco = parentesco.valueOf(dadosDependente[3].toUpperCase());
                    Dependente dependente = new Dependente(nomeDependente, cpfDependente, dataNascimentoDependente, parentesco);
                    funcionario.adicionarDependente(dependente);
                }

                return funcionario;
            } catch (Exception e) {
                System.err.println("Erro ao processar bloco: " + e.getMessage());
                return null;
            }
        }
    }




}
