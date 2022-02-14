package com.example.hellospring.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class ShowDay {

    public String calculateToday(String date){

        int day;
        int month;
        int year;
        try {
            String[] inputDate = date.split("/");
            day = Integer.parseInt(inputDate[0]);
            month = Integer.parseInt(inputDate[1]);
            year = Integer.parseInt(inputDate[2]);
        } catch (Exception e){
            LocalDate currentDate = LocalDate.now();
            day = currentDate.getDayOfMonth();
            month = currentDate.getMonthValue();
            year = currentDate.getYear();
        }

        if (month == 1)
        {
            month = 13;
            year--;
        }
        if (month == 2)
        {
            month = 14;
            year--;
        }

        int j = year/100;
        int k = year%100;

        int h = (day + ( 13 * (month + 1) / 5 ) + k + ( k / 4 )  + ( j / 4 ) - (2 * j) ) % 7;
        h = ((h+5)%7)+1;
        if (h == 5) {
            return "Is Day Friday? Yes ";
        } else {
            return "Is Day Friday? No ";
        }




    }





} // class ends here
