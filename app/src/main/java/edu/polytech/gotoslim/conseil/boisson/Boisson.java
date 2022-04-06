package edu.polytech.gotoslim.conseil.boisson;

import android.os.Parcel;
import android.os.Parcelable;

public class Boisson implements Parcelable {


    String name;
    int picture;

    public Boisson(String name, int picture) {
        this.name = name;
        this.picture =picture;
    }

    protected Boisson(Parcel in) {
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

    public static final Creator<Boisson> CREATOR = new Creator<Boisson>() {
        @Override
        public Boisson createFromParcel(Parcel in) {
            return new Boisson(in);
        }

        @Override
        public Boisson[] newArray(int size) {
            return new Boisson[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getPicture(){ return picture; }

}
