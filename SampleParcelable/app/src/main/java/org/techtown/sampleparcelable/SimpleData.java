package org.techtown.sampleparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {
    int number;
    String message;
    
    public SimpleData(int num, String msg){
        number=num;
        message=msg;
    }
    
    public SimpleData(Parcel src){ // Parcel 객체에서 읽기
        number=src.readInt(); // 읽어오는 것이므로 readOOO 사용
        message=src.readString();
    }

    public static final Parcelable.Creator CREATOR=new Parcelable.Creator(){ // CREATOR 상수 정의

        public SimpleData createFromParcel(Parcel in){
            return new SimpleData(in); // SimpleData 생성자를 호출하여 Parcel 객체 읽기
        }

        public SimpleData[] newArray(int size){
            return new SimpleData[size];
        }

    };
    
    public int describeContents(){return 0;}
    
    public void writeToParcel(Parcel dest, int flags){ // Parcel 객체로 쓰기
        dest.writeInt(number); // 객체에 넣는 것이므로 writeOOO 사용
        dest.writeString(message);
    }
}
