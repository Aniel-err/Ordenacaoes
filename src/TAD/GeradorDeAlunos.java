package TAD;

import java.util.Random;

public class GeradorDeAlunos {
    public static Aluno[] gerarAlunos(int quantidade) {
        Aluno[] alunos = new Aluno[quantidade];
        Random rand = new Random();
        for (int i = 0; i < quantidade; i++) {
            alunos[i] = new Aluno(rand.nextDouble() * 100);
        }
        return alunos;
    }
}
