package com.nashtech.nashtech_shop.APIController.publicAPI;

import com.nashtech.nashtech_shop.APIController.exceptionHandler.APIHandlerException;
import com.nashtech.nashtech_shop.Service.BrandService;
import com.nashtech.nashtech_shop.model.dto.BrandDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

@RestControllerAdvice
@RestController
public class BrandAPI {
    @Autowired
    BrandService brandService;


    @RequestMapping(value = "/toann/public/api/1.0/brand/", method = RequestMethod.GET)
    public ResponseEntity<?> getALl() {
        List<BrandDTO> brands = brandService.findAll();
        if (brands == null) {
            return ResponseEntity.ok(APIHandlerException.IntenalServerException2());
        }
        return ResponseEntity.ok(brands);
    }

    @RequestMapping(value = "/toann/public/api/1.0/brand/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getbyId(@PathVariable Integer id) {
        BrandDTO brand = brandService.findById(id);
        if (brand == null) {
            return ResponseEntity.ok(APIHandlerException.IntenalServerException2());
        }
        return ResponseEntity.ok(brand);
    }
    @RequestMapping(value = "/toann/auth/api/1.0/brand/{id}/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        Boolean result = brandService.delete(id);
        if (!result ) {
            return ResponseEntity.ok(APIHandlerException.IntenalServerException2());
        }
        return ResponseEntity.ok(result);
    }
    @PutMapping(value = "/toann/auth/api/1.0/brand/{id}/")
    public ResponseEntity<?> updateById(@PathVariable(name = "id") Integer id , @RequestBody String name ) {
        BrandDTO result = brandService.updateBrand(id , name);
        System.out.println("cho t hỏi là m có vào đây ko ");
        if (result == null  ) {
            System.out.println(" Null à ??");
            return ResponseEntity.ok(APIHandlerException.IntenalServerException2());
        }
        return ResponseEntity.ok(result);

    }
}
