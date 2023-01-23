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
            if (allstns.get(j).getLatitude() > allstns.get(i).getLatitude())
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
            //System.out.println(x.getLatitude());
      }
      System.out.println("\nThe station with the lowest latitude is: ");
      System.out.println(allstns.get(allstns.size() - 1).getId() + ", " + allstns.get(allstns.size() - 1).getName()
               + ", " + allstns.get(allstns.size() - 1).getState() + ": " + allstns.get(allstns.size() - 1).getLatitude());

      
               String stateName = "MO";
      /*for (int i = 0; i < allstns.size(); i++)
      {
         if (!allstns.get(i).getState().equals(stateName))
         {
            allstns.remove(i);
         }
         else
         {
            System.out.println(allstns.get(i).getId() + ", " + allstns.get(i).getName() + ", "
                        + allstns.get(i).getState() + ": " + allstns.get(i).getLatitude());
         }
      }*/

      
      
      /*
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

      /*ArrayList<WeatherStation> stateStations = new ArrayList<WeatherStation>();
      
      String stateName = "MO";
      for (WeatherStation x : allstns)
      {
         if (x.getState().equals(stateName.toUpperCase()))
         {
            stateStations.add(x); 
         }
      }
      for (int i = 0; i < stateStations.size() - 1; i++)
      {
         //will find the index of the lowest remaining latitude
         int minIndex = i;
         for (int j = i + 1; j < stateStations.size(); j++)
         {
            if (stateStations.get(j).getLatitude() < stateStations.get(i).getLatitude())
            {
               minIndex = j;
            }
         }

         WeatherStation temp = stateStations.get(i);
         stateStations.set(i, stateStations.get(minIndex));
         stateStations.set(minIndex, temp);
      }

      for (WeatherStation x : allstns)
      {
         System.out.println(x.getId() + ", " + x.getName() + ", " + x.getState() + ": " + x.getLatitude());
      }

      System.out.println("\nTotal number of stations in the state: " + allstns.size());
      System.out.println("The station with the lowest latitude is: ");
      System.out.println(allstns.get(0).getId() + ", " + allstns.get(0).getName()
               + ", " + allstns.get(0).getState() + ": " + allstns.get(0).getLatitude());
               */
      
      /*System.out.println("\nTotal number of stations in the state: " + stateStations.size());
      System.out.println("The station with the lowest latitude is: ");
      System.out.println(stateStations.get(0).getId() + ", " + stateStations.get(0).getName()
               + ", " + stateStations.get(0).getState() + ": " + stateStations.get(0).getLatitude());*/


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