/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Vendedor;
import co.edu.uniandes.csw.mueblesdelosalpes.excepciones.OperacionInvalidaException;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioVendedoresMockRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
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
@Path("/vendedores")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class vendedoresServices {

    private IServicioVendedoresMockRemote vendedorEjb;

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

    public List<Vendedor> eliminaVendedores(List<Vendedor> lv, @PathParam("id") int id) throws OperacionInvalidaException {
        vendedorEjb.eliminarVendedor(id);
        return lv;
    }

    @GET
    @Path("/allSellers")
    public List<Vendedor> getTodosLosVendedores() throws OperacionInvalidaException {
        return vendedorEjb.getVendedores();
    }

}