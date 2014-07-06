package factoidstore;

import de.ruedigermoeller.serialization.*;
import org.vertx.java.core.eventbus.*;
import org.vertx.java.core.json.*;

import java.io.*;
import java.util.*;

/**
 * Created by kurt on 6/07/14.
 */
public class ReadHandler extends ActionHandler {

   @Override
   protected ActionResult handle(Message<JsonObject> message) {
      try
      {
         List<FactoidData> list = new ArrayList<FactoidData>();
         FileInputStream stream = new FileInputStream(message.body().getString("attribute"));
         FSTObjectInput in = fstConf.getObjectInput(stream);
         while (in.available() > 0) {
            list.add((FactoidData) in.readObject(FactoidData.class));
         }
         stream.close();
         return ActionResult.OK;
      } catch (IOException e)
      {
         e.printStackTrace();
      } catch (Exception e)
      {
         e.printStackTrace();
      }
      return ActionResult.FAILED;
   }
}
