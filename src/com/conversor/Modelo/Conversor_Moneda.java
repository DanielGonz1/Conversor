package com.conversor.Modelo;

import java.text.DecimalFormat;

public class Conversor_Moneda {
	
	/**
	 * Esta clase representa la conversión entre monedas
	 * Contiene valirables de instancia el método para la resolución del problema
	*/
	private String tconversion, moneda_sale;;
	private double moneda_entra;
	
	public void setTconversion(String conversion) {
		this.tconversion = conversion;
	}
	public void setMoneda_entra(double moneda) {
		this.moneda_entra = moneda;
	}
	
	DecimalFormat formato = new DecimalFormat("0.00");
	
	/**
	 * Método Conversión
	 * 
	 * Este método realiza la conversión donde se concatena según a la conversión
	 *  
	 * @return El resultado de la conversión
	 */
	
	public String Conversion() {
		switch(tconversion) {
		case "De Pesos a Dolar":
			moneda_sale = "" + formato.format(moneda_entra * 0.059) + " Dolares";
			break;
		case "De Pesos a Euro":
			moneda_sale = "" + formato.format(moneda_entra * 0.053) + " Euros";
			break;
		case "De Pesos a Libra":
			moneda_sale = "" + formato.format(moneda_entra * 0.046) + "Libras";
			break;
		case "De Pesos a Yen":
			moneda_sale = "" + formato.format(moneda_entra * 8.30) + " Yenes";
			break;
		case "De Pesos a Won Coreano":
			moneda_sale = "" + formato.format(moneda_entra * 76.36) + " Wons Coreanos";
			break;
		case "De Dolar a Pesos":
			moneda_sale = "" + formato.format(moneda_entra / 0.059) + " Pesos";
			break;
		case "De Euro a Pesos":
			moneda_sale = "" + formato.format(moneda_entra / 0.053) + " Pesos";
			break;
		case "De Libra a Pesos":
			moneda_sale = "" + formato.format(moneda_entra / 0.046) + " Pesos";
			break;
		case "De Yen a Pesos":
			moneda_sale = "" + formato.format(moneda_entra / 8.30) + " Pesos";
			break;
		case "De Won Coreano a Pesos" + " Pesos":
			moneda_sale = "" + formato.format(moneda_entra / 76.36) + " Pesos";
			break;
		}
		return moneda_sale;
	}
}
