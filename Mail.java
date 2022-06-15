import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mail {
    public static void main(String args []) {
        File obj = new File("C:\\Users\\hagrawal\\Downloads\\TestMail.eml");
        Scanner sc = null;
        try {
            sc = new Scanner(obj);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //  while(sc.hasNextLine()){
        //    System.out.println(sc.nextLine());
        String bodystart = "--0000000000002c980605e087c8b5";
        int flag = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int a = s.indexOf("From");
            int b = s.indexOf("To");
            int c = s.indexOf("Subject");
            if (a == 0) {
                System.out.println(s.substring(a));
            }
            if (b == 0) {
                System.out.println(s.substring(b));
            }
            if (c == 0) {
                System.out.println(s.substring((c)));

            }
            if (s.equals(bodystart)) {
                System.out.println("body: ");
                if (flag == 0) {
                    String bodyline = "";
                    bodyline = sc.nextLine();
                    boolean f = false;
                    while (!(bodyline.equals(bodystart))) {
                        if (f == false) {
                            f = true;
                            bodyline = sc.nextLine();
                            continue;
                        }
                        System.out.println(bodyline);
                        bodyline = sc.nextLine();
                    }
                }
                flag = 1;
            }
        }
    }
}

