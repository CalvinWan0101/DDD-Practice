package tw.teddysoft.clean.usecase.lane.swimlane.create.impl;

import tw.teddysoft.clean.domain.model.kanbanboard.workflow.Lane;
import tw.teddysoft.clean.domain.model.kanbanboard.workflow.LaneBuilder;
import tw.teddysoft.clean.domain.model.kanbanboard.workflow.Workflow;
import tw.teddysoft.clean.usecase.kanbanboard.workflow.WorkflowRepository;
import tw.teddysoft.clean.usecase.lane.swimlane.create.CreateSwimlaneInput;
import tw.teddysoft.clean.usecase.lane.swimlane.create.CreateSwimlaneOutput;
import tw.teddysoft.clean.usecase.lane.swimlane.create.CreateSwimlaneUseCase;

public class CreateSwimlaneUseCaseImpl implements CreateSwimlaneUseCase {

    private WorkflowRepository repository;

    public CreateSwimlaneUseCaseImpl(WorkflowRepository repository) {
        this.repository = repository;
    }


    public static CreateSwimlaneInput createInput(){
        return new CreateSwimlaneInputImpl();
    }

    @Override
    public void execute(CreateSwimlaneInput input, CreateSwimlaneOutput output) {

        Workflow workflow = repository.findById(input.getWorkflowId());

        Lane parent = workflow.findLaneById(input.getParentId());
        if (null == parent)
            throw new RuntimeException("Cannot find the lane : " + input.getParentId() + " to add a swimlane under it.");

        Lane lane = LaneBuilder.getInstance()
                .title(input.getLaneName())
                .workflowId(input.getWorkflowId())
                .swimlane()
                .build();

        parent.addSubLane(lane);

        repository.save(workflow);

        output.setId(lane.getId());

    }

    private static class CreateSwimlaneInputImpl implements CreateSwimlaneInput {
        private String workflowId;
        private String laneName;
        private String parentId;

        @Override
        public void setWorkflowId(String workflowId) {
            this.workflowId = workflowId;
        }

        @Override
        public void setLaneName(String laneName) {
            this.laneName = laneName;
        }

        @Override
        public String getWorkflowId() {
            return workflowId;
        }

        @Override
        public String getLaneName(){
            return this.laneName;
        }

        @Override
        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        @Override
        public String getParentId() {
            return parentId;
        }
    }

}