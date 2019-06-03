package comp.gang.api;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * A resource that responds to a get request and returns a StringRepresentaiton
 * of the current time in milliseconds from Epoch
 * @author corsiKa
 */
public class CurrentTimeResource extends ServerResource {

    @Get // add the get annotation so it knows this is for gets
    // method is pretty self explanatory
    public Representation getTime() {
        long now = System.currentTimeMillis();
        String nowstr = String.valueOf(now);
        Representation result = new StringRepresentation(nowstr);
        return result;
    }
}