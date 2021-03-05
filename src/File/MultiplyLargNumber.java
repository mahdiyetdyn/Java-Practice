package File;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MultiplyLargNumber {
    private static final ArrayList<String> List = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        // String s = multiply("123456789987654","123456789987654");
        // System.out.println(s);
        // readNumber("E:\\projects\\input.txt");
        // writeText(List.get(0) ,"E:\\projects\\output.txt");
        System.out.println("Please enter your file address :");
        Scanner scanner = new Scanner(System.in);
        String fileAddressInput = scanner.nextLine();
        readNumber(fileAddressInput);
        String answer = multiply(List.get(0), List.get(1));
        System.out.println("Please enter the file address in which you want to write the answer :");
        String fileAddressOutput = scanner.nextLine();
        writeText(answer, fileAddressOutput);
        System.out.println("mission done ;)");


    }

    private static void writeText(String text, String fileName) {
        try {
            File file = new File(fileName);
            FileWriter Writer = new FileWriter(file);
            Writer.write(text);
            Writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void readNumber(String fileName) throws IOException {
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                List.add(line);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static String multiply(String num1, String num2) {

        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0)
            return "0";

        int[] result = new int[len1 + len2];

        int i_n1 = 0;
        int i_n2 = 0;

        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            int n1 = num1.charAt(i) - '0';

            i_n2 = 0;

            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = n1 * n2 + result[i_n1 + i_n2] + carry;
                carry = sum / 10;

                result[i_n1 + i_n2] = sum % 10;

                i_n2++;
            }

            if (carry > 0)
                result[i_n1 + i_n2] += carry;

            i_n1++;
        }

        int i = result.length - 1;
        while (i >= 0 && result[i] == 0)
            i--;

        if (i == -1)
            return "0";

        String s = "";

        while (i >= 0)
            s += (result[i--]);

        return s;
    }

}
