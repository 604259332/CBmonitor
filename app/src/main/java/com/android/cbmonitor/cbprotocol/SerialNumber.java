package com.android.cbmonitor.cbprotocol;

import com.android.cbmonitor.bitutils.BitwiseOutputStream;
import com.android.cbmonitor.bitutils.HexDump;

/**
 * @info as defined in 3gpp TS 23.041, section 9.4.1.2.1 Serial Number
 * The serial number combines geographical scope, message code, and update number.
 */
public class SerialNumber extends BaseParams{

    public final int SIZE = 2;
    public int mGeographicalScope;
    public int mMessageCode;
    public int mUpdateNumber;

    public SerialNumber(int mGeographicalScope, int mMessageCode, int mUpdateNumber) {
        this.mGeographicalScope = mGeographicalScope;
        this.mMessageCode = mMessageCode;
        this.mUpdateNumber = mUpdateNumber;
    }


    @Override
    public byte[] toByteArray() {
        try{
            BitwiseOutputStream outStream = new BitwiseOutputStream(SIZE);

            outStream.write(2,mGeographicalScope);
            outStream.write(8 ,(mMessageCode & 0x3fc)>>2);
            outStream.write(2 ,(mMessageCode & 0x3));
            outStream.write(4 ,mUpdateNumber);
            return outStream.toByteArray();

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toHexString() {
        if(toByteArray() == null){
            return "";
        }

        return HexDump.toHexString(toByteArray());
    }
}
