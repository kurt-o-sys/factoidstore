package factoidstore;

import org.vertx.java.core.eventbus.*;
import org.vertx.java.core.json.*;
import org.vertx.java.platform.*;

import java.util.*;

public class ActionExecutor
      extends Verticle
{

   private final Map<String, ActionHandler> handlerMap = new HashMap<String, ActionHandler>();

   public void start() {
      handlerMap.put("add", new AddHandler());
      handlerMap.put("read", new ReadHandler());
      EventBus eb = vertx.eventBus();

      for (Map.Entry<String, ActionHandler> entry : handlerMap.entrySet()) {
         eb.registerHandler(Channel.REQUEST_ACTION.asString(entry.getKey()),
               (Message<JsonObject> message) -> {
                  JsonObject action = message.body();
                  if (entry.getValue().handle(message).equals(ActionResult.OK)) {
                     eb.publish(Channel.ACTION_EXECUTED.asString(action.getString("action")),
                           action.getObject("data"));
                     message.reply("ok");
                  }
               });
      }
      container.logger().info("ActionExecutor started");
   }
}
