// 65130500073 - Watchara Santawee
package dev.bestzige.int202midexam.controllers;

import dev.bestzige.int202midexam.models.User;
import dev.bestzige.int202midexam.utils.StringUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/073/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        if(!StringUtils.stringValidation(username) || !StringUtils.stringValidation(email)) {
            doGet(req, resp);
            return;
        }
        User user = new User(username, email);
        session.setAttribute("user", user);
        resp.sendRedirect(req.getContextPath() + "/073/is_prime");
    }
}
