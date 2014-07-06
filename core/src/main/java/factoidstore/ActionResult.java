package factoidstore;

import org.vertx.java.core.json.*;

/**
 * Created by kurt on 6/07/14.
 */
enum ActionResult {

   OK(new JsonObject().putString(ActionResult.RESULT, "action ok")),
   FAILED(new JsonObject().putString(ActionResult.RESULT, "action failed, unknown reason")),
   VALIDATION_ERROR(new JsonObject().putString(ActionResult.RESULT, "validation failed"));

   private JsonObject json;

   private ActionResult(JsonObject json) {
      this.json = json;
   }

   JsonObject asJson() {
      return json;
   }


   public static final String RESULT = "result";
}
