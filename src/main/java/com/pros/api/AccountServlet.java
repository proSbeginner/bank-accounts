package com.pros.api;

import com.google.gson.Gson;
import com.pros.dao.AccountDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AccountServlet extends HttpServlet {
    private AccountDao dao = new AccountDao();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List list = dao.findAll();
        String result =  new Gson().toJson(list);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(result);
        out.flush();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
