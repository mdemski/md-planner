package pl.okpol.mdplanner.dto;

import com.opencsv.bean.CsvBindByName;

public class AddedOrderDTO {

    @CsvBindByName
    private Integer offer;
    @CsvBindByName
    private String reference;
    @CsvBindByName
    private Integer number;
    @CsvBindByName
    private String client;
    @CsvBindByName
    private String system;
    @CsvBindByName
    private String colour;
    @CsvBindByName
    private Double units;
    @CsvBindByName
    private Integer windows;
    @CsvBindByName
    private Integer doors;
    @CsvBindByName
    private Integer slidings;

    public AddedOrderDTO(Integer offer, String reference, Integer number, String client, String system, String colour, Double units, Integer windows, Integer numberOfDoors, Integer slidings) {
        this.offer = offer;
        this.reference = reference;
        this.number = number;
        this.client = client;
        this.system = system;
        this.colour = colour;
        this.units = units;
        this.windows = windows;
        this.doors = numberOfDoors;
        this.slidings = slidings;
    }

    public AddedOrderDTO() {
    }

    public Integer getOffer() {
        return offer;
    }

    public void setOffer(Integer offer) {
        this.offer = offer;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Double getUnits() {
        return units;
    }

    public void setUnits(Double units) {
        this.units = units;
    }

    public Integer getWindows() {
        return windows;
    }

    public void setWindows(Integer windows) {
        this.windows = windows;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer numberOfDoors) {
        this.doors = numberOfDoors;
    }

    public Integer getSlidings() {
        return slidings;
    }

    public void setSlidings(Integer slidings) {
        this.slidings = slidings;
    }
}
