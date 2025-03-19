package expirydatetracker.servlet;

import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.BufferedReader;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Read JSON input
        BufferedReader reader = req.getReader();
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }

        // Convert request body to JSON
        JSONObject requestJson = new JSONObject(requestBody.toString());
        String username = requestJson.optString("username", "");
        String password = requestJson.optString("password", "");

        // Mock response (No actual storage)
        JSONObject responseJson = new JSONObject();
        responseJson.put("status", "success");
        responseJson.put("message", "User registered successfully (Not stored)");

        // Send response
        resp.setContentType("application/json");
        resp.getWriter().write(responseJson.toString());
    }
}
