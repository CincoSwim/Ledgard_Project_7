EECS 1510 Object-Oriented Programming
Project 7: Phonebook.java and Entry.java
Written by Christopher Pucko

    This project implements a phonebook program operated
using console commands. On boot, the program starts with
the "ReadsPhoneBook()" method, which goes through each line of
phonebook.txt, and loads the data in this document to memory.
This data is used to create an array of 'Entry' objects, with each
having a name, number, and notes associated. Once loaded, the user
is prompted to enter a command, with a small legend printed above.
This legend and prompt will be printed again after the completion of
a successful action.
    By entering 'e' followed by a string or line,
the user can begin creating a new entry in the phonebook. After recieving
a name, number, and any notes, the program creates a new Entry object
at the next available index location.
    By entering 'f' and a string,
the array containing all entries will be searched for any Entry
objects with a name containing the search query.
    By entering 'l', all entries
are listed.
    To quit the program, the user must enter 'q'. The program
will then save all entries back to phonebook.txt in a manner that allows
their loading upon next book, then ends.