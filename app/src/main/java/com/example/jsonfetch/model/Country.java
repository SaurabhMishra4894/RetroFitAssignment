package com.example.jsonfetch.model;

/**
 * Class Country defines the Country state
 * Country will have two features Name and Capital
 *
 */
public class Country {
    private String name;
    private String capital;

    /**
     * Constructor for class Country which will get values name and capital
     *
     * @param name
     * @param capital
     */
    Country(String name, String capital){
        this.name = name;
        this.capital = capital;
    }

    /*
     ^Methpd tO get Name of the Country
     */
    public String getName() {
        return name;
    }


    /*
     ^Methpd tO get Capital of the Country
     */
    public String getCapital() {
        return capital;
    }


}
