//database operations
package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public List<Track>getAllTracks() throws TrackNotFoundException;;

    public int deleteTrack(long id);

    public Track getTrackById(int noteId);

    public Track UpdateTrack(Track track);
}