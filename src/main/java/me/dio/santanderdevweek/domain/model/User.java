package me.dio.santanderdevweek.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tab_user") // nome da tabela
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerar identificador automáticamente
    private Long id;

    //@Column(length = 80) // nome não pode passar de 80 caracteres
    private String name;

    @OneToOne(cascade = CascadeType.ALL) // garantir que ao deletar um usuário, todos os itens relacionados também
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // um usuário tem muitas features em formato de lista
    private List<Feature> features;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // toda vez que buscar um usuario a lista de
    // features vem junto
    private List<News> news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

}
