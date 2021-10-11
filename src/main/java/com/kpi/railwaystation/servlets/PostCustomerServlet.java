package com.kpi.railwaystation.servlets;

import com.kpi.railwaystation.dao.CustomerDao;
import com.kpi.railwaystation.dao.impl.postgres.PostgresCustomerDao;
import com.kpi.railwaystation.factory.DaoFactory;
import com.kpi.railwaystation.factory.PostgreSQLFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PostCustomerServlet", value = "/post-customer")
public class PostCustomerServlet extends HttpServlet {

    PostgresCustomerDao postgresCustomerDAO;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/postcustomer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request);
        try {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            PostgreSQLFactory postgreSQLFactory = (PostgreSQLFactory) DaoFactory.getDAOFactory(1);
            postgreSQLFactory.createConnection();
            CustomerDao customerDao = postgreSQLFactory.getCustomerDao();
            customerDao.createCustomer(
                    firstName,
                    lastName,
                    email,
                    password,
                    2);
//            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
