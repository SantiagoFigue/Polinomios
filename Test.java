package Polinomios;

import static Polinomios.Polinomio.multiplicar;
import static Polinomios.Polinomio.resta;
import static Polinomios.Polinomio.sumar;
import static Polinomios.Polinomio.dividir;

public class Test {

	public static void main(String[] args) { // Se usa antes de instanciar cualquier cosa.

		Polinomio polinomio1 = new Polinomio();
		polinomio1.add(new Monomio(15, 5));
		polinomio1.add(new Monomio(-35, 4));
		polinomio1.add(new Monomio(-30, 3));
		polinomio1.add(new Monomio(60, 2));
		polinomio1.add(new Monomio(40, 1));
		Polinomio polinomio2 = new Polinomio();

		polinomio2.add(new Monomio(1, 1));
		polinomio2.add(new Monomio(-1, 0));

		polinomio1.imprimir();
		System.out.println(" ");
		polinomio2.imprimir();

		System.out.println("\nQueda:"); // Queda la siguiente manera.
		sumar(polinomio1, polinomio2).imprimir();
		System.out.println(" ");
		resta(polinomio1, polinomio2).imprimir();
		System.out.println(" ");
		multiplicar(polinomio1, polinomio2).imprimir();
		System.out.println("");
		dividir(polinomio1, polinomio2);
	}
}
