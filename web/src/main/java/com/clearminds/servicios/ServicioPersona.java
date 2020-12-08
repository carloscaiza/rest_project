package com.clearminds.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.clearminds.entidades.Persona;

@Path("/srvpersonas")
public class ServicioPersona {
	
	@Path("/busqueda")
	@GET
	public String consultar(){
		return "Mensaje";
	}

	@Path("/recuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Persona recuperar(){
		return new Persona("Carlos", "Caiza");
	}
	
	@Path("/ingresar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void ingresar (Persona p){
		System.out.println("Ingresando Persona: " + p);
	}
	
	@Path("/actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Persona actualizar(Persona p){
		
		try {
			
			if( p != null){
				System.out.println("Ingresando Persona: " + p);
				p.setNombre(p.getNombre().toUpperCase());
				p.setApellido(p.getApellido().toUpperCase());
				System.out.println("Persona Modificada: " + p);
			}else{
				System.out.println("Llega persona vacía");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return new Persona();
		}
		
		return p;
	}
	
}
