package edu.polytech.gotoslim.conseil.listCreation.lists;

public class FactoryList {

    public FactoryList(){}

    public MealList createList(String meal) {
        return new MealList(meal);
    }
}
