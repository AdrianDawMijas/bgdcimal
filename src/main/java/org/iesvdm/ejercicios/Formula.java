package org.iesvdm.ejercicios;

import java.math.BigDecimal;

public class Formula {
    public static void main(String[] args) {

        // Definir valores iniciales
        BigDecimal radio = new BigDecimal("6371"); // Radio de la Tierra en kilómetros
        BigDecimal latitud10 = new BigDecimal("8.53687");
        BigDecimal latitud20 = new BigDecimal("18.53687");
        BigDecimal longitud10 = new BigDecimal("-3.5227");
        BigDecimal longitud20 = new BigDecimal("5.5227");

        // Convertir grados a radianes
        BigDecimal degToRad = new BigDecimal(Math.PI).divide(new BigDecimal("180"), 10, BigDecimal.ROUND_HALF_UP);
        BigDecimal latitud1 = latitud10.multiply(degToRad);
        BigDecimal latitud2 = latitud20.multiply(degToRad);
        BigDecimal longitud1 = longitud10.multiply(degToRad);
        BigDecimal longitud2 = longitud20.multiply(degToRad);

        // Calcular las diferencias de latitud y longitud
        BigDecimal deltaLatitud = latitud2.subtract(latitud1);
        BigDecimal deltaLongitud = longitud2.subtract(longitud1);

        // Calcular el seno cuadrado de la mitad de la diferencia de latitud
        BigDecimal latitudSeno = BigDecimal.valueOf(Math.sin(deltaLatitud.divide(BigDecimal.TWO, 10, BigDecimal.ROUND_HALF_UP).doubleValue()));
        BigDecimal latitudSenoCuadrado = latitudSeno.pow(2);

        // Calcular los cosenos de las latitudes
        BigDecimal latitud1Cos = BigDecimal.valueOf(Math.cos(latitud1.doubleValue()));
        BigDecimal latitud2Cos = BigDecimal.valueOf(Math.cos(latitud2.doubleValue()));

        // Calcular el seno cuadrado de la mitad de la diferencia de longitud
        BigDecimal longitudSeno = BigDecimal.valueOf(Math.sin(deltaLongitud.divide(BigDecimal.TWO, 10, BigDecimal.ROUND_HALF_UP).doubleValue()));
        BigDecimal longitudSenoCuadrado = longitudSeno.pow(2);

        // Calcular 'a' según la fórmula de Haversine
        BigDecimal a = latitudSenoCuadrado.add(latitud1Cos.multiply(latitud2Cos).multiply(longitudSenoCuadrado));

        // Calcular 'c' utilizando atan2(sqrt(a), sqrt(1-a))
        BigDecimal sqrtA = BigDecimal.valueOf(Math.sqrt(a.doubleValue()));
        BigDecimal sqrtOneMinusA = BigDecimal.valueOf(Math.sqrt(BigDecimal.ONE.subtract(a).doubleValue()));
        BigDecimal c = BigDecimal.TWO.multiply(BigDecimal.valueOf(Math.atan2(sqrtA.doubleValue(), sqrtOneMinusA.doubleValue())));

        // Calcular la distancia final 'd'
        BigDecimal distancia = radio.multiply(c);

        // Mostrar el resultado de la distancia en kilómetros
        System.out.println("La distancia calculada es: " + distancia + " km");
    }
}
