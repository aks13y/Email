import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
public class parse {
    public static void main(String[] args){
        try {
            File myObj = new File("C:\\Users\\vkeshetti\\IdeaProjects\\mailparse\\src\\TestMail.eml");
            Scanner myReader = new Scanner(myObj);
            int flag=0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words = data.split(" ");
                if(Objects.equals(words[0], "From:") || Objects.equals(words[0], "To:") || Objects.equals(words[0], "Subject:")){
                    System.out.println(data);
                }
                String boundary = "--0000000000002c980605e087c8b5";
                if(data.equals(boundary)){
                    flag = flag + 1;
                    continue;
                }
                if(flag == 1){
                    if(Objects.equals(words[0], "Content-Type:")){
                        continue;
                    }
                    System.out.println(data);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
