package factoidstore;

import java.io.*;
import java.time.*;

/**
 * Created by kurt on 26/06/14.
 */
public class FactoidData
      implements Serializable
{

   private long entity;

   private String value;

   private long timestamp;


   FactoidData(long entity, String value) {
      this.entity = entity;
      this.value = value;
      this.timestamp = Instant.now().toEpochMilli();
   }
}
