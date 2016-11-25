package br.com.brasilprev.motorcalculo.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Estrutura HashMap por faixas de valor.
 * @author Cleps
 *
 * @param <T>
 */
public class RangeMap<T>{
	private Map<Range,T> rangeMap = new HashMap<Range, T>();
	
	/**
	 * insere um valor para uma faixa de inicio e fim.
	 * @param inicio
	 * @param fim
	 * @param valor
	 * @throws Exception
	 */
	public void add(BigDecimal inicio, BigDecimal fim, T valor) throws Exception{
		Range chave = validarChave(inicio,fim);
		rangeMap.put(chave, valor);
	}
	
	private Range validarChave(BigDecimal inicio, BigDecimal fim) throws Exception {
		boolean podeCriar = true;
		
		if(inicio.compareTo(fim) < 0 ){
			for(Range range : rangeMap.keySet()){
				if( !(range.getInicio().compareTo(inicio) > 0 && range.getFim().compareTo(inicio) > 0 ) ){
					podeCriar = false;
				}
				if( !(range.getInicio().compareTo(inicio) < 0 && range.getFim().compareTo(inicio) < 0) ){
					podeCriar = false;
				}
			}
		}
		else
			podeCriar = false;
		
		if(podeCriar)
			return new Range(inicio,fim);
		throw new Exception();
	}

	/**
	 * Busca em que faixa o valor se encontra.
	 * @param value
	 * @return
	 */
	public T get(BigDecimal value) {
		for (Range range : rangeMap.keySet()) 
			if(range.getInicio().compareTo(value) >= 0 && range.getFim().compareTo(value) <= 0 ) 
				return this.rangeMap.get(new Range(range.getInicio(),range.getFim()));
		return null;
	}
}
