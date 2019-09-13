package com.gpp.testmart.business;

import com.gpp.testmart.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl {

    List<String> bookList = new ArrayList<>();
    List<String> musicList = new ArrayList<>();
    List<String> movieList = new ArrayList<>();

    public ProductServiceImpl() {
        bookList.add("Infierno");
        bookList.add("Joyland");
        bookList.add("The Game of Thrones");

        musicList.add("Random access memories");
        musicList.add("Night Visions");
        musicList.add("Unorthodox Jukebox");

        movieList.add("Oz the Great and Powerful");
        movieList.add("Despicable Me");
        movieList.add("Star Trek Into Darkness");

    }

    public List<String> getProductCategories() {
        List<String> categories = new ArrayList<>();
        categories.add("Books");
        categories.add("Music");
        categories.add("Movies");
        return categories;
    }

    public List<String> getProducts(String category) {
        switch (category.toLowerCase()) {
            case "books":
                return bookList;
            case "music":
                return musicList;
            case "movies":
                return movieList;
        }
        return null;
    }

    public boolean addProduct(String category, String product) {
        switch (category.toLowerCase()) {
            case "books":
                bookList.add(product);
                break;
            case "music":
                musicList.add(product);
                break;
            case "movies":
                movieList.add(product);
                break;
            default:
                return false;
        }
        return true;
    }


    public List<Product> getProductsv2(String category) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Java Brains Book", "1234",99999.99));
        productList.add(new Product("Other Book", "ABC",12.50));
        return productList;
    }
}
