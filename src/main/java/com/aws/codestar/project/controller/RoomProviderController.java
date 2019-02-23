package com.aws.codestar.project.controller;

import com.aws.codestar.project.pojos.rooms.Room;
import com.aws.codestar.project.pojos.rooms.RoomProvider;
import com.aws.codestar.project.service.rooms.RoomProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * Basic Spring web service controller that handles all GET requests.
 */
@RestController
@RequestMapping("/roomprovider")
public class RoomProviderController
{

    @Autowired
    private RoomProviderService roomProviderService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public RoomProvider receive(@RequestBody RoomProvider roomProvider)
    {
        Logger.getAnonymousLogger().info(roomProvider.toString());

        String requesterId = roomProvider.getRequesterId();
        Room room = roomProvider.getProvider().stream().filter(x -> x.isAvailable() && x.getUserId().equalsIgnoreCase(requesterId)).findFirst().get();
        Logger.getAnonymousLogger().info("room being updated is "+room.getId());
        roomProviderService.reserveRoom(roomProvider, room);
        return roomProvider;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public RoomProvider send()
    {
        Logger.getAnonymousLogger().info(roomProviderService.toString());

        @SuppressWarnings("UnnecessaryLocalVariable") RoomProvider roomProvider = roomProviderService.getRooms();

        return roomProvider;
    }
}
