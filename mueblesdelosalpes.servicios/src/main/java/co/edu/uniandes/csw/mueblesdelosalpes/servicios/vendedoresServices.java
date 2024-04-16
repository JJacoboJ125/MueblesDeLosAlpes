/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Vendedor;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioVendedoresMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author USER
 */
@Path("/sellers")
@Stateful
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class vendedoresServices {
    
    @EJB
    private IServicioVendedoresMockLocal vendedorEjb;

    @POST
    @Path("/addSeller")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Vendedor> agregaVendedores(List<Vendedor> lv) throws OperacionInvalidaException {
        for (Vendedor vende : lv) {
            vendedorEjb.agregarVendedor(vende);
        }
        return lv;
    }

    @DELETE
    @Path("/DeleteSeller/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void eliminaVendedores(@PathParam("id") long id) throws OperacionInvalidaException {
        vendedorEjb.eliminarVendedor(id);
    }
    
    @GET
    @Path("getTodosLosVendedores/")
    public List<Vendedor> getTodosLosVendedores() throws OperacionInvalidaException {
        return vendedorEjb.getVendedores();
    }

}