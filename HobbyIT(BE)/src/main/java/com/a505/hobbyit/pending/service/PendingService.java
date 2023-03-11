package com.a505.hobbyit.pending.service;

import com.a505.hobbyit.hobby.domain.Hobby;
import com.a505.hobbyit.pending.dto.PendingAllowRequest;
import com.a505.hobbyit.pending.dto.PendingRequest;
import com.a505.hobbyit.pending.dto.PendingResponse;

import java.util.List;

public interface PendingService {
    public void join(String memberId, Long hobbyId, PendingRequest request);
    public List<PendingResponse> findPendingList(String memberId, Long hobbyId);
    public void allowPending(String memberId,final Long hobbyId, PendingAllowRequest request);
    public Hobby checkPrivilege(Long hobbyId, String memberId);
}
