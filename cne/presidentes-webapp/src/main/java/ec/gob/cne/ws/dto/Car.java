/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.cne.ws.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edwin
 */
public class Car {

    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private int year;
    @Getter
    @Setter
    private String brand;
    @Getter
    @Setter
    private String color;
    @Getter
    @Setter
    private int price;
    @Getter
    @Setter
    private boolean sold;

    public Car(String id, String brand, int year, String color, int price, boolean sold) {
        this.id = id;
        this.year = year;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.sold = sold;
    }

}
