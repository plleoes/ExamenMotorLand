/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablo.examenmotorland.controllers;

import com.pablo.examenmotorland.models.Conectar;
import com.pablo.examenmotorland.models.ValidaMotor;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author plleo
 */
public class ListadoMotorController {
    
       
    private JdbcTemplate jdbcTemplate;

    public ListadoMotorController() {
        Conectar con=new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
   @RequestMapping("index.htm")
    public ModelAndView index(HttpServletRequest request)
    {
        String opc=request.getParameter("opcion");
        ModelAndView mav=new ModelAndView();
        String sql="select modelo,fabricante,potencia,peso,cantidad,if(peso/potencia<10,\"si\",\"no\") as optimo from motores order by fabricante";
        List motores=this.jdbcTemplate.queryForList(sql);
        mav.addObject("motores",motores);
        mav.setViewName("index");
        return mav;
    }

    
}
