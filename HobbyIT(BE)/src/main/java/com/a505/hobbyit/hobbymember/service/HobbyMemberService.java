package com.a505.hobbyit.hobbymember.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.hobbymember.dto.HobbyMemberUpdateRequest;

public interface HobbyMemberService {
    public void updatePrivilege(final String memberId, final Long hobbyId, final Long targetId, HobbyMemberUpdateRequest request);
    public void kickHobbyMember(String memberId, final Long hobbyId, final Long targetId);
    public void resignHobbyMember(String memberId, Long hobbyId);
    public Hobby checkPrivilege(Long hobbyId, String memberId);
    void checkHobbyMember(Long hobbyId, Long memberId);
}
