package com.nt.generators;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustRandomIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor ses, Object domain) throws HibernateException {
		System.out.println("CustomRandomIdGenerator::generate(-,-)");
		Random random=null;
		int idVal=0;
		random=new Random();
		idVal=random.nextInt(100000);
		return idVal;
	}
}
