package client;



public class MessageObjectImplSer implements MessageObjectSer {
   static int number = 0;
   private int objNumber;

   public MessageObjectImplSer() {
      objNumber = number;
      System.out.println("MessageObject: Class Number is #" + number +
              " Object Number is #" + objNumber);
      number = number + 1;
   }

   public int getNumberFromObject() {
      return objNumber;
   }

   public int getNumberFromClass() {
      return number;
   }

   public void finalize() throws Throwable {
      super.finalize();
      System.out.println("MessageObject: Finalize for object #: " + objNumber);
   }
}
