import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class App {
	public static void main(String []gg){
		
		Server server = new Server(9999);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/wordcount/*");
        jerseyServlet.setInitOrder(1);
        jerseyServlet.setInitParameter("jersey.config.server.provider.packages","com.nitish.freecharge.resources");
        /*jerseyServlet.setInitParameter("jersey.config.server.provider.classnames",
                "org.glassfish.jersey.moxy.json.MoxyJsonFeature");*/
        try {
			System.out.println("Starting the server..");
			server.start();
			System.out.println("Server started");
			server.join();
		} catch(Exception e) {
			System.out.println("Exception in starting the server ");
			e.printStackTrace();
		}
	}
}
