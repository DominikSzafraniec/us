package config;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.logging.Logger;

@ApplicationPath("/api")
public class WebApplication extends Application {
    public static final Logger logger = Logger.getLogger(WebApplication.class.getName());
}
