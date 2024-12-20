package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Model implements Serializable
{
    private static final Model instance = new Model();
    private final Map<Integer, User> model;
    public static Model getInstance()
    {
        return instance;
    }
    private Model()
    {
        model = new HashMap<>();
        model.put(1, new User("Artem","Kleymenov",120000));
        model.put(2, new User("Oleg","Kazakov",120000));
    }

    public void Add(int id, User user)
    {
        model.put(id, user);
    }

    public void Delete(int id)
    {
        model.remove(id);
    }

    public void Update(int id, User user)
    {
        model.put(id, user);
    }

    public Map<Integer, User> getFromList()
    {
        return model;
    }
}
