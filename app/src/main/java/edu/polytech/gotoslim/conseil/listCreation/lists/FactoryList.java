package edu.polytech.gotoslim.conseil.listCreation.lists;

import java.util.ArrayList;

import edu.polytech.gotoslim.conseil.listCreation.Meal;

public class FactoryList {

    public FactoryList(){}

    public MealList createList(String meal) {
        return new MealList(meal);
    }
}
