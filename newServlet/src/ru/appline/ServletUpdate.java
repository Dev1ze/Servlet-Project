package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.sun.org.apache.xpath.internal.operations.Mod;
import ru.appline.logic.Model;
import ru.appline.logic.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/put")
public class ServletUpdate extends HttpServlet
{
    Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        try
        {
            BufferedReader bufferedReader = request.getReader();
            while ((line = bufferedReader.readLine()) != null)
            {
                stringBuffer.append(line);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        JsonObject jsonObject = gson.fromJson(String.valueOf(stringBuffer), JsonObject.class);
        String name = jsonObject.get("name").getAsString();
        String surname = jsonObject.get("surname").getAsString();
        double salary = jsonObject.get("salary").getAsDouble();
        int id = jsonObject.get("id").getAsInt();
        User changedUser = new User(name, surname, salary);
        model.Update(id, changedUser);
        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(model.getFromList()));
    }
}
