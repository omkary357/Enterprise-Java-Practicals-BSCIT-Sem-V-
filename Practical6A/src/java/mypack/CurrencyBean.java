package mypack;

import javax.ejb.Stateless;

@Stateless
public class CurrencyBean {

    public double convert(double amount, String type)
    {
        if(type.equals("INR_TO_USD"))
        {
            return amount/85;
        }
        else
        {
            return amount*85;
        }
    }

}