package com.gocarting.controller;

import com.gocarting.item.Item;
import com.gocarting.item.ItemRepository;
import com.gocarting.service.CartServiceImpl;
import com.gocarting.item.MockItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import com.gocarting.service.CartService;

@RestController
public class CartController {

    private CartService cartService;

    private ItemRepository itemRepository = new MockItemRepository();

    // TODO make this injection
    CartController() {
        this.cartService = new CartServiceImpl(itemRepository);
    }

    @PutMapping(value = "/peek")
    @ResponseStatus(HttpStatus.OK)
    public String peek() {
        addToCart("10A");
        return "Done!";
    }

    @PutMapping(value = "/add-to-cart?itemid={id}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String addToCart(@PathVariable String id) {
        return cartService.addToCart(id);
    }

    @DeleteMapping(value = "/remove-from-cart?itemid={id}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String removeFromCart(@PathVariable String id) {
        return cartService.removeFromCart(id);
    }

    @GetMapping(value = "/get-cart-sum", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Double getCartSum() {
        return cartService.getCartSum();
    }

    @GetMapping(value = "/get-cheapest-item", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Item cheapestItem() {
        return cartService.getCheapestItem();
    }

    // Gets priciest item available.
    @GetMapping(value = "/get-priciest-item", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Item priciestItem() {
        return cartService.getPriciestItem();
    }

    // Index
    @RequestMapping("/")
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
