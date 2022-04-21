package edu.polytech.gotoslim.conseil.listCreation;

import android.os.Parcel;
import android.os.Parcelable;

public class Meal implements Parcelable {
    String name;
    int picture;

    public Meal(String name, int picture) {
        this.name = name;
        this.picture =picture;
    }

    protected Meal(Parcel in) {
        name = in.readString();
        picture = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(picture);
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

    public int getPicture(){ return picture; }
}
