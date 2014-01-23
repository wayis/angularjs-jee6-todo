package fr.neosoft.poc.todo.server.rest.resource;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import fr.neosoft.poc.todo.server.mongo.DBConnection;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by l.labbe on 22/01/14.
 */
@Stateless
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

    @POST
    public void create(String name) {
        DBObject todo = new BasicDBObject("name", name).append("done", false);
        todos.insert(todo);
    }

    @PUT
    public void mark(String id, boolean done) {
        DBObject searchQuery = new BasicDBObject("_id.$oid", id);
        DBObject valueToSet = new BasicDBObject("$set", new BasicDBObject("done", done));

        todos.update(searchQuery, valueToSet);
    }
}
