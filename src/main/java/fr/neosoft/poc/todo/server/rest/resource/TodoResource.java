package fr.neosoft.poc.todo.server.rest.resource;

import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by l.labbe on 22/01/14.
 */
@Singleton
@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {

    private static List<Todo> todos = new ArrayList<>();

    @GET
    public List<Todo> findAll() {
        return todos;
    }
}
