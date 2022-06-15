import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class GetMailMetaData {
    public static void main(String[] args) throws  IOException {
        File f = new File("C:\\Users\\nbejgaon\\Downloads\\TestMail.eml");
        Scanner scan = new Scanner(f);
        int count = 0;
        while(scan.hasNextLine()){
            String s = scan.nextLine();
            String[] arr = s.split(" ");
            if(Objects.equals(arr[0], "To:")){
                System.out.println(s);
            }
            if(Objects.equals(arr[0], "From:")){
                System.out.println(s);
            }
            if(Objects.equals(arr[0], "Subject:")){
                System.out.println(s);
            }
            if("--0000000000002c980605e087c8b5".equals(s)){
                count++;
                s = scan.nextLine();
                s = scan.nextLine();
            }
            if(count==1){
                System.out.println(s);
            }
        }
    }

}