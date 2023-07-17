import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 int[] arr = {10, 10, 5, 12, 3, 5};
	        HashMap<Integer, Integer> occurrences = countOccurrences(arr);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sentence: ");
		String user = sc.nextLine();
		 String v = "aeiou";
		 int count = 0;
		 for (int i = 0; i < user.length(); i++) {
			 if (v.contains(Character.toString(user.charAt(i)))) {
	                count++;
	            }
	        }
	        
	        System.out.println("Number of vowels: " + count);
	        String result = replaceConsonantsWithAsterisk(user);
	        System.out.println("Modified string: " + result);
	        
	        int wordCount = countWords(user);
	        System.out.println("Number of words in the sentence: " + wordCount);
	        
	        System.out.println("Enter the number of places to rotate: ");
	        int counts = sc.nextInt();

	        String rotatedWord = rotateString(user, counts);
	        System.out.println("Output: " + rotatedWord);
	        String[] words = user.split("\\s+");
	        StringBuilder switchedSentence = new StringBuilder(user);

	        int sCount = 0, yCount = 0;
	        for (String word : words) {
	            if (word.endsWith("s")) {
	                sCount++;
	                if (sCount == 1) {
	                    switchedSentence.replace(user.indexOf(word), user.indexOf(word) + word.length(), "any");
	                }
	            } else if (word.endsWith("y")) {
	                yCount++;
	                if (yCount == 1) {
	                    switchedSentence.replace(user.indexOf(word), user.indexOf(word) + word.length(), "is");
	                }
	            }
	        }

	        System.out.println("Output:");
	        System.out.println(switchedSentence);
	        String uniqueChars = getUniqueCharacters(user);
	        System.out.println("Output: " + uniqueChars);
	        System.out.println("Output:");
	        for (int num : occurrences.keySet()) {
	            System.out.println(num + ": " + occurrences.get(num));
	        }
	    }
		 


	
	




    public static int countWords(String sentence) {
       
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }
    



    public static String replaceConsonantsWithAsterisk(String str) {
       
        String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (consonants.indexOf(ch) != -1) {
                result.append("*");
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
    public static String rotateString(String str, int count) {
        count = count % str.length();
        return str.substring(str.length() - count) + str.substring(0, str.length() - count);
    }
 

        public static HashMap<Integer, Integer> countOccurrences(int[] arr) {
            HashMap<Integer, Integer> occurrences = new HashMap<>();

            for (int num : arr) {
                occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
            }

            return occurrences;
        }
    
    

  

        public static String getUniqueCharacters(String str) {
            HashSet<Character> uniqueChars = new HashSet<>();

            StringBuilder result = new StringBuilder();
            for (char ch : str.toCharArray()) {
                if (uniqueChars.add(ch)) {
                    result.append(ch);
                }
            }

            return result.toString();
        }
}

