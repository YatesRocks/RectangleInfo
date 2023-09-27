import java.io.InputStreamReader;
import java.util.function.Function;
import java.io.BufferedReader;

public class Main {
    private static <T> T get_valid_input(String prompt, Function<String, T> parser) {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print(prompt);
            try {
                String input = scan.readLine();
                return parser.apply(input);
            } catch (NumberFormatException e) {
                System.err.println(e); // TODO: Use logger instead of sys err
                System.out.println("Error parsing input. Please try again.");
            } catch (Exception e) {
                System.err.println("Error occurred: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        double length = get_valid_input("Enter your rectangles length: ", Double::parseDouble);
        double width = get_valid_input("Enter your rectangles width: ", Double::parseDouble);
        double area = length * width;
        double perimeter = (length * width) * 2;
        double diagonal = Math.sqrt(Math.pow(length, 2.) + Math.pow(width, 2.));
        System.out.println("Area: " + area + "; Perimeter: " + perimeter + "; Diagonal: " + diagonal + ";");
    }
}