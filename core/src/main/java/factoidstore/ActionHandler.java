package factoidstore;

import de.ruedigermoeller.serialization.*;
import org.vertx.java.core.eventbus.*;
import org.vertx.java.core.json.*;

/**
 * Created by kurt on 6/07/14.
 */
abstract class ActionHandler {

   protected final FSTConfiguration fstConf = ServiceLocator.instance().fstConfiguration();

   protected ActionHandler() {

   }

   protected abstract ActionResult handle(Message<JsonObject> message);
}
