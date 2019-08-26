package com.example.notestore.Helpers;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Jim.
 */

public final class CourseInfo implements Parcelable {
    private final String mCourseId;
    private final String mTitle;

    public CourseInfo(String courseId, String title) {
        mCourseId = courseId;
        mTitle = title;
    }

    private CourseInfo(Parcel source) {
        mCourseId = source.readString();
        mTitle = source.readString();
    }

    public String getCourseId() {
        return mCourseId;
    }

    public String getTitle() {
        return mTitle;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseInfo that = (CourseInfo) o;

        return mCourseId.equals(that.mCourseId);

    }

    @Override
    public int hashCode() {
        return mCourseId.hashCode();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mCourseId);
        dest.writeString(mTitle);
    }

    public static final Creator<CourseInfo> CREATOR =
            new Creator<CourseInfo>() {

                @Override
                public CourseInfo createFromParcel(Parcel source) {
                    return new CourseInfo(source);
                }

                @Override
                public CourseInfo[] newArray(int size) {
                    return new CourseInfo[size];
                }
            };
}
