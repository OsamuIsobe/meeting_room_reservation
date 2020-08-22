package controllers.reservations;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Reservation;
import utils.DBUtil;
/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();


        Reservation r = em.find(Reservation.class, (Integer)(request.getSession().getAttribute("reservation_id")));

        String room_name = request.getParameter("room_name");
        r.setRoom_name(room_name);

        String reserver = request.getParameter("reserver");
        r.setReserver(reserver);

        String comment = request.getParameter("comment");
        r.setComment(comment);

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        r.setCreated_at(currentTime);
        r.setUpdated_at(currentTime);

        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();


        request.getSession().removeAttribute("reservation_id");


        response.sendRedirect(request.getContextPath() + "/reservations/index");
    }

}
