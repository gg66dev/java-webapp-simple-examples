package com.gpp.GeoIPService;

import com.lavasoft.GeoIPService;
import com.lavasoft.GeoIPServiceSoap;

public class IPLocationFinder {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("You need to pass in one IP Address");
        } else {
            String ipAddress = args[0];
            GeoIPService ipService = new GeoIPService();
            GeoIPServiceSoap geoIPServiceSoap = ipService.getGeoIPServiceSoap();
            String location = geoIPServiceSoap.getIpLocation(ipAddress);
            System.out.println(location);
        }
    }
}
