package com.company;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//variable for user input and counter
        String question;
        int count  =0;

// scanner for user input
        Scanner input = new Scanner(System.in);

// random number object declaration
        Random r = new Random();
//Hashset for hedges
        HashSet<String> hedges = new HashSet<String>();
        hedges.add("Please tell me more");
        hedges.add("Many of my patients tell me the same thing ");
        hedges.add("It is getting late, maybe we had better quit");
        hedges.add("Any thing you want to add more");

//Hashset for qualifiers
        HashSet<String> qualifiers = new HashSet<String>();
        qualifiers.add("Why do you say that");
        qualifiers.add("You seem to that that");
        qualifiers.add( "So, you are concerned that");
//hashset for the replacing strings
        HashSet<String> replace = new HashSet<String>();
        replace.add("I");
        replace.add("me");
        replace.add("my");
        replace.add("am");

//variable to generate random number
        int hedge= r.nextInt(hedges.size());
        int qualify = r.nextInt(qualifiers.size());

//Start the program with a welcome message
        System.out.println("Welcome to the Chat-bot.");

// user question input
        System.out.println("Good day. What is your problem? Enter your response here or Q to quit: ");
        question = input.nextLine();


//loop untill user inputs quit
        while(!question.equals("quit") && count < 15) {

//split the user input into array and set it to userInput array
            String [] userInput = question.split(" ");
            String reorder ="";

//for loop to replace the words from userInput array that previously got placed
                for(int i=0; i<userInput.length;i++){
                   if(userInput[i].equalsIgnoreCase("I"))
                   {
                       userInput[i]="you";
                   }
                   else if(userInput[i].equalsIgnoreCase("me"))
                   {
                       userInput[i]="you";
                   }
                   else if(userInput[i].equalsIgnoreCase("my"))
                   {
                       userInput[i]="your";
                   }
                   else if(userInput[i].equalsIgnoreCase("am"))
                   {
                       userInput[i]="are";
                   }
                }
// for loop to set the userInput into a single string
                for(int i=0; i<userInput.length;i++)
                {
                    reorder += userInput[i] + " ";
                }
// for loop to check the replaceable words from the hashset
                for(String retval: replace){
// condition to check if the user question contains the elements from replace Hashset
                if(question.contains(retval)){
                    System.out.println( randomGen(qualifiers,qualify)+" "+reorder);
                    break;
                }
//if no elements from replace hashset is present in the question this prints next random question
                else{
                    System.out.println(randomGen(hedges,hedge));
                break;
                }
                }
          System.out.println("\n::::::::::::::::::::::::::::::::::::::::::::::::::::");
//counter to end the program if the user input it 15 times
            count ++;

//aks the question question again to resond or end the program
            System.out.println("Enter your response here or Q to quit:");
            question = input.nextLine();
        }
    }
//
    public static String randomGen(HashSet<String> random, int ran ){
        int i =0;
        String []elem = new String[random.size()];
        for(String a : random)
        {
            elem[i] = a;
            i++;
        }
        String answer = elem[ran];
        return answer;
    }
}
