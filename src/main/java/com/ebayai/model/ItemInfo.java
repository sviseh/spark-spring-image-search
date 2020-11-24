package com.ebayai.model;

public class ItemInfo {
    private long itemId;
    private long catId;
    private String imageUrl;

    public ItemInfo(long itemId, long catId, String imageUrl){
        this.itemId = itemId;
        this.catId = catId;

        this.imageUrl = imageUrl;
    }
    /***********************************
     *
     **********************************/
    public Long getItemId(){
        return itemId;
    }
    /***********************************
     *
     **********************************/
    public Long getCatId(){
        return catId;
    }
    /***********************************
     *
     **********************************/
    public String getImageUrl(){
        return imageUrl;
    }
}
