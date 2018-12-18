package com.example.admin.test.json;

public class Inventories {
    int productId,branchId,cost,onHand,reserved;
    String branchName;

    public Inventories(int productId, int branchId, int cost, int onHand, int reserved, String branchName) {
        this.productId = productId;
        this.branchId = branchId;
        this.cost = cost;
        this.onHand = onHand;
        this.reserved = reserved;
        this.branchName = branchName;
    }

    public Inventories() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getOnHand() {
        return onHand;
    }

    public void setOnHand(int onHand) {
        this.onHand = onHand;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
