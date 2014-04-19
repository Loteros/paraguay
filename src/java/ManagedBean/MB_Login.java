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
public class MB_Login {

    private String usuario;
    private String clave;
    private final HttpServletRequest httpServletRequest;   
    private final FacesContext facesContext;
    private FacesMessage facesMessage;
    
    public MB_Login() {
        facesContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    }

    public String login(){
        if(usuario.equals("admin") && clave.equals("admin")){
            httpServletRequest.getSession().setAttribute("sessionUsuario", usuario);
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto",null);
            facesContext.addMessage(null, facesMessage);
            return "acceso";
        }else{
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acceso Incorrecto. Vuelva a intentarlo o contacte con el administrador.",null);
            facesContext.addMessage(null, facesMessage);
            return "index";
        }
    }
            
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
       
    
}
