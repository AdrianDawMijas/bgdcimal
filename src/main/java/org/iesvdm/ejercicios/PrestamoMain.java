package org.iesvdm.ejercicios;


import java.math.BigDecimal;
public class PrestamoMain {
    public static void main(String[] args) {
        // Ejemplo: préstamo de 200,000€, tasa de interés anual 5%, 30 años
        BigDecimal principal = new BigDecimal("200000");
        BigDecimal interesAnual = new BigDecimal("0.05");
        int años = 30;

        // Crear el préstamo
        Prestamo prestamo = new Prestamo(principal, interesAnual, años);

        // Convertir interés anual en mensual
        prestamo.interesAnualaMensual(interesAnual);

        // Calcular el pago mensual
        BigDecimal pagoMensual = prestamo.pagoMensual();
        BigDecimal saldoPendiente = prestamo.getPrincipal(); // El saldo inicial es el principal

        System.out.println("Pago mensual: " + pagoMensual + "€");

        // Ciclo para calcular el desglose de cada mes
        int totalPagos = años * 12;
        for (int mes = 1; mes <= totalPagos; mes++) {
            // Calcular el pago de intereses del mes
            BigDecimal pagoInteres = saldoPendiente.multiply(prestamo.getInterest());
            // Calcular el pago al principal
            BigDecimal pagoPrincipal = pagoMensual.subtract(pagoInteres);
            // Reducir el saldo pendiente
            saldoPendiente = saldoPendiente.subtract(pagoPrincipal);

            // Mostrar los resultados del mes
            System.out.println("Mes " + mes + ":");
            System.out.println("   Pago de intereses: " + pagoInteres + "€");
            System.out.println("   Pago de principal: " + pagoPrincipal + "€");
            System.out.println("   Nuevo saldo pendiente: " + saldoPendiente + "€");

            // Si el saldo pendiente llega a cero o se vuelve negativo, terminamos el ciclo
            if (saldoPendiente.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("Préstamo pagado en el mes " + mes);
                break;
            }
        }
    }
}