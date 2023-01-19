import core.data.*;
import java.util.ArrayList;
//import java.util.Scanner;

public class Welcome03_List {
   public static void main(String[] args) {
      DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml").load();
      ArrayList<WeatherStation> allstns = ds.fetchList("WeatherStation", "station/station_name", 
             "station/station_id", "station/state",
             "station/latitude", "station/longitude");
      System.out.println("Total stations: " + allstns.size());


      for (int i = 0; i < allstns.size() - 1; i++)
      {
         //will find the index of the lowest remaining latitude
         int minIndex = i;
         for (int j = i + 1; j < allstns.size(); j++)
         {
            if (allstns.get(j).getLatitude() < allstns.get(i).getLatitude())
            {
               minIndex = j;
            }
         }

         WeatherStation temp = allstns.get(i);
         allstns.set(i, allstns.get(minIndex));
         allstns.set(minIndex, temp);
      }
      for (WeatherStation x : allstns)
      {
            System.out.println(x.getId() + ", " + x.getName() + ", " + x.getState() + ": " + x.getLatitude());
      }
      System.out.println("\nThe station with the lowest latitude is: ");
      System.out.println(allstns.get(0).getId() + ", " + allstns.get(0).getName()
               + ", " + allstns.get(0).getState() + ": " + allstns.get(0).getLatitude());


      /*
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a state abbreviation: ");
      String state = sc.next();
      System.out.println("Stations in " + state);
      for (WeatherStation ws : allstns) {
         if (ws.isLocatedInState(state)) {
            System.out.println("  " + ws.getId() + ": " + ws.getName());
         }
      }
      sc.close();
      */

   }
}