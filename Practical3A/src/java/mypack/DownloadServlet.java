package mypack;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DownloadServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String fileName
                = request.getParameter("file");

        String filePath
                = "C:\\uploads\\" + fileName;

        File file = new File(filePath);

        response.setContentType(
                "application/octet-stream");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=\""
                + file.getName() + "\"");

        FileInputStream fis
                = new FileInputStream(file);

        OutputStream os
                = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead
                = fis.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }

        fis.close();
        os.close();
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
