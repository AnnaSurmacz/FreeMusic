package pl.freemusic.freemusic.controller.dto;

import java.util.List;

public class CheckoutRequest {

    public BuyerDTO buyer;
    public LicenseDTO license;
    public List<CartItemDTO> items;

    public static class BuyerDTO {
        public String email;
        public String companyName;
        public String vatId;
        public String street;
        public String zip;
        public String city;
        public String contactName;
        public Long userId; // opcjonalnie (jeśli zalogowany)
    }

    public static class LicenseDTO {
        public String venueName;     // nazwa lokalu
        public String venueAddress;  // adres lokalu
    }

    public static class CartItemDTO {
        public Long albumId;
    }
}