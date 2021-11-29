package com.android.cbmonitor;

import com.android.cbmonitor.cbprotocol.SerialNumber;

public class MainTest {

    public static void main(String[] args){


        SerialNumber serialNumber = new SerialNumber(2,
                150,12);
        System.out.println(serialNumber.toHexString());
        System.out.println("fffff");



    }
}
