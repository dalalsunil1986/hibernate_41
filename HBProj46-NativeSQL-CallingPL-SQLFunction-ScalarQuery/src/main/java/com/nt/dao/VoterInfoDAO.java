package com.nt.dao;

import java.util.List;

import com.nt.domain.VoterInfo;

public interface VoterInfoDAO {
	public List<Object[]> getVotersDetailsByMpLoc(String loc);

}
