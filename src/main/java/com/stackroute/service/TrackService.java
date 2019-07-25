//database operations
package com.stackroute.service;

import com.stackroute.domain.Track;
import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track);

    public List<Track>getAllTracks();

    public int deleteTrack(long id);

    public Track getTrackById(int noteId);

    public Track UpdateTrack(Track track);
}