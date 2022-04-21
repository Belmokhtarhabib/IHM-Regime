package edu.polytech.gotoslim.conseil.listCreation.lists;

import static edu.polytech.gotoslim.conseil.listCreation.MealConst.DRINK;
import static edu.polytech.gotoslim.conseil.listCreation.MealConst.MAIN_COURSE;

import java.util.ArrayList;

import edu.polytech.gotoslim.conseil.listCreation.Meal;

public class MealList extends ArrayList<Meal> {
    public MealList(String type){
        if(type.equals(DRINK)) addAll(new ListDrink());
        else if(type.equals(MAIN_COURSE)) addAll(new ListPlat());
    }
}
