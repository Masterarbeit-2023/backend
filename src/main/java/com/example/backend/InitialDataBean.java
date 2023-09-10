package com.example.backend;

import com.example.backend.model.Extra;
import com.example.backend.model.Facility;
import com.example.backend.model.Rate;
import com.example.backend.model.Room;
import com.example.backend.repository.ExtraRepository;
import com.example.backend.repository.FacilityRepository;
import com.example.backend.repository.RateRepository;
import com.example.backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InitialDataBean implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ExtraRepository extraRepository;

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
                            240f
                    ),
                    new Rate(
                            "Mitgliedsvorteil",
                            true,
                            new String[]{"Inklusive Frühstück", "Early Check-in"},
                            230f
                    ),
                    new Rate(
                            "Mitgliedsvorteil",
                            true,
                            new String[]{"Inklusive Frühstück", "Early Check-in"},
                            220f
                    ),
                    new Rate(
                            "Mitgliedsvorteil",
                            true,
                            new String[]{"Inklusive Frühstück", "Early Check-in"},
                            210f
                    ),
                    new Rate(
                            "Mitgliedsvorteil",
                            true,
                            new String[]{"Inklusive Frühstück", "Early Check-in"},
                            200f
                    )
            }).toList());
        }

        if (roomRepository.count() == 0) {
            List<Rate> rates = new ArrayList<>();
            for (Rate item : rateRepository.findAll()) {
                rates.add(item);
            }
            for (int i = 0; i < rates.toArray().length; i++) {
                roomRepository.save(new Room(
                        "Doppel-Zimmer",
                        new Facility[]{facilityRepository.findAll().iterator().next()},
                        new Rate[]{rates.get(i)},
                        2,
                        19,
                        false
                ));
            }
        }

        if (extraRepository.count() == 0) {
            extraRepository.saveAll(
                    Arrays.stream(
                            new Extra[]{
                                    new Extra(
                                            "Mineralwasser",
                                            "Genießen Sie eine Flasche Wasser 0,75 l bei Anreise auf Ihrem Zimmer.",
                                            5f,
                                            false, false, false, true
                                    ),
                                    new Extra(
                                            "Sekt",
                                            "Eine Flasche Sekt 0,75 l, als gewisses Extra für besondere Anlässe.",
                                            25f,
                                            false, false, false, true
                                    ),
                                    new Extra(
                                            "Frühanreise",
                                            "Nutzen Sie den Tag. Beziehen Sie Ihr Zimmer bereits ab 13:00 Uhr.",
                                            15f,
                                            false, true, false, true
                                    ),
                                    new Extra(
                                            "Spätabreise",
                                            "Lassen Sie den Tag gemütlich angehen. Late Check-Out um 14.00 Uhr.",
                                            15f,
                                            false, true, false, true
                                    ),
                                    new Extra(
                                            "Hund",
                                            "Wir freuen uns Ihren besten Freund bei uns Willkommen zu heißen!",
                                            15f,
                                            true, false, false, true
                                    )
                            }
                    ).toList()
            );
        }
        return;
    }
}
