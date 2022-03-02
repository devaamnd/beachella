package com.skylinetech.travelbnb.classes;

public class RecyclerClass {

    public int PlaceImage;
    public String PlaceName;
    public String PlaceCountry;

    public RecyclerClass(String PlaceName,String PlaceCountry, int PlaceImage) {
        this.PlaceImage = PlaceImage;
        this.PlaceName = PlaceName;
        this.PlaceCountry = PlaceCountry;
    }

    public int getPlaceImage() {
        return PlaceImage;
    }

    public void setPlaceImage(int PlaceImage) {
        this.PlaceImage = PlaceImage;
    }

    public String getPlaceName() {
        return PlaceName;
    }

    public void setPlaceName(String PlaceName) {
        this.PlaceName = PlaceName;
    }

    public String getPlaceCountry() {
        return PlaceCountry;
    }

    public void setPlaceCountry(String PlaceCountry) {
        this.PlaceCountry = PlaceCountry;
    }
}
