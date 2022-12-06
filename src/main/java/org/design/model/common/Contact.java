package org.design.model.common;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Contact {
    private String countryCode;
    private String phone;
    private String email;

    public Contact(String phone){
        this.phone = phone;
    }

    public Contact(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }
}
