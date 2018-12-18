package com.example.admin.test.json;

public class Attributes {
    int productId;
    String attributeName,attributeValue;

    public Attributes(int productId, String attributeName, String attributeValue) {
        this.productId = productId;
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }

    public Attributes() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }
}
