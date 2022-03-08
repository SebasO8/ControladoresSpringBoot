package IAS.training.TrainingIAS.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping(value = "/products/read", method = RequestMethod.GET)
    public String productsGet(){
        return "Este es el método para consultar todos los productos";
    };

    @RequestMapping(value = "/products/create", method = RequestMethod.POST)
    public String productsPost(@RequestBody User user){
        return "Este es el método para crear un producto";
    };

    @RequestMapping(value = "/products/update", method = RequestMethod.PUT)
    public String productsPut(@RequestBody User user){
        return "Este es el método para actualizar un producto";
    };

    @RequestMapping(value = "/products/delete/{id}", method = RequestMethod.DELETE)
    public String productsDelete(@PathVariable() Long id){
        return "Este es el método para eliminar un producto";
    };


}
