package fr.neosoft.poc.todo.server.rest.resource;

/**
 * Created by l.labbe on 22/01/14.
 */
public class Todo {
    private String name;
    private boolean done;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
