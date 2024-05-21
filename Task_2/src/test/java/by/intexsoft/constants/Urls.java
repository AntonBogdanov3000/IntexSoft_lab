package by.intexsoft.constants;

public enum Urls {

    BASE_URL("https://qa-scooter.praktikum-services.ru/"),
    YANDEX_URL("https://dzen.ru/");
    private String title;
    public String getTitle(){
        return title;
    }
    Urls(String title){
        this.title = title;
    }
}
