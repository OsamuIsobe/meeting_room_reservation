package controllers;

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

        // セッションスコープからメッセージのIDを取得して
        // 該当のIDのメッセージ1件のみをデータベースから取得
        Reservation r = em.find(Reservation.class, (Integer)(request.getSession().getAttribute("reservation_id")));

        String room_id = request.getParameter("room_id");
        r.setRoom_id(room_id);

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        r.setReserve_time(currentTime);

        String name= request.getParameter("name");
        r.setName(name);

        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();

        // セッションスコープ上の不要になったデータを削除
        request.getSession().removeAttribute("reservation_id");

        // indexページへリダイレクト
        response.sendRedirect(request.getContextPath() + "/index");
    }

}
