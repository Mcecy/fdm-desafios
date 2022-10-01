package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos contribuintes serao considerados? ");
        int n = sc.nextInt();

        List<TaxPayer> taxpayers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("\n\nDigite os dados do " + i + "o contribuinte:");
            System.out.println("Renda anual com salário: ");
            double salaryIncome = sc.nextDouble();
            System.out.println("Renda anual com prestacao de servico: ");
            double servicesIncome = sc.nextDouble();
            System.out.println("Renda anual com ganho de capital: ");
            double capitalIncome = sc.nextDouble();
            System.out.println("Gastos medicos: ");
            double healthSpending = sc.nextDouble();
            System.out.println("Gastos educacionais: ");
            double educationSpending = sc.nextDouble();

            TaxPayer taxpayer = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending,
                    educationSpending);

            taxpayers.add(taxpayer);

        }

        int counter = 1;

        for (TaxPayer taxpayer : taxpayers) {
            System.out.println("\nResumo do " + counter + "o contribuinte:");
            System.out.printf("Imposto bruto total: %.2f%n", taxpayer.grossTax());
            System.out.printf("Abatimento: %.2f%n", taxpayer.taxRebate());
            System.out.printf("Imposto devido: %.2f%n", taxpayer.netTax());

            counter++;
        }

        sc.close();
    }
}
