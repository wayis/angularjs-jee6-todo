package fr.neosoft.poc.todo.server.application;

import com.mongodb.jee.jaxrs.JaxrsMongoApplication;
import fr.neosoft.poc.todo.server.rest.resource.TodoResource;

import javax.ws.rs.ApplicationPath;
import java.util.Set;

/**
 * Created by l.labbe on 22/01/14.
 */
@ApplicationPath("/api/v1")
public class ApplicationConfig extends JaxrsMongoApplication {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = super.getClasses();
        classes.add(TodoResource.class);
        return classes;
    }
}
