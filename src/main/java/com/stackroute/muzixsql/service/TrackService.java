package com.stackroute.muzixsql.service;

import com.stackroute.muzixsql.domain.Track;
import com.stackroute.muzixsql.exception.TrackAlreadyExistsException;
import com.stackroute.muzixsql.exception.TrackNotFoundException;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> getAllTracks() throws TrackNotFoundException;

    public int deleteTrack(long id);

    public Track getTrackById(int noteId);

    public Track UpdateTrack(int id, Track track);

    public <T> T getForObject(String url, Class<T> responseType, Map<String,?> urlVariables) throws RestClientException;
}
