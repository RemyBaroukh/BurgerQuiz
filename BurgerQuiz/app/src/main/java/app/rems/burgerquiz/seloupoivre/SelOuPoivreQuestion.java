package app.rems.burgerquiz.seloupoivre;

/**
 * Created by remsd_000 on 08/04/2015.
 */
public class SelOuPoivreQuestion {
    private int idQuestion;
    private String question;
    private String reponses;

    public SelOuPoivreQuestion(int id)
    {
        idQuestion = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponses() {
        return reponses;
    }

    public void setReponses(String reponses) {
        this.reponses = reponses;
    }

    @Override
    public String toString() {
        return "SelOuPoivreQuestion{" +
                "idQuestion=" + idQuestion +
                ", question='" + question + '\'' +
                ", reponses='" + reponses + '\'' +
                '}';
    }

    public  boolean checkReponse(int idReponse)
    {

        switch(idReponse)
        {
            case 0:
                return reponses.contains("1");
            case 1:
                return reponses.contains("2");
            case 2:
                return reponses.contains("3");
            default:
                return false;

        }
    }
}
