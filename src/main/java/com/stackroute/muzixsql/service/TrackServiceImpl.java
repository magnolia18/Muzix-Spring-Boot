package com.stackroute.muzixsql.service;

import com.stackroute.muzixsql.domain.Track;
import com.stackroute.muzixsql.exception.TrackAlreadyExistsException;
import com.stackroute.muzixsql.exception.TrackNotFoundException;
import com.stackroute.muzixsql.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public abstract class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {

        trackRepository.save(track);
        return (Track)trackRepository;
    }

    @Override
    public List<Track> getAllTracks() throws TrackNotFoundException {

        return trackRepository.findAll();
    }

    @Override
    public int deleteTrack(long id) {
        System.out.println(id);

        Long l = new Long(id);
        int i = l.intValue();
        Track track = new Track();
        try {
            trackRepository.deleteById(i);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

    @Override
    public Track getTrackById(int id) {
        // Integer IntObj = new Integer(id);
        trackRepository.findById((Integer) id);
        return (Track) trackRepository;

    }

}
