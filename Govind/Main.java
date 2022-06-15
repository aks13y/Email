package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\gsehrawat\\Downloads\\TestMail.eml");
        String text = new String();

        //"to", "from", "toEmail", "fromEmail" "subject" and "body"
        String to=null, from=null, toEmail=null, fromEmail=null, subject=null, body=null, boundaryValue=null;

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String temp = null;
            temp = br.readLine();
            String[] line_array;
            while ( temp!= null) {
                line_array = temp.split(":");
                if(line_array[0].equals("To")){
                    to = line_array[1].split("<")[0].substring(1, line_array[1].split("<")[0].length()-1);
                    toEmail = line_array[1].split("<")[1].substring(0, line_array[1].split("<")[1].length()-1);
                } else if (line_array[0].equals("From")) {
                    from = line_array[1].split("<")[0].substring(1, line_array[1].split("<")[0].length()-1);
                    fromEmail = line_array[1].split("<")[1].substring(0, line_array[1].split("<")[1].length()-1);
                } else if (line_array[0].equals("Subject")) {
                    subject = line_array[1].substring(1);
                } else if (line_array[0].equals("Content-Type")) {
                    if(boundaryValue==null && line_array[1].split(";")[0].split("/")[1].equals("alternative")){
                        try {
                            boundaryValue = line_array[1].split("=")[1].substring(1, line_array[1].split("=")[1].length()-1);
                        } catch (Exception e){
                            System.out.println("boundary value comes later");
                        }
                    }
                }

                text += temp + "\n";
                temp = br.readLine();
            }
//            System.out.println(text);
        } catch (Exception e) {
            e.getMessage();
        }

        String[] textArrayByNewLine;
        textArrayByNewLine = text.split("\n");

        int flag = 0;
        for(int i=0; i< textArrayByNewLine.length; i++){
            if(textArrayByNewLine[i].equals("--" + boundaryValue)){
                flag++;
                i+=2;
            }
            if (flag==1){
                if(body== null){
                    body = textArrayByNewLine[i] + "\n";;
                }
                else{
                    body +=textArrayByNewLine[i] + "\n";
                }
            } else if (flag==2) {
                break;
            }
        }


        System.out.println("To: " + to);
        System.out.println("To Email: " + toEmail);

        System.out.println("From: " + to);
        System.out.println("From Email: " + fromEmail);

        System.out.println("Subject: " + subject);

        System.out.println("Body: \n" + body);

    }
}