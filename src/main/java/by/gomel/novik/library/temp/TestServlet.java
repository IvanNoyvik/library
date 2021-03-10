package by.gomel.novik.library.temp;

import by.gomel.novik.library.model.Book;
import by.gomel.novik.library.persistance.connection.Connector;
import by.gomel.novik.library.persistance.dao.bookimpl.BookJdbcDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "TestServlet", urlPatterns = "/test")
@MultipartConfig
public class TestServlet extends HttpServlet {

    BookJdbcDao bookJdbcDao = new BookJdbcDao();
    private static final Connector CONNECTOR = Connector.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        try {


            Long id = Long.parseLong(request.getParameter("id"));

            Part part = request.getPart("file");
            try (InputStream inputStream = part.getInputStream()){

                Book book = bookJdbcDao.addImage(id, inputStream);

            }


            response.sendRedirect("/main.jsp");
        } catch (Exception e) {
            e.printStackTrace();
//            request.setAttribute("errorMessage", "Error: " + e.getMessage());
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/test.jsp");
//            dispatcher.forward(request, response);
        } finally {

        }
    }


//    public void printNames(HttpServletRequest request) throws IOException, ServletException {
//        for(Part part : request.getParts()){
//            System.out.println("PN: "+ part.getName());
//            Collection<String> headers = part.getHeaders("content-disposition");
//            if (headers == null)
//                continue;
//            for(String header : headers){
//                System.out.println("CDH: " + header);
//            }
//        }
//    }


//    private String extractFileName(Part part) {
//        // form-data; name="file"; filename="C:\file1.zip"
//        // form-data; name="file"; filename="C:\Note\file2.zip"
//        String contentDisp = part.getHeader("content-disposition");
//        String[] items = contentDisp.split(";");
//        for (String s : items) {
//            if (s.trim().startsWith("filename")) {
//                // C:\file1.zip
//                // C:\Note\file2.zip
//                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
//                clientFileName = clientFileName.replace("\\", "/");
//                int i = clientFileName.lastIndexOf('/');
//                // file1.zip
//                // file2.zip
//                return clientFileName.substring(i + 1);
//            }
//        }
//        return null;
//    }



    private void writeToDB(Long id, InputStream is, Connection connection) throws SQLException {

        String sql = "update books set image = ? where id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setLong(2, id);
        pstm.setBlob(1, is);
        pstm.executeUpdate();
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Book book = bookJdbcDao.findById(2);
        request.setAttribute("book", book);
        getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
    }
}
