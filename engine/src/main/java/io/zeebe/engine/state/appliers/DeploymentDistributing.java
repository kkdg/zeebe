/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.engine.state.appliers;

import io.zeebe.engine.state.TypedEventApplier;
import io.zeebe.engine.state.ZeebeState;
import io.zeebe.engine.state.mutable.MutableDeploymentState;
import io.zeebe.protocol.impl.record.value.deployment.DeploymentDistributionRecord;
import io.zeebe.protocol.record.intent.DeploymentDistributionIntent;

public class DeploymentDistributing
    implements TypedEventApplier<DeploymentDistributionIntent, DeploymentDistributionRecord> {

  private final MutableDeploymentState deploymentState;

  public DeploymentDistributing(final ZeebeState zeebeState) {
    deploymentState = zeebeState.getDeploymentState();
  }

  @Override
  public void applyState(final long key, final DeploymentDistributionRecord value) {
    // add partition on which deployment should be distributed
    deploymentState.addPendingDeploymentDistribution(key, value.getPartition());
  }
}
