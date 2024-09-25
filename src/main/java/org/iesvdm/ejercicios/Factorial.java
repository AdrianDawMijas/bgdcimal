package org.iesvdm.ejercicios;

import java.math.BigInteger;

public class Factorial {
    public static BigInteger calcularFactorial(BigInteger numero) {
        // Caso base: si el número es 0 o 1, el factorial es 1
        if (numero.equals(BigInteger.ONE) || numero.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        // Llamada recursiva: n * factorial(n - 1)
        else {
            return numero.multiply(calcularFactorial(numero.subtract(BigInteger.ONE)));
        }
    }

    public static void main(String[] args) {
        BigInteger numero = new BigInteger("5"); // Cambia este número para probar otros factoriales
        BigInteger resultado = calcularFactorial(numero);
        System.out.println("El factorial de " + numero + " es: " + resultado);
    }
}
