package co.com.sofkau.model.board;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    private String id;
    private Date time;

    private List<String> listWinRound = new ArrayList<>();
    private List<Card> listCard= new ArrayList<>();
    private List<Player> listplayer = new ArrayList<>();

    private List<String> idplayers;

    public void addNewWinRound(String playerId){
        listWinRound.add(playerId);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<String> getListWinRound() {
        return listWinRound;
    }

    public void setListWinRound(List<String> listWinRound) {
        this.listWinRound = listWinRound;
    }

    public List<Card> getListCard() {
        return listCard;
    }

    public void setListCard(List<Card> listCard) {
        this.listCard = listCard;
    }

    public List<Player> getListplayer() {
        return listplayer;
    }

    public void setListplayer(List<Player> listplayer) {
        this.listplayer = listplayer;
    }

    public List<String> getIdplayers() {
        return idplayers;
    }

    public void setIdplayers(List<String> idplayers) {
        this.idplayers = idplayers;
    }
}
