import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestEmail {
    public static void main(String[] args) {

        String file = "C:\\Users\\kbadole\\Downloads\\TestMail.eml";
        String vals[] = new String[4];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean b=false;
            while ((line = br.readLine()) != null) {

                if (line.contains("To:"))
                {
                    vals[0]=line.substring(line.indexOf(':') + 1);
                }
                else if (line.contains("From:"))
                {
                    vals[1]=line.substring(line.lastIndexOf(":") + 1);
                }
                else if (line.contains("Subject:"))
                {
                    vals[2]=line.substring(line.lastIndexOf(":") + 1);
                }
                else if (line.equals("--0000000000002c980605e087c8b5") || b)
                {
                    break;

                }

            }
            line = br.readLine();
            line = br.readLine();
            while(line.indexOf("--0000000000002c980605e087c8b5")==-1)
            {
                if(vals[3]==null){
                    vals[3] = line+"\n";
                }
                else{
                    vals[3] += line +"\n";
                }

                line = br.readLine();
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e){
            System.out.println(e);
        }

        System.out.println("To : " + vals[0]);
        System.out.println("From : " + vals[1]);
        System.out.println("Subject : " + vals[2]);
        System.out.println("Body : " + vals[3]);
    }
}
