/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.protocol.impl.record.value.deployment;

import io.zeebe.msgpack.property.IntegerProperty;
import io.zeebe.protocol.impl.record.UnifiedRecordValue;
import io.zeebe.protocol.record.value.DeploymentDistributionRecordValue;

public class DeploymentDistributionRecord extends UnifiedRecordValue
    implements DeploymentDistributionRecordValue {

  private final IntegerProperty partitionProperty = new IntegerProperty("partition");

  public DeploymentDistributionRecord() {
    declareProperty(partitionProperty);
  }

  public int getPartition() {
    return partitionProperty.getValue();
  }

  public void setPartition(final int partitionId) {
    partitionProperty.setValue(partitionId);
  }
}
