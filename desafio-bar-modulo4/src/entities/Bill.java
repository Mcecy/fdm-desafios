package entities;

public class Bill {

    public char gender;
    public int beer;
    public int barbecue;
    public int softDrink;

    public Bill() {
    }

    public double cover() {
        if (feeding() <= 30) {
            return 4.00;
        }
        else {
            return 0.00;
        }
    }

    public double feeding() {
        return beer * 5 + barbecue * 7 + softDrink * 3;
    }

    public double ticket() {
        if (gender == 'f') {
            return 8.00;
        } else {
            return 10.00;
        }
    }

    public double total() {
        return ticket() + feeding() + cover();
    }

    public String toString() {
        if (cover() == 4.00) {
            return "RELATÓRIO:"
                    + "\n"
                    + "Consumo = R$"
                    + String.format("%.2f%n", feeding())
                    + "Couvert = R$"
                    + String.format("%.2f%n", cover())
                    + "Ingresso = R$"
                    + String.format("%.2f%n", ticket())
                    + "Valor a pagar = R$"
                    + String.format("%.2f%n", total());
        } else {
            return "RELATÓRIO:"
                    + "\n"
                    + "Consumo = R$"
                    + String.format("%.2f%n", feeding())
                    + "Isento de Couvert\n"
                    + "Ingresso = R$"
                    + String.format("%.2f%n", ticket())
                    + "Valor a pagar = R$"
                    + String.format("%.2f%n", total());
        }
    }

}
