package com.project.mall.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceController {
    private static Map<String, Product> productRepo = new HashMap<>();
        static {
            Product honey = new Product();
            honey.setId("1");
            honey.setName("Honey");
            productRepo.put(honey.getId(), honey);
            Product almond = new Product();
            almond.setId("2");
            almond.setName("Almond");
            productRepo.put(almond.getId(), almond);
        }
        @RequestMapping(value = "/products")
        public ResponseEntity<Object> getProduct() {
            return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
        }
        }
        
        class Product {
            private String id;
            private String name;
            
            public String getId() {
                return id;
            }
            public void setId(String id) {
                this.id = id;
            }
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
        }