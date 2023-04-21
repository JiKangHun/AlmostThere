package com.almostThere.domain.chatting.dto;

import com.almostThere.domain.meeting.entity.Meeting;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class ChattingResponseDto {

    // 모임 ID
    private Long meetingId;

    // 모임 이름
    private String meetingName;
    
    // 모임에 해당하는 채팅 리스트
    private List<ChattingDto> chattingList;
    
    // 모임에 해당하는 멤버 리스트
    private Map<Long, ChattingMemberDto> chattingMemberMap;

    public ChattingResponseDto(Meeting meeting) {
        this.meetingId = meeting.getId();
        this.meetingName = meeting.getMeetingName();
//        this.chattingMemberMap = meeting.getMeetingMembers().stream().map(m -> new ChattingMemberDto(m)).collect(Collectors.toList());
    }
}
