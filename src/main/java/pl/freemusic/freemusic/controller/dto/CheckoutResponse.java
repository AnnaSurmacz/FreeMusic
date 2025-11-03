package pl.freemusic.freemusic.controller.dto;

import java.math.BigDecimal;
import java.util.List;

public class CheckoutResponse {
    public Long purchaseId;
    public boolean paid;
    public String purchaseToken;
    public BigDecimal totalAmount;
    public List<ItemLink> items;

    public static class ItemLink {
        public Long itemId;
        public Long albumId;
        public String albumName;
        public String downloadToken; // w MVP zwracamy od razu (bo paid=true)
    }
}