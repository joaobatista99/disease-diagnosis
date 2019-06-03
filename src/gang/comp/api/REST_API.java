package gang.comp.api;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class REST_API extends Application implements IREST_API{

    public static void startServer(String url, int port){
        final Component component = new Component();
        // tell the interface to listen to http:12345
        component.getServers().add(Protocol.HTTP, port);
        // create the application, giving it the component's context
        // technically, its child context, which is a protected version of its context
        ServerMain server = new ServerMain(component.getContext().createChildContext());
        // attach the application to the interface
        component.getDefaultHost().attach(server);
        // go to town
        try {
            component.start();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public REST_API(Context context){
        super(context);
    }

    public Restlet createRoot() {
        // create a router to route the incoming queries
        Router router = new Router(getContext().createChildContext());
        // attach your resource here
        router.attach("/sample/time", CurrentTimeResource.class);
        // return the router.
        return router;
    }
}
