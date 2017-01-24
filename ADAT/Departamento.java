/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ampliacion7;
/**
 *
 * @author Pedro
 */
import java.io.Serializable;

public class Departamento implements Serializable{
	private String departamento, localidad;
	private int dep;
	
	public Departamento(int dep, String departamento, String localidad)	{
	  this.dep=dep;
	  this.departamento=departamento;
          this.localidad=localidad;
	 }
	public Departamento() {
	  this.departamento=null;	  
	 }	
	public void setDep(int d){dep=d;}
	public void setDepartamento(String depart){departamento=depart;}
        public void setLocalidad(String local){localidad=local;}
	
	public int getDep(){return dep;}
	public String getDepartamento(){return departamento;}	
        public String getLocalidad(){return localidad;}
}//fin Persona
