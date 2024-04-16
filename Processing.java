import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Processing{
    
    public static int textSearch(char[] pattern, char[] text)
    {
          return 0;
    }

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/varungole/Desktop/Interactive Brokers/Java-Practice/file-processing/test.txt");
    
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    
            // Count capital and small letters
            long capitalChars = br.lines()
                                  .flatMapToInt(CharSequence::chars)
                                  .filter(Character::isUpperCase)
                                  .count();
    
            long smallChars = br.lines()
                                .flatMapToInt(CharSequence::chars)
                                .filter(Character::isLowerCase) // Filter for lowercase characters
                                .count();
    
            System.out.println("Total Capital letters in the text are " + capitalChars);
            System.out.println("Total Small letters in the text are " + smallChars);
    
            // Search for a pattern
            System.out.println("Please enter the string to find out if there is a match");
            Scanner sc = new Scanner(System.in);
            String check = sc.nextLine();
    
            // Convert the lines to a single string
            String text = br.lines().collect(Collectors.joining(System.lineSeparator()));
    
            // Perform text searching
            int index = textSearch(check.toCharArray(), text.toCharArray());
            if (index != -1) {
                System.out.println("Pattern found at index: " + index);
            } else {
                System.out.println("Pattern not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}