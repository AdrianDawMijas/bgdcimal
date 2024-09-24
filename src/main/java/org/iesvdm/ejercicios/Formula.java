package org.iesvdm.ejercicios;

import java.math.BigDecimal;

public class Formula {
    public static void main(String[] args) {


        BigDecimal radio = new BigDecimal("6371");
        BigDecimal latitud10 = new BigDecimal("8.53687");
        BigDecimal latitud20 = new BigDecimal("18.53687");
        BigDecimal longitud10 = new BigDecimal("-3.5227");
        BigDecimal longitud20 = new BigDecimal("5.5227");

        BigDecimal degToRad = new BigDecimal(Math.PI).divide(new BigDecimal("180"), 10, BigDecimal.ROUND_HALF_UP);
        BigDecimal latitud1 = latitud10.multiply(degToRad);
        BigDecimal latitud2 = latitud20.multiply(degToRad);
        BigDecimal longitud1= longitud10.multiply(degToRad);
        BigDecimal longitud2 = longitud20.multiply(degToRad);


        BigDecimal latitud = latitud2.subtract(latitud1);
        BigDecimal longitud = longitud2.subtract(longitud1);
        BigDecimal latitudseno = BigDecimal.valueOf(Math.sin((latitud.divide(BigDecimal.TWO, 10, BigDecimal.ROUND_HALF_UP)).doubleValue()));
        BigDecimal latitudfinal = latitudseno.pow(2);
        BigDecimal latitud1cos = BigDecimal.valueOf(Math.cos(latitud1.doubleValue()));
        BigDecimal latitud2cos = BigDecimal.valueOf(Math.cos(latitud2.doubleValue()));
        BigDecimal longitudsin = BigDecimal.valueOf(Math.sin((longitud.divide(BigDecimal.TWO, 10, BigDecimal.ROUND_HALF_UP)).doubleValue()));
        BigDecimal longitudfinal = longitudsin.pow(2);
        BigDecimal a = latitudfinal.add(latitud1cos.multiply(latitud2cos.multiply(longitudfinal)));
        BigDecimal sqra = BigDecimal.valueOf(Math.sqrt(a.doubleValue()));
        BigDecimal srqa1 = BigDecimal.valueOf(Math.sqrt(BigDecimal.ONE.subtract(a).doubleValue()));
        BigDecimal c = BigDecimal.TWO.multiply(BigDecimal.valueOf(Math.atan2(sqra.doubleValue(), srqa1.doubleValue())));
        BigDecimal d = radio.multiply(c);

        System.out.println(d);
    }
}
