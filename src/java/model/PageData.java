/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
public final class PageData {
    private int count=0;
    private String currentPageIndex;
    private List<Book> list = null;
    public static int amount_per_page = 12;

    public PageData(List<Book> list, int total, String currentPageIndex){
        currentPageIndex = currentPageIndex==null? "1" : currentPageIndex;
        this.currentPageIndex = currentPageIndex;
        this.count = (int)Math.ceil((float)total/(float)amount_per_page);
        this.list = list;
    }
    public int getCount() {
        return this.count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }

    public List<Book> getList() {
        return this.list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
    
}
