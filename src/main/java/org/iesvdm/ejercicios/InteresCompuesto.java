package org.iesvdm.ejercicios;

import java.math.BigDecimal;
import java.math.BigInteger;

import static java.lang.Math.pow;

public class InteresCompuesto {
    public static void main(String[] args) {
        BigDecimal interesCompuesto = new BigDecimal("1");
        BigDecimal montoInicial= new BigDecimal("1000");
        BigDecimal interes = new BigDecimal("0.05");
        int numeroAños = 5;

        BigDecimal suma = interes.add(new BigDecimal("1"));
        BigDecimal finalsuma = montoInicial.multiply(suma);
        BigDecimal finalisimo = finalsuma.pow(numeroAños);

        System.out.println(finalisimo);
    }
}
