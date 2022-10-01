package application;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import entities.Champion;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Random generator = new Random();

        System.out.print("Digite o nome do primeiro campeão:\nNome: ");
        String name = sc.nextLine();
        System.out.print("Vida inicial: ");
        int life = generator.nextInt(100) + 1;
        System.out.println(life);
        System.out.print("Ataque: ");
        int attack = generator.nextInt(100) + 1;
        System.out.println(attack);
        System.out.print("Armadura: ");
        int armor = generator.nextInt(100) + 1;
        System.out.println(armor);
        System.out.println();

        Champion champion1 = new Champion(name, life, attack, armor);

        System.out.print("Digite o nome do segundo campeão:\nNome: ");
        name = sc.nextLine();
        System.out.print("Vida inicial: ");
        life = generator.nextInt(100) + 1;
        System.out.println(life);
        System.out.print("Ataque: ");
        attack = generator.nextInt(100) + 1;
        System.out.println(attack);
        System.out.print("Armadura: ");
        armor = generator.nextInt(100) + 1;
        System.out.println(armor);
        System.out.println();

        Champion champion2 = new Champion(name, life, attack, armor);

        System.out.print("Turnos de combate: ");
        int turns = generator.nextInt(10) + 1;
        System.out.println(turns);
        System.out.println();

        for (int i = 1; i <= turns; i++) {
            champion1.takeDamage(champion2);
            champion2.takeDamage(champion1);
            System.out.println("Resultado do turno " + i + ": ");
            System.out.println(champion1.status());
            System.out.println(champion2.status());
            System.out.println();

            if (champion1.getLife() <= 0
                    || champion2.getLife() <= 0) {
                break;
            }
        }

        if (champion1.getLife() > champion2.getLife()) {
            System.out.println("O vencedor foi " + champion1.getName() + "!");
        }
        else {
            System.out.println("O vencedor foi " + champion2.getName() + "!");
        }

        System.out.println("FIM DO COMBATE");

        sc.close();
    }
}
