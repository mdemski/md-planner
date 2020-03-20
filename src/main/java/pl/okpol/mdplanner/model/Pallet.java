package pl.okpol.mdplanner.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pallets")
public class Pallet extends AbstractEntity {

    private Integer width;
    private Integer depth;
    private Integer height;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ORDER_PALLET", joinColumns = {
            @JoinColumn(name = "ORDER_ID", nullable = false) },
            inverseJoinColumns = {@JoinColumn(name = "PALLET_ID", nullable = false)})
    private List<Order> orders;

    public Pallet() {
    }

    public Pallet(Integer width, Integer depth, Integer height, List<Order> orders) {
        this.width = width;
        this.depth = depth;
        this.height = height;
        this.orders = orders;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pallet pallet = (Pallet) o;
        return Objects.equals(width, pallet.width) &&
                Objects.equals(depth, pallet.depth) &&
                Objects.equals(height, pallet.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, depth, height);
    }
}
