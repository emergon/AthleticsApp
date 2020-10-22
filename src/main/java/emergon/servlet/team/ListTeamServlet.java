package emergon.servlet.team;

import emergon.entity.Team;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListTeamServlet extends HttpServlet {

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
        req.setAttribute("teams", teams);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/teamList.jsp");
        dispatcher.forward(req, resp);
        
    }

    @Override
    public void destroy() {
        emf.close();
    }


}
