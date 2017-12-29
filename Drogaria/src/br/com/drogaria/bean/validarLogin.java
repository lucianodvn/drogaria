package br.com.drogaria.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import br.com.drogaria.util.jsfUtil;

@ManagedBean
public class validarLogin {

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Login efetuado com sucesso."));
    }
	
	public void login(Object redirectURL) throws IOException {
		if (username != null && username.equals("admin") && password != null && password.equals("admin")) {
			
			jsfUtil.adicionarMensagemSucesso("Login efetuado com sucesso.");
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect("/Drogaria/faces/pages/principal.xhtml");

		} else {
			jsfUtil.adicionarMensagemErro("Login ou senha incorreta!");
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().getExternalContext().redirect("/Drogaria/faces/pages/loginAdmin.xhtml");

		}
		
	}

}
