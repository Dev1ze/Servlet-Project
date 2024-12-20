package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/math")
public class ServletAnswer extends HttpServlet {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
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
            System.out.println("Error");
        }

        JsonObject jsonObject = gson.fromJson(String.valueOf(stringBuffer), JsonObject.class);
        int value_1 = jsonObject.get("a").getAsInt();
        int value_2 = jsonObject.get("b").getAsInt();
        String operation = jsonObject.get("math").getAsString();
        Calculator calculator = new Calculator(value_1, value_2, operation);
        int result = calculator.getResult();

        JsonObject responseJson = new JsonObject();
        responseJson.addProperty("result", result);

        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(responseJson));

    }
}