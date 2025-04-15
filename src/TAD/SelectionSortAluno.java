package TAD;

import java.io.*;
import java.util.*;

public class SelectionSortAluno {

    static class Aluno {
        String nome;
        double nota;

        public Aluno(String nome, double nota) {
            this.nome = nome;
            this.nota = nota;
        }
    }

    public static void selectionSort(Aluno[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].nota < arr[minIdx].nota) {
                    minIdx = j;
                }
            }
            Aluno temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static Aluno[] gerarVetorAlunos(int tamanho) {
        Aluno[] alunos = new Aluno[tamanho];
        Random rand = new Random();
        for (int i = 0; i < tamanho; i++) {
            String nome = "aluno" + (i + 1);
            double nota = rand.nextDouble() * 10;
            alunos[i] = new Aluno(nome, nota);
        }
        return alunos;
    }

    public static String gerarNomeArquivo(String prefixo) {
        int i = 1;
        while (true) {
            String nome = prefixo + "_teste" + i + ".csv";
            File f = new File(nome);
            if (!f.exists()) return nome;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] tamanhos = {10000, 50000, 100000};
        String nomeArquivo = gerarNomeArquivo("selection");

        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.println("tamanho,tempo_ms");

            for (int tamanho : tamanhos) {
                Aluno[] vetor = gerarVetorAlunos(tamanho);

                long inicio = System.nanoTime();
                selectionSort(vetor);
                long fim = System.nanoTime();

                double tempoMs = (fim - inicio) / 1_000_000.0;
                writer.printf("%d,%.3f%n", tamanho, tempoMs);
                System.out.printf("ordenou vetor de %d em %.3f ms%n", tamanho, tempoMs);
            }

            System.out.println("resultados salvos em: " + nomeArquivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
