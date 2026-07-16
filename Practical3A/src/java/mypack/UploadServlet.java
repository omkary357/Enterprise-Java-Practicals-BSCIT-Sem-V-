package mypack;

import com.oreilly.servlet.MultipartRequest;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class UploadServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String path
                = "C:\\uploads";

        MultipartRequest mr
                = new MultipartRequest(request,
                        path,
                        10 * 1024 * 1024);

        String filename
                = mr.getFilesystemName("file");

        out.println("<h2>File Uploaded Successfully</h2>");

        out.println("<a href='DownloadServlet?file="
                + filename
                + "'>Download File</a>");
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
