package com.example.listycity;
import java.time.LocalDate;
import java.util.Objects;


/**
 *
 *  This is a class that defines a City.
 *  A city has a name and a province.
 */

public class City  implements Comparable<Object> {
    private String city;
    private String province;


/**
 *  This is a constructor for the City class.
 *  @param city
 *  This is the name of the city
 *  @param province
 *  This is the name of the province
 **/

    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }
/**
 *  This is a getter for the city name.
 *  @return
 *  Return the city name
 * */



    public String getCityName() {
        return city;
    }

    /**
     *  This is a getter for the province name.
     *  @return
     *  Return the province name
     * */

    public String getProvinceName() {
        return province;
    }


    /**
     *  This is a comparator for the City class.
     *  @param o
     *  This is the other city to compare to
     *  @return
     *  Return the comparison result
     */
    @Override
    public int compareTo(Object o) {
      City city = (City) o;
      return this.city.compareTo(city.getCityName());   // this.city refers to the city name
    }


    /**
     * Logical equality: case-insensitive on both city and province.
     * @param o
     * @return
     * Return true if the cities are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City other = (City) o;
        return city.equalsIgnoreCase(other.city)
                && province.equalsIgnoreCase(other.province);
    }

    /**
     * Hash consistent with equals: use lower-cased fields.
     * @return
     * Return the hash code
     */
    @Override
    public int hashCode() {

        return Objects.hash(city.toLowerCase(), province.toLowerCase());
    }


    
    /**
     * String representation: city, province.
     * @return
     * Return the string representation
     */

    @Override
    public String toString() {
        return city + ", " + province;
    }




}
