package com.gocarting.controller;

import com.gocarting.exception.ResourceNotFoundException;
import com.gocarting.service.CartServiceImpl;
import com.gocarting.service.ItemServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import com.gocarting.service.CartService;
import com.gocarting.service.ItemService;


@RestController
public class CartController {
    private CartService cartService;

    private ItemService itemService;

    // No-Args ctr for services
    CartController() {
        this.cartService = new CartServiceImpl();
        this.itemService = new ItemServiceImpl();
    }

    // Adds a new item to our cart.
    @PutMapping(value = "/add-to-cart?itemid={id}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void addToCart (@PathVariable String id) {
        if (itemService.searchItemByID(id)) {
            cartService.addToCart(id);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    // Sums elements of the cart.
    @GetMapping(value="/get-cart-sum", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getCartSum() {
        return Double.toString(cartService.getCartSum());
    }

    // Gets cheapest item available.
    @GetMapping(value="/get-cheapest-item", produces = MediaType.TEXT_PLAIN_VALUE)
    public String cheapestItem() {
        return itemService.getCheapestItem().toString();
    }

    // Gets priciest item available.
    @GetMapping(value="/get-priciest-item", produces = MediaType.TEXT_PLAIN_VALUE)
    public String priciestItem() {
        return itemService.getPriciestItem().toString();
    }

    // Index
    @RequestMapping("/")
    public String index() {
        return "Let's go carting!";
    }
}
