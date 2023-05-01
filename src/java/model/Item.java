/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author emsin
 */
public class Item {
    private int pid, amount;
    private String username, img = null;
    public Item(int pid, int amount) {
        this.pid = pid;
        this.amount = amount;
    }
    public Item(String username, int pid){
        this.pid = pid;
        this.username = username;   
    }
    public Item(String username, int pid, int amount) {
        this.pid = pid;
        this.amount = amount;
        this.username = username;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public float getTotal(float price){
        return (float) Math.round(price*this.amount*100)/100;
    }
}
