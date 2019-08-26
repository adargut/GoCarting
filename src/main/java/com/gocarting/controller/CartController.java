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

    // TODO make this injection
    CartController() {
        this.cartService = new CartServiceImpl();
        this.itemService = new ItemServiceImpl();
    }

    // @TODO remove logic from cart controller
    @PutMapping(value = "/add-to-cart?itemid={id}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String addToCart (@PathVariable String id) {
//        if (itemService.searchItemByID(id)) {
//            cartService.addToCart(id);
//        } else {
//            throw new ResourceNotFoundException();
//        }
        return "Success!";
    }

    @GetMapping(value="/get-cart-sum", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String getCartSum() {
        return Double.toString(cartService.getCartSum());
    }

    @GetMapping(value="/get-cheapest-item", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String cheapestItem() {
        return cartService.getCheapestItem().toString();
    }

    // Gets priciest item available.
    @GetMapping(value="/get-priciest-item", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String priciestItem() {
//        return itemService.getPriciestItem().toString();
        return "Hello there! Priciest item is:\n" +
                cartService.getPriciestItem().toString();
    }

    // Index
    @RequestMapping("/")
    public String index() {
        return "Let's go carting!";
    }
}
