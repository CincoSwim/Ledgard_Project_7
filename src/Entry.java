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
        boolean entryFound;
        entryFound = false;
        for (int i = 0; i < index; i++){
            if (entryList[i].name.contains(query)){
                System.out.println(entryList[i].name);
                System.out.println(String.valueOf(entryList[i].number).replaceFirst
                        ("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3"));
                System.out.println();
                entryFound = true;
            }
        }

        return entryFound;
    }

}
