package entities;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private Integer payDay;

    private Adress adress;
    private List<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public Department(String name, Integer payDay, Adress adress) {
        this.name = name;
        this.payDay = payDay;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPayDay() {
        return payDay;
    }

    public void setPayDay(Integer payDay) {
        this.payDay = payDay;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public Double payroll() {
        Double sum = 0.0;
        for (Employee emp : employees) {
            Double salary = emp.getSalary();
            sum += salary;
        }
        return sum;
    }

    public String toString() {
        String empList = "";
        for (Employee emp : employees) {
            empList += emp;
        }
        return "\nFOLHA DE PAGAMENTO:"
            + "\n"
            + "Departamento "
            + name
            + " = R$"
            + String.format("%.2f%n", payroll())
            + "Pagamento realizado no dia "
            + payDay
            + "\n"
            + "Funcionários: \n"
            + empList
            + "\n"
            + adress;
    }
}
