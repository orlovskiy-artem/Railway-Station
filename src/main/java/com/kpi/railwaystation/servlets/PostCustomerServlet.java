package com.kpi.railwaystation.servlets;

import com.kpi.railwaystation.DAO.CustomerDAO;
import com.kpi.railwaystation.DAO.impl.postgres.PostgresCustomerDAO;
import com.kpi.railwaystation.Factory.DAOFactory;
import com.kpi.railwaystation.Factory.PostgreSQLFactory;
import com.kpi.railwaystation.model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PostCustomerServlet", value = "/post-customer")
public class PostCustomerServlet extends HttpServlet {

    PostgresCustomerDAO postgresCustomerDAO;
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
            PostgreSQLFactory postgreSQLFactory = (PostgreSQLFactory) DAOFactory.getDAOFactory(1);
            postgreSQLFactory.createConnection();
            CustomerDAO customerDAO = postgreSQLFactory.getCustomerDAO();
            customerDAO.createCustomer(
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
