package za.ac.cput.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Booking;
import za.ac.cput.repository.BookingRepository;

import java.util.List;

@Service
public abstract class BookingService implements IBookingService {
    private BookingRepository repository;

    @Autowired
    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Booking create(Booking booking) {
        return repository.save(booking);
    }

    @Override
    public Booking read(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Booking update(Booking booking) {
        return repository.save(booking);
    }

    @Override
    public void delete(Booking booking) {
        repository.delete(booking);
    }

    @Override
    public List<Booking> getAll() {
        return repository.findAll();
    }
}
