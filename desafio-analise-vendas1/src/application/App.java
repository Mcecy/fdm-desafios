package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entities.Sale;

public class App {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre o caminho do arquivo: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Sale> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Sale(Integer.parseInt(fields[0]), Integer
                        .parseInt(fields[1]), fields[2], Integer.parseInt(fields[3]), Double.parseDouble(fields[4])));
                line = br.readLine();
            }

            Comparator<Sale> comp = (s1, s2) -> s1.compareTo(s2);
            List<Sale> sales = list.stream().map(s -> s).sorted(comp.reversed()).collect(Collectors.toList());

            System.out.println("Cinco primeiras vendas de 2016 de maior preço médio:");
            sales.subList(0, 5).forEach(System.out::println);

            Double sum1 = list.stream().filter(s -> s.getSeller().equals("Logan") && s.getMonth().equals(1))
                    .map(s -> s.getTotal()).reduce(0.0, (x, y) -> x + y);
            Double sum2 = list.stream().filter(s -> s.getSeller().equals("Logan") && s.getMonth().equals(7))
                    .map(s -> s.getTotal()).reduce(0.0, (x, y) -> x + y);
            Double sum = sum1 + sum2;
            System.out.println("\nValor total vendido pelo vendedor Logan nos meses 1 e 7 = " + String.format("%.2f%n", sum));
        } catch (IOException e) {
            System.out.println("Erro: " + path + " (O sistema não pode encontrar o arquivo especificado)");
        }

        sc.close();
    }
}
