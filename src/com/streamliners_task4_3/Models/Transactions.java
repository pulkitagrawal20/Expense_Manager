package com.streamliners_task4_3.Models;

import java.util.Date;

public class Transactions {
    public float amount;
    public int tranType;
    public String date;
    public String info;

    public Transactions(float amount,int tranType,String date,String info){

        this.amount = amount;
        this.tranType = tranType;
        this.date = date;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "amount=" + amount +
                ", tranType=" + tranType +
                ", date=" + date +
                ", info='" + info + '\'' +
                '}';
    }

}

