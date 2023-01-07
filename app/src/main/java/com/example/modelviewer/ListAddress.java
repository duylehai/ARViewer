package com.example.modelviewer;

class ListAddress {
    String name;
    String address;
    Float longtitude;
    Float latitude;
    int imageResource;

    public ListAddress(String name, Float longtitude, Float latitude, int imageResource) {
        this.name = name;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.imageResource = imageResource;
    }

    public ListAddress(String name, String address, Float longtitude, Float latitude, int imageResource) {
        this.name = name;
        this.address = address;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public Float getLongtitude() {
        return longtitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getAddress() {
        return address;
    }
}
