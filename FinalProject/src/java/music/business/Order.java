package music.business;

import java.text.NumberFormat;
import java.io.Serializable;

public class Order implements Serializable
{
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String departureCity;
    private String arrivalCity;
    private int    numberPassenger;
    private double price;

    public Order()
    {
        firstName = "";
        lastName = "";
        address = "";
        city = "";
        state = "";
        zipCode = "";
        departureCity = "";
        arrivalCity = "";
        numberPassenger = 0;
        price = 0;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getFirstName()
    {
        return firstName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    } 
    
    public void setCity(String address)
    {
        this.city = city;
    }

    public String getCity()
    {
        return city;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }

    public String getState()
    {
        return state;
    }
    
    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getZipCode()
    {
        return zipCode;
    }
    
    public void setDepartureCity(String departureCity)
    {
        this.departureCity = departureCity;
    }

    public String getDepartureCity()
    {
        return departureCity;
    }
    
    public void setArrivalCity(String arrivalCity)
    {
        this.arrivalCity = arrivalCity;
    }

    public String getArrivalCity()
    {
        return arrivalCity;
    }
    
    public void setNumberPassenger(int numberPassenger)
    {
        this.numberPassenger = numberPassenger;
    }

    public int getNumbePassenger()
    {
        return numberPassenger;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getPrice()
    {
        return price;
    }

    public String getPriceNumberFormat()
    {
        NumberFormat number = NumberFormat.getNumberInstance();
        number.setMinimumFractionDigits(2);

        String result = "";

        if (price != 0)
        {
			result = number.format(price);
		}

        return result;
    }

    public String getPriceCurrencyFormat()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        return currency.format(price);
    }
}