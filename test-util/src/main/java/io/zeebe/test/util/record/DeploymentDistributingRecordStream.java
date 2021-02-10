/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.test.util.record;

import io.zeebe.protocol.record.Record;
import io.zeebe.protocol.record.value.DeploymentDistributionRecordValue;
import java.util.stream.Stream;

public final class DeploymentDistributingRecordStream
    extends ExporterRecordStream<
        DeploymentDistributionRecordValue, DeploymentDistributingRecordStream> {

  public DeploymentDistributingRecordStream(
      final Stream<Record<DeploymentDistributionRecordValue>> wrappedStream) {
    super(wrappedStream);
  }

  @Override
  protected DeploymentDistributingRecordStream supply(
      final Stream<Record<DeploymentDistributionRecordValue>> wrappedStream) {
    return new DeploymentDistributingRecordStream(wrappedStream);
  }

  public DeploymentDistributingRecordStream withPartition(final int partition) {
    return valueFilter(v -> v.getPartition() == partition);
  }
}
