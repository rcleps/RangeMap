package br.com.brasilprev.motorcalculo.util;

import java.math.BigDecimal;

/**
 * Classe usada para validar faixa.
 * @author Cleps
 *
 */
public class Range {
	private BigDecimal inicio;
	private BigDecimal fim;
	
	public Range(BigDecimal inicio, BigDecimal fim) {
		super();
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public Range(){}

	public BigDecimal getInicio() {
		return inicio;
	}

	public void setInicio(BigDecimal inicio) {
		this.inicio = inicio;
	}

	public BigDecimal getFim() {
		return fim;
	}

	public void setFim(BigDecimal fim) {
		this.fim = fim;
	}
}
