package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final File theFile = new File("library.txt");

    public static void main(String[] args) {
        Createfile();
        while (true) {
            try {
                menu();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private static void menu() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("you want to add a book? y/n or \n1. look for a book\n2. print out the entire library");
        String input = sc.next();
        switch (input) {
            case "y":
                String[] info = GetBookInfo();
                WriteToFile(info);
                break;
            case "n":
                System.exit(0);
            case "1":
                search();
                break;
            case "2":
                Scanner scan = new Scanner(theFile);
                System.out.println(scan.nextLine());
                break;
            default:
                System.out.println("invalid input imma just assume you want to add another book lmao");
                break;
        }
    }

    private static void search() {
        Scanner sc = new Scanner(System.in);

        System.out.println(" enter the content you looking for");
        String name = sc.next();
        Scanner scanner;
        try {
            scanner = new Scanner(theFile).useDelimiter( "]");

            while (scanner.hasNext()) {
                final String lineFromFile = scanner.nextLine();
                if (lineFromFile.contains(name)) {
                    System.out.println("I found " + name);
                    System.out.println(lineFromFile);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(" cannot write to file " + theFile);
        }
    }

    public static void WriteToFile(String[] info) {
        try {
            FileWriter myWriter = new FileWriter(theFile.getName(), true);
            System.out.println("appending book info to file");
            myWriter.write(Arrays.toString(info) + "\n");
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
        sc.useDelimiter("\n");
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
