package arquivo;

import arquivo.testeArquivo;
import java.util.Scanner;

public class testeArquivo{


    public class TesteLeituraCSV {
        public static void main(String[] args) {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Insira o caminho do diretório ou seu arquivo: ");
                String diretorio = sc.nextLine();

                leituraArquivo.leituraCSV(diretorio);
            }
        }
    }

}
