
/*

Created By: Margie Ruffin
Networks & Security


Part 1 -- Due: October 28 at 11:59 pm
    Encryption & Decryption
    Double Encryption and Decryption



Part 2  -- Due: November 4 at 11:59 pm
    Cryptanalysis



This program is used to encrypt and decrypt files using
the caesar cipher.
It takes as input from the user the cipher key, directions on
whether or not to encrypt or decrypt, an unencrypted message to be encrypted
or the encrypted cypher text to be decrypted.

This program can swtich modes between Double Encryption and Decryption
when prompted by the user




 */

import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        char[] alphabet = new char[26];
        int index = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet[index++] = c;
        }

        //System.out.println(alphabet);



        Scanner input = new Scanner(System.in);

        String Operation = "";
        String message = "";

        int keyValue;
        int keyValue2;


        //Menu

        System.out.println();
        System.out.println("Caesar Cipher Implementation");
        System.out.println("-------------------------------------");
        System.out.println();
        System.out.println("What operation would you like to preform");

        System.out.println("Encryption: Enter E");

        System.out.println("Decryption: Enter D");


        Operation = input.nextLine();

        Operation = Operation.toLowerCase();;



        //Encryption Path
        if(Operation.equals("e")){

            System.out.println("Would you like to enter into double encryption mode? Y/N");

            String answer = input.nextLine();
            answer = answer.toLowerCase();

            if(answer.equals("n")){


                char[] encryptMessageList;


                //ask for the message to encrypt
                System.out.println("What is the message you want to encrypt? Do not include " +
                        "special characters");
                message = input.nextLine();


                //remove and special characters just in case they were included
                message = message.replaceAll("/[&/#,+()$~%.'\":*?<>{}]/g", " ");


                //add the message to a char array
                encryptMessageList = message.toLowerCase().toCharArray();
                int length = encryptMessageList.length;


                //ask for the key value
                System.out.println("Please enter an encryption key, ex. 3: ");
                keyValue = input.nextInt();


                //call encryption function
                EncryptMessage(encryptMessageList, keyValue, alphabet, length);
            }


            else if(answer.equals("y")){

                char[] encryptMessageList;


                //ask for the message to encrypt
                System.out.println("What is the message you want to encrypt? Do not include " +
                        "special characters");
                message = input.nextLine();


                //remove and special characters just in case they were included
                message = message.replaceAll("/[&/#,+()$~%.'\":*?<>{}]/g", " ");


                //add the message to a char array
                encryptMessageList = message.toLowerCase().toCharArray();
                int length = encryptMessageList.length;


                //ask for the key value
                System.out.println("Please enter the first encryption key, ex. 3: ");
                keyValue = input.nextInt();



                System.out.println("Please enter the second encryption key, ex. 4: ");
                keyValue2 = input.nextInt();

                DoubleEncryptMessage(encryptMessageList, keyValue, keyValue2, alphabet, length);


            }




        }





        //Decryption Path
        else if (Operation.equals("d")){

            System.out.println("Would you like to enter into double decryption mode? Y/N");

            String answer = input.nextLine();
            answer = answer.toLowerCase();


            if(answer.equals("n")){

                char[] decryptMessageList;

                System.out.println("What is the message you want to decrypt? ");
                message = input.nextLine();

                message = message.replaceAll("/[&/#,+()$~%.'\":*?<>{}]/g", "");


                decryptMessageList = message.toLowerCase().toCharArray();
                int length = decryptMessageList.length;



                //ask for the key value
                System.out.println("Please enter a decryption key, ex. 3: ");
                keyValue = input.nextInt();


                //add the message to a char array
                DecryptMessage(decryptMessageList, keyValue, alphabet, length);

            }


            else if(answer.equals("y")){

                char[] decryptMessageList;

                System.out.println("What is the message you want to decrypt? ");
                message = input.nextLine();



                decryptMessageList = message.toLowerCase().toCharArray();
                int length = decryptMessageList.length;


                //ask for the key value
                System.out.println("Please enter the first decryption key, ex. 3: ");
                keyValue = input.nextInt();



                System.out.println("Please enter the second decryption key, ex. 4: ");
                keyValue2 = input.nextInt();

                DoubleDecryptMessage(decryptMessageList, keyValue, keyValue2, alphabet, length);



            }



        }



        else
        {
            System.out.println("You have entered an invalid input. Please restart the program");
        }


    }


    //Alphabet Reference

    //a b c d e f g h i j k l m n o p q r s t u v w x y z


    private static void EncryptMessage(char[] message, int key, char[] alphabet, int length){


        char [] finalMessage = new char[length];


        for( int i = 0; i < message.length; i++){

            //check to see if its a letter
            if(Character.isLetter(message[i])){

                for(int j=0; j < alphabet.length; j++){
                    if (message[i] == alphabet[j]){

                        //System.out.println(alphabet[(j + key)% 26]);

                        finalMessage[i] = alphabet[ (j + key)% 26];
                    }
                }

            }
            //check to see if it is a space
            else if(message[i] == ' '){

                finalMessage[i] = ' ';

            }
        }


        String OGmessage = new String(message);


        System.out.println("The text supplied is: " + OGmessage );
        System.out.println();

        for(int i = 0; i < message.length; i++){

            System.out.println("unencrypted letter: " + message[i] + " | " + "encrypted letter: " + finalMessage[i]);
            System.out.println();

        }

        //Print out the final Message
        String finalString = new String(finalMessage);

        System.out.println("Output Text: " + finalString);


    } // End Encryption



    private static void DecryptMessage(char[] message, int key, char[] alphabet, int length){


        //final message char array
        char [] finalMessage = new char[length];

        for( int i = 0; i < message.length; i++){


            //check to see if its a letter
            if(Character.isLetter(message[i])){

                for(int j = 0; j < alphabet.length; j++){

                    if (message[i] == alphabet[j]){



                        int index = (j - key) % 26;


                        if (index < 0){
                            index = 26 + index;
                        }

                        finalMessage[i] = alphabet[index];
                    }
                }

            }
            //check to see if it is a space
            else if(message[i] == ' '){

                finalMessage[i] = ' ';

            }
        }


        String OGmessage = new String(message);


        System.out.println("The text supplied is: " + OGmessage);
        System.out.println();

        for(int i = 0; i < message.length; i++){

            System.out.println("encrypted letter: " + message[i] + " | " + "unencrypted letter: " + finalMessage[i]);
            System.out.println();

        }

        //Print out the final Message
        String finalString = new String(finalMessage);

        System.out.println("Output Text: " + finalString);

    } // End Decryption



    private static void DoubleEncryptMessage(char[] message, int key1, int key2, char[] alphabet, int length){


        char [] finalMessage = new char[length];


        for( int i = 0; i < message.length; i++){

            if(i % 2 == 0){

                //check to see if its a letter
                if(Character.isLetter(message[i])){

                    for(int j=0; j < alphabet.length; j++){
                        if (message[i] == alphabet[j]){

                            //System.out.println(alphabet[(j + key)% 26]);

                            finalMessage[i] = alphabet[ (j + key1)% 26];
                        }
                    }

                }
                //check to see if it is a space
                else if(message[i] == ' '){

                    finalMessage[i] = ' ';

                }
            }
            if(i % 2 == 1){
                //check to see if its a letter
                if(Character.isLetter(message[i])){

                    for(int j=0; j < alphabet.length; j++){
                        if (message[i] == alphabet[j]){


                            finalMessage[i] = alphabet[ (j + key2)% 26];
                        }
                    }

                }
                //check to see if it is a space
                else if(message[i] == ' '){

                    finalMessage[i] = ' ';

                }
            }


        }


        String OGmessage = new String(message);


        System.out.println("The text supplied is: " + OGmessage );
        System.out.println();

        for(int i = 0; i < message.length; i++){

            System.out.println("unencrypted letter: " + message[i] + " | " + "encrypted letter: " + finalMessage[i]);
            System.out.println();

        }

        //Print out the final Message
        String finalString = new String(finalMessage);

        System.out.println("Output Text: " + finalString);


    } // End Double Encryption




    private static void DoubleDecryptMessage(char[] message, int key1, int key2, char[] alphabet, int length){

        //final message char array
        char [] finalMessage = new char[length];



        for( int i = 0; i < message.length; i++){

            if((i % 2) == 0){

                //check to see if its a letter
                if(Character.isLetter(message[i])){

                    for(int j = 0; j < alphabet.length; j++){

                        if (message[i] == alphabet[j]){

                            int index = (j - key1) % 26;


                            if (index < 0){
                                index = 26 + index;
                            }

                            finalMessage[i] = alphabet[index];
                        }
                    }

                }
                //check to see if it is a space
                else if(message[i] == ' '){

                    finalMessage[i] = ' ';

                }


            }
            if ((i % 2) == 1) {

                //check to see if its a letter
                if(Character.isLetter(message[i])){

                    for(int j = 0; j < alphabet.length; j++){

                        if (message[i] == alphabet[j]){

                            int index = (j - key2) % 26;


                            if (index < 0){
                                index = 26 + index;
                            }

                            finalMessage[i] = alphabet[index];
                        }
                    }

                }
                //check to see if it is a space
                else if(message[i] == ' '){

                    finalMessage[i] = ' ';

                }
            }


        }

        String OGmessage = new String(message);


        System.out.println("The text supplied is: " + OGmessage);
        System.out.println();

        for(int i = 0; i < message.length; i++){

            System.out.println("encrypted letter: " + message[i] + " | " + "unencrypted letter: " + finalMessage[i]);
            System.out.println();

        }

        //Print out the final Message
        String finalString = new String(finalMessage);

        System.out.println("Output Text: " + finalString);


    }  // End Double Decryption


}





