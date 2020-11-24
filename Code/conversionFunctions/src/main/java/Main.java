import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Press 1 for binary to denary");
            System.out.println("Press 2 for denary to binary");
            System.out.println("Press 3 for binary to hexadecimal");
            System.out.println("Press 4 for hexadecimal to binary");
            System.out.println("Press 5 for hexadecimal to denary");
            System.out.println("Press 5 for denary to hexadecimal");
            String choice = input.nextLine();
            if (choice.equals("1")) {
                System.out.println("Enter your binary number:");
                String binToDen = input.nextLine();
                System.out.println(binToDen + " in denary is " + binaryToDenary(binToDen));
            }
            if (choice.equals("2")) {
                System.out.println("Enter your denary number:");
                int denToBin = Integer.parseInt(input.nextLine());
                System.out.println(denToBin + " in binary is " + denaryToBinary(denToBin));
            }
            if (choice.equals("3")) {
                System.out.println("Enter your binary number:");
                String binToHex = input.nextLine();
                System.out.println(binToHex + " in hexadecimal is " + binaryToHex(binToHex));
            }
            if (choice.equals("4")) {
                System.out.println("Enter your hexadecimal number");
                String hexToBin = input.nextLine();
                System.out.println(hexToBin+" in binary is "+hexToBinary(hexToBin));
            }
            if (choice.equals("5")) {
                System.out.println("Enter your hexadecimal number:");
                String hexToDen = input.nextLine();
                System.out.println(hexToDen+" in denary is "+hexToDenary(hexToDen));
            }
            if (choice.equals("6")) {
                System.out.println("Enter your denary number:");
                String denToHex = input.nextLine();
                System.out.println(denToHex+" in hexadecimal is "+denToHex(denToHex));
            }
            System.out.println("Press enter to continue");
            input.nextLine();
        }
    }

    public static String hexToBinary(String hex){
        int length = hex.length();
        int x = 0;
        String hexOut = "";
        String binaryOut = "";
        for (int i = 0; i < hex.length(); i++) {
            if (hex.charAt(x) == 'A') {hexOut = "10";}
            else if (hex.charAt(x) == 'B') {hexOut = "11";}
            else if (hex.charAt(x) == 'C') {hexOut = "12";}
            else if (hex.charAt(x) == 'D') {hexOut = "13";}
            else if (hex.charAt(x) == 'E') {hexOut = "14";}
            else if (hex.charAt(x) == 'F') {hexOut = "15";}
            else {hexOut = Character.toString(hex.charAt(x));}
            x++;
            String binaryTemp = denaryToBinary(Integer.parseInt(hexOut));
            binaryOut += binaryTemp.substring(4,8);
        }
        return binaryOut;
    }

    public static String hexToDenary(String hex){
        return binaryToDenary(hexToBinary(hex));
    }

    public static String binaryToHex(String binary) {
        String hex = "";
        int length = binary.length()/4;
        int x = 0;
        String[] hexArray = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        while (length > 0) {
            String binaryShort = "";
            for (int i = 0; i < 4; i++){
                String binaryChar = Character.toString(binary.charAt(x));
                binaryShort += binaryChar;
                x++;
            }
            hex += hexArray[Integer.parseInt(binaryToDenary("0000"+binaryShort))];
            binaryShort = "";
            length -= 1;
        }
        return hex;
    }

    public static String denaryToBinary(int denary){
        String binary = "";
        int x = 128;
        for (int i = 0; i < 8; i++) {
            if (denary < x) {
                x = x/2;
                binary = binary+"0";
            } else {
                denary -= x;
                binary = binary+"1";
                x = x/2;
            }
        }
        return (binary);
    }

    public static String binaryToDenary(String binary) {
        int total = 0;
        binary = reverse(binary);
        int x = 0;
        int value = 1;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(x) == '1') {
                for (int y = x; y > 0; y--) {
                    value = value*2;
                }
                total += value;
                value=1;
            }
            x++;
        }
        return(Integer.toString(total));
    }

    public static String reverse(String input) {
        if (input == null) {
            return input;
        }
        String output = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            output = output + input.charAt(i);
        }
        return output;
    }

}

