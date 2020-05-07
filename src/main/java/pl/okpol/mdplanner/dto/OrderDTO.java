package pl.okpol.mdplanner.dto;

import pl.okpol.mdplanner.model.Pallet;

import java.time.LocalDate;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Integer offerNumber;
    private String referenceNumber;
    private Integer number;
    private String client;
    private String profileSystem;
    private String colour;
    private String profileDatedDelivery;
    private String hardwareDatedDelivery;
    private String glazingDatedDelivery;
    private String extrasDatedDelivery;
    private Integer optimizationNumber;
    private Double windowUnits;
    private Integer numberOfWindows;
    private Integer numberOfDoors;
    private Integer numberOfSlidingDoors;
    private String productionTime;
    private String dateOfShipment;
    private Integer expectationWeekNumber;
    private List<String> pallets;
    private boolean completed;
    private String comments;

    public OrderDTO(Long id, Integer offerNumber, String referenceNumber, Integer number, String client, String profileSystem, String colour, String profileDatedDelivery, String hardwareDatedDelivery, String glazingDatedDelivery, String extrasDatedDelivery, Integer optimizationNumber, Double windowUnits, Integer numberOfWindows, Integer numberOfDoors, Integer numberOfSlidingDoors, String productionTime, String dateOfShipment, Integer expectationWeekNumber, List<String> pallets, boolean completed, String comments) {
        this.id = id;
        this.offerNumber = offerNumber;
        this.referenceNumber = referenceNumber;
        this.number = number;
        this.client = client;
        this.profileSystem = profileSystem;
        this.colour = colour;
        this.profileDatedDelivery = profileDatedDelivery;
        this.hardwareDatedDelivery = hardwareDatedDelivery;
        this.glazingDatedDelivery = glazingDatedDelivery;
        this.extrasDatedDelivery = extrasDatedDelivery;
        this.optimizationNumber = optimizationNumber;
        this.windowUnits = windowUnits;
        this.numberOfWindows = numberOfWindows;
        this.numberOfDoors = numberOfDoors;
        this.numberOfSlidingDoors = numberOfSlidingDoors;
        this.productionTime = productionTime;
        this.dateOfShipment = dateOfShipment;
        this.expectationWeekNumber = expectationWeekNumber;
        this.pallets = pallets;
        this.completed = completed;
        this.comments = comments;
    }

    public OrderDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOfferNumber() {
        return offerNumber;
    }

    public void setOfferNumber(Integer offerNumber) {
        this.offerNumber = offerNumber;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
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

    public String getProfileSystem() {
        return profileSystem;
    }

    public void setProfileSystem(String profileSystem) {
        this.profileSystem = profileSystem;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getProfileDatedDelivery() {
        return profileDatedDelivery;
    }

    public void setProfileDatedDelivery(String profileDatedDelivery) {
        this.profileDatedDelivery = profileDatedDelivery;
    }

    public String getHardwareDatedDelivery() {
        return hardwareDatedDelivery;
    }

    public void setHardwareDatedDelivery(String hardwareDatedDelivery) {
        this.hardwareDatedDelivery = hardwareDatedDelivery;
    }

    public String getGlazingDatedDelivery() {
        return glazingDatedDelivery;
    }

    public void setGlazingDatedDelivery(String glazingDatedDelivery) {
        this.glazingDatedDelivery = glazingDatedDelivery;
    }

    public String getExtrasDatedDelivery() {
        return extrasDatedDelivery;
    }

    public void setExtrasDatedDelivery(String extrasDatedDelivery) {
        this.extrasDatedDelivery = extrasDatedDelivery;
    }

    public Integer getOptimizationNumber() {
        return optimizationNumber;
    }

    public void setOptimizationNumber(Integer optimizationNumber) {
        this.optimizationNumber = optimizationNumber;
    }

    public Double getWindowUnits() {
        return windowUnits;
    }

    public void setWindowUnits(Double windowUnits) {
        this.windowUnits = windowUnits;
    }

    public Integer getNumberOfWindows() {
        return numberOfWindows;
    }

    public void setNumberOfWindows(Integer numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Integer getNumberOfSlidingDoors() {
        return numberOfSlidingDoors;
    }

    public void setNumberOfSlidingDoors(Integer numberOfSlidingDoors) {
        this.numberOfSlidingDoors = numberOfSlidingDoors;
    }

    public String getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(String productionTime) {
        this.productionTime = productionTime;
    }

    public String getDateOfShipment() {
        return dateOfShipment;
    }

    public void setDateOfShipment(String dateOfShipment) {
        this.dateOfShipment = dateOfShipment;
    }

    public Integer getExpectationWeekNumber() {
        return expectationWeekNumber;
    }

    public void setExpectationWeekNumber(Integer expectationWeekNumber) {
        this.expectationWeekNumber = expectationWeekNumber;
    }

    public List<String> getPallets() {
        return pallets;
    }

    public void setPallets(List<String> pallets) {
        this.pallets = pallets;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
