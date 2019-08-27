package com.gocarting.controller;

import com.gocarting.item.Item;
import com.gocarting.repository.ItemRepository;
import com.gocarting.service.CartServiceImpl;
import com.gocarting.repository.MockItemRepository;
import com.gocarting.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    CartController() {
        ItemRepository itemRepository = new MockItemRepository();
        this.cartService = new CartServiceImpl(itemRepository);
    }

    // Index
    @RequestMapping("/")
    public String index() {
        return "Let's go carting!";
    }

    @PutMapping("/add-to-cart")
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
    public ResponseEntity<String> cheapestItem() {
        Item cheapestItem = cartService.getCheapestItem();
        return ResponseEntity.status(HttpStatus.OK)
                .body(cheapestItem.toString());
    }

    @GetMapping("/get-priciest-item")
    public ResponseEntity<String> priciestItem() {
        Item priciestItem = cartService.getPriciestItem();
        return ResponseEntity.status(HttpStatus.OK)
                .body(priciestItem.toString());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class BadRequestException extends RuntimeException {
        //
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class ItemNotFoundException extends RuntimeException {

        public ItemNotFoundException(String id) {
            super("Could not find item " + id + ".");
        }

        public ItemNotFoundException() {
            super("Could not find item.");
        }
    }
}
