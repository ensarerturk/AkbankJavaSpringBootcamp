import UI.UI;
import model.House;
import model.SummerHouse;
import model.Villa;
import service.HouseService;

public class Main {
        public static void main(String[] args) {
                UI ui = new UI();
                HouseService service = new HouseService();

                service.addHouse(new House(150000, 200, 2, 1));
                service.addHouse(new House(550000, 300, 5, 3));

                service.addVilla(new Villa(250000, 300, 3,2));

                service.addSummerHouse(new SummerHouse(350000, 500, 5, 3));

                ui.show(service);
        }
}
