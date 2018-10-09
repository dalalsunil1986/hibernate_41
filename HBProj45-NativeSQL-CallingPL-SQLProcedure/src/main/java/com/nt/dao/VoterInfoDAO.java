package com.nt.dao;

import java.util.List;

import com.nt.domain.VoterInfo;

public interface VoterInfoDAO {
	public List<VoterInfo> getVotersDetailsByRange(int startId,int endId);

}
