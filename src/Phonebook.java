import java.util.Scanner;
import java.io.*;

public class Phonebook {
    public static void main(String[] foobar){
        int index;
        Entry[] entryList;
        String nameEntry, notesEntry,commandEntry, numberTemp, searchKey;
        char quitCondition;
        long numberEntry;

        entryList = new Entry[200];
        index = 0;
        quitCondition = 'a';
        Scanner input = new Scanner(System.in);

        System.out.println("Enter: e | List: l | Find: f | Quit: q");

        while (!(quitCondition == 'q')){
            System.out.print("Command: ");
            commandEntry = input.nextLine();

            switch (commandEntry.charAt(0)){
                case 'e':
                    nameEntry = commandEntry.substring(2);
                    System.out.print("Enter Number: ");
                    numberTemp = input.nextLine();
                    numberEntry = Long.parseLong(numberTemp.replaceAll("[^0-9]", ""));
                    System.out.println("Enter Notes: ");
                    notesEntry = input.nextLine();

                    entryList[index] = new Entry(nameEntry,numberEntry,notesEntry);
                case 'f':
                    searchKey = commandEntry.substring(2);
                case 'l':
                case 'q':
                    quitCondition = 'q';
                    System.out.println("Saving and Shutting Down......");

            }

        }

    }

}
