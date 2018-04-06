import java.util.Scanner;
import java.io.*;

public class Entry {
    String name, notes;
    long number;

    public Entry(String nameEntry, long numberEntry, String notesEntry){
        name = nameEntry;
        number = numberEntry;
        notes = notesEntry;
    }
    public static void listEntries(Entry[] entryList, int index){
        for (int i = 0; i < index; i++){
            System.out.println("Name: " + entryList[i].name);
            System.out.println("Phone Number: " +entryList[i].number);
            System.out.println("Notes: " + entryList[i].notes);
            System.out.println();
        }
    }
    public static boolean findEntry(String query, Entry[] entryList, int index){

        for (int i = 0; i < 200; i++){
            if (entryList[i].name.equals(query)){
            }
        }

        //make logic for this
        return true;
    }

}
