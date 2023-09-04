package com.example.backend;

import com.example.backend.model.Facility;
import com.example.backend.model.Rate;
import com.example.backend.model.Room;
import com.example.backend.repository.FacilityRepository;
import com.example.backend.repository.RateRepository;
import com.example.backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InitialDataBean implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private RoomRepository roomRepository;

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        if (facilityRepository.count() == 0) {
            facilityRepository.saveAll(Arrays.stream(new Facility[]{
                    new Facility("Test")
            }).toList());
        }

        if (rateRepository.count() == 0) {
            rateRepository.saveAll(Arrays.stream(new Rate[]{
                    new Rate(
                            "Mitgliedsvorteil",
                            true,
                            new String[]{"Inklusive Frühstück", "Early Check-in"},
                            230f
                    )
            }).toList());
        }

        if (roomRepository.count() == 0) {
            roomRepository.saveAll(Arrays.stream(new Room[]{
                    new Room(
                            "Doppel-Zimmer",
                            new Facility[]{facilityRepository.findAll().iterator().next()},
                            new Rate[]{rateRepository.findAll().iterator().next()},
                            2,
                            19,
                            false
                    )
            }).toList());
        }
        return;
    }
}
