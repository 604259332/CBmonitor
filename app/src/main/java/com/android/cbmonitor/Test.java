package com.android.cbmonitor;

import android.content.Intent;

import com.android.cbmonitor.bitutils.BitwiseOutputStream;
import com.android.cbmonitor.bitutils.HexDump;

public class Test {

    public static void main(String[] args){



        try{
            BitwiseOutputStream outStream = new BitwiseOutputStream(2);

            outStream.write(2,2);
            outStream.write(8 ,(147 & 0x3fc)>>2);
            outStream.write(2 ,(147 & 0x3));
            outStream.write(4 ,12);

            String s = HexDump.dumpHexString(outStream.toByteArray());

            System.out.println(s);
        }catch (Exception e){
            e.printStackTrace();
        }


    }




}
