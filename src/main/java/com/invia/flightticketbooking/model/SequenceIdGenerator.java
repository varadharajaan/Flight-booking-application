package com.invia.flightticketbooking.model;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import java.io.Serializable;

public class SequenceIdGenerator implements IdentifierGenerator {


    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o)  {

        String prefix="EU-CUS-";

        return prefix.concat(String.valueOf(Math.random()));
    }
}
