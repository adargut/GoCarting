package com.gocarting.controller;

import com.gocarting.item.Item;
import com.gocarting.item.ItemRepository;
import com.gocarting.service.CartServiceImpl;
import com.gocarting.item.MockItemRepository;
import com.gocarting.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    CartController() {
        ItemRepository itemRepository = new MockItemRepository();
        this.cartService = new CartServiceImpl(itemRepository);
    }

    @PutMapping("/test")
    public String claimTask(@RequestParam String id){
        return cartService.addToCart(id);
    }

    // Index
    @RequestMapping("/")
    public String index() {
        return "Let's go carting!";
    }

    @GetMapping("/peek")
        public String postTest() {
        cartService = new CartServiceImpl(new MockItemRepository());
        return "OK!";
    }

    @PostMapping("/add-to-cart")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String addToCart(@RequestParam String itemid) {
        return cartService.addToCart(itemid);
    }

    @DeleteMapping("/delete-from-cart")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String removeFromCart(@RequestParam String itemid) {
        return cartService.removeFromCart(itemid);
    }

    @GetMapping("/get-cart-sum")
    @ResponseStatus(HttpStatus.OK)
    public String getCartSum() {
        return cartService.getCartSum().toString();
    }

    @GetMapping("/get-cheapest-item")
    @ResponseStatus(HttpStatus.OK)
    public String cheapestItem() {
        return cartService.getCheapestItem().toString();
    }

    @GetMapping("/get-priciest-item")
    @ResponseStatus(HttpStatus.OK)
    public String priciestItem() {
        return cartService.getPriciestItem().toString();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class BadRequestException extends RuntimeException {
        //
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class ItemNotFoundException extends RuntimeException {

        public ItemNotFoundException(String id) {
            super("Could not find item" + id);
        }

        public ItemNotFoundException() {
            super("Could not find item");
        }
    }
}
