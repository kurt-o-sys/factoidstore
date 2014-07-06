package factoidstore;

import de.ruedigermoeller.serialization.*;

/**
 * Created by kurt on 6/07/14.
 */
public class ServiceLocator {

   private FSTConfiguration fstConf = FSTConfiguration.createDefaultConfiguration();


   private static class Holder {

      private static final ServiceLocator INSTANCE = new ServiceLocator();
   }

   public static ServiceLocator instance() {
      return Holder.INSTANCE;
   }

   private ServiceLocator() {
      fstConf.registerClass(FactoidData.class);
   }

   public FSTConfiguration fstConfiguration() {
      return fstConf;
   }

}
