package org.example;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecione uma opção de conversão:");
            System.out.println("1. USD para EUR");
            System.out.println("2. USD para GBP");
            System.out.println("3. USD para JPY");
            System.out.println("4. USD para CAD");
            System.out.println("5. USD para AUD");
            System.out.println("6. Mostrar todas as taxas disponíveis");
            System.out.println("7. Mostrar taxas específicas");
            System.out.println("8. Sair");

            int choice = scanner.nextInt();

            if (choice == 8) {
                break;
            }

            try {
                switch (choice) {
                    case 1:
                        converter.convertUSDTo("EUR");
                        break;
                    case 2:
                        converter.convertUSDTo("GBP");
                        break;
                    case 3:
                        converter.convertUSDTo("JPY");
                        break;
                    case 4:
                        converter.convertUSDTo("CAD");
                        break;
                    case 5:
                        converter.convertUSDTo("AUD");
                        break;
                    case 6:
                        converter.showAllRates();
                        break;
                    case 7:
                        List<String> currencies = Arrays.asList("ARS", "BOB", "BRL", "CLP", "COP", "USD");
                        converter.showSpecificRates(currencies);
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao processar a conversão. Verifique sua conexão ou tente novamente mais tarde.");
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }
}



/*import java.io.IOException;
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            CurrencyConverter converter = new CurrencyConverter();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Selecione uma opção de conversão:");
                System.out.println("1. USD para EUR");
                System.out.println("2. USD para GBP");
                System.out.println("3. USD para JPY");
                System.out.println("4. USD para CAD");
                System.out.println("5. USD para AUD");
                System.out.println("6. Mostrar todas as taxas disponíveis");
                System.out.println("7. Sair");

                int choice = scanner.nextInt();

                if (choice == 7) {
                    break;
                }

                try {
                    switch (choice) {
                        case 1:
                            converter.convertUSDTo("EUR");
                            break;
                        case 2:
                            converter.convertUSDTo("GBP");
                            break;
                        case 3:
                            converter.convertUSDTo("JPY");
                            break;
                        case 4:
                            converter.convertUSDTo("CAD");
                            break;
                        case 5:
                            converter.convertUSDTo("AUD");
                            break;
                        case 6:
                            converter.showAllRates();
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                } catch (IOException | InterruptedException e) {
                    System.out.println("Erro ao processar a conversão. Verifique sua conexão ou tente novamente mais tarde.");
                }
            }

            scanner.close();
            System.out.println("Programa encerrado.");
        }
    }   */

