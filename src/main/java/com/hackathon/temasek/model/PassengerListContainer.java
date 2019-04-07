
package com.hackathon.temasek.model;

import java.util.LinkedList;
import java.util.List;


public class PassengerListContainer {

    //Important. Set this to a default List in order to avoid null pointer exceptions when the list is empty
    private List<Passenger> passengerList = new LinkedList<Passenger>();

    public PassengerListContainer() {
    }

    public PassengerListContainer(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }
}
