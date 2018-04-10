import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/*
EECS 1510 Object-Oriented Programming
Project 7
Written by Christopher Pucko

Implements a Phonebook program, saving separate entries as Objects.
For more information, please refer to Readme.txt
 */
public class Phonebook {
    static int index;
    static Entry[] entryList;

    public static void main(String[] foobar) throws FileNotFoundException {

        String nameEntry, notesEntry, commandEntry, numberTemp, query;
        char quitCondition;
        long numberEntry;
        boolean qSuccess;

        entryList = new Entry[200];
        quitCondition = 'a';
        Scanner input = new Scanner(System.in);

        System.out.println("Loading...");
        index = ReadsPhoneBook();
        System.out.println();


        while (!(quitCondition == 'q')) {
            System.out.println("Enter: e | List: l | Find: f | Quit: q ");
            System.out.print("Command: ");
            commandEntry = input.nextLine();

            switch (commandEntry.charAt(0)) {
                case 'e':
                    nameEntry = commandEntry.substring(2);
                    System.out.print("Enter Number: ");
                    numberTemp = input.nextLine();
                    numberEntry = Long.parseLong(numberTemp.replaceAll("[^0-9]", ""));
                    if (numberEntry < 1000000000)
                        numberEntry += 4190000000L;
                    System.out.print("Enter Notes: ");
                    notesEntry = input.nextLine();
                    System.out.println();

                    entryList[index] = new Entry(nameEntry, numberEntry, notesEntry);
                    index++;
                    break;

                case 'f':
                    query = commandEntry.substring(2);
                    qSuccess = findsEntry(query);
                    if (!qSuccess)
                        System.out.println("** No entry found for " + query);
                    break;
                case 'l':
                    System.out.println();
                    listsEntries();
                    break;

                case 'q':
                    quitCondition = 'q';
                    System.out.println("Saving and Shutting Down......");
                    WritesPhoneBook();
                    System.exit(0);

            }

        }

    }


    public static int ReadsPhoneBook() throws FileNotFoundException {
        //Static Method that reads entries from included phonebook.txt.
        //As each entry is read, a new Entry object is created.

        Scanner read = new Scanner(new File("phonebook.txt"));
        String name, notes, numberTemp;
        long number;

        index = 0;
        try {


            for (int i = 0; i < 200; i++) {
                name = read.nextLine();
                numberTemp = read.nextLine();
                notes = read.nextLine();
                number = Long.parseLong(numberTemp);
                entryList[i] = new Entry(name, number, notes);
                index++;

            }
        } catch (Exception NoSuchElementException) {
            System.out.println("Now Loaded!");
            return index;
        }
        return index;
    }

    public static void WritesPhoneBook() throws FileNotFoundException {
        //Method that writes each objects name, number and notes for easy storage.
        //Formatted so that it can be read back by ReadsPhoneBook().
        PrintStream P = new PrintStream("phonebook.txt");
        for (int i = 0; i < index; i++) {
            P.println(entryList[i].name);
            P.println(entryList[i].number);
            P.println(entryList[i].notes);
        }
        P.close();
        System.out.println("Phonebook Saved");
    }

    public static void listsEntries() {
        for (int i = 0; i < index; i++) {
            System.out.println();
            System.out.println("Name: " + entryList[i].name);
            System.out.println("Phone Number: " +
                    String.valueOf(entryList[i].number).replaceFirst
                    ("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3"));
            System.out.println("Notes: " + entryList[i].notes);
            System.out.println();
        }
    }

    public static boolean findsEntry(String query) {
        boolean entryFound;
        entryFound = false;
        String nameLower, queryLower;
        for (int i = 0; i < index; i++) {
            queryLower = query.toLowerCase();
            nameLower = entryList[i].name.toLowerCase();
            if (nameLower.contains(queryLower)) {
                System.out.println();
                System.out.println("Name: " + entryList[i].name);
                System.out.println("Number: " +
                        String.valueOf(entryList[i].number).replaceFirst
                        ("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3"));
                System.out.println("Notes: " + entryList[i].notes);
                System.out.println();
                entryFound = true;
            }
        }


        return entryFound;
    }

}

