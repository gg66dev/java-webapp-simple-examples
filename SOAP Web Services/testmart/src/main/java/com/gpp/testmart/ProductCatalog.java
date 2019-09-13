package com.gpp.testmart;

import com.gpp.testmart.business.ProductServiceImpl;
import com.gpp.testmart.model.Product;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "com.gpp.testmart.ProductCatalogInterface",
        portName = "TestMartCatalogPort", serviceName = "TestMartCatalogService")
public class ProductCatalog implements ProductCatalogInterface {

    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    public  List<String> getProductCategories() {
        return productService.getProductCategories();
    }

    @Override
    public List<String> getProducts(String category) {
        return productService.getProducts(category);
    }

    @Override
    public boolean addProduct(String category, String product) {
        return productService.addProduct(category, product);
    }

    @Override
    public List<Product> getProductsv2(String category) {
        return productService.getProductsv2(category);
    }

}
