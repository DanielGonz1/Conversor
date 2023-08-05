package com.conversor.Modelo;

import java.text.DecimalFormat;

public class Conversor_Temperatura {
	/**
	 * Esta clase representa la conversión entre monedas
	 * Contiene valirables de instancia el método para la resolución del problema
	*/
	
	private String tconversion, conca;
	private double temperatura_1, temperatura_2;
	
	public void setTconversion(String conversion) {
		this.tconversion = conversion;
	}
	public void setTemperatura_1(double temperatura) {
		this.temperatura_1 = temperatura;
	}
	
	private double celsius_fahrenheit(double tem){
		return (tem * 9 / 5) + 32;
	}
	
	private double celsius_kelvin(double tem) {
		return tem + 273.15;
	}
	
	private double fahrenheit_celsius(double tem){
		return (tem - 32) * 5 / 9;
	}
	
	private double kelvin_celsius(double tem) {    //
		return tem - 273.15;
	}
	
	/**
	 * Método Conversión Temperatura
	 * 
	 * Este método realiza la conversión donde se concatena según a la conversión
	 *  
	 * @return El resultado de la conversión para métodos internos
	 */
	private double Conversion() {
		switch(tconversion) {
		case "De Celsius (°C) a Fahrenheit (°F)":
			temperatura_2 = celsius_fahrenheit(temperatura_1);
			conca = " °F";
			break;
		case "De Celsius (°C) a Kelvin (°K)":
			temperatura_2 = celsius_kelvin(temperatura_1);
			conca = " °K";
			break;
		case "De Fahrenheit (°F) a Kelvin (°K)":
			temperatura_2 = celsius_kelvin(fahrenheit_celsius(temperatura_1));
			conca = " °K";
			break;
		case "De Kelvin (°K) a Fahrenheit (°F)":
			temperatura_2 = celsius_fahrenheit(kelvin_celsius(temperatura_1));
			conca = " °F";
			break;
		case "De Fahrenheit (°F) a Celsius (°C)":
			temperatura_2 = fahrenheit_celsius(temperatura_1);
			conca = " °C";
			break;
		case "De Kelvin (°K) a Celsius (°C)":
			temperatura_2 = kelvin_celsius(temperatura_1);
			conca = " °C";
			break;
		}
		return temperatura_2;
	}
	
	/**
	 * getResultado Es el método que se encarga que mandar el resultado
	 * Ocupa el método de {@link Conversion()}
	 * @return Retorna una cadena donde va el resultado y concatenando el signo de la temperatura
	 */
	public String getResultado() {
		DecimalFormat formato = new DecimalFormat("0.00");
		return "" + formato.format(Conversion()) + conca;
	}
}
