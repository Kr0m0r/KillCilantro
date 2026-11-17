import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class KillCilantro {

   public static String killCilantro(String text, ArrayList<ArrayList<String>> changes, int numPairs) {
      for (int i = 0; i < numPairs; i++) { //Repeats for each pair
         int index = 0;
         String killWord = changes.get(i).get(0); //First word in the pair
         String newWord = changes.get(i).get(1); //Second word in the pair
         for (int j = 0; j < (text.length() - killWord.length() + 1); j++) { //Repeats until the killWord would no longer fit in the string
            if (text.substring(j, j + killWord.length()).equalsIgnoreCase(killWord)) {
               text = text.substring(0, j) + newWord + text.substring(j + killWord.length(), text.length());
            }
         }
      }
      return text;
   }
   
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("How many words do you want to replace?");
      int numKills = input.nextInt();
      input.nextLine(); //Uses \n to prevent input errors

      ArrayList<ArrayList<String>> words = new ArrayList<>();
      for (int i = 0; i < numKills; i++) {
         words.add(new ArrayList<>()); //Creates pairs
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