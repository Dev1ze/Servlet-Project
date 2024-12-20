package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import ru.appline.logic.Model;
import ru.appline.logic.User;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(urlPatterns = "/get")
public class ServletList extends HttpServlet
{
    Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String contentType = request.getContentType();
        if ("application/json".equals(contentType))
        {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            String idParam = request.getParameter("id");
            int id = Integer.parseInt(idParam);
            PrintWriter pw = response.getWriter();
            if(id > 0)
            {
                User user = model.getFromList().get(id);
                pw.print(gson.toJson(user));
            }
            else if(id == 0)
            {
                pw.print(gson.toJson(model.getFromList()));
            }

        }
        else
        {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter pw = response.getWriter();
            int id = Integer.parseInt(request.getParameter("id"));
            if(id == 0)
            {
                pw.print("<html>" +
                        "<h3>Доступные пользователи:</h3><br/>" +
                        "ID пользователя: " +
                        "<ul>");
                for(Map.Entry<Integer, User> entry : model.getFromList().entrySet()) //Map.Entry<Integer, User> entry - один элемент списка
                {
                    pw.print("<li>" + entry.getKey() + "</li>" +
                            "<ul>" +
                            "<li>Имя: " + entry.getValue().getName() + "</li>" +
                            "<li>Фамилия: " + entry.getValue().getSurname() + "</li>" +
                            "<li>Зарплата: " + entry.getValue().getSalary() + "</li>" +
                            "</ul>");
                }
                pw.print("</ul>" +
                        "<a href=\"index.jsp\">Домой</a>" +
                        "</html>");
            }
            else if (id > 0)
            {
                if(id > model.getFromList().size())
                {
                    pw.print("<html>" +
                            "<h3>Данного пользователя не существует</h3><br/>" +
                            "<a href=\"index.jsp\">Домой</a>" +
                            "</html>");
                }
                else
                {
                    pw.print("<html>" +
                            "<h3>Запршенный пользователь:</h3>" +
                            "<br/>" +
                            "Имя: " + model.getFromList().get(id).getName() + "<br/>" +
                            "Фамилия: " + model.getFromList().get(id).getSurname() + "<br/>" +
                            "Зарплата: " + model.getFromList().get(id).getSalary() + "<br/>" +
                            "<a href=\"index.jsp\">Домой</a>" +
                            "</html>");
                }
            }
        }

    }
}