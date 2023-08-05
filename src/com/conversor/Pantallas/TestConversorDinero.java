package com.conversor.Pantallas;

import com.conversor.Modelo.*;

public class TestConversorDinero {
	public static void main(String[] args) {
		Conversor_Moneda c = new Conversor_Moneda();
		c.setMoneda_entra(250);
		c.setTconversion("De Dolar a Pesos");
		System.out.println(c.Conversion());
	}
}
