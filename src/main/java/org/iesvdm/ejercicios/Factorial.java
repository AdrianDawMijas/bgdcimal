package org.iesvdm.ejercicios;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("Dame un numero natural");
        Scanner sc = new Scanner(System.in);
        String numero = sc.next();
        BigInteger factorial = new BigInteger(numero);
        System.out.println(calcularFactorial(factorial));
        }



    public static BigInteger calcularFactorial(BigInteger numero){
        if(numero.subtract(BigInteger.ONE).compareTo(BigInteger.ONE) == 0){
            return numero;
        }
        else{
            return calcularFactorial(numero.multiply(numero.subtract(BigInteger.ONE)));
        }
    }
}
