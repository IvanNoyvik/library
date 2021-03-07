package by.gomel.novik.library.temp;

import by.gomel.novik.library.model.Order;
import by.gomel.novik.library.persistance.dao.OrderJdbcDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    OrderJdbcDao orderJdbcDao = new OrderJdbcDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        try {
            // Connection to Database
            // (See more in JDBC Tutorial).
            conn = ConnectionUtils.getMyConnection();
            conn.setAutoCommit(false);

            String description = request.getParameter("description");

            // Part list (multi files).
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                if (fileName != null && fileName.length() > 0) {
                    // File data
                    InputStream is = part.getInputStream();
                    // Write to file
                    this.writeToDB(conn, fileName, is, description);
                }
            }
            conn.commit();

            // Upload successfully!.
            response.sendRedirect(request.getContextPath() + "/uploadToDBResults");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsps/uploadToDB.jsp");
            dispatcher.forward(request, response);
        } finally {
            this.closeQuietly(conn);
        }
    }

    private String extractFileName(Part part) {
        // form-data; name="file"; filename="C:\file1.zip"
        // form-data; name="file"; filename="C:\Note\file2.zip"
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                // C:\file1.zip
                // C:\Note\file2.zip
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                clientFileName = clientFileName.replace("\\", "/");
                int i = clientFileName.lastIndexOf('/');
                // file1.zip
                // file2.zip
                return clientFileName.substring(i + 1);
            }
        }
        return null;
    }

    private Long getMaxAttachmentId(Connection conn) throws SQLException {
        String sql = "Select max(a.id) from Attachment a";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            long max = rs.getLong(1);
            return max;
        }
        return 0L;
    }

    private void writeToDB(Connection conn, String fileName, InputStream is, String description) throws SQLException {

        String sql = "Insert into Attachment(Id,File_Name,File_Data,Description) " //
                + " values (?,?,?,?) ";
        PreparedStatement pstm = conn.prepareStatement(sql);

        Long id = this.getMaxAttachmentId(conn) + 1;
        pstm.setLong(1, id);
        pstm.setString(2, fileName);
        pstm.setBlob(3, is);
        pstm.setString(4, description);
        pstm.executeUpdate();
    }

    private void closeQuietly(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int orders = orderJdbcDao.findNumberOfOverdueOrdersByUserId(1l);
        request.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
    }
}
