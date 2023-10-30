package dev.bestzige.int202midexam.controllers;

import dev.bestzige.int202midexam.models.Prime;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PrimeHistoryServlet", value = "/073/history")
public class PrimeHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/073/register");
            return;
        }

        int primeCount = 0;
        if(session.getAttribute("primes") != null) {
            for(Prime p : (List<Prime>) session.getAttribute("primes")) {
                if(p.isPrime()) {
                    primeCount++;
                }
            }
        }
        req.setAttribute("primeCount", primeCount);
        req.getRequestDispatcher("/prime-history.jsp").forward(req, resp);
    }
}
