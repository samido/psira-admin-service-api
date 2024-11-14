package com.psira.resource;

import com.psira.dto.ManagerDTO;
import com.psira.entity.Manager;
import com.psira.services.ManagerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/managers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ManagerResource {

    @Inject
    ManagerService managerService;

    @GET
    public List<Manager> getAll() {
        return managerService.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Integer id) {
        return managerService.findById(id)
                .map(manager -> Response.ok(manager).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    public Response create(ManagerDTO managerDTO) {
        Manager createdManager = managerService.create(managerDTO);
        return Response.status(Response.Status.CREATED).entity(createdManager).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, ManagerDTO managerDTO) {
        Manager updatedManager = managerService.update(id, managerDTO);
        return Response.ok(updatedManager).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        managerService.delete(id);
        return Response.noContent().build();
    }
}
