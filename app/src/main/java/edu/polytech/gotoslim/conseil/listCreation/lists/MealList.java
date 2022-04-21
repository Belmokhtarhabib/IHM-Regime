package edu.polytech.gotoslim.conseil.listCreation.lists;

import static edu.polytech.gotoslim.conseil.listCreation.MealConst.DESERT;
import static edu.polytech.gotoslim.conseil.listCreation.MealConst.DRINK;
import static edu.polytech.gotoslim.conseil.listCreation.MealConst.MAIN_COURSE;
import static edu.polytech.gotoslim.conseil.listCreation.MealConst.STARTER;

import java.util.ArrayList;

import edu.polytech.gotoslim.conseil.listCreation.Meal;

public class MealList extends ArrayList<Meal> {
    public MealList(String type){
        switch (type){
            case DRINK: addAll(new ListDrink());
            case MAIN_COURSE: addAll(new ListMainCourse());
            case DESERT: addAll(new ListDesert());
            case STARTER: addAll(new ListStarter());
        }
    }
}
