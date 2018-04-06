import java.util.Scanner;
import java.io.*;

public class Phonebook {
    static int index;
    static Entry[] entryList;

    public static void main(String[] foobar) throws FileNotFoundException {

        String nameEntry, notesEntry, commandEntry, numberTemp, query;
        char quitCondition;
        long numberEntry;
        boolean qSuccess;

        entryList = new Entry[200];
        index = 0;
        quitCondition = 'a';
        Scanner input = new Scanner(System.in);

        System.out.println("Loading...");
        ReadPhoneBook();
        System.out.println("Now Loaded!");
        System.out.println();
        System.out.println("Enter: e | List: l | Find: f | Quit: q");

        while (!(quitCondition == 'q')) {
            System.out.print("Command: ");
            commandEntry = input.nextLine();

            switch (commandEntry.charAt(0)) {
                case 'e':
                    nameEntry = commandEntry.substring(2);
                    System.out.print("Enter Number: ");
                    numberTemp = input.nextLine();
                    numberEntry = Long.parseLong(numberTemp.replaceAll("[^0-9]", ""));
                    System.out.print("Enter Notes: ");
                    notesEntry = input.nextLine();

                    entryList[index] = new Entry(nameEntry, numberEntry, notesEntry);
                    index++;
                    break;

                case 'f':
                    query = commandEntry.substring(2);
                    qSuccess = Entry.findEntry(query, entryList, index);
                    if (!qSuccess)
                        System.out.println("No matching entries.");
                    break;
                case 'l':
                    Entry.listEntries(entryList, index);
                    break;

                case 'q':
                    quitCondition = 'q';
                    System.out.println("Saving and Shutting Down......");
                    WritePhoneBook();
                    System.exit(0);

            }

        }

    }

    public static void WritePhoneBook() throws FileNotFoundException {
        PrintStream P = new PrintStream("phonebook.txt");
        for (int i = 0; i < index; i++) {
            P.println(entryList[i].name + "\t" +
                    entryList[i].number + "\t" +
                    entryList[i].notes);
        }
        P.close();
        System.out.println("Phonebook Saved");
    }

    public static void ReadPhoneBook() throws FileNotFoundException{
       // Scanner filein = new Scanner ();
    }
}
