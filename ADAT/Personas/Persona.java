/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;

import java.io.Serializable;


public class Persona implements Serializable{
	String nombre;
	private int edad;
	
	public Persona(String nombre,int edad)	{
	  this.nombre=nombre;
	  this.edad=edad;	
	 }
	public Persona() {
	  this.nombre=null;	  
	 }	
	public void setNombre(String nom){nombre=nom;}
	public void setEdad(int ed){edad=ed;}
	
	public String getNombre(){return nombre;}
	public int getEdad(){return edad;}	
}//fin Persona
