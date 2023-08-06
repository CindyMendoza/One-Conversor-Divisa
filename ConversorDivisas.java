import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface ConversorMoneda {
    double convertirAMoneda(double cantidad);

    double convertirDesdeMoneda(double cantidad);
}

class ConversorDolar implements ConversorMoneda {
    private double tasaDolar;

    public ConversorDolar(double tasaDolar) {
        this.tasaDolar = tasaDolar;
    }

    public double convertirAMoneda(double cantidad) {
        return cantidad / tasaDolar;
    }

    public double convertirDesdeMoneda(double cantidad) {
        return cantidad * tasaDolar;
    }
}

class ConversorEuro implements ConversorMoneda {
    private double tasaEuro;

    public ConversorEuro(double tasaEuro) {
        this.tasaEuro = tasaEuro;
    }

    public double convertirAMoneda(double cantidad) {
        return cantidad / tasaEuro;
    }

    public double convertirDesdeMoneda(double cantidad) {
        return cantidad * tasaEuro;
    }
}

class ConversorLibraEsterlina implements ConversorMoneda {
    private double tasaLibraEsterlina;

    public ConversorLibraEsterlina(double tasaLibraEsterlina) {
        this.tasaLibraEsterlina = tasaLibraEsterlina;
    }

    public double convertirAMoneda(double cantidad) {
        return cantidad / tasaLibraEsterlina;
    }

    public double convertirDesdeMoneda(double cantidad) {
        return cantidad * tasaLibraEsterlina;
    }
}

class ConversorYenJapones implements ConversorMoneda {
    private double tasaYenJapones;

    public ConversorYenJapones(double tasaYenJapones) {
        this.tasaYenJapones = tasaYenJapones;
    }

    public double convertirAMoneda(double cantidad) {
        return cantidad / tasaYenJapones;
    }

    public double convertirDesdeMoneda(double cantidad) {
        return cantidad * tasaYenJapones;
    }
}

class ConversorWonCoreano implements ConversorMoneda {
    private double tasaWonCoreano;

    public ConversorWonCoreano(double tasaWonCoreano) {
        this.tasaWonCoreano = tasaWonCoreano;
    }

    public double convertirAMoneda(double cantidad) {
        return cantidad / tasaWonCoreano;
    }

    public double convertirDesdeMoneda(double cantidad) {
        return cantidad * tasaWonCoreano;
    }
}

public class ConversorDivisas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tasas de cambio para cada moneda
        double tasaDolar = 3.9;
        double tasaEuro = 4.3;
        double tasaLibraEsterlina = 5.2;
        double tasaYenJapones = 0.035;
        double tasaWonCoreano = 0.0033;

        Map<Integer, ConversorMoneda> conversores = new HashMap<>();
        conversores.put(1, new ConversorDolar(tasaDolar));
        conversores.put(2, new ConversorEuro(tasaEuro));
        conversores.put(3, new ConversorLibraEsterlina(tasaLibraEsterlina));
        conversores.put(4, new ConversorYenJapones(tasaYenJapones));
        conversores.put(5, new ConversorWonCoreano(tasaWonCoreano));

        System.out.println("¡Bienvenido al Conversor de Divisas!");

        System.out.print("Ingrese la cantidad en su moneda local: ");
        double cantidadMonedaLocal = scanner.nextDouble();

        System.out.println("Elija la moneda a la que desea convertir:");
        System.out.println("1. Dólar");
        System.out.println("2. Euro");
        System.out.println("3. Libra Esterlina");
        System.out.println("4. Yen Japones");
        System.out.println("5. Won Coreano");

        System.out.print("Ingrese el número de opción: ");
        int opcion = scanner.nextInt();

        ConversorMoneda conversorSeleccionado = conversores.get(opcion);

        if (conversorSeleccionado == null) {
            System.out.println("Opción inválida. Por favor, elija una opción válida.");
            scanner.close();
            return;
        }

        double resultado = conversorSeleccionado.convertirAMoneda(cantidadMonedaLocal);
        System.out.println("El resultado de la conversión es: " + resultado);

        System.out.println("\n¿Desea realizar una conversión inversa? (s/n)");
        String respuesta = scanner.next();

        if (respuesta.equalsIgnoreCase("s")) {
            System.out.print("Ingrese la cantidad en la moneda seleccionada: ");
            double cantidadMonedaExtranjera = scanner.nextDouble();

            double resultadoInverso = conversorSeleccionado.convertirDesdeMoneda(cantidadMonedaExtranjera);
            System.out.println("El resultado de la conversión inversa es: " + resultadoInverso);
        }

        scanner.close();
    }
}
