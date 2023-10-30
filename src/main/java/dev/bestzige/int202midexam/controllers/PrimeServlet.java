// 65130500073 - Watchara Santawee
package dev.bestzige.int202midexam.controllers;

import dev.bestzige.int202midexam.models.Prime;
import dev.bestzige.int202midexam.utils.NumberUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PrimeServlet", value = "/073/is_prime")
public class PrimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/073/register");
            return;
        }

        req.getRequestDispatcher("/prime-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String number = req.getParameter("number");
        req.setAttribute("currentValue", number);

        if(number == null || number.trim().isEmpty()) {
            number = "Empty";
        }
        int primerCheck = 0;
        String errorMessage = number + " is invalid input!!!";

        try {
            primerCheck = Integer.parseInt(number);
        } catch (Exception exception) {
            req.setAttribute("error", errorMessage);
        }

        if(primerCheck < 2) {
            req.setAttribute("error", errorMessage);
        }

        boolean isPrime = NumberUtils.isPrimerNumber(primerCheck);
        Prime prime = new Prime(primerCheck, isPrime);
        List<Prime> primes = new ArrayList<>();
        if(session.getAttribute("primes") != null) {
            for(Prime p : (List<Prime>) session.getAttribute("primes")) {
                primes.add(p);
            }
        }

        primes.add(prime);
        session.setAttribute("primes", primes);
        req.setAttribute("message", primerCheck + " is " + (isPrime ? "" : "not") + " prime number");

        req.getRequestDispatcher("/prime-form.jsp").forward(req, resp);
    }
}
