import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.nitish.freecharge.resources.CountResource;

public class MyApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(CountResource.class);
        return s;
    }
}
