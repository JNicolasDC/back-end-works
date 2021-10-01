package com.nicolasdeaza;

public class Card extends Payment{

    String number;
    String cvv;
    String date;

    public Card(Integer id, String number, String cvv, String date){
        super(id);
        this.number = number;
        this.cvv = cvv;
        this.date = date;
    }
}
