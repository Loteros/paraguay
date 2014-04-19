/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import POJO.Usuarios;

/**
 *
 * @author Orlando
 */
public interface UsuarioDao {
    public Usuarios findByUsusario(Usuarios usuario);
    public Usuarios login(Usuarios usuario);
    
}
