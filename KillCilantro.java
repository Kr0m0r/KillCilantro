public class KillCilantro {

   public static String killCilantro(String text) {
   
      int index = 0;
      String killWord = "cilantro";
      while (text.indexOf(killWord) >= 0) {
         index = text.indexOf(killWord);
         text = text.substring(0, index) + "parsley" + text.substring(index + killWord.length(), text.length());
         index = text.indexOf(killWord);
      }
      return text;
   }
   
   public static void main(String[] args) {
      System.out.println(killCilantro("testcilantrotest"));
      System.out.println(killCilantro("cilantrotest"));
      System.out.println(killCilantro("nothinghere"));
      System.out.println(killCilantro("testcilantro"));
      System.out.println(killCilantro("cilantrocilantrocilantro"));

   }
   
}