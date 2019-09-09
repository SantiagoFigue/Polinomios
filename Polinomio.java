package Polinomios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Polinomio {

	private ArrayList<Monomio> terminos;

//constructor
	public Polinomio() {
		terminos = new ArrayList<Monomio>();
	}

	public void add(Monomio mono) {
		terminos.add(mono);
	}

	public void imprimir() {
		for (Monomio t : terminos) {
			System.out.print(t);
		}
	}

	public void reducir() {
		ArrayList<Monomio> aux = new ArrayList<>();
		while (terminos.size() > 0) {
			Monomio actual = terminos.remove(0);
			int contador = 0;
			while (contador < terminos.size()) {
				Monomio t = terminos.get(contador);
				if (actual.isSemejante(t)) {
					actual.setCoeficiente(actual.getCoeficiente() + t.getCoeficiente());
					terminos.remove(contador);
				} else {
					contador++;
				}
			}
			if (actual.getCoeficiente() != 0) {
				aux.add(actual);
			}
		}
		terminos = aux;
	}

	public static Polinomio sumar(Polinomio p1, Polinomio p2) {
		Polinomio p3 = new Polinomio();
		Integer contador = 0;
		while (p1.terminos.size() > contador) {
			p3.add(new Monomio(p1.terminos.get(contador).getCoeficiente(), p1.terminos.get(contador).getExponente()));
			contador++;
		}
		contador = 0;
		while (p2.terminos.size() > contador) {
			p3.add(new Monomio(p2.terminos.get(contador).getCoeficiente(), p2.terminos.get(contador).getExponente()));
			contador++;
		}
		p3.reducir();
		return p3;
	}

	public static Polinomio resta(Polinomio p1, Polinomio p2) {
		Polinomio p4 = new Polinomio();
		Integer contador = 0;
		while (p1.terminos.size() > contador) {
			p4.add(new Monomio(p1.terminos.get(contador).getCoeficiente(), p1.terminos.get(contador).getExponente()));
			contador++;
		}
		contador = 0;
		while (p2.terminos.size() > contador) {
			p4.add(new Monomio(p2.terminos.get(contador).getCoeficiente() * -1,
					p2.terminos.get(contador).getExponente()));
			contador++;
		}
		p4.reducir();
		return p4;
	}

	public static Polinomio multiplicar(Polinomio p1, Polinomio p2) {
		Polinomio p5 = new Polinomio();
		Integer contador = 0;
		Integer contador1 = 0;
		while (p1.terminos.size() > contador) {
			while (p2.terminos.size() > contador1) {
				p5.add(new Monomio(
						p1.terminos.get(contador).getCoeficiente() * p2.terminos.get(contador1).getCoeficiente(),
						p1.terminos.get(contador).getExponente() + p2.terminos.get(contador1).getExponente()));
				contador1++;
			}
			contador1 = 0;

			contador++;
		}
		p5.reducir();
		return p5;
	}
	
	public static Polinomio dividir(Polinomio p1, Polinomio p2) {
		Polinomio p5 = new Polinomio();
		p1.ordenar();
		p2.ordenar();
		while (p1.terminos.get(0).getExponente() >= p2.terminos.get(0).getExponente() ) {
			p5.add(new Monomio(p1.terminos.get(0).getCoeficiente() / p2.terminos.get(0).getCoeficiente(),
					p1.terminos.get(0).getExponente() - p2.terminos.get(0).getExponente()
					)
				);
			p1.ordenar();
			p1.reducir();
			p1 = resta(p1, multiplicarTodo(p2, p5.terminos.get(p5.terminos.size()-1)));
			if (p1.terminos.size() == 0) {
				break;
			}
		}
		p5.reducir();
		p5.imprimir();
		
		if (p1.terminos.size() != 0) {
			System.out.print("(");
			p1.imprimir();
			System.out.print("/");
			p2.imprimir();
			System.out.print(")");
		}
		return p5;
	}
	
	public static Polinomio multiplicarTodo(Polinomio p1, Monomio m1) {
		Polinomio p5 = new Polinomio();
		for (Monomio monoP : p1.terminos) {
			p5.add(new Monomio(
					monoP.getCoeficiente() * m1.getCoeficiente(), monoP.getExponente() + m1.getExponente()
					));
		}
		return p5;
	}
	
	public void ordenar() {
		Monomio aux = null;
		
		for (int i = 0; i < terminos.size()-1; i++) {
			for (int j = 0; j < terminos.size()-1; j++) {
				if (terminos.get(j).getExponente() < terminos.get(j+1).getExponente()) {
					aux = terminos.get(j);
					terminos.set(j, terminos.get(j+1));
					terminos.set(j+1, aux);
				}
			}
			
		}
	}
}