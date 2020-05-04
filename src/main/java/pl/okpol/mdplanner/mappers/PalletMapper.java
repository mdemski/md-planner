package pl.okpol.mdplanner.mappers;

import org.springframework.stereotype.Component;
import pl.okpol.mdplanner.model.Pallet;

import java.util.ArrayList;
import java.util.List;

@Component
public class PalletMapper {
    public List<Pallet> fromStringToPalletsConverter(List<String> palletsFromRequest) {
        List<Pallet> pallets = new ArrayList<>();
        palletsFromRequest.forEach(pallet -> {
            Pallet pallet1 = new Pallet();
            pallet1.setSize(pallet);
            pallets.add(pallet1);
        });
        return pallets;
    }

    public List<String> fromPalletsToStringConverter(List<Pallet> palletList) {
        List<String> stringListPallet = new ArrayList<>();
        palletList.forEach(pallet -> {
            stringListPallet.add(pallet.toString());
        });
        return stringListPallet;
    }
}
