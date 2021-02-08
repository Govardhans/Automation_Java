package de.westwingnow.page.object.model;

public class Product {
    private String productName;
    private String brandText;
    private String price;
    private boolean addedToWishList;

    public Product(String productName, String brandText, String price, boolean addedToWishList) {
        this.productName = productName;
        this.brandText = brandText;
        this.price = price;
        this.addedToWishList = addedToWishList;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandText() {
        return brandText;
    }

    public void setBrandText(String brandText) {
        this.brandText = brandText;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isAddedToWishList() {
        return addedToWishList;
    }

    public void setAddedToWishList(boolean addedToWishList) {
        this.addedToWishList = addedToWishList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", brandText='" + brandText + '\'' +
                ", price=" + price +
                ", addedToWishList=" + addedToWishList +
                '}';
    }
}
