package com.shishank.android.models.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import lombok.Data;

/**
 * @author shishank
 */

@Data
public class DiscoverResponse implements Parcelable {

    private int page;
    private int totalResults;
    private int total_pages;
    private List<Result> results;

    protected DiscoverResponse(Parcel in) {
        page = in.readInt();
        totalResults = in.readInt();
        total_pages = in.readInt();
    }

    public static final Creator<DiscoverResponse> CREATOR = new Creator<DiscoverResponse>() {
        @Override
        public DiscoverResponse createFromParcel(Parcel in) {
            return new DiscoverResponse(in);
        }

        @Override
        public DiscoverResponse[] newArray(int size) {
            return new DiscoverResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(page);
        dest.writeInt(totalResults);
        dest.writeInt(total_pages);
    }
}
