package org.iesvdm.ejercicios;

import java.math.BigDecimal;

public class Prestamo {
    BigDecimal principal;
    BigDecimal interest;
    int años;

    public Prestamo(BigDecimal principal, BigDecimal interest, int años) {
        this.principal = principal;
        this.interest = interest;
        this.años = años;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public int getAños() {
        return años;
    }

    public void setAños(int años) {
        this.años = años;
    }

    public void interesAnualaMensual(BigDecimal interesAnualaMensual) {
        this.interest = interesAnualaMensual.divide(new BigDecimal("12"), 10, BigDecimal.ROUND_HALF_EVEN);
    }

    public BigDecimal pagoMensual() {

        BigDecimal exponenente = BigDecimal.ONE.add(interest).pow(años);
        BigDecimal numerador = principal.multiply(interest).add(exponenente);
        BigDecimal denominador = exponenente.subtract(BigDecimal.ONE);
        return numerador.divide(denominador, 10, BigDecimal.ROUND_HALF_EVEN);
    }

}

