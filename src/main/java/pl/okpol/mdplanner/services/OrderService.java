package pl.okpol.mdplanner.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.okpol.mdplanner.dto.AddedOrderDTO;
import pl.okpol.mdplanner.dto.OrderDTO;
import pl.okpol.mdplanner.mappers.DateConverter;
import pl.okpol.mdplanner.mappers.PalletMapper;
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
    private PalletMapper palletMapper;
//    private static final LocalDate defaultDate = LocalDate.parse("01-01-1991");

    public OrderService(OrderRepository orderRepository, PalletMapper palletMapper) {
        this.orderRepository = orderRepository;
        this.palletMapper = palletMapper;
    }

    public void saveOrderInDB(AddedOrderDTO addedOrderDTO) {
        List<Order> orders = orderRepository.findAll();
        orders.forEach(o -> {
            if (!o.getNumber().equals(addedOrderDTO.getNumber())) {
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
        });
    }

    public List<OrderDTO> getAllOrders() {
        Page<Order> ordersDTO = orderRepository.findAllByInCompleted(PageRequest.of(0, 100));
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
            dto.setProfileDatedDelivery(DateConverter.convertFromDateToString(source.getProfileDatedDelivery()));
            dto.setHardwareDatedDelivery(DateConverter.convertFromDateToString(source.getHardwareDatedDelivery()));
            dto.setGlazingDatedDelivery(DateConverter.convertFromDateToString(source.getGlazingDatedDelivery()));
            dto.setExtrasDatedDelivery(DateConverter.convertFromDateToString(source.getExtrasDatedDelivery()));
            dto.setOptimizationNumber(source.getOptimizationNumber());
            dto.setWindowUnits(source.getWindowUnits());
            dto.setNumberOfWindows(source.getNumberOfWindows());
            dto.setNumberOfDoors(source.getNumberOfDoors());
            dto.setNumberOfSlidingDoors(source.getNumberOfSlidingDoors());
            dto.setProductionTime(DateConverter.convertFromDateToString(source.getProductionTime()));
            dto.setDateOfShipment(DateConverter.convertFromDateToString(source.getDateOfShipment()));
            dto.setExpectationWeekNumber(source.getExpectationWeekNumber());
            dto.setPallets(palletMapper.fromPalletsToStringConverter(source.getPallets()));
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

    public void updateOrder(Integer number, OrderDTO orderDTO) {
        Order order = orderRepository.findByNumber(number);
        order.setProfileDatedDelivery(DateConverter.convertFromStringToDate(orderDTO.getProfileDatedDelivery()));
        order.setHardwareDatedDelivery(DateConverter.convertFromStringToDate(orderDTO.getHardwareDatedDelivery()));
        order.setGlazingDatedDelivery(DateConverter.convertFromStringToDate(orderDTO.getGlazingDatedDelivery()));
        order.setExtrasDatedDelivery(DateConverter.convertFromStringToDate(orderDTO.getExtrasDatedDelivery()));
        order.setOptimizationNumber(orderDTO.getOptimizationNumber());
        order.setProductionTime(DateConverter.convertFromStringToDate(orderDTO.getProductionTime()));
        order.setDateOfShipment(DateConverter.convertFromStringToDate(orderDTO.getDateOfShipment()));
        order.setPallets(palletMapper.fromStringToPalletsConverter(orderDTO.getPallets()));
        order.setCompleted(orderDTO.isCompleted());
        order.setComments(orderDTO.getComments());
        orderRepository.save(order);
    }

    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }
}
