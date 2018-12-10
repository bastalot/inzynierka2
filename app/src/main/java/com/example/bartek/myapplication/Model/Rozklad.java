package com.example.bartek.myapplication.Model;

public class Rozklad {

    public int idrozklad_jazdy, idlinia_autobusowa, idprzystanek;
    public String godzina_odjazdu, typ_dnia;

    public Rozklad(int idrozklad_jazdy, int idlinia_autobusowa, int idprzystanek, String godzina_odjazdu, String typ_dnia) {
        this.idrozklad_jazdy = idrozklad_jazdy;
        this.idlinia_autobusowa = idlinia_autobusowa;
        this.idprzystanek = idprzystanek;
        this.godzina_odjazdu = godzina_odjazdu;
        this.typ_dnia = typ_dnia;
    }

    public Rozklad() {
    }

    public int getRozklad_jazdy() {
        return idrozklad_jazdy;
    }

    public void setIdRozklad_jazdy(int rozklad_jazdy) {
        this.idrozklad_jazdy = rozklad_jazdy;
    }

    public int getLinia_autobusowa() {
        return idlinia_autobusowa;
    }

    public void setIdLinia_autobusowa(int linia_autobusowa) {
        this.idlinia_autobusowa = linia_autobusowa;
    }

    public int getIdprzystanek() {
        return idprzystanek;
    }

    public void setIdprzystanek(int idprzystanek) {
        this.idprzystanek = idprzystanek;
    }

    public String getGodzina_odjazdu() {
        return godzina_odjazdu;
    }

    public void setGodzina_odjazdu(String godzina_odjazdu) {
        this.godzina_odjazdu = godzina_odjazdu;
    }

    public String getTyp_dnia() {
        return typ_dnia;
    }

    public void setTyp_dnia(String typ_dnia) {
        this.typ_dnia = typ_dnia;
    }
}
