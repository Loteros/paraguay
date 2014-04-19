/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import HibernateUtil.HibernateUtil;
import POJO.Usuarios;
import org.hibernate.Session;
/**
 *
 * @author Orlando
 */
public class UsuarioDaoImpl implements UsuarioDao {

    @Override
    public Usuarios findByUsusario(Usuarios usuario) {
      Usuarios model = null;
      Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
      String sql = "FROM Usuarios WHERE nombre_usuario='"+usuario.getNombreUsuario()+"'";
      try{
          sesion.beginTransaction();
          model = (Usuarios) sesion.createQuery(sql).uniqueResult();
          sesion.beginTransaction().commit();                  
      }catch (Exception e){
          sesion.beginTransaction().rollback();
      }
      return model;
    }

    @Override
    public Usuarios login(Usuarios usuario) {
        Usuarios model = this.findByUsusario(usuario);
        if(model != null){
            if(!usuario.getClave().equals(model.getClave())){
                return null;
            }
        }
        return model;       
    }
    
}
