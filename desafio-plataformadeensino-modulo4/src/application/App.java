package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas aulas tem o curso? ");
        int n = sc.nextInt();
        sc.nextLine();

        List<Lesson> lessons = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados da " + i + "a aula:");
            System.out.print("Conteúdo ou tarefa? (c/t) ");
            char answer = sc.next().charAt(0);
            sc.nextLine();
            if (answer == 'c') {
                System.out.print("Título: ");
                String title = sc.nextLine();
                System.out.print("URL do vídeo: ");
                String url = sc.nextLine();
                System.out.print("Duração em segundos: ");
                int seconds = sc.nextInt();
                sc.nextLine();

                lessons.add(new Video(title, url, seconds));
            } else {
                System.out.print("\nTítulo: ");
                String title = sc.nextLine();
                System.out.print("Descrição: ");
                String description = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                int questionCount = sc.nextInt();
                sc.nextLine();

                lessons.add(new Task(title, description, questionCount));
            }
        }

        Integer sum = 0;

        for (Lesson lesson : lessons) {
            sum += lesson.duration();
        }

        System.out.println("\nDURAÇÃO TOTAL DO CURSO = " + sum + " segundos.");

        sc.close();
    }
}