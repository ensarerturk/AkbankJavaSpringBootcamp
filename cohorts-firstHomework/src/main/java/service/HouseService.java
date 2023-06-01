package service;

import model.House;
import model.SummerHouse;
import model.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HouseService {

    private List<House> houseList = new ArrayList<>();
    private List<Villa> villaList = new ArrayList<>();
    private List<SummerHouse> summerHouseList = new ArrayList<>();

    public void addHouse(House house){
        houseList.add(house);
    }

    public void addVilla(Villa villa){
        villaList.add(villa);
    }

    public void addSummerHouse(SummerHouse summerHouse){
        summerHouseList.add(summerHouse);
    }

    public List<House> getHouseList() {
        return houseList;
    }


    public List<Villa> getVillaList() {
        return villaList;
    }

    public List<SummerHouse> getSummerHouseList() {
        return summerHouseList;
    }

    public int getTotalPricesOfHouses(){
        int totalPrice = 0;
        for (House house :
                houseList) {
            totalPrice += house.getPrice();
        }
        return totalPrice;
    }

    public int getTotalPriceOfVilla(){
        int totalPrice = 0;
        for (Villa villa :
                villaList) {
            totalPrice += villa.getPrice();
        }
        return totalPrice;
    }

    public int getTotalPriceOfSummerHouse(){
        int totalPrice = 0;
        for (SummerHouse summerHouse :
                summerHouseList) {
            totalPrice += summerHouse.getPrice();
        }
        return totalPrice;
    }

    public int getTotalPriceOfAllResidence(){
        return getTotalPricesOfHouses() + getTotalPriceOfVilla() + getTotalPriceOfSummerHouse();
    }

    public double getAverageSquareMeterOfHouses(){
        double squareMeter = 0;
        for (House house :
                houseList) {
            squareMeter += house.getSquareMeters();
        }
        return squareMeter / houseList.size();
    }

    public double getAverageSquareMeterOfVillas(){
        double squareMeter = 0;
        for (Villa villa :
                villaList) {
            squareMeter += villa.getSquareMeters();
        }
        return squareMeter / villaList.size();
    }

    public double getAverageSquareMeterOfSummerHouses(){
        double squareMeter = 0;
        for (SummerHouse summerHouse :
                summerHouseList) {
            squareMeter += summerHouse.getSquareMeters();
        }
        return squareMeter / summerHouseList.size();
    }

    public double getAverageSquareMeterOfAllResidance(){
        double squareMeter = getAverageSquareMeterOfHouses() * houseList.size() +
                getAverageSquareMeterOfVillas() * villaList.size() +
                getAverageSquareMeterOfSummerHouses() * summerHouseList.size();

        return squareMeter / (houseList.size() + villaList.size() + summerHouseList.size());
    }

    public String filterResidance(int numberOfRooms, int numberOfHalls){
        String result = "";

        for (House house :
                houseList) {
            if (house.getNumberOfRooms() == numberOfRooms && house.getNumberOfHalls() == numberOfHalls){
                result = String.valueOf(house);
            }
        }
        for (Villa villa :
                villaList) {
            if (villa.getNumberOfRooms() == numberOfRooms && villa.getNumberOfHalls() == numberOfHalls) {
                result = String.valueOf(villa);
            }
        }

        for (SummerHouse summer :
                summerHouseList) {
            if (summer.getNumberOfRooms() == numberOfRooms && summer.getNumberOfHalls() == numberOfHalls) {
                result = String.valueOf(summer);
            }
        }

        if (Objects.equals(result, "")){
            return "there is no such house";
        }else {
            return result;
        }
    }
}
