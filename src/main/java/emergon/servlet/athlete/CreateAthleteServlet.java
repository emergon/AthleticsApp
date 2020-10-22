/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.servlet.athlete;

import emergon.entity.Athlete;
import emergon.entity.Team;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "CreateAthleteServlet", urlPatterns = {"/CreateAthleteServlet"})
public class CreateAthleteServlet extends HttpServlet {

    private static EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("AthleticPU");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNativeQuery("Select * from team", Team.class);
        List<Team> teams = (List<Team>)q.getResultList();
        em.close();
        req.setAttribute("teams", teams);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/athleteForm.jsp");
        dispatcher.forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String sweight = req.getParameter("weight");
        String sheight = req.getParameter("height");
        String steam = req.getParameter("team");
        double weight = Double.parseDouble(sweight);
        double height = Double.parseDouble(sheight);
        int teamId = Integer.parseInt(steam);
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("Select t from Team t where id = :id", Team.class);
        q.setParameter("id", teamId);
        Team omada = (Team)q.getSingleResult();
        Athlete athlete = new Athlete(name, height, weight, LocalDate.now());
        athlete.setTeam(omada);
        em.getTransaction().begin();
        em.persist(athlete);
        em.getTransaction().commit();
        em.close();
    }

    

    
}
