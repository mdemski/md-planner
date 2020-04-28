package pl.okpol.mdplanner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pallets")
public class Pallet extends AbstractEntity {

    private String size;
    @ManyToMany (fetch = FetchType.LAZY, mappedBy = "pallets")
    @JsonIgnore
    private List<Order> orders;

    public Pallet() {
    }

    public Pallet(String size, List<Order> orders) {
        this.size = size;
        this.orders = orders;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pallet pallet = (Pallet) o;
        return Objects.equals(size, pallet.size) &&
                Objects.equals(orders, pallet.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, orders);
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
