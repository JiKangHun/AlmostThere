package com.almostThere.domain.meeting.dto;

import com.almostThere.domain.meeting.entity.MeetingMember;
import com.almostThere.domain.meeting.entity.StateType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AttendMeetingMemberDto {

    private Long meetingMemberId;

    private StateType state;

    private Double spentMoney;

    private AttendMeetingDto meetingDto;

    public AttendMeetingMemberDto(MeetingMember meetingMember) {
        this.meetingMemberId = meetingMember.getId();
        this.state = meetingMember.getState();
        if (meetingMember.getSpentMoney() == null) {
            this.spentMoney = 0.0;
        } else {
            this.spentMoney = Double.valueOf(meetingMember.getSpentMoney());
        }
        this.meetingDto = new AttendMeetingDto(meetingMember.getMeeting());
    }
}
