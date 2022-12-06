package org.design.model;

import orestes.bloomfilter.CountingBloomFilter;
import org.design.exception.BlockLimitExceededException;
import org.design.exception.ContactDoesNotExistsException;
import org.design.exception.ContactsExceededException;
import org.design.model.common.Contact;
import org.design.model.common.PersonalInfo;
import org.design.model.common.SocialInfo;
import org.design.model.common.Tag;
import org.design.model.tries.ContactTrie;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Account {
    private String id;
    private String phoneNumber;
    private String username;
    private String password;
    private LocalDateTime lastAccessed;
    private Tag tag;
    private Contact contact;
    private PersonalInfo personalInfo;
    private SocialInfo socialInfo;
    private Business business;
    private UserCategory userCategory;
    private Map<String, User> contacts;

    private CountingBloomFilter<String> blockedContacts;
    private Set<String> blockedSet;

    private ContactTrie contactTrie;

    public Account(){
    }

    public Account(String phoneNumber, String firstNumber){
        this.phoneNumber = phoneNumber;
        this.personalInfo = new PersonalInfo(firstNumber);
    }

    public Account(String phoneNumber, String firstName, String lastName){
        this(phoneNumber, firstName);
        this.personalInfo.setLastName(lastName);
    }

    public abstract void register(UserCategory userCategory, String userName, String password,
                                  String email, String phoneNumber, String countryCode,
                                  String firstName);

    public abstract void addConcat(User user) throws ContactsExceededException;
    public abstract void removeContact(String number) throws ContactDoesNotExistsException;
    public abstract void blockNumber(String number) throws BlockLimitExceededException;
    public abstract void unblockNumber(String number);
    public abstract void reportSpam(String number, String reason);
    public abstract void upgrade(UserCategory userCategory);
    public abstract boolean isBlocked(String number);
    public abstract boolean canReceive(String number);
    public abstract boolean importContacts(List<User> users);

}
