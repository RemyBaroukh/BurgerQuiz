package app.rems.burgerquiz.seloupoivre;

import java.util.ArrayList;

/**
 * Created by remsd_000 on 08/04/2015.
 */
public class SelOuPoivre {
    private int idSelOuPoivre;
    private String sel;
    private String poivre;
    private String titre3;
    private ArrayList<SelOuPoivreQuestion> listQuestions = new ArrayList<>();

    public SelOuPoivre(int id)
    {
        idSelOuPoivre = id;
    }


    public int getIdSelOuPoivre() {
        return idSelOuPoivre;
    }


    public void setIdSelOuPoivre(int dSelOuPoivre) {
        this.idSelOuPoivre = dSelOuPoivre;
    }

    public String getSel() {
        return sel;
    }

    public void setSel(String sel) {
        this.sel = sel;
    }

    public String getPoivre() {
        return poivre;
    }

    public void setPoivre(String poivre) {
        this.poivre = poivre;
    }

    public String getTitre3() {
        return titre3;
    }

    public void setTitre3(String titre3) {
        this.titre3 = titre3;
    }

    public ArrayList<SelOuPoivreQuestion> getListQuestions() {
        return listQuestions;
    }

    public void setListQuestions(ArrayList<SelOuPoivreQuestion> listQuestions) {
        this.listQuestions = listQuestions;
    }

    public void addQuestion(SelOuPoivreQuestion question)
    {
        this.listQuestions.add(question);
    }

    @Override
    public String toString() {
        return "SelOuPoivre{" +
                "idSelOuPovire=" + idSelOuPoivre +
                ", sel='" + sel + '\'' +
                ", poivre='" + poivre + '\'' +
                ", titre3='" + titre3 + '\'' +
                '}';
    }
}
