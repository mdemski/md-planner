package pl.okpol.mdplanner.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.okpol.mdplanner.dto.AddedOrderDTO;
import pl.okpol.mdplanner.dto.OrderDTO;
import pl.okpol.mdplanner.model.Order;
import pl.okpol.mdplanner.repositories.OrderRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {

    private OrderRepository orderRepository;
    private static final LocalDate defaultDate = LocalDate.parse("1991-01-01");

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void saveOrderInDB(AddedOrderDTO addedOrderDTO) {
        Order order = new Order();
        order.setOfferNumber(addedOrderDTO.getOffer());
        order.setReferenceNumber(addedOrderDTO.getReference());
        order.setNumber(addedOrderDTO.getNumber());
        order.setClient(addedOrderDTO.getClient());
        order.setProfileSystem(addedOrderDTO.getSystem());
        order.setColour(addedOrderDTO.getColour());
//        order.setProfileDatedDelivery(defaultDate);
//        order.setHardwareDatedDelivery(defaultDate);
//        order.setGlazingDatedDelivery(defaultDate);
//        order.setExtrasDatedDelivery(defaultDate);
//        order.setOptimizationNumber(0);
        order.setWindowUnits(addedOrderDTO.getUnits());
        order.setNumberOfWindows(addedOrderDTO.getWindows());
        order.setNumberOfDoors(addedOrderDTO.getDoors());
        order.setNumberOfSlidingDoors(addedOrderDTO.getSlidings());
//        order.setProductionTime(defaultDate);
//        order.setDateOfShipment(defaultDate);
//        order.setExpectationWeekNumber(LocalDate.now().getDayOfYear()/7);
//        order.setPallets(new ArrayList<>());
        order.setCompleted(false);
//        order.setComments("");
        orderRepository.save(order);
    }

    public List<OrderDTO> getAllOrders(){
        Page ordersDTO = orderRepository.findAllByInCompleted(PageRequest.of(0,100));
        List<Order> content = ordersDTO.getContent();
        return content.stream().map(source -> {
            OrderDTO dto = new OrderDTO();
            dto.setId(source.getId());
            dto.setOfferNumber(source.getOfferNumber());
            dto.setReferenceNumber(source.getReferenceNumber());
            dto.setNumber(source.getNumber());
            dto.setClient(source.getClient());
            dto.setProfileSystem(source.getProfileSystem());
            dto.setColour(source.getColour());
            dto.setProfileDatedDelivery(source.getProfileDatedDelivery());
            dto.setHardwareDatedDelivery(source.getHardwareDatedDelivery());
            dto.setGlazingDatedDelivery(source.getGlazingDatedDelivery());
            dto.setExtrasDatedDelivery(source.getExtrasDatedDelivery());
            dto.setOptimizationNumber(source.getOptimizationNumber());
            dto.setWindowUnits(source.getWindowUnits());
            dto.setNumberOfWindows(source.getNumberOfWindows());
            dto.setNumberOfDoors(source.getNumberOfDoors());
            dto.setNumberOfSlidingDoors(source.getNumberOfSlidingDoors());
            dto.setProductionTime(source.getProductionTime());
            dto.setDateOfShipment(source.getDateOfShipment());
            dto.setExpectationWeekNumber(source.getExpectationWeekNumber());
            dto.setPallets(source.getPallets());
            dto.setCompleted(source.isCompleted());
            dto.setComments(source.getComments());
            return dto;
        }).collect(Collectors.toList());
    }

    public Order findOneById(Long id) throws Throwable {
        return (Order) orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No id"));
    }

    public Order findOneByNumber(Integer number) {
        return orderRepository.findByNumber(number);
    }
}
