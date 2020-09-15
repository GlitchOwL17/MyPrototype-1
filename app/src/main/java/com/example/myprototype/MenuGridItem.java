package com.example.myprototype;

public class MenuGridItem {
    private String menuTitle;
    private int menuImage;

    public MenuGridItem(String menuTitle, int menuImage) {
        this.menuTitle = menuTitle;
        this.menuImage = menuImage;
    }
    public String getMenuTitle(){
        return menuTitle;
    }
    public int getMenuImage() {
        return menuImage;
    }

}
