package com.company;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Terminal {

     Directory currentDirectory;


     public static void main(String[] args) {
         System.out.println("s");

         Directory directory = new Directory("dev");

         directory.addSubDirectory("project");

         Directory subDirectory1 = directory.getSubdirectory("project");
         directory.getSubdirectories();

         subDirectory1.printFullPathDirectory();
            Terminal t = new Terminal();
         t.enterCommand();

     }

     public void start(){
         if(currentDirectory != null) {
             System.out.println("You have already started the terminal ");
             return;
         }

         currentDirectory = new Directory("user");
     }

     public void enterCommand(){
         Scanner sc= new Scanner(System.in);
         //String nextList = sc.nextLine();

         List<String> words = getCommandWords("cd dev");
         System.out.println(words);
     }


    //replaceAll
    //   /s{0,}[a-z,A-Z]

    //Continue
public List<String> getCommandWords(String str){
    String command = str.trim();
    List<String> words = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder("");

    for (int i = 0, j = 0; i < command.length(); i++) {
        char c = command.charAt(i);

        boolean lastIteration = i == command.length()-1;

        if(Character.isWhitespace(c) || lastIteration) {

            if(lastIteration)
                stringBuilder.append(c);

            words.add(stringBuilder.toString());
            stringBuilder.setLength(0);
            continue;
        }

        stringBuilder.append(c);
    }

    return words;

}

public void executeCommand(List<String> commandWords){
         int size = commandWords.size();

        if(size <= 1)
            return;


}






 }



 