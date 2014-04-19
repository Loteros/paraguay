/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Orlando
 */
@ManagedBean
@RequestScoped
public class MB_Session {

    private String usuario;
    private final HttpServletRequest httpServletRequest;   
    private final FacesContext facesContext;
    private FacesMessage facesMessage;
   
    public MB_Session() {
        facesContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        if(httpServletRequest.getSession().getAttribute("sessionUsuario")!=null){
            usuario=httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
        }
    }
    
    public String cerrarSession(){
        httpServletRequest.getSession().removeAttribute("sessionUsuario");
        facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sesión cerrada correctamente.",null);
        facesContext.addMessage(null, facesMessage);
        return "/faces/index";
    }
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
