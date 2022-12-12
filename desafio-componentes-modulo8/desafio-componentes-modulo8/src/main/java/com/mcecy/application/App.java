package com.mcecy.application;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.mcecy.entities.Order;
import com.mcecy.services.OrderService;

@SpringBootApplication
@ComponentScan({"com.mcecy"})
public class App implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Insira os dados do pedido:");
		Integer code = sc.nextInt();
		Double basic = sc.nextDouble();
		Double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		double total = orderService.total(order);

		System.out.printf("Pedido código " + code + "\n");
		System.out.printf("Valor total: R$ %.2f%n", total);

		sc.close();
	}

}
