package controllers.reservations;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Reservation;
import utils.DBUtil;
/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
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
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Reservation r = new Reservation();

            String room_name = request.getParameter("room_name");
            r.setRoom_name(room_name);

            String reserver = request.getParameter("reserver");
            r.setReserver(reserver);

            String comment = request.getParameter("comment");
            r.setComment(comment);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            r.setCreated_at(currentTime);
            r.setUpdated_at(currentTime);

            Timestamp start_time;
            Timestamp finish_time;
            String a = request.getParameter("start_time");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
            java.util.Date date = null;
            try {
                date = sdf.parse(a);
            } catch (ParseException e) {

                e.printStackTrace();
            }
            start_time = new Timestamp(date.getTime());

            r.setStart_time(start_time);

            String b = request.getParameter("start_time");

            java.util.Date date_out = null;
            try {
                date_out = sdf.parse(b);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            finish_time = new Timestamp(date_out.getTime());

            r.setFinish_time(finish_time);

            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
            em.close();

            response.sendRedirect(request.getContextPath() + "/reservations/index");
        }
    }

}
