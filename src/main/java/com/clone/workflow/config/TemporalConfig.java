package com.clone.workflow.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import com.clone.workflow.temporal.ActivityImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowClientOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
import io.temporal.worker.WorkerFactory;

@Component
@Configuration
public class TemporalConfig {
	@Bean
	public WorkflowServiceStubs workflowServiceStubs() {
		return WorkflowServiceStubs.newLocalServiceStubs();
	}

	@Bean
	public WorkflowClient workflowClient(WorkflowServiceStubs workflowServiceStubs) {
        // Here u may pass workflowServiceStubs options like namespaces.
		return WorkflowClient.newInstance(workflowServiceStubs);
	}

	@Bean
	public WorkerFactory workerFactory(WorkflowClient workflowClient) {
		return WorkerFactory.newInstance(workflowClient);
	}

	@Bean
	public ActivityImpl SignUpActivity() {
		return new ActivityImpl();
	}

}
