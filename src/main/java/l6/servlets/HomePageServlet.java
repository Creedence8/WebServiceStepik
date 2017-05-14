package l6.servlets;

import l6.resources.ResourceServerController;
import l6.resources.ResourceService;
import l6.resources.TestResource;
import l6.sax.ReadXMLFileSAX;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * @author a.akbashev
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class HomePageServlet extends HttpServlet {
    static final Logger logger = LogManager.getLogger(HomePageServlet.class.getName());
    public static final String PAGE_URL = "/resources";
    private final ResourceService resourceService;

    public HomePageServlet(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        String path = request.getParameter("path");

        TestResource testResource =(TestResource) ReadXMLFileSAX.readXML("./"+path);

        try {
            ResourceServerController resourceServerController = new ResourceServerController(testResource);
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName name = new ObjectName("Admin:type=ResourceServerController");
            mbs.registerMBean(resourceServerController, name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.getWriter().print(path+"\n"+testResource);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);

    }
}
