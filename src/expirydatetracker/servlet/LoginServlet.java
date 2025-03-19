package expirydatetracker.servlet;

import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.BufferedReader;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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

        // Mock validation (Fixed username and password)
        JSONObject responseJson = new JSONObject();
        if ("ckdeekshi".equals(username) && "deekshi04".equals(password)) {
            responseJson.put("status", "success");
            responseJson.put("message", "Login successful");
        } else {
            responseJson.put("status", "error");
            responseJson.put("message", "Invalid credentials");
        }

        // Send response
        resp.setContentType("application/json");
        resp.getWriter().write(responseJson.toString());
    }
}
