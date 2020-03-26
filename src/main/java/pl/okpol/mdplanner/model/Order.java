package pl.okpol.mdplanner.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {

    private Integer offerNumber;
    private String referenceNumber;
    private Integer number;
    private String client;
    private String profileSystem;
    private String colour;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate profileDatedDelivery;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hardwareDatedDelivery;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate glazingDatedDelivery;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate extrasDatedDelivery;
    private Integer optimizationNumber;
    private Double windowUnits;
    private Integer numberOfWindows;
    private Integer numberOfDoors;
    private Integer numberOfSlidingDoors;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate productionTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfShipment;
    private Integer expectationWeekNumber;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ORDER_PALLET", joinColumns = {
            @JoinColumn(name = "ORDER_ID") },
            inverseJoinColumns = {@JoinColumn(name = "PALLET_ID")})
    private List<Pallet> pallets;
    private boolean completed;
    private String comments;


    public Order(Integer offerNumber, String referenceNumber, Integer number, String client, String profileSystem, String colour, LocalDate profileDatedDelivery, LocalDate hardwareDatedDelivery, LocalDate glazingDatedDelivery, LocalDate extrasDatedDelivery, Integer optimizationNumber, Double windowUnits, Integer numberOfWindows, Integer numberOfDoors, Integer numberOfSlidingDoors, LocalDate productionTime, LocalDate dateOfShipment, Integer expectationWeekNumber, List<Pallet> pallets, boolean completed, String comments) {
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

    public Order() {
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

    public void setProfileSystem(String system) {
        this.profileSystem = system;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public LocalDate getProfileDatedDelivery() {
        return profileDatedDelivery;
    }

    public void setProfileDatedDelivery(LocalDate profileDatedDelivery) {
        this.profileDatedDelivery = profileDatedDelivery;
    }

    public LocalDate getHardwareDatedDelivery() {
        return hardwareDatedDelivery;
    }

    public void setHardwareDatedDelivery(LocalDate hardwareDatedDelivery) {
        this.hardwareDatedDelivery = hardwareDatedDelivery;
    }

    public LocalDate getGlazingDatedDelivery() {
        return glazingDatedDelivery;
    }

    public void setGlazingDatedDelivery(LocalDate glazingDatedDelivery) {
        this.glazingDatedDelivery = glazingDatedDelivery;
    }

    public LocalDate getExtrasDatedDelivery() {
        return extrasDatedDelivery;
    }

    public void setExtrasDatedDelivery(LocalDate extrasDatedDelivery) {
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

    public void setNumberOfWindows(Integer numberOfWindow) {
        this.numberOfWindows = numberOfWindow;
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

    public LocalDate getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(LocalDate productionTime) {
        this.productionTime = productionTime;
    }

    public LocalDate getDateOfShipment() {
        return dateOfShipment;
    }

    public void setDateOfShipment(LocalDate dateOfShipment) {
        this.dateOfShipment = dateOfShipment;
    }

    public Integer getExpectationWeekNumber() {
        return expectationWeekNumber;
    }

    public void setExpectationWeekNumber(Integer expectationWeekNumber) {
        this.expectationWeekNumber = expectationWeekNumber;
    }

    public List<Pallet> getPallets() {
        return pallets;
    }

    public void setPallets(List<Pallet> palletList) {
        this.pallets = palletList;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return completed == order.completed &&
                Objects.equals(offerNumber, order.offerNumber) &&
                Objects.equals(referenceNumber, order.referenceNumber) &&
                Objects.equals(number, order.number) &&
                Objects.equals(client, order.client) &&
                Objects.equals(profileSystem, order.profileSystem) &&
                Objects.equals(colour, order.colour) &&
                Objects.equals(profileDatedDelivery, order.profileDatedDelivery) &&
                Objects.equals(hardwareDatedDelivery, order.hardwareDatedDelivery) &&
                Objects.equals(glazingDatedDelivery, order.glazingDatedDelivery) &&
                Objects.equals(extrasDatedDelivery, order.extrasDatedDelivery) &&
                Objects.equals(optimizationNumber, order.optimizationNumber) &&
                Objects.equals(windowUnits, order.windowUnits) &&
                Objects.equals(numberOfWindows, order.numberOfWindows) &&
                Objects.equals(numberOfDoors, order.numberOfDoors) &&
                Objects.equals(numberOfSlidingDoors, order.numberOfSlidingDoors) &&
                Objects.equals(productionTime, order.productionTime) &&
                Objects.equals(dateOfShipment, order.dateOfShipment) &&
                Objects.equals(expectationWeekNumber, order.expectationWeekNumber) &&
                Objects.equals(pallets, order.pallets) &&
                Objects.equals(comments, order.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), offerNumber, referenceNumber, number, client, profileSystem, colour, profileDatedDelivery, hardwareDatedDelivery, glazingDatedDelivery, extrasDatedDelivery, optimizationNumber, windowUnits, numberOfWindows, numberOfDoors, numberOfSlidingDoors, productionTime, dateOfShipment, expectationWeekNumber, pallets, completed, comments);
    }

    @Override
    public String toString() {
        return "Order{" +
                "offerNumber=" + offerNumber +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", number=" + number +
                ", client='" + client + '\'' +
                ", system='" + profileSystem + '\'' +
                ", colour='" + colour + '\'' +
                ", profileDatedDelivery=" + profileDatedDelivery +
                ", hardwareDatedDelivery=" + hardwareDatedDelivery +
                ", glazingDatedDelivery=" + glazingDatedDelivery +
                ", extrasDatedDelivery=" + extrasDatedDelivery +
                ", optimizationNumber=" + optimizationNumber +
                ", windowUnits=" + windowUnits +
                ", numberOfWindows=" + numberOfWindows +
                ", numberOfDoors=" + numberOfDoors +
                ", numberOfSlidingDoors=" + numberOfSlidingDoors +
                ", productionTime=" + productionTime +
                ", dateOfShipment=" + dateOfShipment +
                ", expectationWeekNumber=" + expectationWeekNumber +
                ", pallets=" + pallets +
                ", completed=" + completed +
                ", comments='" + comments + '\'' +
                '}';
    }
}
