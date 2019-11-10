package DataModels;

import android.util.Log;

import org.json.JSONObject;

import Common.RSA;

public class Product {

    private String productID;
    private String productName;
    private int priceEuro;
    private int priceCent;

    public Product(String data, String key) throws Exception {
        String product = RSA.Decrypt(data,key);
        Log.d("Product",product);
        JSONObject JSONproduct = new JSONObject(product);
        this.productID = JSONproduct.getString("id");
        this.productName = JSONproduct.getString("name");
        this.priceEuro = JSONproduct.getInt("euros");
        this.priceCent = JSONproduct.getInt("cents");
    }

    public int getPriceCent() {
        return priceCent;
    }

    public int getPriceEuro() {
        return priceEuro;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductID() {
        return productID;
    }
}