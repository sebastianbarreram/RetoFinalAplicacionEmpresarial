package co.com.sofkau.usecase.gameusecase.winround;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import co.com.sofkau.model.game.gateways.GameRepository;
import co.com.sofkau.usecase.cardusecase.getcardsusecase.GetCardsUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RequiredArgsConstructor
public class WinroundUseCase {
    private final GameRepository gameRepository;
    private final BoardRepository boardRepository;
    private final GetCardsUseCase getCardsUseCase;
    private final CardRepository cardRepository;

    public Mono<Card> winRound(String id){


        //var board = boardRepository.findById(id).toFuture().join();

        var card = gameRepository.findById(id)
                .map(e->e.getCardGamesList().stream()
                        .reduce((value1,value2)->(value1.getXp()>value2.getXp())?value1:value2))
                .map(player -> player.get());



        return  boardRepository.winRound(card);
    }
}
