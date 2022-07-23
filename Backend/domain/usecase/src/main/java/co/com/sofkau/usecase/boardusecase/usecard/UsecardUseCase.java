package co.com.sofkau.usecase.boardusecase.usecard;

import co.com.sofkau.model.board.Board;
import co.com.sofkau.model.board.gateways.BoardRepository;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UsecardUseCase {
    private final BoardRepository boardRepository;
    private final CardRepository cardRepository;


    public Mono<Board> useCard(String idBoard, String id,Board board){
        boardRepository.findById(idBoard);
        List<Card> listCards = new ArrayList<>();
        cardRepository.findById(id).subscribe(card-> {
            listCards.addAll(board.getListCard());
            listCards.add(card);
        });
        board.setListCard(listCards);
        return  boardRepository.useCard(board);
    }
}
