package com.ouchin.WRM.visitor.service;

import com.ouchin.WRM.visitor.embedded.VisitorId;
import com.ouchin.WRM.visitor.entity.Visitor;

public interface VisitorService {

    Visitor findEntityById(VisitorId visitorId);
}
