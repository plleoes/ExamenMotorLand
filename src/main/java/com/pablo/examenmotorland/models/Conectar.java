/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablo.examenmotorland.models;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author plleo
 */
public class Conectar {
    
        public DriverManagerDataSource conectar()
    {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.0.197/MotorLand");
        dataSource.setUsername("root");
        dataSource.setPassword("kkb2chmy");
        return dataSource;
        
    }

    
    
}
