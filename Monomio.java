package Polinomios;

public class Monomio {

	private Integer coeficiente;
	private Integer exponente;

	public static final Character VARIABLE = 'x'; // Variable de clase

	public Monomio(Integer coeficiente, Integer exponente) {
		this.coeficiente = coeficiente;
		this.exponente = exponente;
	}

	public void setCoeficiente(Integer coeficiente) {
		this.coeficiente = coeficiente;
	}

	public Integer getCoeficiente() {
		return this.coeficiente;
	}

	public void setExponenete(Integer exponente) {
		this.exponente = exponente;
	}

	public Integer getExponente() {
		return this.exponente;
	}

	public String toString() {
		// ó return String.format("%d%c^%d", (coeficiente>0?'+': '
		// '),VARIABLE,exponente);
		if (coeficiente > 0) {
			return String.format("+%d%c^%d", coeficiente, VARIABLE, exponente);
		} else {
			return String.format("%d%c^%d", coeficiente, VARIABLE, exponente);
		}
	}

	public Boolean isSemejante(Monomio otro) {
		return this.getExponente() == otro.getExponente();
	}

}
