package br.com.cristianmathias.conversordemoedas.ui;

import java.util.Scanner;

public class UserInterface {
    private final Scanner sc = new Scanner(System.in);

    public String askCurrency(String message){
        System.out.print(message);
        return sc.next().toUpperCase();
    }

    public double askAmount(String message){
        System.out.println(message);
        return sc.nextDouble();
    }

    public void showResult(String from, String to, double rate, double converted) {
        System.out.printf("Taxa %s → %s: %.4f%n", from, to, rate);
        System.out.printf("Valor convertido: %.2f %s%n", converted, to);
    }
}
