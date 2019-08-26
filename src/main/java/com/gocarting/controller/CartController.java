package com.gocarting.controller;

import com.gocarting.service.CartServiceImpl;
import com.gocarting.item.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import com.gocarting.service.CartService;


@RestController
public class CartController {
    private CartService cartService;

    private ItemRepository itemRepository;

    // TODO make this injection
    CartController() {
        this.cartService = new CartServiceImpl();
        this.itemService = new ItemRepository();
    }

    @PutMapping(value = "/add-to-cart?itemid={id}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String addToCart (@PathVariable String id) {
        cartService.addToCart(id);
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private static class BadRequestException extends RuntimeException {
        //
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    private static class ResourceNotFoundException extends RuntimeException {
        //
    }
}
