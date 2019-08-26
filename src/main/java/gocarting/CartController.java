package gocarting;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@RestController
public class CartController {

    Cart cart = new Cart();

//    @PutMapping("/add-to-cart?itemid={id}")
//    public Cart addToCart(@PathVariable String id, @RequestBody Map<String, String> body){
//        int blogId = Integer.parseInt(id);
//        String title = body.get("title");
//        String content = body.get("content");
//        return blogMockedData.updateBlog(blogId, title, content);
//    }
    @GetMapping(value="/get-cart-sum", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getCartSum() {
        return Double.toString(cart.getCartSum());
    }

    @GetMapping(value="/get-cheapest-item", produces = MediaType.TEXT_PLAIN_VALUE)
    public String cheapestItem() {
        return ItemData.getCheapest().toString();
    }

    @RequestMapping("/")
    public String index() {
        return "Adar <3 Amit";
    }
}
