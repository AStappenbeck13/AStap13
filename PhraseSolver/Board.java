package PhraseSolver;
import java.util.Scanner;
import java.io.File;

public class Board {

  private String actualPhrase;
  private String currentPhrase;

  private String lettersGuessed = "";

  public String getPhrase()
  {
    return actualPhrase;
  }
  
  public void setPhrase(String g)
  {
    actualPhrase = g;
  }

  public String getCurrentPhrase()
  {
    return currentPhrase;
  }

  public void setCurrentPhrase(String c)
  {
    currentPhrase = c;
  }

  public String getLettersGuessed()
  {
    return lettersGuessed;
  }

  public void setLettersGuessed(String g)
  {
    lettersGuessed = g;
  }

  public String loadPhrase()
    {
      String tempPhrase = "";
      
      int numOfLines = 0;
      
      try 
      {
        
        Scanner sc = new Scanner(new File("/workspace/AStap13/PhraseSolver/phrases2.txt"));
        //phrases2 is the same list, just doubled spaced - I think it looks nicer double spaced
        while (sc.hasNextLine())
        {
          tempPhrase = sc.nextLine().trim();
          numOfLines++;
        }
      } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
      
      int randomInt = (int) ((Math.random() * numOfLines) + 1);
      
      try 
      {
        int count = 0;
        Scanner sc = new Scanner(new File("/workspace/AStap13/PhraseSolver/phrases2.txt"));
        while (sc.hasNextLine())
        {
          count++;
          String temp = sc.nextLine().trim();
          if (count == randomInt)
          {
            tempPhrase = temp;
          }
        }
      } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }

      return tempPhrase;
    }

    // sets up a board with all letters from the actual phrase replaced with underscores
    public String setBoard(String phrase){
    {
      phrase += " ";
      
      String blank = "";

      String word = "";


      while (phrase.length() > 0)
      {
        int spacePos = phrase.indexOf(" ");

        word = phrase.substring(0, spacePos);
        phrase = phrase.substring(spacePos + 1);

        for (int i = 0; i < word.length(); i++)
        {
          blank += "_";
        }
        blank += " ";
      }

      return blank.trim();
    }
  }

  // changes the currentPhrase by replacing underscores
  // with correctly guessed letters
  public String processGuess(String guess, String phrase)
  {
    char x = guess.charAt(0);

    if (guess.length() == 1 && Character.isLetter(x))
    {
      String newPhrase = "";

      for (int i = 0; i < phrase.length() - 1; i++)
      {
        if (guess.equals(actualPhrase.substring(i, i + 1)))
        {
          newPhrase += guess;
        }
        else
        {
          newPhrase += phrase.substring(i, i + 1);
        }
      }

      if(guess.equals(actualPhrase.substring(actualPhrase.length() - 1)))
      {
        newPhrase += guess;
      }
      else
      {
        newPhrase += phrase.substring(phrase.length() - 1);
      }
      
      currentPhrase = newPhrase;
      return currentPhrase;
    }
    // in the event that a guess is not one letter
    // points will still be subtracted
    else
    {
      System.out.println("Invalid Guess!");
      return currentPhrase;
    }
  }
}