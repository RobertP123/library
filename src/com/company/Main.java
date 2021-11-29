package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final File theFile = new File("library.txt");

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            Createfile();
            String[] info = GetBookInfo();
            WriteToFile(info);
            System.out.println("you want to add another book? y/n");
            if (sc.next().equals("y")) {
                continue;
            } else if (sc.next().equals("n")) {
                System.exit(0);
            } else {
                System.out.println("invalid input imma just assume you want to add another book lmao");
            }
        }
    }

    public static void WriteToFile(String[] info) {
        try {
            FileWriter myWriter = new FileWriter(theFile.getName(), true);
            System.out.println("appending book info to file");
            myWriter.write(Arrays.toString(info));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void Createfile() {
        try {
            if (theFile.createNewFile()) {
                System.out.println("File created: " + theFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static String[] GetBookInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter the Book title");
        String title = sc.next();
        System.out.println("please enter the isbn");
        String isbn = sc.next();
        System.out.println("please enter the Author");
        String author = sc.next();
        System.out.println("please enter the genre");
        String genre = sc.next();
        return new String[]{title, isbn, author, genre};
    }
}
