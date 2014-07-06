package factoidstore;

/**
 * Created by kurt on 6/07/14.
 */
public enum Channel {
   REQUEST_ACTION("factoidstore.core.actionrequest"),
   ACTION_EXECUTED("factoidstore.core.actionexecuted->");

   private String channel;

   private Channel(String channel) {
      this.channel = channel;
   }

   public String asString(String action) {
      return channel + action;
   }
}
