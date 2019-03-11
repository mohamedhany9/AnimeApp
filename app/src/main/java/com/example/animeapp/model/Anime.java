package com.example.animeapp.model;

public class Anime {

    private String name;
    private String description;
    private String Rating;
    private int episode;
    private String img;
    private String categorie;
    private String studio;

    public Anime() {
    }

    public Anime(String name, String description, String rating, int episode, String img, String categorie, String studio) {
        this.name = name;
        this.description = description;
        Rating = rating;
        this.episode = episode;
        this.img = img;
        this.categorie = categorie;
        this.studio = studio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
}