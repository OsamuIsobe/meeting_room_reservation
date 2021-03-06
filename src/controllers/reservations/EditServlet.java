package controllers.reservations;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Reservation;
import utils.DBUtil;
/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Reservation r = em.find(Reservation.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("reservation", r);
        request.setAttribute("_token", request.getSession().getId());

        request.getSession().setAttribute("reservation_id", r.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reservations/edit.jsp");
        rd.forward(request, response);
    }

}
