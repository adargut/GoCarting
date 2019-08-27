# GoCarting

> A RESTful API design for an online shopping cart

> built using Maven & Spring, for AppsFlyer

**Supported requests:**

- localhost:8080/add-to-cart?itemid={id}
- localhost:8080/remove-from-cart?itemid={id}
- localhost:8080/get-priciest-item
- localhost:8080/get-cheapest-item
- localhost:8080/get-cart-sum

**Available item ids:**

- "10A"
- "20B"
- "30C"
- "40D"
- "50E"
- "60F"
- "70G"
- "80H"
- "90I"

**Tips:**

- Item are represented as JSONs
- To avoid 405 Errors, use PUT request for adding an item to the cart, DELETE request for deletion, and GET request otherwise

## Author

- Adar Gutman
