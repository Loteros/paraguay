/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import POJO.Usuarios;
import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Orlando
 */
@Named(value="loginBean")
@SessionScoped
public class loginBean implements Serializable{

    private Usuarios usuario;  
    private UsuarioDao usuarioDao;  
    
    public loginBean() {
        this.usuarioDao = new UsuarioDaoImpl();
        if(this.usuario == null){
            this.usuario = new Usuarios();
        }
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    
    public void login(ActionEvent actionEvent) {  
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
        boolean loggedIn = false;  
        String ruta = "";
        this.usuario = this.usuarioDao.login(this.usuario);
        if(this.usuario != null) {  
            loggedIn = true;  
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getNombreUsuario());
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido ", this.usuario.getNombreUsuario()); 
            ruta = "inicio.xhtml";
        } else {  
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "La combinación de usuario y/o clave es incorrecta. ");  
        }  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);
        context.addCallbackParam("ruta", ruta);
    }  
}
