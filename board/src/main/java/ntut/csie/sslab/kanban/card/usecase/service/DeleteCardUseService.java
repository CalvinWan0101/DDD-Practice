package ntut.csie.sslab.kanban.card.usecase.delete.impl;

import ntut.csie.sslab.ddd.usecase.DomainEventBus;
import ntut.csie.sslab.ddd.usecase.cqrs.CqrsCommandOutput;
import ntut.csie.sslab.ddd.usecase.cqrs.ExitCode;
import ntut.csie.sslab.kanban.card.entity.Card;
import ntut.csie.sslab.kanban.common.ClientBoardContentMightExpire;
import ntut.csie.sslab.kanban.card.usecase.delete.in.DeleteCardInput;
import ntut.csie.sslab.kanban.card.usecase.delete.in.DeleteCardUseCase;
import ntut.csie.sslab.kanban.card.usecase.get.out.CardRepository;

public class DeleteCardUseCaseImpl implements DeleteCardUseCase {
	private final CardRepository cardRepository;
	private final DomainEventBus domainEventBus;

	public DeleteCardUseCaseImpl(CardRepository cardRepository,
								 DomainEventBus domainEventBus) {

		this.cardRepository = cardRepository;
		this.domainEventBus = domainEventBus;
	}

	@Override
	public CqrsCommandOutput execute(DeleteCardInput input) {
		Card card = cardRepository.findById(input.getCardId()).orElse(null);
		CqrsCommandOutput output = CqrsCommandOutput.create();

		if (null == card){
			output.setId(input.getCardId())
					.setExitCode(ExitCode.FAILURE)
					.setMessage("Delete card failed: card not found, card id = " + input.getCardId());
			domainEventBus.post(new ClientBoardContentMightExpire(input.getBoardId()));
			return output;
		}

		card.markAsRemoved(
				input.getWorkflowId(),
				input.getLaneId(),
				input.getUserId(),
				input.getUsername(),
				input.getBoardId()
		);

		cardRepository.deleteById(card.getCardId());
		domainEventBus.postAll(card);

		return output.setId(card.getCardId()).setExitCode(ExitCode.SUCCESS);
	}

}