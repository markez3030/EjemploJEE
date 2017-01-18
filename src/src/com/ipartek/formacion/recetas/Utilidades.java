package com.ipartek.formacion.recetas;

/**
 * Clase {@code Utilidades} con metodos estaticos y comunues.<br>
 * Por ejemplo: generar numeros aleatorios, validaciones etc
 * 
 * @author ur00
 *
 */
public class Utilidades {

	/**
	 * Generar numero {@code int} aleatorio desde 0 hasta <b>maximoValor</b>
	 * 
	 * @param maximoValor
	 *            numero aletarorio maximos que puede generar, incluido este.
	 * @return numero entero aleatorio
	 */
	static public int getNumeroAleatorio(int maximoValor) {
		return (int) (Math.random() * maximoValor);
	}

	/**
	 * Suma muy rara que se inventa el jefe, no me digas para que
	 * 
	 * @param num1
	 *            entero a sumar
	 * @param num2
	 *            entero a sumar
	 * @return sumar de los dos parametros, pero: <br>
	 *         si cualquiera de los dos negativo return 0. <br>
	 *         Si la suma es superior a 100 return 0.
	 */
	static public int sumaTonta(int num1, int num2) {
		int resultado = -1;

		if (num1 < 0 || num2 < 0 || (num1 + num2 > 100)) {
			resultado = 0;
		} else {
			resultado = num1 + num2;
		}
		return resultado;
	}

}
