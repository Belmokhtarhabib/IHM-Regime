package edu.polytech.gotoslim.conseil.listCreation;

import android.os.Parcel;
import android.os.Parcelable;

public class Meal implements Parcelable {
    String name;
    int picture;
    String recipe;

    public Meal(String name, int picture, String recipe) {
        this.name = name;
        this.picture = picture;
        this.recipe = recipe;
    }

    protected Meal(Parcel in) {
        name = in.readString();
        picture = in.readInt();
        recipe = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(picture);
        dest.writeString(recipe);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Meal> CREATOR = new Creator<Meal>() {
        @Override
        public Meal createFromParcel(Parcel in) {
            return new Meal(in);
        }

        @Override
        public Meal[] newArray(int size) {
            return new Meal[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getRecipe(){
        return recipe;
    }

    public int getPicture(){ return picture; }
}
