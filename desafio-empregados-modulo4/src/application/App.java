package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Adress;
import entities.Department;
import entities.Employee;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String name = sc.nextLine();
        System.out.print("Dia do pagamento: ");
        Integer payDay = sc.nextInt();
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Telefone: ");
        String phone = sc.nextLine();

        Adress adress = new Adress(email, phone);
        Department dept = new Department(name, payDay, adress);

        System.out.print("Quantos funcionários tem o departamento? ");
        Integer n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados do funcionário " + i + ":");
            System.out.print("Nome: ");
            name = sc.nextLine();
            System.out.print("Salário: ");
            Double salary = sc.nextDouble();
            sc.nextLine();

            Employee employee = new Employee(name, salary);
            dept.addEmployee(employee);

        }

        showReport(dept);
    }

    private static void showReport(Department dept) {
        System.out.println(dept);
    }
}
