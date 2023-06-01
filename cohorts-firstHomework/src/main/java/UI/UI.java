package UI;
import service.HouseService;

import java.util.Scanner;

public class UI {
    private HouseService houseService;

    public UI() {
        this.houseService = new HouseService();
    }

    public void show(HouseService service){

        System.out.print("\n");
        System.out.println("All current houses: " + service.getHouseList());
        System.out.println("All current villas: " + service.getVillaList());
        System.out.println("All current summerhouse: " + service.getSummerHouseList());
        System.out.print("\n");
        System.out.println("Total price of houses: " + service.getTotalPricesOfHouses());
        System.out.println("Total price of the villas: " + service.getTotalPriceOfVilla());
        System.out.println("Total price of the summerhouse: " + service.getTotalPriceOfSummerHouse());
        System.out.println("Total price of all types of houses: " + service.getTotalPriceOfAllResidence());
        System.out.print("\n");
        System.out.println("Average square meter of houses: " + service.getAverageSquareMeterOfHouses());
        System.out.println("Average square meter of villas: " + service.getAverageSquareMeterOfVillas());
        System.out.println("Average square meter of summerhouses: " + service.getAverageSquareMeterOfSummerHouses());
        System.out.println("Average square meter of all types of houses: " + service.getAverageSquareMeterOfAllResidance());
        System.out.print("\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rooms and halls to be filtered....");
        System.out.print("Number of Rooms : ");
        int room = scanner.nextInt();
        System.out.print("Number of Halls : ");
        int halls = scanner.nextInt();
        System.out.println(room + " room, " + halls + " halls residance are: \n\t" + service.filterResidance(room, halls));
    }
}
