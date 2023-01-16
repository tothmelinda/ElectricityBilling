package com.electricity.audit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractActiveAuditingEntity extends AbstractAuditingEntity {

    protected boolean active;
}
