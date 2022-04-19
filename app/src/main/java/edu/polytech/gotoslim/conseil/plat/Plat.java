package edu.polytech.gotoslim.conseil.plat;

import android.os.Parcel;
import android.os.Parcelable;

public class Plat implements Parcelable {


    String name;
    int picture;

    public Plat(String name, int picture) {
        this.name = name;
        this.picture =picture;
    }

    protected Plat(Parcel in) {
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

    public static final Creator<Plat> CREATOR = new Creator<Plat>() {
        @Override
        public Plat createFromParcel(Parcel in) {
            return new Plat(in);
        }

        @Override
        public Plat[] newArray(int size) {
            return new Plat[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getPicture(){ return picture; }

}
