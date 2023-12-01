import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import your.package.name.HibernateUtil;
import your.package.name.SalesFormBean;

@WebServlet("/SubmitFormServlet")
public class SubmitFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve form data
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // Create SalesFormBean object
            SalesFormBean salesForm = new SalesFormBean();
            salesForm.setFirstName(firstName);
            salesForm.setLastName(lastName);
            salesForm.setEmail(email);

            // Save to the database using Hibernate
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                Long id = (Long) session.save(salesForm);
                transaction.commit();
            }

            // Redirect to a success page
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // Handle errors and redirect to an error page
            response.sendRedirect("error.jsp");
        }
    }
}
