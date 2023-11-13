package com.thefivebytes.mmc.converters;

import com.thefivebytes.mmc.dto.SpeakerDTO;
import com.thefivebytes.mmc.entities.Speaker;

public class SpeakerDTOConverter {

    public static Speaker speakerDtoToSpeaker(SpeakerDTO speakerDTO) {
        Speaker speaker = new Speaker();
        speaker.setId(speakerDTO.getId());
        speaker.setName(speakerDTO.getName());
        speaker.setImage(speakerDTO.getImage());
        speaker.setIsMCT(speakerDTO.getIsMCT());
        speaker.setIsMVP(speakerDTO.getIsMVP());
        speaker.setBiography(speakerDTO.getBiography());

        return speaker ;
    }

    public static SpeakerDTO speakerToSpeakerDto(Speaker speaker) {
        SpeakerDTO speakerDTO = new SpeakerDTO() ;
        speakerDTO.setId(speaker.getId());
        speakerDTO.setName(speaker.getName());
        speakerDTO.setImage(speaker.getImage());
        speakerDTO.setIsMCT(speaker.getIsMCT());
        speakerDTO.setIsMVP(speaker.getIsMVP());
        speakerDTO.setBiography(speaker.getBiography());

        return speakerDTO ;
    }


}
