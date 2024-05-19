package za.ac.cput.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Contact;
import za.ac.cput.repository.ContactRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ContactService implements IService<Contact, String>{
    private ContactRepository contactRepository;
    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact create(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact read(String id) {
        return contactRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Contact not found for id: " + id));

    }

    @Override
    public Contact update(Contact contact) {return contactRepository.save(contact);}
    @Override
    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }

    @Override
    public List<Contact> getall() {return contactRepository.findAll();}
}
