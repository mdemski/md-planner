package pl.okpol.mdplanner.mappers;

import org.springframework.stereotype.Component;
import pl.okpol.mdplanner.dto.AddedOrderDTO;
import pl.okpol.mdplanner.dto.OrderDTO;
import pl.okpol.mdplanner.model.Order;
import pl.okpol.mdplanner.model.Pallet;
import pl.okpol.mdplanner.services.OrderService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {

    private OrderService orderService;
    private static final LocalDate defaultDate = LocalDate.parse("1991-01-01");

    public OrderMapper(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderDTO convertToOrderDTO(Order entity) {
        OrderDTO dto = new OrderDTO();
        dto.setId(entity.getId());
        dto.setOfferNumber(entity.getOfferNumber());
        dto.setReferenceNumber(entity.getReferenceNumber());
        dto.setNumber(entity.getNumber());
        dto.setClient(entity.getClient());
        dto.setProfileSystem(entity.getProfileSystem());
        dto.setColour(entity.getColour());
        dto.setProfileDatedDelivery(entity.getProfileDatedDelivery());
        dto.setHardwareDatedDelivery(entity.getHardwareDatedDelivery());
        dto.setGlazingDatedDelivery(entity.getGlazingDatedDelivery());
        dto.setExtrasDatedDelivery(entity.getExtrasDatedDelivery());
        dto.setOptimizationNumber(entity.getOptimizationNumber());
        dto.setWindowUnits(entity.getWindowUnits());
        dto.setNumberOfWindows(entity.getNumberOfWindows());
        dto.setNumberOfDoors(entity.getNumberOfDoors());
        dto.setNumberOfSlidingDoors(entity.getNumberOfSlidingDoors());
        dto.setProductionTime(entity.getProductionTime());
        dto.setDateOfShipment(entity.getDateOfShipment());
        dto.setExpectationWeekNumber(entity.getExpectationWeekNumber());
        dto.setPallets(fromPalletsToStringConverter(entity.getPallets()));
        dto.setCompleted(entity.isCompleted());
        dto.setComments(entity.getComments());
        return dto;
    }

    public Order convertToEntityOrder(OrderDTO orderDTO) throws Throwable {
        Order order = new Order();
        order.setOfferNumber(orderDTO.getOfferNumber());
        order.setReferenceNumber(orderDTO.getReferenceNumber());
        order.setNumber(orderDTO.getNumber());
        order.setClient(orderDTO.getClient());
        order.setProfileSystem(orderDTO.getProfileSystem());
        order.setColour(orderDTO.getColour());
        order.setProfileDatedDelivery(orderDTO.getProfileDatedDelivery());
        order.setHardwareDatedDelivery(orderDTO.getHardwareDatedDelivery());
        order.setGlazingDatedDelivery(orderDTO.getGlazingDatedDelivery());
        order.setExtrasDatedDelivery(orderDTO.getExtrasDatedDelivery());
        order.setOptimizationNumber(orderDTO.getOptimizationNumber());
        order.setWindowUnits(orderDTO.getWindowUnits());
        order.setNumberOfWindows(orderDTO.getNumberOfWindows());
        order.setNumberOfDoors(orderDTO.getNumberOfDoors());
        order.setNumberOfSlidingDoors(orderDTO.getNumberOfSlidingDoors());
        order.setProductionTime(orderDTO.getProductionTime());
        order.setDateOfShipment(orderDTO.getDateOfShipment());
        order.setExpectationWeekNumber(orderDTO.getExpectationWeekNumber());
        order.setPallets(fromStringToPalletsConverter(orderDTO.getPallets()));
        order.setCompleted(orderDTO.isCompleted());
        order.setComments(orderDTO.getComments());
        return order;
    }

    public List<Order> convertToListEntityOrderFromAddDTO(List<AddedOrderDTO> orders) {
        List<Order> orderEntityList = new ArrayList<>();
        for (AddedOrderDTO order : orders) {
            Order tempOrder = new Order();
            tempOrder.setOfferNumber(order.getOffer());
            tempOrder.setReferenceNumber(order.getReference());
            tempOrder.setNumber(order.getNumber());
            tempOrder.setClient(order.getClient());
            tempOrder.setProfileSystem(order.getSystem());
            tempOrder.setColour(order.getColour());
            tempOrder.setWindowUnits(order.getUnits());
            tempOrder.setNumberOfWindows(order.getWindows());
            tempOrder.setNumberOfDoors(order.getDoors());
            tempOrder.setNumberOfSlidingDoors(order.getSlidings());
            orderEntityList.add(tempOrder);
        }
        return orderEntityList;
    }

    public List<Order> convertToEntityOrders(List<OrderDTO> orderDTOS) {
        List<Order> orders = new ArrayList<>();
        orderDTOS.forEach(orderDTO -> {
            Order order = new Order();
            order.setOfferNumber(orderDTO.getOfferNumber());
            order.setReferenceNumber(orderDTO.getReferenceNumber());
            order.setNumber(orderDTO.getNumber());
            order.setClient(orderDTO.getClient());
            order.setProfileSystem(orderDTO.getProfileSystem());
            order.setColour(orderDTO.getColour());
            order.setProfileDatedDelivery(orderDTO.getProfileDatedDelivery());
            order.setHardwareDatedDelivery(orderDTO.getHardwareDatedDelivery());
            order.setGlazingDatedDelivery(orderDTO.getGlazingDatedDelivery());
            order.setExtrasDatedDelivery(orderDTO.getExtrasDatedDelivery());
            order.setOptimizationNumber(orderDTO.getOptimizationNumber());
            order.setWindowUnits(orderDTO.getWindowUnits());
            order.setNumberOfWindows(orderDTO.getNumberOfWindows());
            order.setNumberOfDoors(orderDTO.getNumberOfDoors());
            order.setNumberOfSlidingDoors(orderDTO.getNumberOfSlidingDoors());
            order.setProductionTime(orderDTO.getProductionTime());
            order.setDateOfShipment(orderDTO.getDateOfShipment());
            order.setExpectationWeekNumber(orderDTO.getExpectationWeekNumber());
            order.setPallets(fromStringToPalletsConverter(orderDTO.getPallets()));
            order.setCompleted(orderDTO.isCompleted());
            order.setComments(orderDTO.getComments());
            orders.add(order);
        });
        return orders;
    }

    private List<String> fromPalletsToStringConverter(List<Pallet> palletList) {
        List<String> stringListPallet = new ArrayList<>();
        palletList.forEach(pallet -> {
            stringListPallet.add(pallet.toString());
        });
        return stringListPallet;
    }

    private List<Pallet> fromStringToPalletsConverter(List<String> palletsFromRequest) {
        List<Pallet> pallets = new ArrayList<>();
        palletsFromRequest.forEach(pallet -> {
            Pallet pallet1 = new Pallet();
            pallet1.setSize(pallet);
            pallets.add(pallet1);
        });
        return pallets;
    }

}

//    public OrderDTO convertToOrderDTO(Order entity) {
//        OrderDTO dto = new OrderDTO();
//        dto.setId(entity.getId());
//        dto.setOfferNumber(entity.getOfferNumber());
//        dto.setReferenceNumber(entity.getReferenceNumber());
//        dto.setNumber(entity.getNumber());
//        dto.setClient(entity.getClient());
//        dto.setProfileSystem(entity.getProfileSystem());
//        dto.setColour(entity.getColour());
//        dto.setProfileDatedDelivery(DateConverter.convertFromDateToString(entity.getProfileDatedDelivery()));
//        dto.setHardwareDatedDelivery(DateConverter.convertFromDateToString(entity.getHardwareDatedDelivery()));
//        dto.setGlazingDatedDelivery(DateConverter.convertFromDateToString(entity.getGlazingDatedDelivery()));
//        dto.setExtrasDatedDelivery(DateConverter.convertFromDateToString(entity.getExtrasDatedDelivery()));
//        dto.setOptimizationNumber(entity.getOptimizationNumber());
//        dto.setWindowUnits(entity.getWindowUnits());
//        dto.setNumberOfWindows(entity.getNumberOfWindows());
//        dto.setNumberOfDoors(entity.getNumberOfDoors());
//        dto.setNumberOfSlidingDoors(entity.getNumberOfSlidingDoors());
//        dto.setProductionTime(DateConverter.convertFromDateToString(entity.getProductionTime()));
//        dto.setDateOfShipment(DateConverter.convertFromDateToString(entity.getDateOfShipment()));
//        dto.setExpectationWeekNumber(entity.getExpectationWeekNumber());
//        dto.setPallets(fromPalletsToStringConverter(entity.getPallets()));
//        dto.setCompleted(entity.isCompleted());
//        dto.setComments(entity.getComments());
//        return dto;
//    }
//
//    public Order convertToEntityOrder(OrderDTO orderDTO) throws Throwable {
//        Order order = new Order();
//        order.setOfferNumber(orderDTO.getOfferNumber());
//        order.setReferenceNumber(orderDTO.getReferenceNumber());
//        order.setNumber(orderDTO.getNumber());
//        order.setClient(orderDTO.getClient());
//        order.setProfileSystem(orderDTO.getProfileSystem());
//        order.setColour(orderDTO.getColour());
//        order.setProfileDatedDelivery(DateConverter.convertFromStringToDate(orderDTO.getProfileDatedDelivery()));
//        order.setHardwareDatedDelivery(DateConverter.convertFromStringToDate(orderDTO.getHardwareDatedDelivery()));
//        order.setGlazingDatedDelivery(DateConverter.convertFromStringToDate(orderDTO.getGlazingDatedDelivery()));
//        order.setExtrasDatedDelivery(DateConverter.convertFromStringToDate(orderDTO.getExtrasDatedDelivery()));
//        order.setOptimizationNumber(orderDTO.getOptimizationNumber());
//        order.setWindowUnits(orderDTO.getWindowUnits());
//        order.setNumberOfWindows(orderDTO.getNumberOfWindows());
//        order.setNumberOfDoors(orderDTO.getNumberOfDoors());
//        order.setNumberOfSlidingDoors(orderDTO.getNumberOfSlidingDoors());
//        order.setProductionTime(DateConverter.convertFromStringToDate(orderDTO.getProductionTime()));
//        order.setDateOfShipment(DateConverter.convertFromStringToDate(orderDTO.getDateOfShipment()));
//        order.setExpectationWeekNumber(orderDTO.getExpectationWeekNumber());
//        order.setPallets(fromStringToPalletsConverter(orderDTO.getPallets()));
//        order.setCompleted(orderDTO.isCompleted());
//        order.setComments(orderDTO.getComments());
//        return order;
//    }
//
//    public List<Order> convertToListEntityOrderFromAddDTO(List<AddedOrderDTO> orders) {
//        List<Order> orderEntityList = new ArrayList<>();
//        for (AddedOrderDTO order : orders) {
//            Order tempOrder = new Order();
//            tempOrder.setOfferNumber(order.getOffer());
//            tempOrder.setReferenceNumber(order.getReference());
//            tempOrder.setNumber(order.getNumber());
//            tempOrder.setClient(order.getClient());
//            tempOrder.setProfileSystem(order.getSystem());
//            tempOrder.setColour(order.getColour());
//            tempOrder.setWindowUnits(order.getUnits());
//            tempOrder.setNumberOfWindows(order.getWindows());
//            tempOrder.setNumberOfDoors(order.getDoors());
//            tempOrder.setNumberOfSlidingDoors(order.getSlidings());
//            orderEntityList.add(tempOrder);
//        }
//        return orderEntityList;
//    }
//
//    public List<Order> convertToEntityOrders(List<OrderDTO> orderDTOS) {
//        List<Order> orders = new ArrayList<>();
//        orderDTOS.forEach(orderDTO -> {
//            Order order = new Order();
//            order.setOfferNumber(orderDTO.getOfferNumber());
//            order.setReferenceNumber(orderDTO.getReferenceNumber());
//            order.setNumber(orderDTO.getNumber());
//            order.setClient(orderDTO.getClient());
//            order.setProfileSystem(orderDTO.getProfileSystem());
//            order.setColour(orderDTO.getColour());
//            order.setProfileDatedDelivery(DateConverter.convertFromStringToDate(orderDTO.getProfileDatedDelivery()));
//            order.setHardwareDatedDelivery(DateConverter.convertFromStringToDate(orderDTO.getHardwareDatedDelivery()));
//            order.setGlazingDatedDelivery(DateConverter.convertFromStringToDate(orderDTO.getGlazingDatedDelivery()));
//            order.setExtrasDatedDelivery(DateConverter.convertFromStringToDate(orderDTO.getExtrasDatedDelivery()));
//            order.setOptimizationNumber(orderDTO.getOptimizationNumber());
//            order.setWindowUnits(orderDTO.getWindowUnits());
//            order.setNumberOfWindows(orderDTO.getNumberOfWindows());
//            order.setNumberOfDoors(orderDTO.getNumberOfDoors());
//            order.setNumberOfSlidingDoors(orderDTO.getNumberOfSlidingDoors());
//            order.setProductionTime(DateConverter.convertFromStringToDate(orderDTO.getProductionTime()));
//            order.setDateOfShipment(DateConverter.convertFromStringToDate(orderDTO.getDateOfShipment()));
//            order.setExpectationWeekNumber(orderDTO.getExpectationWeekNumber());
//            order.setPallets(fromStringToPalletsConverter(orderDTO.getPallets()));
//            order.setCompleted(orderDTO.isCompleted());
//            order.setComments(orderDTO.getComments());
//            orders.add(order);
//        });
//        return orders;
//    }
