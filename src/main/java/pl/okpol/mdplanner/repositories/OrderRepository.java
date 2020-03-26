package pl.okpol.mdplanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.okpol.mdplanner.model.AbstractEntity;
import pl.okpol.mdplanner.model.Order;

public interface OrderRepository<T extends AbstractEntity, L extends Number> extends JpaRepository<Order, Long> {
}
