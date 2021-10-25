package com.kpi.railwaystation.controller;

import com.kpi.railwaystation.controller.commands.AddRouteCommand;
import com.kpi.railwaystation.controller.commands.ChooseSeatCommand;
import com.kpi.railwaystation.controller.commands.Command;
import com.kpi.railwaystation.controller.commands.SearchRouteCommand;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class    Servlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(Servlet.class);
    private Map<String, Command> commandMapping;

    @Override
    public void init() throws ServletException {
        logger.debug("servlet initialization started");
        commandMapping = new HashMap<>();
        commandMapping.put("search-routes", new SearchRouteCommand());
        commandMapping.put("choose-seat", new ChooseSeatCommand());
        commandMapping.put("add-route", new AddRouteCommand());
        super.init();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String commandParameter = request.getParameter("command");
        System.out.println(request.getParameter("departure-datetime"));
        System.out.println(request.getParameter("arrival-datetime"));
        logger.debug("received command ---> " + commandParameter);
        Command command = commandMapping.get(commandParameter);
        logger.trace("executing command...");
        String page = command.execute(request, response);
        if (page.contains("redirect:")) {
            logger.trace("successfully executed command, sending redirect to " + page);
            response.sendRedirect(page.replace("redirect:/", ""));
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            logger.trace("successfully executed command, forwarding request to " + page);
            dispatcher.forward(request, response);
        }
    }

}
