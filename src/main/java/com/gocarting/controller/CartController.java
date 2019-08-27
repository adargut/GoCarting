package com.gocarting.controller;

import com.gocarting.item.Item;
import com.gocarting.item.ItemRepository;
import com.gocarting.service.CartServiceImpl;
import com.gocarting.item.MockItemRepository;
import com.gocarting.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@RestController
public class CartController {

    private CartService cartService;

    private ItemRepository itemRepository = new MockItemRepository();

    CartController() {
        this.cartService = new CartServiceImpl(itemRepository);
    }

    @RequestMapping(value = "/add-to-cart/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String addToCart(@PathVariable String id) {
        return cartService.addToCart(id);
    }

    @RequestMapping(value = "/remove-from-cart/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String removeFromCart(@PathVariable String id) {
        return cartService.removeFromCart(id);
    }

    @GetMapping(value = "/get-cart-sum", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String getCartSum() {
        return cartService.getCartSum().toString();
    }

    @GetMapping(value = "/get-cheapest-item", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String cheapestItem() {
        return cartService.getCheapestItem().toString();
    }

    @GetMapping(value = "/get-priciest-item", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String priciestItem() {
        return cartService.getPriciestItem().toString();
    }

    // Index
    @RequestMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String index() {
        return "Let's go carting!";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class BadRequestException extends RuntimeException {
        //
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends RuntimeException {
        //
    }
}
