package model;

/**
 *
 * @author emsin
 */
public class Params {
    public String search, category_id, author_id, publisher_id, id_order, price_order;
    public Params(String search, String category_id, String author_id, String publisher_id, String id_order, String price_order) {
        this.search = search;
        this.category_id = category_id;
        this.author_id = author_id;
        this.publisher_id = publisher_id;
        this.id_order = id_order;
        this.price_order = price_order;
    }
    
}
