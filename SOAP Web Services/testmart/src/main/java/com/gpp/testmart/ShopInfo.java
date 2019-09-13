package com.gpp.testmart;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ShopInfo {

    @WebMethod
    @WebResult(partName = "lookupOutput")
    public String getShopInfo(@WebParam(partName = "lookupInput") String property) throws InvalidInputException {
        String response = "Invalid property";
        if ("ShopName".equals(property) ) {
            response = "Test Mart";
        }
        else if ("since".equals(property)) {
            response = "since 2012";
        }
        else {
            throw new InvalidInputException("Invalid Input", property + "is not  a valid input");
        }
        return response;
    }

}
