import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class email_extraction {
    public static void main(String[] args) {
        try {
            File obj = new File("C:\\Users\\amendu\\Downloads\\TestMail.eml");
            Scanner scan = new Scanner(new FileReader(obj));
            while(scan.hasNextLine()){
                String s = scan.nextLine();
                String[] arr1 = s.split(" ");
                if(Objects.equals(arr1[0],"To:")){
                    System.out.println(s);
                }
                if(Objects.equals(arr1[0],"From:")){
                    System.out.println(s);
                }
                if(Objects.equals(arr1[0],"Subject:")){
                    System.out.println(s);
                }
                if(Objects.equals(s,"--0000000000002c980605e087c8b5")){
                    scan.nextLine();
                    String s1 = scan.nextLine();
                    while(!s1.equals("--0000000000002c980605e087c8b5")){
                        System.out.println(s1);
                        s1 = scan.nextLine();
                    }
                    break;
                }
            }

            }
        catch (IOException e){
            e.printStackTrace();;
        }
    }
}
