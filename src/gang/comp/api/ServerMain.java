package gang.comp.api;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;


/**
 * This Application creates an HTTP server with a singple service
 * that tells you the current time.
 * @author corsiKa
 */
public class ServerMain extends Application {

    /**
     * The main method. If you don't know what a main method does, you
     * probably are not advanced enough for the rest of this tutorial.
     * @param args Command line args, completely ignored.
     * @throws Exception when something goes wrong. Yes I'm being lazy here.
     */
    public static void main(String...args) throws Exception {
        // create the interface to the outside world
        final Component component = new Component();
        // tell the interface to listen to http:12345
        component.getServers().add(Protocol.HTTP, 12345);
        // create the application, giving it the component's context
        // technically, its child context, which is a protected version of its context
        ServerMain server = new ServerMain(component.getContext().createChildContext());
        // attach the application to the interface
        component.getDefaultHost().attach(server);
        // go to town
        component.start();

    }

    // just your everyday chaining constructor
    public ServerMain(Context context) {
        super(context);
    }

    /** add hooks to your services - this will get called by the component when
     * it attaches the application to the component (I think... or somewhere in there
     * it magically gets called... or something...)
     */
    public Restlet createRoot() {
        // create a router to route the incoming queries
        Router router = new Router(getContext().createChildContext());
        // attach your resource here
        router.attach("/sample/time", CurrentTimeResource.class);
        // return the router.
        return router;
    }

}