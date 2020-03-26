package pl.okpol.mdplanner.controllers;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.okpol.mdplanner.dto.OrderDTO;
import pl.okpol.mdplanner.services.OrderService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Controller
@RequestMapping("/zamowienia")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String prepareOrdersPage() {
        return "orders";
    }

    @PostMapping
    public String processUploadFile(@RequestParam("file") MultipartFile file, Model model) {

        if(file.isEmpty()){
            model.addAttribute("message", "Wybierz plik CSV do wczytania");
            model.addAttribute("status", false);
        } else {
            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                CsvToBean<OrderDTO> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(OrderDTO.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                List<OrderDTO> newOrders = csvToBean.parse();

                for (OrderDTO newOrder : newOrders) {
                    orderService.saveOrderInDB(newOrder);
                }

            } catch (Exception e) {
                model.addAttribute("message", "Nie udało się wczytać pliku");
                model.addAttribute("status", false);
            }
        }
        return "redirect:/zamowienia";
    }
}
