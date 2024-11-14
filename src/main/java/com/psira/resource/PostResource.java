package com.psira.resource;

import com.psira.dto.PostDTO;
import com.psira.entity.Post;
import com.psira.services.PostService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {

    @Inject
    PostService postService;

    @GET
    public List<Post> getAll() {
        return postService.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        return postService.findById(id)
                .map(post -> Response.ok(post).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    public Response create(PostDTO postDTO) {
        Post createdPost = postService.create(postDTO);
        return Response.status(Response.Status.CREATED).entity(createdPost).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, PostDTO postDTO) {
        Post updatedPost = postService.update(id, postDTO);
        return Response.ok(updatedPost).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        postService.delete(id);
        return Response.noContent().build();
    }
}
