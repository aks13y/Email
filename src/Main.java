import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner;
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\nbhukya\\Downloads\\TestMail.eml");
        scanner = new Scanner(file);
        boolean quit = false;
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            //int index = 0;
            if(str.indexOf("Subject:") > -1){
                System.out.println(str);
            } else if (str.indexOf("To:") > -1) {
                System.out.println(str);
            } else if (str.indexOf("From:") > -1) {
                System.out.println(str);
            }else if(str.indexOf("--0000000000002c980605e087c8b5") > -1){
                str = scanner.nextLine();
                str = scanner.nextLine();
                quit = false;
                while (scanner.hasNextLine() && !quit){
                    System.out.println(str);
                    str = scanner.nextLine();
                    if (str.indexOf("--0000000000002c980605e087c8b5") > -1)
                        quit = true;
                }
                if(quit){
                    break;
                }
            }
        }
    }
}
