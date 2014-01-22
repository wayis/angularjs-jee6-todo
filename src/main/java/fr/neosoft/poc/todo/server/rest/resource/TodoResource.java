package fr.neosoft.poc.todo.server.rest.resource;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import fr.neosoft.poc.todo.server.mongo.DBConnection;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by l.labbe on 22/01/14.
 */
@Singleton
@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {

    /**
     * MongoDB connection provider.
     */
    @Inject
    private DBConnection dbConnection;
    /**
     * Todos collection.
     */
    private DBCollection todos;

    @PostConstruct
    public void init() {
        todos = dbConnection.getCollection("todos");
    }

    @GET
    public List<DBObject> findAll() {
        return todos.find().toArray();
    }
}
