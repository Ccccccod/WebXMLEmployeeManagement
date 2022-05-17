/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Employee;
import entity.Name;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MR TU
 */
public class HomeController extends HttpServlet {
    
//    private final String filePath = getServletContext().getRealPath("/employees.xml");
    private final String filePath = System.getProperty("user.dir") + "/employees.xml";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EmployeeManager manager = new EmployeeManager(filePath);

            String id = request.getParameter("id");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String gender = request.getParameter("gender");
            String image = request.getParameter("image");

            if (request.getParameter("add") != null) {
                manager.add(new Employee(id, new Name(firstName, lastName), gender, image));
                List<Employee> employees = manager.list();
                request.setAttribute("list", employees);
                request.setAttribute("alert", "Added successfully");
                request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
            } else if (request.getParameter("update") != null) {
                boolean success = manager.update(new Employee(id, new Name(firstName, lastName), gender, image));
                List<Employee> employees = manager.list();
                request.setAttribute("list", employees);
                request.setAttribute("alert", success ? "Updated successfully" : "Nothing was updated");
                request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
            } else if (request.getParameter("delete") != null) {
                boolean success = manager.delete(id);
                List<Employee> employees = manager.list();
                request.setAttribute("list", employees);
                request.setAttribute("alert", success ? "Deleted successfully" : "Nothing was deleted");
                request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
            } else if (request.getParameter("search") != null) {
                List<Employee> employees = manager.search(new Employee(id, new Name(firstName, lastName), gender, image));
                request.setAttribute("list", employees);
                request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
            } else if (request.getParameter("list") != null) {
                List<Employee> employees = manager.list();
                request.setAttribute("list", employees);
                request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
            } else {
                List<Employee> employees = manager.list();
                request.setAttribute("list", employees);
                request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e.getStackTrace());
            request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
