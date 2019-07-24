package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TrackController {


    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity("Successfully created", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
    }

    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            trackService.updateTrack(track);
            responseEntity = new ResponseEntity("Successfully Updated", HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    //Deleting the track
    @DeleteMapping(value = "track/{id}")
    public ResponseEntity<?> removeTrack(@PathVariable("id") int trackId) {
        ResponseEntity responseEntity;
        try {
            trackService.removeTrack(trackId);
            responseEntity = new ResponseEntity("Successfully deeted the track", HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}