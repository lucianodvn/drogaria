package br.com.drogaria.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import br.com.drogaria.util.jsfUtil;

@ManagedBean
public class ButtonView {
	
	
	public void buttonAction(ActionEvent actionEvent) throws IOException {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		jsfUtil.adicionarMensagemSucesso("Você saiu!");
		FacesContext.getCurrentInstance().getExternalContext().redirect("/Drogaria/faces/pages/loginAdmin.xhtml");
		
		
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
