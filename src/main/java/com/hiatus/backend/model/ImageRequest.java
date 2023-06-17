package com.hiatus.backend.model;

public class ImageRequest {
    private byte[] imageBytes;

    public ImageRequest(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }
}
