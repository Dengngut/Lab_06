package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();


    /**
     *  This adds a city to the list if the city does not exist
     *  @param city
     *   This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();   }
        cities.add(city);   }

    /**
     *  This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City>list = new ArrayList<>(cities) ;
        Collections.sort(list);
        return list; }


    /**
     * When given a city
     * returns true if the city is in the list
     * @param city
     * @return
     * */
    public boolean hasCity(City city) {

        return cities.contains(city);
    }

    /**
     * Removes a city from the list.
     * @param city the city to remove
     * @throws IllegalArgumentException if the city is not found in the list
     */
    public void delete(City city) {
        boolean removed = cities.remove(city);
        if (!removed) {
            throw new IllegalArgumentException("City not found: " + city);
        }
    }


    /**
     * Returns how many cities are in the list.
     *
     * @return the current number of stored cities
     */
    public int countCities() {

        return cities.size();
    }
}




