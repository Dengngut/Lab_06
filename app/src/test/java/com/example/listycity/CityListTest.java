package com.example.listycity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList; }
    private City mockCity() {
        return new City("Edmonton", "Alberta"); }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city)); }


    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city); assertThrows(IllegalArgumentException.class, () -> { cityList.add(city); }); }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()


        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island"); cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(new City("Edmonton", "Alberta")));
        assertFalse(cityList.hasCity(new City("Regina", "Saskatchewan")));
    }

    @Test
    public void testDelete_throwsMissingCityException() {
        CityList cityList = mockCityList();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    cityList.delete(new City("Regina", "Saskatchewan"));
                });

    }

    @Test
    public void testDelete_removesCity () {
        CityList cityList = mockCityList();
        cityList.delete( new City("Edmonton", "Alberta") );
        assertEquals(0, cityList.getCities().size());
        assertFalse(cityList.hasCity(new City("Edmonton", "Alberta")));
    }


    @Test
    public void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        cityList.add(new City("Regina", "Saskatchewan"));
        assertEquals(2, cityList.countCities());
        cityList.delete(new City("Edmonton", "Alberta"));
        assertEquals(1, cityList.countCities());
    }



}
