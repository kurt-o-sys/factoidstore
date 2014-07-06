package factoidstore;

import de.ruedigermoeller.serialization.*;
import org.vertx.java.core.eventbus.*;
import org.vertx.java.core.json.*;

import java.io.*;
import java.util.*;

/**
 * Created by kurt on 6/07/14.
 */
class AddHandler extends ActionHandler {

   private Map<String, Validator> validatorMap = new HashMap<String, Validator>();

   @Override
   public ActionResult handle(Message<JsonObject> message) {
      final JsonObject data = message.body().getObject("data");
      final String attribute = data.getString("attribute");
      if (!validatorMap.containsKey(attribute) || validatorMap.get(attribute).validate()) {

         final FactoidData factoid = new FactoidData(data.getLong("entity"), data.getString("value"));
         try
         {
            FileOutputStream stream = new FileOutputStream(data.getString("attribute"), true);
            FSTObjectOutput out = fstConf.getObjectOutput(stream);
            out.writeObject(factoid, FactoidData.class);
            out.flush();
            stream.close();

            return ActionResult.OK;
         } catch (IOException e)
         {
            e.printStackTrace();
         }
      } else
      {
         return ActionResult.VALIDATION_ERROR;
      }
      return ActionResult.FAILED;
   }

   void addValidator(String key, Validator validator) {
      validatorMap.put(key, validator);
   }
}
