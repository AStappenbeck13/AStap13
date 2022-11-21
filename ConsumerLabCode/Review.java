package ConsumerLabCode;
import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
//import java.util.Random;
//import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {
  
  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();
 
  public static void main(String[] args)
  {
    System.out.println(sentimentVal("happily"));
    System.out.println(sentimentVal("terrible"));
    System.out.println(sentimentVal("cold"));

    System.out.println();

    System.out.println(totalSentiment("/workspace/AStap13/ConsumerLabCode/SampleReview.txt"));
    System.out.println(starRating("/workspace/AStap13/ConsumerLabCode/SampleReview.txt"));

    System.out.println(fakeReview("/workspace/AStap13/ConsumerLabCode/SampleReview.txt"));
  }
  
  private static final String SPACE = " ";
  
  static{
    try {
      Scanner input = new Scanner(new File("/workspace/AStap13/ConsumerLabCode/cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }
  
  
  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("/workspace/AStap13/ConsumerLabCode/positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        System.out.println(temp);
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }   
 
  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("/workspace/AStap13/ConsumerLabCode/negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }   
  }
  
  /** 
   * returns a string containing all of the text in fileName (including punctuation), 
   * with words separated by a single space 
   */
  public static String textToString( String fileName )
  {  
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));
      
      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();
      
    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }
  
  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment) 
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }

  public static double totalSentiment(String fileName)
  {
    
    // rohan's way
    /*
    String sentence = textToString(fileName);
    String[] words = sentence.split(" ");
    double total = 0;
    for (String s : words){
      total += sentimentVal(s);
    }

    return total;
    */



    double total = 0;
    String s = textToString(fileName);

    String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz ";

    for (int i = 0; i < s.length(); i++)
    {
      String x = s.substring(i, i + 1);
      boolean isLetter = false;

      for (int j = 0; j < alphabet.length(); j++)
      {
        if (x.equals(alphabet.substring(j, j + 1)))
        {
          isLetter = true;
        }
      }

      if (!isLetter)
      {
        s = s.replace(x, "");
      }
    }
    s = s + " ";
    String word = "";

    while (s.length() > 0)
    {
      int space = s.indexOf(" ");
      word = s.substring(0, space);
      total += sentimentVal(word);
      s = s.substring(space + 1);

    }

    return total;
  }

  public static int starRating(String fileName)
  {
    double x = totalSentiment(fileName);

    if (x <= 0)
    {
      return 1;
    }
    else if (x <= 10)
    {
      return 2;
    }
    else if (x <= 20)
    {
      return 3;
    }
    else if (x <= 30)
    {
      return 4;
    }
    else
    {
      return 5;
    }
  }

  public static String fakeReview(String fileName)
  {
    String reviewWords = Review.textToString(fileName);
    String oneWord = "";
    String fakeReview = "";

    int spacePosition = reviewWords.indexOf(" ");
    while (spacePosition != -1)
    {
      oneWord = reviewWords.substring(0, spacePosition);

      reviewWords = reviewWords.substring(spacePosition + 1);

      if(oneWord.substring(0,1).equals("*"))
      {
        String punctuation = getPunctuation(reviewWords);
        String randomWord = randomPositiveAdj();
        fakeReview = fakeReview + randomWord + punctuation;
      }
      else
      {
        fakeReview += reviewWords;
      }
      fakeReview += SPACE;
      
      spacePosition = reviewWords.indexOf(" ");
    }

    if(oneWord.substring(0,1).equals("*"))
    {
      String punctuation = getPunctuation(reviewWords);
      String randomWord = randomPositiveAdj();
      fakeReview = fakeReview + randomWord + punctuation;
    }
    else
    {
      fakeReview += reviewWords;
    }
    return fakeReview;


    /*String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz* ";

    for (int i = 0; i < s.length(); i++)
    {
      String x = s.substring(i, i + 1);
      boolean isLetter = false;

      for (int j = 0; j < alphabet.length(); j++)
      {
        if (x.equals(alphabet.substring(j, j + 1)))
        {
          isLetter = true;
        }
      }

      if (!isLetter)
      {
        s = s.replace(x, "");
      }
    }

    String finalString = s;
    s = s + " ";
    String word = "";

    while (s.length() > 0)
    {
      int space = s.indexOf(" ");
      word = s.substring(0, space);
      s = s.substring(space + 1);

      if (word.substring(0,1).equals("*"))
      {
        sentimentVal(word);

        // how do I get another word from the choices???
      }
    }    

    return finalString;*/
  }
  
  /**
   * Returns the ending punctuation of a string, or the empty string if there is none 
   */
  public static String getPunctuation( String word )
  { 
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }

      /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }
    
    return word;
  }
 
  /** 
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }
  
  /** 
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);
    
  }
  
  /** 
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }
}
