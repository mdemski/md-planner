package pl.okpol.mdplanner.controllers;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.okpol.mdplanner.dto.AddedOrderDTO;
import pl.okpol.mdplanner.dto.OrderDTO;
import pl.okpol.mdplanner.mappers.OrderMapper;
import pl.okpol.mdplanner.mappers.PalletMapper;
import pl.okpol.mdplanner.model.Order;
import pl.okpol.mdplanner.model.Pallet;
import pl.okpol.mdplanner.repositories.PalletRepository;
import pl.okpol.mdplanner.services.OrderService;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {

    private OrderService orderService;
    private OrderMapper orderMapper;
    private PalletRepository palletRepository;
    private PalletMapper palletMapper;

    public OrderController(OrderService orderService, OrderMapper orderMapper, PalletRepository palletRepository, PalletMapper palletMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.palletRepository = palletRepository;
        this.palletMapper = palletMapper;
    }

    @GetMapping
    public List<Order> prepareOrdersPage() {
        List<OrderDTO> orderDTOS = orderService.getAllOrders();
        return orderMapper.convertToEntityOrders(orderDTOS);
    }

    @PostMapping
    public List<Order> processUploadFile(@RequestParam("file") MultipartFile file, Model model) {

        if(file.isEmpty()){
            System.out.println("Wybierz plik CSV do wczytania");
        } else {
            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                CsvToBean<AddedOrderDTO> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(AddedOrderDTO.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                List<AddedOrderDTO> newOrders = csvToBean.parse();

                newOrders.forEach((newOrder) -> {
                    orderService.saveOrderInDB(newOrder);
                });
//                for (AddedOrderDTO newOrder : newOrders) {
//                    orderService.saveOrderInDB(newOrder);
//                }
                return orderMapper.convertToListEntityOrderFromAddDTO(newOrders);

            } catch (Exception e) {
                System.out.println("Failed with uploading file");
            }
        }
        return new ArrayList<>();
    }

    @GetMapping("/{number}")
    public Order processOrderDetail(@PathVariable Integer number) {
        try {
            Order order = orderService.findOneByNumber(number);
            return order;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @PutMapping("/{number}")
    public Order processOrderUpdate(@PathVariable Integer number, @Valid @RequestBody OrderDTO orderDTO) {
        try {
            orderDTO.getPallets().forEach(pallet ->{
                Pallet pallet1 = new Pallet();
                pallet1.setSize(pallet);
                palletRepository.save(pallet1);
            });
            orderService.updateOrder(number, orderDTO);
            return orderMapper.convertToEntityOrder(orderDTO);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to update order");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
