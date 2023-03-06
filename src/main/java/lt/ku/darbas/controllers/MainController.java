package lt.ku.darbas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class MainController {

    @GetMapping("/")
    public String showForm() {
        return "skaiciuokle";
    }

    @PostMapping("/")
    public String calculate(@RequestParam double price, @RequestParam int quantity, Model model) {
        double netPrice = price / 1.21;
        double vat = price - netPrice;
        double totalNetPrice = netPrice * quantity;
        double totalVat = vat * quantity;
        double totalPrice = price * quantity;

        model.addAttribute("netPrice", netPrice);
        model.addAttribute("vat", vat);
        model.addAttribute("totalNetPrice", totalNetPrice);
        model.addAttribute("totalVat", totalVat);
        model.addAttribute("totalPrice", totalPrice);

        return "resultatai";
    }
}