package ru.ifmo.lab3_derbenyova;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Image {
    private String imageUrl;

    public Image() {
    }

    public Image(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<Image> generateImages() {
        List<Image> images = new ArrayList<>();
        images.add(new Image("https://i.imgur.com/2KxoIsa.jpg"));
        images.add(new Image("https://i.imgur.com/EZHXbA0.jpg"));
        images.add(new Image("https://i.imgur.com/qb7Ev7A.jpg"));
        images.add(new Image("https://i.imgur.com/ZtXXAwX.jpg"));
        images.add(new Image("https://i.imgur.com/lrE9vha.jpg"));
        images.add(new Image("https://i.imgur.com/S66rx9n.jpg"));
        images.add(new Image("https://i.imgur.com/KaSkWef.jpg"));
        images.add(new Image("https://i.imgur.com/jp5z1s0.jpg"));
        images.add(new Image("https://i.imgur.com/iLNrl9Z.jpg"));
        images.add(new Image("https://i.imgur.com/Z3ei74h.jpg"));
        images.add(new Image("https://i.imgur.com/uXbb81d.jpg"));
        images.add(new Image("https://i.imgur.com/92mT0BB.jpg"));
        return images;
    }
}
