package co.com.sofkau.usecase.deleteplayer;

import co.com.sofkau.model.player.gateways.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeletePlayerUseCase {
    private final PlayerRepository repository;

    public Mono<Void> deletePlayer(String id) {
        return repository.delete(id);
    }
}
