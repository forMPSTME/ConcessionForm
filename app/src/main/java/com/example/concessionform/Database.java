package com.example.concessionform;

public class Database {
    private  String id;
    private  String Name;
    private  String Surname;
    private  String Apartment;
    private  String Street;
    private  String Locality;
    private  String PIN;
    private  String Gender;
    private  String Station;
    private  String Cla;
    private  String Year;
    private  String Prog;
    private  String Duration;
    private String age;
    private int wallet;
    public Database(){

    }
    public Database(String id, String Name, String Surname, String Apartment, String Street, String Locality, String PIN, String Gender, String Station, String Cla, String Year, String Prog, String Duration, String age)
    {
        this.id=id;
        this.Name=Name;
        this.Surname=Surname;
        this.Apartment=Apartment;
        this.Street=Street;
        this.Locality=Locality;
        this.PIN=PIN;
        this.Gender=Gender;
        this.Station=Station;
        this.Cla=Cla;
        this.Year=Year;
        this.Prog=Prog;
        this.Duration=Duration;
        this.age=age;
        this.wallet=wallet;

    }
    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getApartment() {
        return Apartment;
    }

    public void setApartment(String apartment) {
        Apartment = apartment;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getLocality() {
        return Locality;
    }

    public void setLocality(String locality) {
        Locality = locality;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getStation() {
        return Station;
    }

    public void setStation(String station) {
        Station = station;
    }

    public String getCla() {
        return Cla;
    }

    public void setCla(String cla) {
        Cla = cla;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getProg() {
        return Prog;
    }

    public void setProg(String prog) {
        Prog = prog;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
