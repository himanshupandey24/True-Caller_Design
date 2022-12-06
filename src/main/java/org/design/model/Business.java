package org.design.model;

import org.design.model.common.Contact;
import org.design.model.common.PersonalInfo;
import org.design.model.common.SocialInfo;
import org.design.model.common.Tag;

import java.util.Map;

public class Business {
    private String businessName;
    private String businessDescription;
    private Tag tag;

    private BusinessSize businessSize;
    private Map<Days,OperatingHours> openHours;
    private Contact contact;
    private PersonalInfo personalInfo;
    private SocialInfo socialInfo;

    public Business(String name, Tag tag){
        this.businessName = name;
        this.tag = tag;
    }
}
