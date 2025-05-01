package arquivo;

import arquivo.gravacao;
import arquivo.leituraArquivo;
import java.util.Scanner;

public class testeGravacao {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Insira o caminho do diretório ou seu arquivo: ");
            String diretorio = sc.nextLine();

            gravacao.gerarCSV(leituraArquivo.leituraCSV(diretorio));
        }
    }


