package com.conversor.Pantallas;

import javax.swing.*;

import com.conversor.Modelo.*;

/**
 * En esta clase contiene el método principal con la que interactua el usuario
 * Para realizar las conversiones (Moneda, temperatura)
 */

public class Principal {
	//Variables a utilizar para el funcionamiento de la clase
	private static int salir;
	private static boolean ban = true, ban2;
	private static String opc, tipo, dinero, tem;
	
	public static void main(String[] args) {
		//Creamos una instancia para la conversión de tipo moneda
		Conversor_Moneda c = new Conversor_Moneda();
		
		//Creamos una instancia para la conversión de tipo temperatura
		Conversor_Temperatura t = new Conversor_Temperatura(); 
		
		//Este ciclo es el que le da vida al programa para que se repita según la bandera
		do {
			ban2 = true;
			/**
			 * Necesitamos saber la opción que desea hacer el usuario, del mismo modo tenemos que cubrir la posibilidad de si se llega a 
			 * cerrar el JOptionPane ya que generara una excepción de tipo nula
			 */
			try {
				//Preguntamos al usuario que tipo de conversión realizara 
				opc = (JOptionPane.showInputDialog(
						null,
						"Seleccione una opcion de conversion",
						"Menu",
						JOptionPane.DEFAULT_OPTION,
						null,
						new Object[]{"Conversor de Moneda", "Conversor de Temperatura"},
						"Selecciona")).toString();
				
				//Comparamos si es tipo moneda
				if(opc.contains("Conversor de Moneda")) {
					/**
					 * Se realiza un ciclo que depende de una bandera ya que en dado caso que ingrese
					 *un valor no valido (double) se repetira el proceso 
					*/ 
					while(ban2) {
						//EL usuario ingresara la cantidad de dinero a convertir
						dinero = JOptionPane.showInputDialog(
					            null,
					            "Ingresa la cantidad de dinero que deseas convertir:",
					            "Input",
					            JOptionPane.QUESTION_MESSAGE
					        );
						//Se tomara en cuenta que se podra dar una excepción de tipo de formato en este caso double
						try {
							c.setMoneda_entra(Double.parseDouble(dinero));
							tipo = (JOptionPane.showInputDialog(
									null,
									"Seleccione una opcion de conversion",
									"Menu",
									JOptionPane.DEFAULT_OPTION,
									null,
									new Object[]{"De Pesos a Dolar", "De Pesos a Euro", "De Pesos a Libra", "De Pesos a Yen",
												 "De Pesos a Won Coreano", "De Dolar a Pesos","De Euro a Pesos", "De Libra a Pesos",
												 "De Yen a Pesos", "De Won Coreano a Pesos"},
									"Selecciona")).toString();
							c.setTconversion(tipo);
							
							//Mostraremos el resultado de la conversión
							JOptionPane.showMessageDialog(null, "Tienes $" + c.Conversion());
							salida();//AQUI
						}catch(NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Valor no valido!");
						}
					}
				}
				
				else {
					while(ban2) {
						//EL usuario ingresara la temperatura a convertir
						tem = JOptionPane.showInputDialog(
					            null,
					            "Ingresa la temperatura que deseas convertir:",
					            "Input",
					            JOptionPane.QUESTION_MESSAGE
					        );
						//Se tomara en cuenta que se podra dar una excepción de tipo de formato en este caso double
						try {
							t.setTemperatura_1(Double.parseDouble(tem));
							tipo = (JOptionPane.showInputDialog(
									null,
									"Seleccione una opcion de conversion",
									"Menu",
									JOptionPane.DEFAULT_OPTION,
									null,
									new Object[]{"De Celsius (°C) a Fahrenheit (°F)", "De Celsius (°C) a Kelvin (K)", "De Fahrenheit (°F) a Kelvin (°K)",
												 "De Kelvin (°K) a Fahrenheit (°F)", "De Fahrenheit (°F) a Celsius (°C)", "De Kelvin (°K) a Celsius (°C)"},
									"Selecciona")).toString();
							t.setTconversion(tipo);
							//Mostraremos el resultado de la conversión
							JOptionPane.showMessageDialog(null, "Resultado: " + t.getResultado());
							salida();//AQUI
							//Mostramos el mensaje de valor invalido
						}catch(NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Valor no valido!");
						}
					}
				}
				
				
			//En caso de que se cierre el primer dialog, preguntamos si queria hacer eso o desea cancelar
			}catch(NullPointerException e) {
				salir = JOptionPane.showConfirmDialog(
			            null,
			            "¿Estás seguro que quieres salir?",
			            "Confirmación",
			            JOptionPane.YES_NO_OPTION
			        );
				//Cerramos la comunicación
				if (salir == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Programa finalizado.");
		            ban = false;
				}
			}
		}while(ban);	
	}
	
	private static void salida() {
		//Preguntaremos si desea continuar, nos referimos en dado caso que necesitara hacer una nueva conversión
		salir = JOptionPane.showConfirmDialog(
	            null,
	            "¿Deseas continuar?",
	            "Confirmación",
	            JOptionPane.YES_NO_CANCEL_OPTION
	        );
		
		//Si es si, nos vamos al menú principal
		if (salir == JOptionPane.YES_OPTION) 
            ban2 = false;
		//Nos despedimos y cerramos todo tipo de comunicación con el usuario
		else {
			JOptionPane.showMessageDialog(null, "Programa finalizado");
			ban = false;
			ban2 = false;
		}
	}
}