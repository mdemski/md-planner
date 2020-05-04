package pl.okpol.mdplanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.okpol.mdplanner.model.Pallet;

public interface PalletRepository extends JpaRepository<Pallet, Long> {

}
