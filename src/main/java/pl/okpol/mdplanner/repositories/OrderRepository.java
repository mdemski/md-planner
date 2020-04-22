package pl.okpol.mdplanner.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.okpol.mdplanner.model.AbstractEntity;
import pl.okpol.mdplanner.model.Order;

public interface OrderRepository<T extends AbstractEntity, L extends Number> extends JpaRepository<Order, Long> {
    
    @Query(value = "SELECT * FROM orders WHERE completed = 0", nativeQuery = true)
    Page<Order> findAllByInCompleted(Pageable pageable);
}
