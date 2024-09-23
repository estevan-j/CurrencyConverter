package Service;

import Logger.ConvertionLogs;
import Models.Currencies;
import Models.CurrencyModel;

import java.io.IOException;
import java.util.Scanner;

public class CurrencyConverter {
    private final CurrentService service;
    private final Currencies[] currencies;

    public CurrencyConverter(CurrentService service) {
        this.service = service;
        this.currencies = Currencies.values();
    }

    public void run(ConvertionLogs logsConversion) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            showMenu();
            int origen = obtenerOpcion(scanner, "Elija la moneda que desea convertir: ");
            if (origen == -1) continue;

            double amount = obtenerCantidad(scanner, "Escriba la cantidad que desea convertir: ");

            int destino = obtenerOpcion(scanner, "Elija la moneda a la que desea convertir: ");
            if (origen == destino) {
                System.out.println("Seleccione diferentes formatos de conversión de monedas!!\n");
                logsConversion.addLog("Intento de conversión: misma moneda origen = destino!!\n");
                continue;
            }
            if (destino == -1) continue;
            CurrencyModel divisa = service.getCurrencyDivisas(currencies[origen].getCodigo());
            double resultado = divisa.convertion(currencies[destino].getCodigo(), amount) ;
            System.out.printf("\nEl valor de "+ amount  +" ["+currencies[origen].getCodigo()+"] = " + resultado + " [" + currencies[destino].getCodigo() + "]\n");
            logsConversion.addLog("El valor de "+ amount  +" ["+currencies[origen].getCodigo()+"] = " + resultado + " [" + currencies[destino].getCodigo() + "]\n");
            System.out.println("*".repeat(45)+"\n");
            continuar = preguntarContinuar(scanner);
        }

        scanner.close();
    }

    private void showMenu() {
        System.out.println("*".repeat(45));
        System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
        for (int i = 0; i < currencies.length; i++) {
            System.out.println(i + 1 + ") " + currencies[i].name().replace("_", " "));
        }
    }

    private int obtenerOpcion(Scanner scanner, String mensaje) {
        System.out.print(mensaje+"\n---> ");
        int opcion = Integer.parseInt(scanner.nextLine());
        if (opcion < 1 || opcion > currencies.length) {
            System.out.println("Opción inválida");
            return -1; // Indicador de opción no válida
        }
        return opcion - 1; // Ajustar a índice base 0
    }

    private double obtenerCantidad(Scanner scanner, String mensaje) {
        System.out.println(mensaje);
        return Double.parseDouble(scanner.nextLine());
    }

    private boolean preguntarContinuar(Scanner scanner) {
        System.out.println("¿Desea realizar otra conversión? (s/n): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.equals("s");
    }

}
