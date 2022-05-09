package com.iiitb.instilunchbox.Service;

import com.iiitb.instilunchbox.Model.Lunchbox;
import com.iiitb.instilunchbox.Repository.LunchboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LunchboxService {

    @Autowired
    private LunchboxRepository lunchboxRepository;

    public Lunchbox addLunchbox(Lunchbox lunchbox) {
        return lunchboxRepository.save(lunchbox);
    }
    public List<Lunchbox> getAllLunchbox() {
        return lunchboxRepository.findAll();
    }
}
