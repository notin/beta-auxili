package com.aws.codestar.project.service.rooms;

import com.aws.codestar.project.pojos.rooms.Room;
import com.aws.codestar.project.pojos.rooms.RoomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomProviderService
{
    @Autowired
    RoomProviderRepository roomProviderRepository;

    @Autowired
    RoomRepository roomRepository;

    public void reserveRoom(RoomProvider roomProvider, Room s)
    {
        roomRepository.save(s);
        roomProviderRepository.save(roomProvider);
    }

    public RoomProvider getRooms()
    {
        Iterable<RoomProvider> all = roomProviderRepository.findAll();
        RoomProvider next = RoomProvider.builder().build();

        for( RoomProvider roomProvider: all)
        {
            if(roomProvider.getProvider()!= null && !roomProvider.getProvider().isEmpty())
            {
                next = roomProvider;
                break;
            }
        }
        return next;
    }
}
