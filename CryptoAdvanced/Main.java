/*Created By: Margie Ruffin
  Networks & Security


  Part 1 -- Due: October 28 at 11:59 pm
  Encryption & Decryption
  Double Encryption and Decryption



  Part 2  -- Due: November 4 at 11:59 pm
  Cryptanalysis



  This program performs decryption of words without knowing the key
  beforehand. It goes through 26 possible operations (all 26
  possible alphabet shifts) and compares the strings from each shift to
  the strings in the Encryption.txt file.

  The result of the program is the unencrypted text along with the key used to
  decrypt the text.


 */



import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;




public class Main {

    public static void main(String[] args) {

        //Add the standard alphabet to a char array
        char[] alphabet = new char[26];
        int index = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet[index++] = c;
        }


        //Create array to hold words from the list
        ArrayList<String> wordList2 = new ArrayList<String>();


        String message;

        //Create a Scanner to take in input
        Scanner input = new Scanner(System.in);

        //Ask user for the ciphertext they want to decrypt
        char[] decryptMessageList;

        System.out.println("What is the message you want to decrypt? ");
        message = input.nextLine();


        //Add ciphertext to a char array so that you may iterate through it
        decryptMessageList = message.toLowerCase().toCharArray();
        int length = decryptMessageList.length;


        try {


            //Initialize variables
            String line;
            String finalString="";
            String[] splitString;
            StringBuilder str = new StringBuilder();
            int realKey = 0; 



            //Open the file and read it into an ArrayList
            File wordList = new File("/Users/margieruffin/Desktop/Networks and Security/CryptographyIII/src/Word_list_encryption_lab.txt");

            BufferedReader br = null;
            br = new BufferedReader(new FileReader(wordList));
            while ((line = br.readLine()) != null) {

                wordList2.add(line);

            }
            br.close();



            //final message char array
            char[] finalMessage = new char[length];

            //create a counter for the key starting at 0
            int key = 0;

            //This will go through all likely options
            while (key < 26) {

                    //Standard procedure for decryption
                    for (int i = 0; i < decryptMessageList.length; i++) {


                        if (Character.isLetter(decryptMessageList[i])) {


                            for (int j = 0; j < alphabet.length; j++) {


                                if (decryptMessageList[i] == alphabet[j]) {


                                    int index2 = (j - key) % 26;

                                    if (index2 < 0) {


                                        index2 = 26 + index2;
                                    }

                                    finalMessage[i] = alphabet[index2];
                                }
                            }
                        }

                        //check to see if it is a space
                        else if (decryptMessageList[i] == ' ') {
                            finalMessage[i] = ' ';
                        }

                    }



                    //Turn the finalMessage into a String
                    finalString = new String(finalMessage);


                    //split the string so that we can compare each word
                    splitString = finalString.split(" ");


                    //Determine if the words from the decoded input for this specified key
                    //match any of the words in the .txt
                    //print out the decoded statement and the key

                    int j = 0;

                    for (String i: splitString) {
                        for (String k : wordList2) {
                            if(i.equals(k)){

                                str.append(k).append(" ");
                                realKey = key; 

                            }

                        }
                        
                    }

                key++;
                }





            System.out.println();
            System.out.println("Your decrypted message is: " + str + '\n' + "The key for the message " +
                    "is: " + (realKey));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



