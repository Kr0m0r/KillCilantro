import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class KillCilantro {

   public static String killCilantro(String text, ArrayList<ArrayList<String>> changes, int numPairs) {
      for (int i = 0; i < numPairs; i++) {
         int index = 0;
         String killWord = changes.get(i).get(0);
         String newWord = changes.get(i).get(1);
         while (text.indexOf(killWord) >= 0) {
            index = text.indexOf(killWord);
            text = text.substring(0, index) + newWord + text.substring(index + killWord.length(), text.length());
            index = text.indexOf(killWord);
         }
         
      }
      return text;
   }
   
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("How many words do you want to replace?");
      int numKills = input.nextInt();
      input.nextLine();

      ArrayList<ArrayList<String>> words = new ArrayList<>();
      for (int i = 0; i < numKills; i++) {
         words.add(new ArrayList<>());
      }
      for (int j = 0; j < numKills; j++) {
         System.out.println("What word do you want to replace? (" + (j + 1) + ")");
         words.get(j).add(input.nextLine());
         
         System.out.println("What word do you want to change it to?");
         words.get(j).add(input.nextLine());
      }
      
      System.out.println(killCilantro("testcilantrotest", words, numKills));
      System.out.println(killCilantro("cilantrotest", words, numKills));
      System.out.println(killCilantro("nothinghere", words, numKills));
      System.out.println(killCilantro("testcilantro", words, numKills));
      System.out.println(killCilantro("cilantrocilantrocilantro", words, numKills));
      System.out.println("\nWhat sentence do you want to replace?");
      System.out.println(killCilantro(input.nextLine(), words, numKills));
   }
   
}