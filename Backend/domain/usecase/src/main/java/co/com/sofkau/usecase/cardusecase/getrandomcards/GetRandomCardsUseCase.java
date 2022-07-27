package co.com.sofkau.usecase.cardusecase.getrandomcards;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GetRandomCardsUseCase {
    private final CardRepository cardRepository;
    private final BoardRepository boardRepository;

    public Mono<Board> obtenerCartasAleatorias(Integer numeroDeCartas) {

        var listPlayers=boardRepository.findById("62de01f1ee60c664c3d720fb")
                .toFuture().join().getListplayer();
        int newNumeroDeCartas = numeroDeCartas/listPlayers.size();
        List<Card> cards = cardRepository.findAll().collectList().toFuture().join();
        Collections.shuffle(cards);
        List<Card> newCards = cards.stream()
                .skip(cards.size() - numeroDeCartas)
                .collect(Collectors.toList());

        List<Card> newCardList= new ArrayList<>();

        for (int i = 0; i<listPlayers.size(); i++) {
            for (int j = 0; j < newCards.size(); j++) {
                if (j < newNumeroDeCartas*(i+1) && j>=(newNumeroDeCartas*i)) {
                    newCards.get(j).setPlayerId(listPlayers.get(i).getPlayerId());
                    newCardList.add(newCards.get(j));
                }
            }
        }

        var board =boardRepository.findById("62de01f1ee60c664c3d720fb").toFuture().join();

        board.setListCard(newCardList);

//        var listaFinal=listPlayers.stream()
//                .map(player-> newCards.stream().filter(card -> card.getPlayerId().isEmpty())
//               .skip(newCards.size()-(newCards.size()-5))
//               .flatMap(a-> a.setPlayerId(player.getPlayerId()))
//                ).collect(Collectors.toList());




        return boardRepository.save(board);

        //return cardRepository.randomCards(newCardList);
    }

}
