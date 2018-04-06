import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

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
        index = ReadPhoneBook();
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
                    System.out.print("Enter Notes: ");
                    notesEntry = input.nextLine();

                    entryList[index] = new Entry(nameEntry, numberEntry, notesEntry);
                    index++;
                    break;

                case 'f':
                    query = commandEntry.substring(2);
                    qSuccess = findEntry(query);
                    if (!qSuccess)
                        System.out.println("** No entry found for " + query);
                    break;
                case 'l':
                    System.out.println();
                    listEntries();
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
            P.println(entryList[i].name);
            P.println(entryList[i].number);
            P.println(entryList[i].notes);
        }
        P.close();
        System.out.println("Phonebook Saved");
    }

    public static int ReadPhoneBook() throws FileNotFoundException {
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

    public static void listEntries() {
        for (int i = 0; i < index; i++) {
            System.out.println("Name: " + entryList[i].name);
            System.out.println("Phone Number: " + String.valueOf(entryList[i].number).replaceFirst
                    ("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3"));
            System.out.println("Notes: " + entryList[i].notes);
            System.out.println();
        }
    }

    public static boolean findEntry(String query) {
        boolean entryFound;
        entryFound = false;
        String nameLower, queryLower;
        for (int i = 0; i < index; i++) {
            queryLower = query.toLowerCase();
            nameLower = entryList[i].name.toLowerCase();
            if (nameLower.contains(queryLower)) {
                System.out.println();
                System.out.println("Name: " + entryList[i].name);
                System.out.println("Notes: " + String.valueOf(entryList[i].number).replaceFirst
                        ("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3"));
                System.out.println();
                entryFound = true;
            }
        }


        return entryFound;
    }

}

