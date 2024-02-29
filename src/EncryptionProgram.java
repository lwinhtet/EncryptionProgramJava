import java.util.*;

/*
* First, let begin by creating the necessary framework, so let declare all of the methods that we'll need first*/
public class EncryptionProgram {

    // declare these and not yet initialize them
    private Scanner scanner;
    private ArrayList<Character> list; // store all the character from ASCII table range 32-126
    private ArrayList<Character> shuffledList; // take copy from list and shuffle them
    private char character;
    private char[] letters; // store letters from user message

    EncryptionProgram() {
        // let initialize everything within our constructor
        scanner = new Scanner(System.in);

        list = new ArrayList();
        shuffledList = new ArrayList();
        character = ' '; // make sure you use single quote to denote that the value inside is a single character literal.

        newKey();
        // ask user what do you want to do?
        askQuestion();
    }
    /* Do you want to generate a new key, get the current key, encrypt/decrypt the message or quite the program */
    private void askQuestion() {
        // this will consistently prompt the user to type in an answer that is valid ex. type "q" to quit
        // this will continue on forever
        while(true) {
            System.out.println("*********************************************");
            System.out.println("What do you want to do?");
            System.out.println("(N)ewKey,(G)etKey,(E)ncrypt,(D)ecrypt,(Q)uit");
            // let get the response using the scanner
            char response = Character.toUpperCase(scanner.nextLine().charAt(0));

            switch(response) {
                case 'N':
                    newKey();
                    break;
                case 'G':
                    getKey();
                    break;
                case 'E':
                    encrypt();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'Q':
                    quit();
                    break;
                default:
                    System.out.println("Not a valid answer :(");
            }
        }
    }

    // to generate key
    private void newKey() {
        // let assign our character variable as just an empty space
        character = ' '; // kind of like resetting it
        list.clear(); // clear our list if it's already full
        shuffledList.clear();

        /* with character, there is a corresponding integer value to each character(ASCII table)
         actually if we add a number to this character = ' '+1; this would give us the next letter/character
         in the ASCII table, So, what we can do is actually add numbers or increment our character if we want
         to retrieve from that ASCII table. We could easily do it with the for loop. */

        // let start from 32 because empty space(' ') character is 32
        for (int i=32; i < 127; i++) {
            list.add(Character.valueOf(character));
            character++;
        }
        // in our list, we're going to have most of the members of the ASCII table at least the ones that we can
        // type in normally
        shuffledList = new ArrayList(list); // to make a copy of "list"
        Collections.shuffle(shuffledList);
        System.out.println("*A new key has been generated*");
    }

    // to retrieve key
    private void getKey() {
        System.out.println("Key: ");
        for(Character x : list) {
            System.out.print(x);
        }
        System.out.println();
        for (Character x : shuffledList) {
            System.out.print(x);
        }
        System.out.println();
    }

    private void encrypt() {
         /* 1. ask the user for a message they want to encrypt
         2. we're going to break down that string that they type in into individual character
         if they type in "Hello World" we will find where "H" is and at this same index within out shuffledlist
         32 is "empty space", so we start from the empty space
          !"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\]^_`abcdefghijklmnopqrstuvwxyz{|}~
         V.Wg`I)t=EKab6&q-3_DA>rvN[,MFmwX8$/e@zH\jyxf25U4<?"i}7od^]OBp%s;~RSPu1Y+hCJT'Z |Ql{k#0L9nG:!(*c
         "H" is "j", "e" is 1*/

        System.out.println("Enter a message to be encrypted: ");
        String message = scanner.nextLine();
        // method that break up a string into an array of characters
        letters = message.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            // looking through our list to see if there is a matching letter to our current letter
            for (int j = 0; j < list.size(); j++) {
                if (letters[i] == list.get(j)) {
                    letters[i] = shuffledList.get(j);
                    break;
                }
            }
        }

        System.out.println("Encrypted: ");
        for (char x : letters) {
            System.out.print(x);
        }
        System.out.println();
    }

    private void decrypt() {
        System.out.println("Enter a message to be decrypted: ");
        String message = scanner.nextLine();
        // method that break up a string into an array of characters
        letters = message.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            // looking through our list to see if there is a matching letter to our current letter
            for (int j = 0; j < shuffledList.size(); j++) {
                if (letters[i] == shuffledList.get(j)) {
                    letters[i] = list.get(j);
                    break;
                }
            }
        }

        System.out.println("Decrypted: ");
        for (char x : letters) {
            System.out.print(x);
        }
        System.out.println(' ');
    }

    private void quit() {
        System.out.println("Thank you, have a nice day!");
        // The integer argument status indicates the exit status of the program.
        /* 0: Indicates successful termination of the program.
        Non-zero values: Typically indicate an error or abnormal termination. The specific meaning of non-zero
        status codes may vary depending on the application or system. */
        System.exit(0);
    }


}
