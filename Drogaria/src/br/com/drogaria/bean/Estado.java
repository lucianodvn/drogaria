package br.com.drogaria.bean;

import javax.faces.convert.*;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;



@SuppressWarnings("unused")
@ManagedBean
public class Estado {
	private List<String> estados;
	private String[] selectedEstado;

	@PostConstruct
	public void init() {
		estados = new ArrayList<String>();
		estados.add("Acre - AC");
		estados.add("Alagoas - AL");
		estados.add("Amap� - AP");
		estados.add("Amazonas - AM");
		estados.add("Bahia - BA");
		estados.add("Cear� - CE");
		estados.add("Distrito Federal - DF");
		estados.add("Esp�rito Santo	- ES");
		estados.add("Goi�s - GO");
		estados.add("Maranh�o - MA");
		estados.add("Mato Grosso - MT");
		estados.add("Mato Grosso do Sul - MS");
		estados.add("Minas Gerais - MG");
		estados.add("Par� - PA");
		estados.add("Para�ba - PB");
		estados.add("Paran� - PR");
		estados.add("Piau� - PI");
		estados.add("Rio de Janeiro - RJ");
		estados.add("Rio Grande do Norte - RN");
		estados.add("Rio Grande do Sul - RS");
		estados.add("Rond�nia - RO");
		estados.add("Roraima - RR");
		estados.add("Santa Catarina - SC");
		estados.add("S�o Paulo - SP");
		estados.add("Sergipe - SE");
		estados.add("Tocantins - TO");

	}

	public List<String> getEstados() {
		return estados;
	}

	public void setEstados(List<String> estados) {
		this.estados = estados;
	}

	public String[] getSelectedEstado() {
		return selectedEstado;
	}

	public void setSelectedEstado(String[] selectedEstado) {
		this.selectedEstado = selectedEstado;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Estado))
			return false;
		Estado other = (Estado) obj;
		if (estados == null) {
			if (other.estados != null)
				return false;
		} else if (!estados.equals(other.estados))
			return false;
		return true;
	}

}
