import java.util.Scanner;           // import scanner to use


class Main                  // Main class for hex to dec conversion
{
    public static long hexToDex(String hexNumber)       // method to which the user input hex will be cast to
    {
        String hexString = "0123456789ABCDEF";      // string variable to compare substring
        hexNumber = hexNumber.toUpperCase();        // changes letters to uppercase
        long totalDex = 0;
        for(int hexPlace = 0; hexPlace < hexNumber.length(); hexPlace++)    //for loop will start at 0 and run
        {                                                                   // until the count of char position is less than the length of string
            char hex = hexNumber.charAt(hexPlace);       //this method will isolate character from position 0- final char in string                   
            int decVal = hexString.indexOf(hex);        //this will assign decimal value of isolated hex char with position from hexString
            int powerCount = hexPlace + 1;              
            int power = hexNumber.length()-powerCount;                      // assigns power by removing 1 from the position R to L to accomodate 0 start
            totalDex = (long)(Math.pow(16,power) * decVal)+ totalDex;       // sum using loop and each new char value
        }
        return totalDex;            // returns decimal sum to method
    }

    public static void main(String[] args)
    {
        String userHex;                     // main will input user string and send to method for conversion
        long dexNumber;
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter a hexadecimal number: ");
        userHex = scnr.nextLine();
        userHex = userHex.replace("0x","");     //removes 0x to improve method readability
        dexNumber = hexToDex(userHex);
        System.out.print("Your number is " + dexNumber + " in decimal");

    }
}
