import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class HelloJava {
    public static void main(String[] args) {
        System.out.println("Visal");
        System.out.println(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy").format(LocalDate.now()));
    }
}
