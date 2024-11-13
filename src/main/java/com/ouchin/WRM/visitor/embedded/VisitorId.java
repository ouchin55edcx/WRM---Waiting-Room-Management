package com.ouchin.WRM.visitor.embedded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;

@Embeddable
public record VisitorId(@GeneratedValue Long value) {
}
