package mypack;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletResponse;

public class MyReadListener implements ReadListener {

    private ServletInputStream input;
    private AsyncContext asyncContext;
    private HttpServletResponse response;

    private StringBuilder data = new StringBuilder();

    public MyReadListener(ServletInputStream input,
            AsyncContext asyncContext,
            HttpServletResponse response) {

        this.input = input;
        this.asyncContext = asyncContext;
        this.response = response;
    }

    @Override
    public void onDataAvailable() throws IOException {

        byte[] buffer = new byte[1024];

        int len;

        while (input.isReady() &&
                (len = input.read(buffer)) != -1) {

            data.append(new String(buffer, 0, len));
        }
    }

    @Override
    public void onAllDataRead() throws IOException {

        response.getWriter().println("<html>");
        response.getWriter().println("<body>");

        response.getWriter().println("<h2>Data Received Successfully</h2>");

        response.getWriter().println("<hr>");

        response.getWriter().println("<b>Entered Text :</b>");

        response.getWriter().println("<br><br>");

        response.getWriter().println(data.toString());

        response.getWriter().println("</body>");
        response.getWriter().println("</html>");

        asyncContext.complete();
    }

    @Override
    public void onError(Throwable t) {

        t.printStackTrace();

        asyncContext.complete();
    }
}