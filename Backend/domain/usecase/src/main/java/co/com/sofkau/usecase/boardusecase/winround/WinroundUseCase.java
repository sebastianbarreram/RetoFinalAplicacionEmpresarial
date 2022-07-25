package co.com.sofkau.usecase.boardusecase.winround;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.gateways.CardRepository;
import co.com.sofkau.usecase.cardusecase.getcardsusecase.GetCardsUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class WinroundUseCase {
    private final BoardRepository boardRepository;
    private final GetCardsUseCase getCardsUseCase;
    private final CardRepository cardRepository;

    public Mono<String> winRound(String id){

        Board board = boardRepository.findById(id).toFuture().join();

        String playerId = boardRepository.findById(id)
                .map(e->e.getListCard().stream()
                        .reduce((value1,value2)->(value1.getXp()>value2.getXp())?value1:value2))
                .map(player -> player.get().getPlayerId()).toFuture().join();


        var  listWinRound =   board.getListWinRound();

       // if(  listWinRound.size() == 0){
          // listWinRound.add(playerId);
        //}


        //var  listWinRound2 = listWinRound.stream()
         //       .collect(Collectors.toCollection(() -> Arrays.asList(playerId)  ));


        //AtomicReference<String> idPlayer = new AtomicReference<>("");
/*
        var playerId = boardRepository.findById(id)
                        .map(e->e.getListCard().stream()
                               .reduce((value1,value2)->(value1.getXp()>value2.getXp())?value1:value2))
                .map(player -> player.get().getPlayerId())
                .subscribe(idPlayer::set);
*/
       // var idPlayerString = idPlayer.get();

        return  boardRepository.winRound(playerId,  board);
    }
}
