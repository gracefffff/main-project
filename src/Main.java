import it.sevenbits.Formatter;

public class Main {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        String input =  "aaa { bbbb; ccc;}" ;
        System.out.println(formatter.format(input));
    }
}