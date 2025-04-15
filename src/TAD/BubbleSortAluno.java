package TAD;

import java.io.*;
import java.util.*;

public class BubbleSortAluno {

    public static void bubbleSort(Aluno[] arr) {
        int n = arr.length;
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].nota > arr[j + 1].nota) {
                    Aluno temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
    }

    public static Aluno[] gerarVetorAlunos(int tamanho) {
        Aluno[] alunos = new Aluno[tamanho];
        Random rand = new Random();
        for (int i = 0; i < tamanho; i++)
            alunos[i] = new Aluno(rand.nextDouble() * 10);
        return alunos;
    }

    public static String gerarNomeArquivo(String prefixo) {
        int i = 1;
        while (true) {
            String nome = prefixo + "_teste" + i + ".csv";
            if (!new File(nome).exists()) return nome;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] tamanhos = {300000};
        String nomeArquivo = gerarNomeArquivo("bubble");

        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.println("tamanho,tempo_ms");
            for (int tamanho : tamanhos) {
                Aluno[] vetor = gerarVetorAlunos(tamanho);
                long inicio = System.nanoTime();
                bubbleSort(vetor);
                long fim = System.nanoTime();
                double tempoMs = (fim - inicio) / 1_000_000.0;
                writer.printf("%d,%.3f%n", tamanho, tempoMs);
                System.out.printf("ordenou vetor de %d em %.3f ms%n", tamanho, tempoMs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
