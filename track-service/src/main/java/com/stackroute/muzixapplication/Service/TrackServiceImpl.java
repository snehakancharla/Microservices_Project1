package com.stackroute.muzixapplication.Service;

import com.stackroute.muzixapplication.domain.Track;
import com.stackroute.muzixapplication.exception.IdNotFoundException;
import com.stackroute.muzixapplication.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapplication.exception.TrackNotFoundException;
import com.stackroute.muzixapplication.respository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {

        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveAlbum(Track album) throws TrackAlreadyExistsException {

        if (trackRepository.existsById(album.getTrackId())) {
            throw new TrackAlreadyExistsException("album Already Exists");
        }
        Track savedAlbum = trackRepository.save(album);
        if (savedAlbum == null) {
            throw new TrackAlreadyExistsException("track already exist exception");
        }
        return savedAlbum;
    }

    @Override
    public List<Track> getAllAlbums() {
        return trackRepository.findAll();
    }

    /*@Override
    public List<Track> getByName(String trackname) throws TrackNotFoundException {
        List<Track> albums=trackRepository.getByName(trackname);
        if(albums.isEmpty())
        {
            throw new TrackNotFoundException("Track id not found");
        }
        return albums;
    }*/
    @Override
    public Track updateTrack(Track album) throws IdNotFoundException {
        if (trackRepository.existsById(album.getTrackId())) {
            Track savedAlbum = trackRepository.save(album);
        }

        Track updateTrack = trackRepository.save(album);
        return updateTrack;
    }

    @Override
    public Track putUpdateTrack(Track album) throws IdNotFoundException {
        Track savedAlbum;
        if (trackRepository.existsById(album.getTrackId())) {
            savedAlbum = trackRepository.save(album);
            return savedAlbum;
        } else {
            throw new IdNotFoundException("Track id not found");
        }

    }

    @Override
    public boolean deleteTrack(int trackid) throws TrackNotFoundException {
        boolean status = false;
        if (trackRepository.existsById(trackid)) {
            trackRepository.deleteById(trackid);
            status = true;
            return status;
        } else {
            throw new TrackNotFoundException("Track id not found");
        }


    }
}
